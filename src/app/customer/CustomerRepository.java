package app;

import java.util.ArrayList;

public class CustomerRepository {

    private ArrayList<Customer> customers;

    public CustomerRepository(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Customer findByName(String name) {
        for (Customer customer : customers) {
            if (customer.isSameName(name)) {
                return customer;
            }
        }
        return null;
    }
}
