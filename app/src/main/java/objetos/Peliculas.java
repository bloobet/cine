package objetos;

import com.example.proyecto.R;

public class Peliculas {
    private int id;
    private String [] peliculas = { "Hallowen", "Venom 2", "Gvsk", "F9", "Shang-chi"} ;
    private int [] precios = { 5000, 7000,7500,6300, 8000,5500};
    private int Stock;


    public Peliculas () {

        Stock = 400;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(String[] peliculas) {
        this.peliculas = peliculas;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }


    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int Adicional (int valor , int adicional)
    {
        int resultado = valor + adicional;

        return resultado;
    }

    public int  Disponible (int stock )
    {
        int resulta = stock - 1;

       return resulta;

    }
}
