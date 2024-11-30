import java.util.Scanner;

public class calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumeros = 0;
        double suma = 0;
        double promedio = 0 ;
        int numeroMayor = Integer.MIN_VALUE; 
        int numeroMenor = Integer.MAX_VALUE; 

        System.out.println("Ingresa una serie de números uno por uno (ingresa -1 para terminar):");

        while (true) {
            System.out.print("Ingresa un número: ");
            int numero = scanner.nextInt();
            
            if (numero == -1) {
                break; 
            }

            totalNumeros++; 
            suma += numero; 

            if (numero > numeroMayor) {
                numeroMayor = numero;
            }


            if (numero < numeroMenor) {
                numeroMenor = numero;
            }
        }

        if (totalNumeros > 0) {
            promedio = suma / totalNumeros;

            System.out.println("\nEstadísticas:");
            System.out.println("Total de números ingresados: " + totalNumeros);
            System.out.println("Suma de los números: " + suma);
            System.out.println("Promedio de los números: " + promedio);
            System.out.println("Número más grande: " + numeroMayor);
            System.out.println("Número más pequeño: " + numeroMenor);
        } else {
            System.out.println("No se ingresaron números.");
        }

        scanner.close();
    }
}
 
    

