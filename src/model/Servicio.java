package model;

/**
 * Clase que representa un servicio adicional del hotel.
 * Ejemplos: Spa, Restaurante, Lavanderia, Transporte.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Reserva
 */
public class Servicio {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico del servicio. */
    private int idServicio;
    
    /** Nombre del servicio. */
    private String nombre;
    
    /** Descripcion del servicio. */
    private String descripcion;
    
    /** Costo del servicio. */
    private double costo;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear un servicio.
     * 
     * @param nombre Nombre del servicio
     * @param costo Costo del servicio
     */
    public Servicio(String nombre, double costo) {
        this.idServicio = contadorIds++;
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = "";
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador del servicio */
    public int getIdServicio() {
        return idServicio;
    }
    
    /** @return Nombre del servicio */
    public String getNombre() {
        return nombre;
    }
    
    /** @return Descripcion del servicio */
    public String getDescripcion() {
        return descripcion;
    }
    
    /** @param descripcion Nueva descripcion */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /** @return Costo del servicio */
    public double getCosto() {
        return costo;
    }
    
    /** @param costo Nuevo costo */
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    /**
     * Devuelve una representacion textual del servicio.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return nombre + " - $" + costo + (descripcion.isEmpty() ? "" : " (" + descripcion + ")");
    }
    
}//fin de la clase