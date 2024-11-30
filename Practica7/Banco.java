package MiBanco ;


 import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    private ArrayList< Cuenta > cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    // Método para registrar una nueva cuenta
    public void registrarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    // Método para buscar una cuenta existente mediante número de cuenta
    private Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            
            if (cuenta.numeroCuenta.equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null; // Retorna null si no se encuentra la cuenta
    }

    // Método para el menú principal
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenido al Banco");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Acceder a cuenta");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    accederCuenta();
                    break;
                case 3:
                    System.out.println("Gracias por usar el banco");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
            }
        }
    }

    // Método para crear una nueva cuenta
    private void crearCuenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del titular:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el tipo de cuenta (Ahorro, Cheques):");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el saldo inicial:");
        double saldoInicial = scanner.nextDouble();

        System.out.println("Ingrese el número de cuenta:");
        String numeroCuenta = scanner.next();

        System.out.println("Ingrese la CLABE interbancaria:");
        String clabe = scanner.next();

        System.out.println("Establezca un PIN de 4 dígitos:");
        int pin = scanner.nextInt();

        Cuenta nuevaCuenta = new Cuenta(nombre, tipo, saldoInicial, numeroCuenta, clabe, pin);
        registrarCuenta(nuevaCuenta);

        System.out.println("Cuenta creada exitosamente.");
    }

    // Método para acceder a una cuenta existente
    private void accederCuenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su número de cuenta:");
        String numeroCuenta = scanner.next();

        Cuenta cuenta = buscarCuenta(numeroCuenta);

        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.println("Ingrese su PIN:");
        int pin = scanner.nextInt();

        if (cuenta.validarPin(pin)) {
            System.out.println("Acceso concedido.");
            boolean continuar = true;
            while (continuar) {
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Retirar");
                System.out.println("4. Salir");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Saldo actual: " + cuenta.obtenerSaldo());
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a depositar:");
                        double montoDeposito = scanner.nextDouble();
                        if (cuenta.depositar(montoDeposito)) {
                            System.out.println("Depósito exitoso.");
                        } else {
                            System.out.println("Error en el depósito.");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a retirar:");
                        double montoRetiro = scanner.nextDouble();
                        if (cuenta.retirar(montoRetiro)) {
                            System.out.println("Retiro exitoso.");
                        } else {
                            System.out.println("Error en el retiro. Verifique el monto.");
                        }
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } else {
            System.out.println("PIN incorrecto.");
        }

    }



}
