package model;

/**
 * Clase que representa una habitacion doble.
 * Capacidad: 4 personas, 2 camas.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Habitacion
 */
public class HabitacionDoble extends Habitacion {
    
    /**
     * Constructor para crear una habitacion doble.
     * 
     * @param numero Numero de habitacion
     * @param piso Piso de la habitacion
     * @param precioBase Precio base por noche
     */
    public HabitacionDoble(int numero, int piso, double precioBase) {
        super(numero, piso, precioBase);
    }
    
    /**
     * Obtiene el tipo de habitacion.
     * 
     * @return "Doble"
     */
    @Override
    public String getTipoHabitacion() {
        return "Doble";
    }
    
    /**
     * Obtiene la capacidad maxima de personas.
     * 
     * @return 4 personas
     */
    @Override
    public int getCapacidadMaxima() {
        return 4;
    }
    
    /**
     * Obtiene el numero de camas.
     * 
     * @return 2 camas
     */
    @Override
    public int getCamas() {
        return 2;
    }
    
}//fin de la clase