
package MiBanco ;

 public class Cuenta {

        private String nombreTitular;
        private String tipoCuenta;
        private double saldo;
        String numeroCuenta;
        private String clabeInterbancaria;
        private int pin;
    
        // Constructor de la cuenta
        public Cuenta(String nombreTitular, String tipoCuenta, double saldoInicial, String numeroCuenta, String clabeInterbancaria, int pin) {
            this.nombreTitular = nombreTitular;
            this.tipoCuenta = tipoCuenta;
            this.saldo = saldoInicial;
            this.numeroCuenta = numeroCuenta;
            this.clabeInterbancaria = clabeInterbancaria;
            this.pin = pin;
        }
    
        // Métodos para depositar y retirar dinero
        public boolean depositar(double monto) {
            if (monto > 0) {
                saldo += monto;
                return true;
            } else {
                return false;
            }
        }
    
        public boolean retirar(double monto) {
            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
                return true;
            } else {
                return false;
            }
        }
    
        // Método para validar el PIN
        public boolean validarPin(int pinIngresado) {
            return this.pin == pinIngresado;
        }
    
        // Método para obtener el saldo 
        public double obtenerSaldo() {
            return saldo;
        }
    }
    
    
