import java.io.*;
import java.util.*;

class Alumno implements Serializable {
    private String nombre;
    private String matricula;
    private List<Double> calificaciones;
    private double promedio;

    public Alumno(String nombre, String matricula, List<Double> calificaciones) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = calificaciones;
        calcularPromedio();
    }

    private void calcularPromedio() {
        if (calificaciones != null && !calificaciones.isEmpty()) {
            double suma = 0;
            for (double cal : calificaciones) {
                suma += cal;
            }
            this.promedio = suma / calificaciones.size();
        } else {
            throw new ArithmeticException("La lista de calificaciones está vacía.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nMatricula: " + matricula +
                "\nCalificaciones: " + calificaciones +
                "\nPromedio: " + promedio;
    }
}

public class Practica11 {
    public static void main(String[] args) {
        String archivoCSV = "proyecto.csv";
        String archivoSalida = "alumnos.txt";

        try {
            List<Alumno> alumnos = leerCSV(archivoCSV);

            // Mostrar en pantalla
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
                System.out.println("------------------------");
            }

            // Guardar en archivo
            guardarEnArchivo(alumnos, archivoSalida);

            System.out.println("El archivo con la información ha sido generado.");
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer/escribir archivo: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Error al calcular el promedio: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private static List<Alumno> leerCSV(String archivoCSV) throws IOException {
        List<Alumno> alumnos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
        String linea;
        int contador = 0;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length >= 9) { // Validar que haya al menos nombre, matrícula y 7 calificaciones
                String nombre = datos[0];
                String matricula = datos[1];
                List<Double> calificaciones = new ArrayList<>();

                for (int i = 2; i < 9; i++) {
                    try {
                        calificaciones.add(Double.parseDouble(datos[i]));
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Calificación no válida en la línea " + (contador + 1));
                    }
                }

                alumnos.add(new Alumno(nombre, matricula, calificaciones));
                if (++contador == 3) break; // Sólo leer 3 alumnos
            } else {
                throw new IOException("Formato inválido en la línea " + (contador + 1));
            }
        }

        br.close();
        return alumnos;
    }

    private static void guardarEnArchivo(List<Alumno> alumnos, String archivoSalida) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

        for (Alumno alumno : alumnos) {
            bw.write(alumno.toString());
            bw.newLine();
            bw.write("------------------------");
            bw.newLine();
        }

        bw.close();
    }
}
