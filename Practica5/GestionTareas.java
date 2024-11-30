package GestiondeTareas;

import java.util.ArrayList;
import java.util.Scanner;

class Tarea {
    private String nombre;
    private String estado;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = "pendiente";
    }



    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void completar() {
        this.estado = "completada";
    }

    @Override
    public String toString() {
        return "Tarea: " + nombre + " | Estado: " + estado;
    }
}

public class GestionTareas {
    
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1 -> agregarTarea();
                case 2 -> completarTarea();
                case 3 -> eliminarTarea();
                case 4 -> mostrarTareas();
                case 5 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestión de Tareas ---");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Marcar tarea como completada");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Mostrar todas las tareas");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregarTarea() {
        System.out.print("Introduce el nombre de la tarea: ");
        String nombre = scanner.nextLine();
        Tarea nuevaTarea = new Tarea(nombre);
        tareas.add(nuevaTarea);
        System.out.println("Tarea agregada: " + nuevaTarea);
    }

    private static void completarTarea() {
        System.out.print("Introduce el nombre de la tarea a completar: ");
        String nombre = scanner.nextLine();
        boolean encontrada = false;
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre) && tarea.getEstado().equals("pendiente")) {
                tarea.completar();
                System.out.println("Tarea completada: " + tarea);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontró una tarea pendiente con ese nombre.");
        }
    }

    private static void eliminarTarea() {
        System.out.print("Introduce el nombre de la tarea a eliminar: ");
        String nombre = scanner.nextLine();
        boolean eliminada = tareas.removeIf(tarea -> tarea.getNombre().equalsIgnoreCase(nombre));
        if (eliminada) {
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("No se encontró una tarea con ese nombre.");
        }
    }

    private static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
        } else {
            System.out.println("\n--- Lista de Tareas ---");
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }
}
