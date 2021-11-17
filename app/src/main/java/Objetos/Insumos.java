package Objetos;

public class Insumos {

    private int id;             // estan ordenados por la misma posición ....
    private String[] insumos = {"Torta mil hojas", "Torta de bizcocho "};
    private int[] precios = {25000, 12000,};
    private int stock;

    public Insumos()
    {

    }

    public Insumos(int id, String[] insumos, int[] precios, int stock) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    // Regla de negocio para el adicional

    public int anadirAdicional(int valor, int adicional)
    {
       return valor + adicional;
    }

}
