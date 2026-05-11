package service;

import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las reservas del hotel.
 * Permite crear reservas, confirmar, cancelar, finalizar y agregar servicios.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Reserva
 * @see Cliente
 * @see Habitacion
 */
public class ReservaService {
    
    private List<Reserva> reservas;
    private List<Factura> facturas;
    
    /**
     * Constructor del servicio de reservas.
     * 
     * @param reservas Lista de reservas
     * @param facturas Lista de facturas
     */
    public ReservaService(List<Reserva> reservas, List<Factura> facturas) {
        this.reservas = reservas;
        this.facturas = facturas;
    }
    
    /**
     * Crea una nueva reserva.
     * 
     * @param scanner Scanner para entrada de datos
     * @param clientes Lista de clientes
     * @param habitaciones Lista de habitaciones
     */
    public void crearReserva(Scanner scanner, List<Cliente> clientes, List<Habitacion> habitaciones) {
        System.out.println("\n=== CREAR RESERVA ===");
        
        // Seleccionar cliente
        System.out.println("\n--- CLIENTES ---");
        for (Cliente c : clientes) {
            System.out.println(c.getIdPersona() + ". " + c.getNombre() + " - " + c.getDocumento());
        }
        System.out.print("ID del cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clientes.stream()
                .filter(c -> c.getIdPersona() == idCliente)
                .findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }
        
        // Seleccionar habitacion
        System.out.println("\n--- HABITACIONES DISPONIBLES ---");
        for (Habitacion h : habitaciones) {
            if (h.isDisponible()) {
                System.out.println(h);
            }
        }
        System.out.print("Numero de habitacion: ");
        int numHabitacion = Integer.parseInt(scanner.nextLine());
        Habitacion habitacion = habitaciones.stream()
                .filter(h -> h.getNumero() == numHabitacion && h.isDisponible())
                .findFirst().orElse(null);
        if (habitacion == null) {
            System.out.println("Habitacion no disponible");
            return;
        }
        
        // Fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Fecha check-in (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Fecha check-out (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(scanner.nextLine(), formatter);
        
        Reserva reserva = new Reserva(cliente, habitacion, checkIn, checkOut);
        reservas.add(reserva);
        cliente.agregarReserva(reserva);
        
        // Factura
        Factura factura = new Factura(reserva);
        facturas.add(factura);
        
        System.out.println("\n✅ Reserva creada exitosamente!");
        System.out.println(reserva);
        System.out.println("Factura: $" + factura.getTotal());
    }
    
    /**
     * Confirma una reserva.
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void confirmarReserva(Scanner scanner) {
        System.out.print("ID de la reserva: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Reserva reserva = reservas.stream()
                .filter(r -> r.getIdReserva() == id)
                .findFirst().orElse(null);
        
        if (reserva == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        reserva.confirmarReserva();
    }
    
    /**
     * Activa una reserva (check-in).
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void activarReserva(Scanner scanner) {
        System.out.print("ID de la reserva: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Reserva reserva = reservas.stream()
                .filter(r -> r.getIdReserva() == id)
                .findFirst().orElse(null);
        
        if (reserva == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        reserva.activarReserva();
    }
    
    /**
     * Cancela una reserva.
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void cancelarReserva(Scanner scanner) {
        System.out.print("ID de la reserva: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Reserva reserva = reservas.stream()
                .filter(r -> r.getIdReserva() == id)
                .findFirst().orElse(null);
        
        if (reserva == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        reserva.cancelarReserva();
    }
    
    /**
     * Finaliza una reserva (check-out).
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void finalizarReserva(Scanner scanner) {
        System.out.print("ID de la reserva: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Reserva reserva = reservas.stream()
                .filter(r -> r.getIdReserva() == id)
                .findFirst().orElse(null);
        
        if (reserva == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        reserva.finalizarReserva();
    }
    
    /**
     * Agrega un servicio a una reserva.
     * 
     * @param scanner Scanner para entrada de datos
     * @param servicios Lista de servicios
     */
    public void agregarServicio(Scanner scanner, List<Servicio> servicios) {
        System.out.print("ID de la reserva: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Reserva reserva = reservas.stream()
                .filter(r -> r.getIdReserva() == id)
                .findFirst().orElse(null);
        
        if (reserva == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        System.out.println("\n--- SERVICIOS DISPONIBLES ---");
        for (Servicio s : servicios) {
            System.out.println(s.getIdServicio() + ". " + s);
        }
        System.out.print("ID del servicio: ");
        int idServicio = Integer.parseInt(scanner.nextLine());
        
        Servicio servicio = servicios.stream()
                .filter(s -> s.getIdServicio() == idServicio)
                .findFirst().orElse(null);
        
        if (servicio == null) {
            System.out.println("Servicio no encontrado");
            return;
        }
        
        reserva.agregarServicio(servicio);
        System.out.println("✅ Servicio agregado a la reserva");
    }
    
    /**
     * Muestra todas las reservas.
     */
    public void mostrarReservas() {
        System.out.println("\n=== LISTA DE RESERVAS ===");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas");
            return;
        }
        
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
    
    /**
     * Muestra las reservas de un cliente.
     * 
     * @param cliente Cliente
     */
    public void mostrarReservasPorCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("No hay cliente seleccionado");
            return;
        }
        
        System.out.println("\n=== RESERVAS DE " + cliente.getNombre().toUpperCase() + " ===");
        List<Reserva> reservasCliente = reservas.stream()
                .filter(r -> r.getCliente().getIdPersona() == cliente.getIdPersona())
                .toList();
        
        if (reservasCliente.isEmpty()) {
            System.out.println("No hay reservas para este cliente");
            return;
        }
        
        for (Reserva r : reservasCliente) {
            System.out.println(r);
        }
    }
    
}//fin de la clase