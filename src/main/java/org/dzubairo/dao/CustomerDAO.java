package org.dzubairo.dao;

import org.dzubairo.db.ConnectionFactory;
import org.dzubairo.model.Customer;
import org.dzubairo.model.CustomerCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CustomerDAO {
    public static Customer addCustomer(Customer customer) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES (DEFAULT, ?, ?, ?, ?, now())", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getCustomerCategory().name());

            int i = ps.executeUpdate();

            if (i == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
                return customer;
            } else {
                throw new SQLException("Creating customer failed, no id obtained.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Customer getCustomer(long id) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id=" + id);

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setCustomerCategory(CustomerCategory.valueOf(rs.getString("category")));

                return customer;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
