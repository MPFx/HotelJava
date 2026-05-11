package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un cliente del hotel.
 * Hereda de Persona e incluye documento, fecha de registro y sus reservas.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Persona
 * @see Reserva
 */
public class Cliente extends Persona {
    
    // ==================== ATRIBUTOS ====================
    
    /** Numero de documento de identidad. */
    private String documento;
    
    /** Fecha de registro del cliente. */
    private LocalDate fechaRegistro;
    
    /** Lista de reservas realizadas por el cliente. */
    private List<Reserva> reservas;
    
    /**
     * Constructor para crear un cliente.
     * 
     * @param nombre Nombre completo
     * @param telefono Telefono de contacto
     * @param email Email de contacto
     * @param documento Documento de identidad
     */
    public Cliente(String nombre, String telefono, String email, String documento) {
        super(nombre, telefono, email);
        this.documento = documento;
        this.fechaRegistro = LocalDate.now();
        this.reservas = new ArrayList<>();
    }
    
    /**
     * Obtiene el tipo de persona.
     * 
     * @return "Cliente"
     */
    @Override
    public String getTipoPersona() {
        return "Cliente";
    }
    
    /**
     * Agrega una reserva al cliente.
     * 
     * @param reserva Reserva a agregar
     */
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    // ==================== GETTERS ====================
    
    /** @return Documento de identidad */
    public String getDocumento() {
        return documento;
    }
    
    /** @param documento Nuevo documento */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    /** @return Fecha de registro */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    
    /** @return Lista de reservas */
    public List<Reserva> getReservas() {
        return reservas;
    }
    
    /**
     * Devuelve una representacion textual del cliente.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + " - Doc: " + documento + " - Registrado: " + fechaRegistro.format(formatter);
    }
    
}//fin de la clase