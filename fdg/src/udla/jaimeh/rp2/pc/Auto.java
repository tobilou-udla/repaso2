package udla.jaimeh.rp2.pc;

public class Auto extends Vehiculo{
    private int numPuertas;
    private TipoTransmision tipoTransmision;
    private double kilometraje;
    private int id;
    static int contadorID = 1;

    public Auto(String marca, String modelo, int anio, double precio, int numPuertas, TipoTransmision tipoTransmision, double kilometraje, int id) {
        super(marca, modelo, anio, precio);
        this.numPuertas = numPuertas;
        this.tipoTransmision = tipoTransmision;
        this.kilometraje = kilometraje;
        this.id = contadorID++;
    }

    public Auto() {
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public TipoTransmision getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(TipoTransmision tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
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
        Auto.contadorID = contadorID;
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de Puertas: " + numPuertas);
        System.out.println("Tipo de Transmisión: " + tipoTransmision);
        System.out.println("Kilometraje: " + kilometraje + " km");
        System.out.println("ID: " + id);
    }
}
