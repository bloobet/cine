package objetos;

public class Pagos {
    private int id;
    private String [] pago = { "Debito", "Credito", "Trasferencias"} ;
    private int [] precioSub = { 5000, 5500,5200};

    public Pagos ()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getPago() {
        return pago;
    }

    public void setPago(String[] pago) {
        this.pago = pago;
    }

    public int[] getPrecioSub() {
        return precioSub;
    }

    public void setPrecioSub(int[] precioSub) {
        this.precioSub = precioSub;
    }
}
