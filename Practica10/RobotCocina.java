public class RobotCocina implements Acciones {
    private String nombre;
    private String tipoRobot;

    public RobotCocina(String nombre, String tipoRobot) {
        this.nombre = nombre;
        this.tipoRobot = tipoRobot; // Puede ser "Ingredientes", "Chef" o "Mesero"
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void prepararIngredientes(EstadoCocina estado) {
        if (!tipoRobot.equals("Ingredientes")) {
            System.out.println("ERROR: El robot " + nombre + " no puede preparar ingredientes.");
            return;
        }
        System.out.println("El robot " + nombre + " está preparando los ingredientes.");
        estado.setIngredientesListos(true);
    }

    @Override
    public void cocinar(EstadoCocina estado, String tipoComida) {
        if (!tipoRobot.equals("Chef")) {
            System.out.println("ERROR: El robot " + nombre + " no puede cocinar.");
            return;
        }
        if (!estado.ingredientesListos()) {
            System.out.println("ERROR: Los ingredientes no están listos.");
            return;
        }
        System.out.println("El robot " + nombre + " está cocinando " + tipoComida + ".");
        estado.setCocinado(true);
    }

    @Override
    public void servir(EstadoCocina estado, String tipoComida) {
        if (!tipoRobot.equals("Mesero")) {
            System.out.println("ERROR: El robot " + nombre + " no puede servir.");
            return;
        }
        if (!estado.cocinado()) {
            System.out.println("ERROR: El plato no está cocinado.");
            return;
        }
        System.out.println("El robot " + nombre + " está sirviendo " + tipoComida + ".");
        estado.setServido(true);
    }
}
