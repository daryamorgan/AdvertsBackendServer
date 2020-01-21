package org.dzubairo.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerCategory customerCategory;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String email, CustomerCategory customerCategory) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerCategory = customerCategory;
    }

    public Customer(int id, String firstName, String lastName, String email, CustomerCategory customerCategory) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerCategory = customerCategory;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerCategory getCustomerCategory() {
        return this.customerCategory;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }
}
