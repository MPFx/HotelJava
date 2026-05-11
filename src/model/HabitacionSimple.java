package model;

/**
 * Clase que representa una habitacion simple.
 * Capacidad: 2 personas, 1 cama.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Habitacion
 */
public class HabitacionSimple extends Habitacion {
    
    /**
     * Constructor para crear una habitacion simple.
     * 
     * @param numero Numero de habitacion
     * @param piso Piso de la habitacion
     * @param precioBase Precio base por noche
     */
    public HabitacionSimple(int numero, int piso, double precioBase) {
        super(numero, piso, precioBase);
    }
    
    /**
     * Obtiene el tipo de habitacion.
     * 
     * @return "Simple"
     */
    @Override
    public String getTipoHabitacion() {
        return "Simple";
    }
    
    /**
     * Obtiene la capacidad maxima de personas.
     * 
     * @return 2 personas
     */
    @Override
    public int getCapacidadMaxima() {
        return 2;
    }
    
    /**
     * Obtiene el numero de camas.
     * 
     * @return 1 cama
     */
    @Override
    public int getCamas() {
        return 1;
    }
    
}//fin de la clase