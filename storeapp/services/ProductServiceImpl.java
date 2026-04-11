package storeapp.services;
import storeapp.domain.Product;
import storeapp.repository.ProductRepository;
import java.util.List;
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public Product saveProduct(Product product){
        return productRepository.saveProduct(product);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAllProducts();
    }

    @Override
    public Product getProductById(int id){
        return productRepository.findProductById(id);
    }

    @Override
    public Product updateProduct(Product product){
        return productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id){
        productRepository.deleteProduct(id);
    }

    @Override
    public boolean existsById(int id){
        return productRepository.existsById(id);
    }



}
