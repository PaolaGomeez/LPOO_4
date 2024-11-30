public interface Acciones {
    void prepararIngredientes(EstadoCocina estado);
    void cocinar(EstadoCocina estado, String tipoComida);
    void servir(EstadoCocina estado, String tipoComida);
}
