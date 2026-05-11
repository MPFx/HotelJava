package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una reserva de habitacion.
 * Contiene informacion del cliente, habitacion, fechas, estado y servicios.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Cliente
 * @see Habitacion
 * @see Servicio
 */
public class Reserva {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la reserva. */
    private int idReserva;
    
    /** Cliente que realiza la reserva. */
    private Cliente cliente;
    
    /** Habitacion reservada. */
    private Habitacion habitacion;
    
    /** Fecha de check-in. */
    private LocalDate fechaCheckIn;
    
    /** Fecha de check-out. */
    private LocalDate fechaCheckOut;
    
    /** Numero de noches. */
    private int noches;
    
    /** Estado de la reserva (PENDIENTE, CONFIRMADA, ACTIVA, FINALIZADA, CANCELADA). */
    private String estado;
    
    /** Lista de servicios adicionales. */
    private List<Servicio> servicios;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una reserva.
     * 
     * @param cliente Cliente
     * @param habitacion Habitacion
     * @param fechaCheckIn Fecha de entrada
     * @param fechaCheckOut Fecha de salida
     */
    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
        this.idReserva = contadorIds++;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.noches = (int) ChronoUnit.DAYS.between(fechaCheckIn, fechaCheckOut);
        this.estado = "PENDIENTE";
        this.servicios = new ArrayList<>();
        
        // Marcar habitacion como no disponible
        habitacion.setDisponible(false);
    }
    
    /**
     * Confirma la reserva.
     */
    public void confirmarReserva() {
        if (estado.equals("PENDIENTE")) {
            this.estado = "CONFIRMADA";
            System.out.println("Reserva confirmada para " + cliente.getNombre());
        }
    }
    
    /**
     * Cancela la reserva.
     */
    public void cancelarReserva() {
        if (!estado.equals("FINALIZADA")) {
            this.estado = "CANCELADA";
            habitacion.setDisponible(true);
            System.out.println("Reserva cancelada");
        }
    }
    
    /**
     * Finaliza la reserva (check-out realizado).
     */
    public void finalizarReserva() {
        if (estado.equals("ACTIVA") || estado.equals("CONFIRMADA")) {
            this.estado = "FINALIZADA";
            habitacion.setDisponible(true);
            System.out.println("Check-out realizado. Reserva finalizada");
        }
    }
    
    /**
     * Agrega un servicio a la reserva.
     * 
     * @param servicio Servicio a agregar
     */
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    
    /**
     * Calcula el costo total de la reserva.
     * 
     * @return Costo total (habitacion + servicios)
     */
    public double calcularTotal() {
        double total = habitacion.calcularCosto(noches);
        for (Servicio s : servicios) {
            total += s.getCosto();
        }
        return total;
    }
    
    /**
     * Activa la reserva (check-in realizado).
     */
    public void activarReserva() {
        if (estado.equals("CONFIRMADA")) {
            this.estado = "ACTIVA";
            System.out.println("Check-in realizado. Disfrute su estadia!");
        }
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador de la reserva */
    public int getIdReserva() {
        return idReserva;
    }
    
    /** @return Cliente */
    public Cliente getCliente() {
        return cliente;
    }
    
    /** @return Habitacion */
    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    /** @return Fecha de check-in */
    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }
    
    /** @return Fecha de check-out */
    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }
    
    /** @return Numero de noches */
    public int getNoches() {
        return noches;
    }
    
    /** @return Estado de la reserva */
    public String getEstado() {
        return estado;
    }
    
    /** @return Lista de servicios */
    public List<Servicio> getServicios() {
        return servicios;
    }
    
    /**
     * Devuelve una representacion textual de la reserva.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Reserva #" + idReserva + " - " + cliente.getNombre() +
               " - Hab." + habitacion.getNumero() + " (" + habitacion.getTipoHabitacion() + ")" +
               " - " + fechaCheckIn.format(formatter) + " a " + fechaCheckOut.format(formatter) +
               " - " + noches + " noches - Total: $" + calcularTotal() + " - " + estado;
    }
    
}//fin de la clase