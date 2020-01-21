package org.dzubairo.service;

import org.dzubairo.model.Customer;
import org.dzubairo.dao.CustomerDAO;

public class CustomerService {
    public static Customer addCustomer(Customer customer) {
        return CustomerDAO.addCustomer(customer);
    }

    public static Customer getCustomer(int id) {
        return CustomerDAO.getCustomer(id);
    }
}
