package storeapp.userinterface;

import storeapp.view.AdminView;
import storeapp.view.CategoryView;
import storeapp.view.CustomerView;
import storeapp.view.ProductView;

import java.util.Scanner;

public class MenuApp {


    private final CategoryView categoryView;
    Scanner sc = new Scanner(System.in);
    private final CustomerView customerView;
    private final AdminView adminView;
    private final ProductView productView;
    public MenuApp(CustomerView customerView, AdminView adminView, ProductView productView, CategoryView categoryView) {
        this.customerView = customerView;
        this.adminView = adminView;
        this.productView=productView;
    this.categoryView = categoryView;}

    public void showMainMenu(){

        System.out.println("Bienvenido a la tienda online");
        System.out.println("Presione 1 para iniciar la aplicacion");

        int init = sc.nextInt();
        sc.nextLine();

        while(init != 0){

            System.out.println("Selecione 1. Registrar Usuario 2. Iniciar Sesion 3. Salir");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    System.out.println("Registrar Usuario");
                    System.out.println("1. Cliente 2. Administrador");
                    int userType = sc.nextInt();
                    sc.nextLine();
                    if (userType == 1){
                        customerView.createCustomer();
                    }else if(userType == 2){
                        adminView.createAdmin();
                    }else{
                        System.out.println("Opcion no valida, por favor seleccione una opcion valida");
                    }

                    break;
                case 2:
                    System.out.println("Iniciar Sesion");
                    profileSelector("admin");
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }

    }


    public void profileSelector(String profile){

        if(profile.equals("admin")){
            showMenuAdmin();
        }else if(profile.equals("customer")){
            showMenuCustomer();
        }
    }


    public void showMenuAdmin(){

        while (true){
            System.out.println("Menu Administrador");
            System.out.println("1. Gestionar Productos 2. Gestionar Categorias 3. Gestionar Clientes 4. Salir");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    System.out.println("Gestionar Productos");
                    productMenuAdmin();
                    break;
                case 2:
                    System.out.println("Gestionar Categorias");
                    categoryMenuAdmin();
                    break;
                case 3:
                    System.out.println("Gestionar Clientes");
                    customerMenuAdmin();
                    break;
                case 4:
                    System.out.println("Saliendo del menu de administrador");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }

    }


    public void showMenuCustomer(){

    }


    public void customerMenuAdmin(){

        System.out.println("Menu Cliente");
        while (true) {

            System.out.println("1. Crear Perfil Cliente 2. " +
                    "Ver perfil por id 3. Modifica perfil 4. " +
                    "Ver perfiles 5. eliminar Perfil 6. Salir" );

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Crear perfil");
                    customerView.createCustomer();
                    break;
                case 2:
                    System.out.println("Ver perfil por id");
                    customerView.getCustomerById();
                    break;
                case 3:
                    System.out.println("Modificar perfil");
                    customerView.updateCustomer();
                    break;
                case 4:
                    System.out.println("Ver perfiles");
                    customerView.getAllCustomers();
                    break;
                case 5:
                    System.out.println("Eliminar perfil");
                    customerView.deleteCustomer();
                    break;
                case 6:
                    System.out.println("Volviendo al menu anterior");
                    return;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }
        }
    }

public void productMenuAdmin(){
        while(true){
            System.out.println("Menu de los productos");
            System.out.println("1. Crear producto 2. Ver producto por Id 3. Modificar producto  4. Ver todos los productos 5. eliminar 6. Salir ");
            int option= sc.nextInt();
            sc.nextLine();
             switch (option){
                 case 1:
                     System.out.println("Crear Producto");
                     productView.createProduct();
                     break;
                 case 2:
                     System.out.println("Ver producto por id");
                     productView.getProductById();
                     break;
                 case 3 :
                     System.out.println("Modificar producto");
                     productView.updateProduct();
                     break;
                 case 4 :
                     System.out.println("Ver todos los productos");
                     productView.getAllProducts();
                     break;
                 case 5:
                     System.out.println("Borrar los productos");
                     productView.deleteProduct();
                     break;
                 case 6:
                     System.out.println("Volviendo al menu anterior");
                     return;
                 default:
                     System.out.println("Opcion no valida, ingrese un numero del 1 al 6a");


             }


        }




}




    public void categoryMenuAdmin(){
        while(true){
            System.out.println("Menu Categorias");
            System.out.println("1. Ver todas 2. Modificar categoria 3. Salir");
            int option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    categoryView.getAllCategories();
                    break;
                case 2:
                    categoryView.updateCategory();
                    break;
                case 3:
                    System.out.println("Volviendo al menu anterior");
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }


}
