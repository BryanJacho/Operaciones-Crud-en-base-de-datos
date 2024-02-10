/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empleado;

import java.util.List;

/**
 *
 * @author BRYAN JACHO
 */
public class Main {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre("Juan");
        nuevoEmpleado.setEdad(30);
        nuevoEmpleado.setSueldo(2500);
        nuevoEmpleado.setCargo("Desarrollador");
        empleadoDAO.crearEmpleado(nuevoEmpleado);

        
        List<Empleado> empleados = empleadoDAO.obtenerEmpleados();
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getId() + ", " + empleado.getNombre() + ", " + empleado.getEdad() + ", " + empleado.getSueldo() + ", " + empleado.getCargo());
        }
    }
}