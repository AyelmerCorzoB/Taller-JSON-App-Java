package com.hexagonaljava.infrastructure.persistence.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexagonaljava.domain.entity.Product;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionDb;

public class ProductRepositoryImpl implements ProductRepository {
    private final ConnectionDb connection;

    public ProductRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }

    @Override
    public void guardar(Product product) {
        String sql = "INSERT INTO product (id, name, stock) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setInt(3, product.getStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product buscarPorId(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("----------------------------------");
                System.out.println("|" + "ID: " + rs.getInt("id"));
                System.out.println("|" + "Nombre: " + rs.getString("name"));
                System.out.println("|" + "Stock: " + rs.getInt("stock"));
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> listarTodos() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                products.add(new Product(id, name, stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Product product : products) {
            System.out.println("|-------------------------------------------------------------------------|");
            System.out.println(
                    "|ID: " + product.getId() + " Name: " + product.getName() + " Stock: " + product.getStock() + " |");
            System.out.println("|-------------------------------------------------------------------------|");
        }
        return products;
    }

    @Override
    public void actualizar(Product product) {
        String sql = "UPDATE product SET name = ?, stock = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStock());
            stmt.setInt(3, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
