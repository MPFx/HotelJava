package model;

/**
 * Clase abstracta que representa una habitacion del hotel.
 * Contiene los atributos y comportamientos comunes a todos los tipos de habitaciones
 * (Simple, Doble, Suite).
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see HabitacionSimple
 * @see HabitacionDoble
 * @see HabitacionSuite
 */
public abstract class Habitacion {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la habitacion. */
    protected int idHabitacion;
    
    /** Numero de la habitacion. */
    protected int numero;
    
    /** Piso donde se encuentra. */
    protected int piso;
    
    /** Precio base por noche. */
    protected double precioBase;
    
    /** Indica si la habitacion esta disponible. */
    protected boolean disponible;
    
    /** Descripcion de la habitacion. */
    protected String descripcion;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una habitacion.
     * 
     * @param numero Numero de habitacion
     * @param piso Piso de la habitacion
     * @param precioBase Precio base por noche
     */
    public Habitacion(int numero, int piso, double precioBase) {
        this.idHabitacion = contadorIds++;
        this.numero = numero;
        this.piso = piso;
        this.precioBase = precioBase;
        this.disponible = true;
        this.descripcion = "";
    }
    
    /**
     * Calcula el costo total para una cantidad de noches.
     * 
     * @param noches Numero de noches
     * @return Costo total
     */
    public double calcularCosto(int noches) {
        return precioBase * noches;
    }
    
    /**
     * Obtiene el tipo de habitacion.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Tipo de habitacion
     */
    public abstract String getTipoHabitacion();
    
    /**
     * Obtiene la capacidad maxima de personas.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Capacidad maxima
     */
    public abstract int getCapacidadMaxima();
    
    /**
     * Obtiene el numero de camas.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Numero de camas
     */
    public abstract int getCamas();
    
    // ==================== GETTERS ====================
    
    /** @return Identificador de la habitacion */
    public int getIdHabitacion() {
        return idHabitacion;
    }
    
    /** @return Numero de habitacion */
    public int getNumero() {
        return numero;
    }
    
    /** @return Piso */
    public int getPiso() {
        return piso;
    }
    
    /** @return Precio base por noche */
    public double getPrecioBase() {
        return precioBase;
    }
    
    /** @return true si esta disponible */
    public boolean isDisponible() {
        return disponible;
    }
    
    /** @param disponible Nueva disponibilidad */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    /** @return Descripcion de la habitacion */
    public String getDescripcion() {
        return descripcion;
    }
    
    /** @param descripcion Nueva descripcion */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve una representacion textual de la habitacion.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return "Habitacion " + numero + " (Piso " + piso + ") - " + getTipoHabitacion() +
               " - Capacidad: " + getCapacidadMaxima() + " personas - $" + precioBase + "/noche" +
               (disponible ? " - Disponible" : " - Ocupada");
    }
    
}//fin de la clase