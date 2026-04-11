package storeapp.config;

import storeapp.domain.Admin;
import storeapp.domain.Customer;
import storeapp.repository.CategoryRepository;
import storeapp.repository.CustomerRepository;
import storeapp.repository.ProductRepository;
import storeapp.services.*;
import storeapp.userinterface.MenuApp;
import storeapp.view.AdminView;
import storeapp.view.CategoryView;
import storeapp.view.CustomerView;
import storeapp.view.ProductView;

public class Config {

    public static MenuApp createMenuApp(){

        // esto es un patron Simple Factory, se encarga de crear los objetos necesarios para la aplicacion, y devolver un objeto MenuApp con todos los objetos necesarios para la aplicacion,
        // esto es para evitar tener que crear los objetos en el main, y tener
        // todo el codigo de creacion de objetos en un solo lugar, y asi poder cambiar la implementacion de los objetos sin tener que cambiar el codigo del main,
        //  por ejemplo si queremos cambiar la implementacion de CustomerServiceImpl por otra implementacion, solo tenemos que cambiar el codigo de esta clase,
        //  y no tenemos que cambiar el codigo del main, esto es una buena practica de programacion, ya que nos permite tener un codigo mas limpio y mantenible.
        Customer customer = new Customer();
        Admin admin = new Admin();
        CustomerRepository customerRepository = new CustomerRepository();
        CustumerService customerService = new CustumerServiceImpl(customer, customerRepository);
        CustomerView customerView = new CustomerView( customerService, customer);
        AdminServiceImpl adminService = new AdminServiceImpl(admin);
        AdminView adminView = new AdminView(adminService, admin);


        //Categorias

        CategoryRepository categoryRepository = new CategoryRepository();
        CategoryView categoryView = new CategoryView(categoryRepository);

        // Productos
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductView productView = new ProductView(productService,categoryRepository);



        return new MenuApp(customerView, adminView, productView,categoryView);

    }










}
