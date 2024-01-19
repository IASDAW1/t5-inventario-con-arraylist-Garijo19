/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyecto.inventariotienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fran Garijo
 * @version 1.0
 * 
 */
public class InventarioTienda {

    public static void main(String[] args) {

        ArrayList<String> listaDnis = new ArrayList<>();

        ArrayList<String> listaTareas = new ArrayList<>();

        ArrayList<String> listaCompletadas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nMenú:");

            System.out.println("1. Agregar tarea");

            System.out.println("2. Marcar tareas completadas");

            System.out.println("3. Mostrar tareas");

            System.out.println("4. Eliminar tareas completadas");

            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese el dni del contacto: ");

                    String dni = scanner.nextLine();

                    System.out.print("Ingrese la tarea a realizar: ");

                    String nombre = scanner.nextLine();

                    if (!listaDnis.contains(dni)) {

                        listaDnis.add(dni);

                        listaTareas.add(nombre);

                        listaCompletadas.add("0"); //marco 0 cuando no está completada

                        System.out.println("Tarea asignada correctamente.");

                    } else {

                        System.out.println("Esa persona ya tiene una tarea asignada.");

                    }

                    break;

                case 2:

                    System.out.print("Ingrese el dni a buscar: ");

                    String nombreBusqueda = scanner.nextLine();

                    if (listaDnis.contains(nombreBusqueda)) {

                        int indice = listaDnis.indexOf(nombreBusqueda);
                        listaCompletadas.set(indice, "1"); //marco la tarea como completada de ese usuario.

                    } else {

                        System.out.println("Contacto no encontrado.");

                    }

                    break;

                case 3:

                    System.out.println("Lista de Tareas:");

                    for (int i = 0; i < listaDnis.size(); i++) {

                        System.out.println("DNI: " + listaDnis.get(i) + " Tarea: " + listaTareas.get(i) + " Completada (0 = No / 1 = SI): " + listaCompletadas.get(i));

                    }

                    break;

                case 4:

                    System.out.println("Eliminar completadas");

                    for (int i = 0; i < listaDnis.size(); i++) {
                        if (listaCompletadas.get(i).equals("1")) {
                            System.out.println("Borrando tarea del usuario: " + listaDnis.get(i));
                            listaDnis.remove(i);
                            listaTareas.remove(1);
                            listaCompletadas.remove(1);
                        }//if
                    }//for

                    break;

                case 5:

                    System.out.println("Saliendo del programa.");

                    scanner.close();

                    System.exit(0);

                default:

                    System.out.println("Opción inválida. Intente de nuevo.");

            }

        }

    }

}