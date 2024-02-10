/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRYAN JACHO
 */
public class EmpleadoDAO {
    private Connection connection;

    public EmpleadoDAO() {
        connection = ConexionBD.getConnection();
    }

    public void crearEmpleado(Empleado empleado) {
        try {
            String query = "INSERT INTO empleados (Nombre, Edad, Sueldo, Cargo) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, empleado.getNombre());
            statement.setInt(2, empleado.getEdad());
            statement.setInt(3, empleado.getSueldo());
            statement.setString(4, empleado.getCargo());
            statement.executeUpdate();
            System.out.println("Empleado creado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear empleado: " + e.getMessage());
        }
    }

    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            String query = "SELECT * FROM empleados";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt("Id"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setEdad(resultSet.getInt("Edad"));
                empleado.setSueldo(resultSet.getInt("Sueldo"));
                empleado.setCargo(resultSet.getString("Cargo"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener empleados: " + e.getMessage());
        }
        return empleados;
    }
public void actualizarEmpleado(Empleado empleado) {
        try {
            String query = "UPDATE empleados SET Nombre=?, Edad=?, Sueldo=?, Cargo=? WHERE Id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, empleado.getNombre());
            statement.setInt(2, empleado.getEdad());
            statement.setInt(3, empleado.getSueldo());
            statement.setString(4, empleado.getCargo());
            statement.setInt(5, empleado.getId());
            statement.executeUpdate();
            System.out.println("Empleado actualizado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(int id) {
        try {
            String query = "DELETE FROM empleados WHERE Id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Empleado eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
        }
    }
}