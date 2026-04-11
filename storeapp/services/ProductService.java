package storeapp.services;
import storeapp.domain.Product;
import java.util.List;
public interface ProductService {
    public Product saveProduct(Product product);
    public List <Product> getAllProducts();
    public Product getProductById(int id);
    public Product updateProduct(Product product);
    public void deleteProduct (int id);
    public boolean existsById(int id);



}
