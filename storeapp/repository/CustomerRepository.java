package storeapp.repository;

import storeapp.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {


    private List<Customer>customers = new ArrayList<>();

    public Customer saveCustomer(Customer customer){
        customers.add(new Customer(
                customer.getId(),
                customer.getName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.isStatus(),
                customer.getQuote(),
                customer.getCustomerType()
        ));
        return customer;
    }


    public List<Customer> findAllCustomers(){
        return customers;
    }


    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;


            }
        }
        return null;
    }


    public void findCustomerByEmail(){

    }

    public Customer updateCustomer(Customer customer){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId()==customer.getId()){
                customers.set(i,customer);
                return customer;
            }
        }
    return null;
    }



    public void deleteCustomer(int id ){
        customers.removeIf(customer->customer.getId()==id);

    }
    public boolean existsById(int id){
        for(Customer customer : customers){
            if(customer.getId() == id){
                return true;
            }
        }
        return false;
    }


}
