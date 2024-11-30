public class EstadoCocina {
    private boolean ingredientesListos = false;
    private boolean cocinado = false;
    private boolean servido = false;

    public boolean ingredientesListos() { return ingredientesListos; }
    public void setIngredientesListos(boolean listos) { this.ingredientesListos = listos; }

    public boolean cocinado() { return cocinado; }
    public void setCocinado(boolean cocinado) { this.cocinado = cocinado; }

    public boolean servido() { return servido; }
    public void setServido(boolean servido) { this.servido = servido; }

    public void reiniciar() {
        ingredientesListos = false;
        cocinado = false;
        servido = false;
    }
}
