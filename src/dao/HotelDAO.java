package dao;

import model.Hotel;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    // CREATE
    public void addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel(name, location, price) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getLocation());
            ps.setDouble(3, hotel.getPrice());

            ps.executeUpdate();
            System.out.println("Hotel added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Hotel> getAllHotels() {
        List<Hotel> list = new ArrayList<>();
        String sql = "SELECT * FROM hotel";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Hotel h = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("price")
                );
                list.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE
    public void updateHotel(Hotel hotel) {
        String sql = "UPDATE hotel SET name=?, location=?, price=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getLocation());
            ps.setDouble(3, hotel.getPrice());
            ps.setInt(4, hotel.getId());

            ps.executeUpdate();
            System.out.println("Hotel updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteHotel(int id) {
        String sql = "DELETE FROM hotel WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Hotel deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}