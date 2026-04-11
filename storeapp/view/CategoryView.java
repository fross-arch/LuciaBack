
package storeapp.view;

import storeapp.domain.Category;
import storeapp.repository.CategoryRepository;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CategoryView {

    Scanner sc = new Scanner(System.in);
    private final CategoryRepository categoryRepository;

    public CategoryView(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void getAllCategories(){
        List<Category> categories = categoryRepository.findAllCatagories();
        for(Category c : categories){
            System.out.println("Id: " + c.getIdCategory() +
                    " | Nombre: " + c.getDescription() +
                    " | Estado: " + (c.isState() ? "Activa" : "Inactiva"));
        }
    }

    public void updateCategory(){
        Category existing = null;
        while(existing == null){
            try {
                System.out.println("Ingrese el id de la categoria a modificar");
                int id = sc.nextInt();
                sc.nextLine();
                existing = categoryRepository.findCategoryById(id);
                if(existing == null){
                    System.out.println("Categoria no encontrada, intente con otro id");
                }
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un número, intente de nuevo");
                sc.nextLine();
            }
        }

        System.out.println("Categoria encontrada: " + existing.getDescription());

        System.out.println("Ingrese el nuevo nombre");
        existing.setDescription(sc.nextLine());

        System.out.println("Activar categoria? (true/false)");
        boolean validState = false;
        while(!validState){
            try {
                boolean state = sc.nextBoolean();
                sc.nextLine();
                existing.setState(state);
                validState = true;
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar true o false, intente de nuevo");
                sc.nextLine();
            }
        }

        categoryRepository.updateCategory(existing);
        System.out.println("Categoria actualizada correctamente");
    }
}