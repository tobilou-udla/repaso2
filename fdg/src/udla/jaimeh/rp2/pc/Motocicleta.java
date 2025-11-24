package udla.jaimeh.rp2.pc;

public class Motocicleta extends Vehiculo{
    private double cilindraje;
    private TipoMotocicleta tipoMotocicleta;
    private int id;
    static int contadorID = 1;

    public Motocicleta(String marca, String modelo, int anio, double precio, double cilindraje, TipoMotocicleta tipoMotocicleta, int id) {
        super(marca, modelo, anio, precio);
        this.cilindraje = cilindraje;
        this.tipoMotocicleta = tipoMotocicleta;
        this.id = contadorID++;
    }

    public Motocicleta() {
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public TipoMotocicleta getTipoMotocicleta() {
        return tipoMotocicleta;
    }

    public void setTipoMotocicleta(TipoMotocicleta tipoMotocicleta) {
        this.tipoMotocicleta = tipoMotocicleta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContadorID() {
        return contadorID;
    }

    public static void setContadorID(int contadorID) {
        Motocicleta.contadorID = contadorID;
    }

    public void mostrarInfoMotocicleta() {
        super.mostrarInfo();
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Tipo de Motocicleta: " + tipoMotocicleta);
        System.out.println("ID: " + id);
    }
}
