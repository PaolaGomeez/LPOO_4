import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstadoCocina estado = new EstadoCocina();

        // Robots instanciados con su tipo específico
        RobotCocina robotIngredientes = new RobotCocina("Preparador de Ingredientes", "Ingredientes");
        RobotCocina robotChef = new RobotCocina("Chef Principal", "Chef");
        RobotCocina robotMesero = new RobotCocina("Mesero Rápido", "Mesero");

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Preparar ingredientes
                    robotIngredientes.prepararIngredientes(estado);
                    break;
                case 2: // Cocinar
                    if (!estado.ingredientesListos()) {
                        System.out.println("ERROR: Los ingredientes no están listos.");
                        break;
                    }
                    mostrarMenuComidas();
                    System.out.print("Selecciona el tipo de comida: ");
                    int opcionComida = scanner.nextInt();
                    String comida = obtenerComida(opcionComida);
                    if (comida != null) {
                        robotChef.cocinar(estado, comida);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 3: // Servir
                    if (!estado.cocinado()) {
                        System.out.println("ERROR: No puedes servir sin cocinar.");
                        break;
                    }
                    robotMesero.servir(estado, "el platillo preparado");
                    if (estado.servido()) {
                        System.out.println("¡Plato servido con éxito!");
                        estado.reiniciar(); // Reiniciar para un nuevo ciclo
                    }
                    break;
                case 4: // Salir
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú principal:");
        System.out.println("1. Preparar ingredientes");
        System.out.println("2. Cocinar");
        System.out.println("3. Servir");
        System.out.println("4. Salir");
    }

    public static void mostrarMenuComidas() {
        System.out.println("\nSelecciona el tipo de comida:");
        System.out.println("1. Desayuno (Hot Cakes)");
        System.out.println("2. Comida (Carne en su jugo)");
        System.out.println("3. Cena (Cereales)");
    }

    public static String obtenerComida(int opcion) {
        switch (opcion) {
            case 1: return "Hot Cakes";
            case 2: return "Carne en su jugo";
            case 3: return "Cereales";
            default: return null;
        }
    }
}
