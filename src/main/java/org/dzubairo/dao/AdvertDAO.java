package org.dzubairo.dao;

import org.dzubairo.db.ConnectionFactory;
import org.dzubairo.model.Advert;
import org.dzubairo.model.AdvertCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class AdvertDAO {
    private static Advert extractAdvertFromResultSet(ResultSet rs) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        Advert advert = new Advert();

        advert.setId(rs.getInt("id"));
        advert.setUserId(rs.getInt("user_id"));
        advert.setTitle(rs.getString("title"));
        advert.setContent(rs.getString("content"));
        advert.setAdvertCategory(AdvertCategory.valueOf(rs.getString("advert_category")));
        advert.setPhoneNumber(rs.getString("phone_number"));
        advert.setCreationDate(formatter.format(rs.getObject("creation_date", LocalDate.class)));

        return advert;
    }

    public static Advert addAdvert(Advert advert) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO advert VALUES (DEFAULT, ?, ?, ?, ?, ?, now())", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, advert.getUserId());
            ps.setString(2, advert.getTitle());
            ps.setString(3, advert.getContent());
            ps.setString(4, advert.getAdvertCategory().name());
            ps.setString(5, advert.getPhoneNumber());

            int i = ps.executeUpdate();

            if (i == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                advert.setId(generatedKeys.getInt(1));
                return advert;
            } else {
                throw new SQLException("Creating customer failed, no id obtained.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Advert getAdvert(long id) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advert WHERE id=" + id);

            if (rs.next()) {
                Advert advert = extractAdvertFromResultSet(rs);
                return advert;
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public static Set<Advert> getAdvertsByCustomerId(long id) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advert WHERE user_id=" + id);
            Set<Advert> adverts = new HashSet<>();

            while(rs.next()) {
                Advert advert = extractAdvertFromResultSet(rs);
                adverts.add(advert);
            }

            return adverts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Set<Advert> getAllAdverts() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advert");
            Set<Advert> adverts = new HashSet<>();

            while (rs.next()) {
                Advert advert = extractAdvertFromResultSet(rs);
                adverts.add(advert);
            }

            return adverts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static boolean removeAdvert(long id) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM advert WHERE id=" + id);

            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
