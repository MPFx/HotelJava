package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un empleado del hotel.
 * Hereda de Persona e incluye cargo, salario, horario y fecha de contratacion.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Persona
 */
public class Empleado extends Persona {
    
    // ==================== ATRIBUTOS ====================
    
    /** Cargo del empleado (Recepcionista, Camarera, Gerente, etc.). */
    private String cargo;
    
    /** Salario del empleado. */
    private double salario;
    
    /** Horario de trabajo. */
    private String horario;
    
    /** Fecha de contratacion. */
    private LocalDate fechaContratacion;
    
    /**
     * Constructor para crear un empleado.
     * 
     * @param nombre Nombre completo
     * @param telefono Telefono de contacto
     * @param email Email de contacto
     */
    public Empleado(String nombre, String telefono, String email) {
        super(nombre, telefono, email);
        this.cargo = "Sin asignar";
        this.salario = 0;
        this.horario = "9:00 - 18:00";
        this.fechaContratacion = LocalDate.now();
    }
    
    /**
     * Obtiene el tipo de persona.
     * 
     * @return "Empleado"
     */
    @Override
    public String getTipoPersona() {
        return "Empleado";
    }
    
    // ==================== GETTERS ====================
    
    /** @return Cargo del empleado */
    public String getCargo() {
        return cargo;
    }
    
    /** @param cargo Nuevo cargo */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    /** @return Salario */
    public double getSalario() {
        return salario;
    }
    
    /** @param salario Nuevo salario */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    /** @return Horario de trabajo */
    public String getHorario() {
        return horario;
    }
    
    /** @param horario Nuevo horario */
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    /** @return Fecha de contratacion */
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
    
    /**
     * Devuelve una representacion textual del empleado.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + " - " + cargo + " - $ " + salario + " - Contratado: " + fechaContratacion.format(formatter);
    }
    
}//fin de la clase