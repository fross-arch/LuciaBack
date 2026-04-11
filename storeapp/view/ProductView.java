package storeapp.view;

import storeapp.domain.Category;
import storeapp.domain.Product;
import storeapp.repository.CategoryRepository;
import storeapp.services.StateSelector;
import storeapp.services.ProductService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductView {

    Scanner sc = new Scanner(System.in);
    private final   ProductService productService;
    private final CategoryRepository categoryRepository ;
    public ProductView(ProductService productService, CategoryRepository categoryRepository){
        this.productService=productService;
        this.categoryRepository = categoryRepository;
    }
    //StateSelector stateSelector = new StateSelector();
    //Category category = new Category();


    public void createProduct(){
        Product newProduct = new Product();

        System.out.println("Ingrese el id del producto");
        int id = 0;
        boolean validId = false;
        while(!validId){
            try {
                id = sc.nextInt();
                sc.nextLine();
                if(productService.existsById(id)){
                    System.out.println("Error: ya existe un producto con ese id, intente con otro");
                } else {
                    validId = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Error: el id debe ser un número, intente de nuevo");
                sc.nextLine();
            }
        }
        newProduct.setIdProduct(id);

        System.out.println("Ingrese el nombre del producto");
        newProduct.setDescription(sc.nextLine());

        System.out.println("Ingrese el precio del producto");
        double price = 0;
        boolean validPrice = false;
        while(!validPrice){
            try {
                price = sc.nextDouble();
                sc.nextLine();
                validPrice = true;
            } catch (InputMismatchException e){
                System.out.println("Error: el precio debe ser un número, intente de nuevo");
                sc.nextLine();
            }
        }
        newProduct.setPrice(price);

        System.out.println("Ingrese el stock del producto");
        int stock = 0;
        boolean validStock = false;
        while(!validStock){
            try {
                stock = sc.nextInt();
                sc.nextLine();
                if(stock <= 0){
                    System.out.println("Error: el stock no puede ser negativo o cero, intente de nuevo");
                } else {
                    validStock = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Error: el stock debe ser un número, intente de nuevo");
                sc.nextLine();
            }
        }
        newProduct.setStock(stock);

        newProduct.setState(true);
        newProduct.setCategory(selectCategory());

        productService.saveProduct(newProduct);
        System.out.println("Producto creado exitosamente");
    }

    public void getAllProducts(){
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()){
            System.out.println("No hay productos registrados");
            return;
        }
        for(Product p : products){
            System.out.println("Id: " + p.getIdProduct() +
                    " | Nombre: " + p.getDescription() +
                    " | Precio: " + p.getPrice() +
                    " | Stock: " + p.getStock()+
                    " | Tipo de producto: " + p.getCategory().getDescription());
        }
    }
    public void getProductById(){
        Product existing = null;
        while(existing == null){
            try {
                System.out.println("Ingrese el id del producto");
                int id = sc.nextInt();
                sc.nextLine();
                existing = productService.getProductById(id);
                if(existing == null){
                    System.out.println("Producto no encontrado, intente con otro id");
                }
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un número, intente de nuevo");
                sc.nextLine();
            }
        }
        System.out.println("Id: " + existing.getIdProduct() +
                " | Nombre: " + existing.getDescription() +
                " | Precio: " + existing.getPrice() +
                " | Stock: " + existing.getStock());
    }
    public void updateProduct(){
        Product existing = null;
        while(existing == null){
            try {
                System.out.println("Ingrese el id del producto a modificar");
                int id = sc.nextInt();
                sc.nextLine();
                existing = productService.getProductById(id);
                if(existing == null){
                    System.out.println("Producto no encontrado, intente con otro id");
                }
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un número, intente de nuevo");
                sc.nextLine();
            }
        }

        System.out.println("Producto encontrado: " + existing.getDescription());

        System.out.println("Ingrese el nuevo nombre");
        existing.setDescription(sc.nextLine());

        System.out.println("Ingrese el nuevo precio");
        double price = 0;
        boolean validPrice = false;
        while(!validPrice){
            try {
                price = sc.nextDouble();
                sc.nextLine();
                validPrice = true;
            } catch (InputMismatchException e){
                System.out.println("Error: el precio debe ser un número, intente de nuevo");
                sc.nextLine();
            }
        }
        existing.setPrice(price);

        System.out.println("Ingrese el nuevo stock");

        int stock = 0;
        boolean validStock = false;
        while(!validStock){
            try {
                stock = sc.nextInt();
                sc.nextLine();
                if(stock <= 0){
                    System.out.println("Error: el stock no puede ser negativo, intente de nuevo");
                } else {
                    validStock = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Error: el stock debe ser un número, intente de nuevo");
                sc.nextLine();
            }
        }
        existing.setStock(stock);

        StateSelector stateSelector = new StateSelector();
        boolean state = stateSelector.ProductState();
        existing.setState(state);
        System.out.println("Desea cambiar la categoria? (true/false)");
        boolean changeCategory = sc.nextBoolean();
        sc.nextLine();
        if(changeCategory){
            existing.setCategory(selectCategory());
        }
        productService.updateProduct(existing);
        System.out.println("Producto actualizado correctamente");
    }
















    public void deleteProduct(){
        System.out.println("Ingrese el id del producto a eliminar");
        int id = 0;
        boolean validId = false;
        while(!validId){
            try {
                id = sc.nextInt();
                sc.nextLine();
                validId = true;
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un número, intente de nuevo");
                sc.nextLine();
            }
        }
        productService.deleteProduct(id);
        System.out.println("Producto eliminado correctamente");
    }

    private Category selectCategory(){
        List<Category> categories = categoryRepository.findAllCatagories();
        System.out.println("Categorias disponibles:");
        for(Category c : categories){
            System.out.println("Id: " + c.getIdCategory() + " | " + c.getDescription());
        }

        Category selected = null;
        while(selected == null){
            try {
                System.out.println("Ingrese el id de la categoria");
                int id = sc.nextInt();
                sc.nextLine();
                selected = categoryRepository.findCategoryById(id);
                if(selected == null){
                    System.out.println("Categoria no encontrada, intente de nuevo");
                }
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un número, intente de nuevo");
                sc.nextLine();
            }
        }
        return selected;
    }



}

