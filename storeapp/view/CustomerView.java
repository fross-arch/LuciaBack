package storeapp.view;

import storeapp.domain.Customer;
import storeapp.services.CustumerService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerView {

    private final CustumerService customerService;
    private final Customer customer;

    public CustomerView(CustumerService customerService, Customer customer){
        this.customerService = customerService;
        this.customer = customer;
    }

    public void createCustomer(){

        customerService.createCustomer(customer);


    }
    public void getAllCustomers(){
        List<Customer>customers = customerService.getAllCustomers();
        for (Customer c : customers){
    System.out.println("Id: "+c.getId()+
            "| Nombre: " + c.getName()+
            "| Email: " + c.getEmail());
        }
    }
    public void getCustomerById(){
        System.out.println("Ingrese el id del cliente");
        Scanner sc= new Scanner(System.in);
        int id = sc.nextInt();
        Customer c = customerService.getCustomerById(id);
        if(c!=null){
            System.out.println("Id "+c.getId()+
                    " | Nombre: "+ c.getName()+
                    " | Email: "+ c.getEmail());


        } else{
            System.out.println("Cliente no encontrado");
        }

    }

    public void updateCustomer(){
        Scanner sc = new Scanner(System.in);
        Customer existing=null;

        while (existing==null){
            try {
                System.out.println("Por favor ingrese el Id del cliente a modificar ");
                int id= sc.nextInt();
                sc.nextLine();
                existing = customerService.getCustomerById(id);
                if (existing== null){
                    System.out.println("Cliente no encontrado, intente con otro id");


                }
            } catch (InputMismatchException e){
                System.out.println("Error: debe ingresar un id correcto ");
                sc.nextLine();

            }


        }


        System.out.println("Cliente encontrado " + existing.getName());
        System.out.println("Ingrese el nuevo id del cliente ");
        int id = 0;
        boolean validId=false;
        while (!validId){
            try{
                id= sc.nextInt();
                sc.nextLine();
                validId=true;
            } catch (InputMismatchException e){
                System.out.println("Error: el id debe ser un numero entero, intentelo nuevamente");
                sc.nextLine();
            }
        }
        existing.setId(id);



        System.out.println("Ingrese el nuevo nombre del usuario ");
        existing.setName(sc.nextLine());

        System.out.println("Ingrese el nuevo apellido del usuario ");
        existing.setLastName(sc.nextLine());

        System.out.println("Ingrese el nuevo email");
        existing.setEmail(sc.nextLine());

        System.out.println("Ingrese el nuevo password ");
        existing.setPassword(sc.nextLine());

        System.out.println("Ingrese el nuevo cupo ");
        double quote =0;
        boolean validQuote=false;
        while (!validQuote){
            try{
                quote= sc.nextDouble();
                sc.nextLine();
                validQuote=true;
            } catch (InputMismatchException e){
                System.out.println("Error : el cupo debe ser un numero , intente de nuevo");
                sc.nextLine();
            }


        }
        existing.setQuote(quote);


        System.out.println("Ingrese el nuevo tipo de cliente ");
        existing.setCustomerType(sc.nextLine());

        customerService.updateCustomer(existing);
        System.out.println("Cliente actualizado correctamente");



    }

    public void deleteCustomer(){
        System.out.println("Ingrese el id del cliente a eliminar");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        customerService.deleteCustomer(id);
        System.out.println("Cliente eliminado correctamente");

    }

}
