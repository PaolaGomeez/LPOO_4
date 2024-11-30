
import java.util.Random;
import java.util.Scanner;

public class Mexicano {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombre = " ";
        String paterno = " ";
        String materno = "";
        String sexo = "";
        String ent = "";
        int mes = 0, dia = 0, anio = 0, opcion = 0;

  
        System.out.println("Ingresa tu nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Ingresa tu apellido paterno: ");
        paterno = scanner.nextLine();
        System.out.println("Ingresa tu apellido materno: ");
        materno = scanner.nextLine();
        System.out.println("Ingresa tu sexo (H/M): ");
        sexo = scanner.nextLine();
        System.out.println("Ingresa tu mes de nacimiento (mm): ");
        mes = scanner.nextInt();
        System.out.println("Ingresa tu año de nacimiento (aa): ");
        anio = scanner.nextInt();
        System.out.println("Ingresa tu día de nacimiento (dd): ");
        dia = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.println("Ingresa tu Entidad: ");
        ent = scanner.nextLine();

        // Menú
        System.out.println("Elige una opción:");
        System.out.println("1. Generar CURP");
        System.out.println("2. Generar RFC a partir del CURP");
        System.out.println("3. Generar CURP y RFC");
        opcion = scanner.nextInt();

        // Generar CURP o RFC según la opción elegida
        if (opcion == 1) {
            // Generar CURP
            String curp = GenerarCurp(nombre, paterno, materno, sexo, anio, mes, dia, ent);
            System.out.println("CURP: " + curp);
        } else if (opcion == 2) {
            // Generar RFC a partir del CURP
            String curp = GenerarCurp(nombre, paterno, materno, sexo, anio, mes, dia, ent);
            String rfc = GenerarRFC(curp);
            System.out.println("RFC: " + rfc);
        } else if (opcion == 3) {
            // Generar CURP y RFC
            String curp = GenerarCurp(nombre, paterno, materno, sexo, anio, mes, dia, ent);
            System.out.println("CURP: " + curp);
            String rfc = GenerarRFC(curp);
            System.out.println("RFC: " + rfc);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Método para generar CURP
    public static String GenerarCurp(String nombre, String paterno, String materno, String sexo, int anio, int mes, int dia, String ent) {
        String curp = "";
        curp += paterno.substring(0, 1).toUpperCase(); // Primer letra  paterno
        curp += Vocal(paterno).toUpperCase(); // Primera vocal apellido paterno
        curp += materno.substring(0, 1).toUpperCase(); // Primer letra apellido materno
        curp += nombre.substring(0, 1).toUpperCase(); // Primer letranombre
        curp += String.format("%02d", anio); // Últimos dos dígitos del año
        curp += String.format("%02d", mes); // Mes
        curp += String.format("%02d", dia); // Día
        curp += sexo.toUpperCase(); // Sexo
        curp += ent.toUpperCase(); // Entidad
        curp += Consonante(paterno).toUpperCase(); // Primera consonante 
        curp += Consonante(materno).toUpperCase(); // Primera consonante
        curp += Consonante(nombre).toUpperCase(); // Primera consonante
        curp += genRand(2); //  caracteres aleatorios
        return curp;
    }

    // Método para generar RFC a partir de la CURP
    public static String GenerarRFC(String curp) {
        // Toma los primeros 10 caracteres de la CURP  y agrega dos dígitos aleatorios
        return curp.substring(0, 10) + genRand(2);
    }

    // Método para obtener la primera vocal  del apellido
    public static String Vocal(String cadena) {
        for (int i = 1; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if ("AEIOUaeiou".indexOf(c) >= 0) {
                return String.valueOf(c);
            }
        }
       return "X";
    }

    // Método para obtener la primera consonante  (después de la primera letra)
    public static String Consonante(String cadena) {
        for (int i = 1; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if ("BCDFGHJKLMNÑPQRSTVWXYZbcdfghjklmnñpqrstvwxyz".indexOf(c) >= 0) {
                return String.valueOf(c);
            }
        }
        return "X"; // En caso de no encontrar consonante, se pone una 'X'
    }

    // Método para generar caracteres aleatorios
    public static String genRand(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randStr = new StringBuilder(len);
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            randStr.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return randStr.toString();
    }
}
