package storeapp.repository;
import storeapp.domain.Product;
import java.util.ArrayList;
import java.util.List;
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public Product saveProduct(Product product){
        Product newProduct=new Product(
                product.getIdProduct(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.isState(),
                product.getCategory()
        );
        products.add(newProduct);
        return newProduct;
    }
    public List<Product> findAllProducts(){
        return products;
    }
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getIdProduct() == id) {
                return product;

            }
        }
        return null;

    }
    public Product updateProduct(Product product){
    for (int i =0; i< products.size();i++){
        if (products.get(i).getIdProduct()==product.getIdProduct()){
            products.set(i,product);
            return product;

        }
    }
return null;
    }
    public void deleteProduct(int id){
    products.removeIf(product -> product.getIdProduct()==id );
    }
    public boolean existsById(int id){
        for(Product product : products){
            if(product.getIdProduct() == id){
                return true;
            }
        }
        return false;
    }




}
