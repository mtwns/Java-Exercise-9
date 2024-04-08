package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Definir la consulta SQL
        String sqlQuery = "SELECT * FROM clientes";

        // Establecer la conexión a la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicioelectro", "root", "0296");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            // Recorrer el resultado de la consulta
            while (resultSet.next()) {
                // Obtener los valores de las columnas
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                // Puedes seguir obteniendo otros valores de columnas según tu tabla
                // Mostrar los valores obtenidos
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
