package storeapp.services;

import storeapp.domain.Customer;
import storeapp.repository.CustomerRepository;

import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustumerServiceImpl implements CustumerService {

    Scanner sc = new Scanner(System.in);

    //Ahora vamos a comunicar las clases , para eso vamos a crear una instancia de la capa inmediatamente anterior
    private final CustomerRepository customerRepository;

    public CustumerServiceImpl(Customer customer, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer newCustomer=new Customer();

        System.out.println("Ingrese el id del cliente");
        int id = 0;
        boolean validId = false;
        while(!validId){
            try {
                id = sc.nextInt();
                sc.nextLine();
                if(customerRepository.existsById(id)){
                    System.out.println("Error: ya existe un cliente con ese id, intente con otro");
                } else {
                    validId = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Error: el id debe ser un número entero, intente de nuevo");
                sc.nextLine();
            }
        }
        newCustomer.setId(id);

        System.out.println("Ingrese el nombre del cliente");
        String name = sc.nextLine();
        newCustomer.setName(name);

        System.out.println("Ingrese el apellido");
        String lastName = sc.nextLine();
        newCustomer.setLastName(lastName);

        System.out.println("ingrese el email");
        String email = sc.nextLine();
        newCustomer.setEmail(email);

        System.out.println("Ingrese el password ");
        String password = sc.nextLine();
        newCustomer.setPassword(password);

        System.out.println("Estado Cliente ");
        boolean state = false;
        boolean validState=false;
        while (!validState){
            try {
                state=sc.nextBoolean();
                sc.nextLine();
                validState=true;
            }catch ( InputMismatchException e){
                System.out.println("Error: debe ingresar un estado correcto true o false ,intente de nuevo");
                sc.nextLine();

            }

        }
        newCustomer.setStatus(state);

        System.out.println("Cupo");
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
        newCustomer.setQuote(quote);


        System.out.println("Tipo de Cliente");
        String customerType = sc.nextLine();
        newCustomer.setCustomerType(customerType);

        System.out.println("Cliente creado de forma exitosa");
        return customerRepository.saveCustomer(newCustomer);
    }
    @Override
    public List<Customer> getAllCustomers(){
        return customerRepository.findAllCustomers();


    }
    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return null;
    }


    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
    @Override
    public void deleteCustomer(int id){
        customerRepository.deleteCustomer(id);


    }

    @Override
    public boolean existsById(int id){
        return customerRepository.existsById(id);
    }


}
