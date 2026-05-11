package model;

/**
 * Clase que representa una habitacion suite.
 * Capacidad: 6 personas, 3 camas, con jacuzzi y sala opcionales.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Habitacion
 */
public class HabitacionSuite extends Habitacion {
    
    // ==================== ATRIBUTOS ====================
    
    /** Indica si tiene jacuzzi. */
    private boolean tieneJacuzzi;
    
    /** Indica si tiene sala de estar. */
    private boolean tieneSala;
    
    /**
     * Constructor para crear una habitacion suite.
     * 
     * @param numero Numero de habitacion
     * @param piso Piso de la habitacion
     * @param precioBase Precio base por noche
     */
    public HabitacionSuite(int numero, int piso, double precioBase) {
        super(numero, piso, precioBase);
        this.tieneJacuzzi = true;
        this.tieneSala = true;
    }
    
    /**
     * Obtiene el tipo de habitacion.
     * 
     * @return "Suite"
     */
    @Override
    public String getTipoHabitacion() {
        return "Suite";
    }
    
    /**
     * Obtiene la capacidad maxima de personas.
     * 
     * @return 6 personas
     */
    @Override
    public int getCapacidadMaxima() {
        return 6;
    }
    
    /**
     * Obtiene el numero de camas.
     * 
     * @return 3 camas
     */
    @Override
    public int getCamas() {
        return 3;
    }
    
    /**
     * Calcula el costo total considerando extras de la suite.
     * 
     * @param noches Numero de noches
     * @return Costo total
     */
    @Override
    public double calcularCosto(int noches) {
        double costo = super.calcularCosto(noches);
        if (tieneJacuzzi) {
            costo += noches * 50000;
        }
        if (tieneSala) {
            costo += noches * 30000;
        }
        return costo;
    }
    
    // ==================== GETTERS ====================
    
    /** @return true si tiene jacuzzi */
    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }
    
    /** @param tieneJacuzzi Nueva condicion */
    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }
    
    /** @return true si tiene sala */
    public boolean isTieneSala() {
        return tieneSala;
    }
    
    /** @param tieneSala Nueva condicion */
    public void setTieneSala(boolean tieneSala) {
        this.tieneSala = tieneSala;
    }
    
    /**
     * Devuelve una representacion textual de la suite.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        String extras = "";
        if (tieneJacuzzi) extras += " Jacuzzi";
        if (tieneSala) extras += " Sala";
        return super.toString() + " - Extras:" + extras;
    }
    
}//fin de la clase