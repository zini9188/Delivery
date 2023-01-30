package app.customer;

import java.util.ArrayList;
import java.util.HashMap;

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
        return addCustomer(name);
    }

    private Customer addCustomer(String name) {
        Customer customer = new Customer(name, new HashMap<>());
        customers.add(customer);
        return customer;
    }
}
