package model;

/**
 * Clase abstracta que representa una persona en el hotel.
 * Contiene los atributos y comportamientos comunes a clientes y empleados.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Cliente
 * @see Empleado
 */
public abstract class Persona {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la persona. */
    protected int idPersona;
    
    /** Nombre completo. */
    protected String nombre;
    
    /** Telefono de contacto. */
    protected String telefono;
    
    /** Email de contacto. */
    protected String email;
    
    /** Direccion de residencia. */
    protected String direccion;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una persona.
     * 
     * @param nombre Nombre completo
     * @param telefono Telefono de contacto
     * @param email Email de contacto
     */
    public Persona(String nombre, String telefono, String email) {
        this.idPersona = contadorIds++;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = "";
    }
    
    /**
     * Obtiene el tipo de persona.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Tipo de persona (Cliente, Empleado)
     */
    public abstract String getTipoPersona();
    
    // ==================== GETTERS ====================
    
    /** @return Identificador de la persona */
    public int getIdPersona() {
        return idPersona;
    }
    
    /** @return Nombre completo */
    public String getNombre() {
        return nombre;
    }
    
    /** @param nombre Nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return Telefono de contacto */
    public String getTelefono() {
        return telefono;
    }
    
    /** @param telefono Nuevo telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /** @return Email de contacto */
    public String getEmail() {
        return email;
    }
    
    /** @param email Nuevo email */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /** @return Direccion */
    public String getDireccion() {
        return direccion;
    }
    
    /** @param direccion Nueva direccion */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Devuelve una representacion textual de la persona.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return "[" + idPersona + "] " + nombre + " (" + getTipoPersona() + ") - " + telefono;
    }
    
}//fin de la clase