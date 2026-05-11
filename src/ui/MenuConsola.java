package ui;

import service.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz de usuario por consola para el Sistema de Hotel.
 * Gestiona la interaccion con el usuario, muestra los menus y procesa las opciones.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see HotelService
 * @see ReservaService
 */
public class MenuConsola {
    
    private Scanner scanner;
    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private List<Habitacion> habitaciones;
    private List<Servicio> servicios;
    private List<Reserva> reservas;
    private List<Factura> facturas;
    private HotelService hotelService;
    private ReservaService reservaService;
    private Cliente clienteActual;
    
    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.habitaciones = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.facturas = new ArrayList<>();
        this.hotelService = new HotelService(clientes, empleados, habitaciones, servicios);
        this.reservaService = new ReservaService(reservas, facturas);
        this.clienteActual = null;
        cargarDatosPrueba();
    }
    
    private void cargarDatosPrueba() {
        // Habitaciones
        habitaciones.add(new HabitacionSimple(101, 1, 150000));
        habitaciones.add(new HabitacionSimple(102, 1, 150000));
        habitaciones.add(new HabitacionDoble(201, 2, 250000));
        habitaciones.add(new HabitacionDoble(202, 2, 250000));
        habitaciones.add(new HabitacionSuite(301, 3, 400000));
        habitaciones.add(new HabitacionSuite(302, 3, 450000));
        
        // Servicios
        servicios.add(new Servicio("Spa", 80000));
        servicios.add(new Servicio("Restaurante", 50000));
        servicios.add(new Servicio("Lavanderia", 30000));
        servicios.add(new Servicio("Transporte", 60000));
        
        // Clientes de prueba
        clientes.add(new Cliente("Juan Perez", "555-1234", "juan@email.com", "12345678"));
        clientes.add(new Cliente("Maria Gomez", "555-5678", "maria@email.com", "87654321"));
        clientes.add(new Cliente("Carlos Lopez", "555-9012", "carlos@email.com", "11223344"));
    }
    
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> hotelService.registrarCliente(scanner);
                case 2 -> hotelService.registrarEmpleado(scanner);
                case 3 -> hotelService.registrarHabitacion(scanner);
                case 4 -> hotelService.registrarServicio(scanner);
                case 5 -> hotelService.listarClientes();
                case 6 -> hotelService.listarHabitaciones();
                case 7 -> hotelService.listarServicios();
                case 8 -> hotelService.listarEmpleados();
                case 9 -> clienteActual = hotelService.buscarCliente(scanner);
                case 10 -> reservaService.crearReserva(scanner, clientes, habitaciones);
                case 11 -> reservaService.confirmarReserva(scanner);
                case 12 -> reservaService.activarReserva(scanner);
                case 13 -> reservaService.cancelarReserva(scanner);
                case 14 -> reservaService.finalizarReserva(scanner);
                case 15 -> reservaService.agregarServicio(scanner, servicios);
                case 16 -> reservaService.mostrarReservas();
                case 17 -> reservaService.mostrarReservasPorCliente(clienteActual);
                case 18 -> hotelService.mostrarFacturasCliente(facturas, clienteActual);
                case 19 -> hotelService.pagarFactura(scanner, facturas);
                case 20 -> {
                    System.out.println("\n¡Gracias por usar el Sistema de Hotel!");
                    System.out.println("¡Hasta pronto!");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
            
            if (!salir) {
                pausa();
            }
        }
        
        scanner.close();
    }
    
    private void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("        SISTEMA DE HOTEL");
        System.out.println("========================================");
        System.out.println("--- REGISTROS ---");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar empleado");
        System.out.println("3. Registrar habitacion");
        System.out.println("4. Registrar servicio");
        System.out.println("\n--- CONSULTAS ---");
        System.out.println("5. Listar clientes");
        System.out.println("6. Listar habitaciones");
        System.out.println("7. Listar servicios");
        System.out.println("8. Listar empleados");
        System.out.println("9. Seleccionar cliente");
        System.out.println("\n--- RESERVAS ---");
        System.out.println("10. Crear reserva");
        System.out.println("11. Confirmar reserva");
        System.out.println("12. Activar reserva (check-in)");
        System.out.println("13. Cancelar reserva");
        System.out.println("14. Finalizar reserva (check-out)");
        System.out.println("15. Agregar servicio a reserva");
        System.out.println("16. Ver todas las reservas");
        System.out.println("17. Ver reservas del cliente");
        System.out.println("\n--- FACTURAS ---");
        System.out.println("18. Ver facturas del cliente");
        System.out.println("19. Pagar factura");
        System.out.println("\n20. Salir");
        System.out.println("========================================");
        
        if (clienteActual != null) {
            System.out.println("Cliente actual: " + clienteActual.getNombre());
        } else {
            System.out.println("Cliente actual: NINGUNO");
        }
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
}//fin de la clase