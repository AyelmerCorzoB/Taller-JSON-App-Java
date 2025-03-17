package com.hexagonaljava.infrastructure.persistence.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hexagonaljava.domain.entity.Client;
import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.infrastructure.database.ConnectionDb;

public class ClientRepositoryImpl implements ClientRespository {
    private final ConnectionDb connection;

    public ClientRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }

    @Override
    public void guardar(Client cliente) {
        String sql = "INSERT INTO clientes (id, name, email) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("----------------------------------");
                System.out.println("|"+"ID: "+rs.getInt("id"));
                System.out.println("|"+"Nombre: "+rs.getString("name"));
                System.out.println("|"+"Email: "+rs.getString("email"));
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> listarTodos() {
        List<Client> clients = new ArrayList<>();
        String sql = "select * from clientes";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                clients.add(new Client(id, name, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Client client : clients) {
            System.out.println("|-------------------------------------------------------------------------|");
            System.out.println(
                    "|ID: " + client.getId() + " Name: " + client.getName() + " Email: " + client.getEmail() + " |");
            System.out.println("|-------------------------------------------------------------------------|");
        }
        return clients;
    }

    @Override
    public void actualizar(Client cliente) {
        String sql = "UPDATE clientes SET name = ?, email = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
