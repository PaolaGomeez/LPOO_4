import java.util.Scanner;

public class MenuCalificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] calificaciones = new float[5];
        int opcion;
        boolean continuar = true;

        // Menú principal con validación
        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Capturar nombre y calificaciones.");
            System.out.println("2. Imprimir calificaciones y promedio.");
            System.out.println("3. Imprimir calificaciones y calificación más baja.");
            System.out.println("4. Imprimir calificaciones y calificación más alta.");
            System.out.println("5. Salir.");
            System.out.print("Elige una opción (1-5): ");
            
            // Validación del menú
            while (!scanner.hasNextInt()) {
                System.out.println("Opción no válida. Ingresa un número entre 1 y 5.");
                scanner.next(); 
            }
            opcion = scanner.nextInt();
            
            // Validar opción dentro de los rangos permitidos
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida. Ingresa un número entre 1 y 5.");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    capturarCalificaciones(scanner, calificaciones);
                    break;
                case 2:
                    imprimirCalificacionesYPromedio(calificaciones);
                    break;
                case 3:
                    imprimirCalificacionesYMinima(calificaciones);
                    break;
                case 4:
                    imprimirCalificacionesYMaxima(calificaciones);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
            }
        }
        
        scanner.close();
    }

    // Método para capturar las calificaciones con validación
    public static void capturarCalificaciones(Scanner scanner, float[] calificaciones) {
        String nombre;
        System.out.println("Introduce el nombre del estudiante:  ");
        scanner.nextLine(); 
        nombre = scanner.nextLine();
        System.out.println("Estudiante: " + nombre);

        System.out.println("Introduce las 5 calificaciones:  ");
        for (int i = 0; i < calificaciones.length; i++) {
            float calificacion;
            do {
                System.out.print("Calificación " + (i + 1) + " (0-100): ");
                while (!scanner.hasNextFloat()) {
                    System.out.println("Entrada no válida. Ingresa un número válido (0-100):");
                    scanner.next();

                }
                calificacion = scanner.nextFloat();
                if (calificacion < 0 || calificacion > 100) {
                    System.out.println("La calificación debe estar entre 0 y 100.");
                }
            } while (calificacion < 0 || calificacion > 100);
            calificaciones[i] = calificacion;
        }
    }

    //  calificaciones y  promedio
    public static void imprimirCalificacionesYPromedio(float[] calificaciones) {
        float suma = 0;
        System.out.println("Calificaciones:");
        for (float calificacion : calificaciones) {
            System.out.println(calificacion);
            suma += calificacion;
        }
        float promedio = suma / calificaciones.length;
        System.out.println("Promedio de calificaciones: " + promedio);
    }

    //  calificación más baja
    public static void imprimirCalificacionesYMinima(float[] calificaciones) {
        float minima = calificaciones[0];
        System.out.println("Calificaciones:");
        for (float calificacion : calificaciones) {
            System.out.println(calificacion);
            if (calificacion < minima) {
                minima = calificacion;
            }
        }
        System.out.println("Calificación más baja: " + minima);
    }

    // calificación más alta
    public static void imprimirCalificacionesYMaxima(float[] calificaciones) {
        float maxima = calificaciones[0];
        System.out.println("Calificaciones:");
        for (float calificacion : calificaciones) {
            System.out.println(calificacion);
            if (calificacion > maxima) {
                maxima = calificacion;
            }
        }
        System.out.println("Calificación más alta: " + maxima);
    }
}
