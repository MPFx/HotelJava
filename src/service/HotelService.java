package service;

import model.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las operaciones generales del hotel.
 * Permite registrar clientes, empleados, habitaciones y servicios.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Cliente
 * @see Empleado
 * @see Habitacion
 * @see Servicio
 */
public class HotelService {
    
    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private List<Habitacion> habitaciones;
    private List<Servicio> servicios;
    
    /**
     * Constructor del servicio del hotel.
     * 
     * @param clientes Lista de clientes
     * @param empleados Lista de empleados
     * @param habitaciones Lista de habitaciones
     * @param servicios Lista de servicios
     */
    public HotelService(List<Cliente> clientes, List<Empleado> empleados, 
                        List<Habitacion> habitaciones, List<Servicio> servicios) {
        this.clientes = clientes;
        this.empleados = empleados;
        this.habitaciones = habitaciones;
        this.servicios = servicios;
    }
    
    /**
     * Registra un nuevo cliente.
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void registrarCliente(Scanner scanner) {
        System.out.println("\n=== REGISTRAR CLIENTE ===");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Documento de identidad: ");
        String documento = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, telefono, email, documento);
        clientes.add(cliente);
        
        System.out.println("\n✅ Cliente registrado exitosamente!");
        System.out.println(cliente);
    }
    
    /**
     * Registra un nuevo empleado.
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void registrarEmpleado(Scanner scanner) {
        System.out.println("\n=== REGISTRAR EMPLEADO ===");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Empleado empleado = new Empleado(nombre, telefono, email);
        
        System.out.print("Cargo: ");
        empleado.setCargo(scanner.nextLine());
        
        System.out.print("Salario: ");
        empleado.setSalario(Double.parseDouble(scanner.nextLine()));
        
        System.out.print("Horario: ");
        empleado.setHorario(scanner.nextLine());
        
        empleados.add(empleado);
        System.out.println("\n✅ Empleado registrado exitosamente!");
        System.out.println(empleado);
    }
    
    /**
     * Registra una nueva habitacion.
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void registrarHabitacion(Scanner scanner) {
        System.out.println("\n=== REGISTRAR HABITACION ===");
        
        System.out.println("Tipo de habitacion:");
        System.out.println("1. Simple (2 personas, 1 cama)");
        System.out.println("2. Doble (4 personas, 2 camas)");
        System.out.println("3. Suite (6 personas, 3 camas, extras)");
        System.out.print("Seleccione: ");
        
        int tipo = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Numero: ");
        int numero = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Piso: ");
        int piso = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Precio base por noche: $");
        double precio = Double.parseDouble(scanner.nextLine());
        
        Habitacion habitacion = switch (tipo) {
            case 2 -> new HabitacionDoble(numero, piso, precio);
            case 3 -> new HabitacionSuite(numero, piso, precio);
            default -> new HabitacionSimple(numero, piso, precio);
        };
        
        System.out.print("Descripcion: ");
        habitacion.setDescripcion(scanner.nextLine());
        
        habitaciones.add(habitacion);
        System.out.println("\n✅ Habitacion registrada exitosamente!");
        System.out.println(habitacion);
    }
    
    /**
     * Registra un nuevo servicio.
     * 
     * @param scanner Scanner para entrada de datos
     */
    public void registrarServicio(Scanner scanner) {
        System.out.println("\n=== REGISTRAR SERVICIO ===");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Costo: $");
        double costo = Double.parseDouble(scanner.nextLine());
        
        Servicio servicio = new Servicio(nombre, costo);
        
        System.out.print("Descripcion: ");
        servicio.setDescripcion(scanner.nextLine());
        
        servicios.add(servicio);
        System.out.println("\n✅ Servicio registrado exitosamente!");
        System.out.println(servicio);
    }
    
    /**
     * Lista todos los clientes.
     */
    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }
        
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    
    /**
     * Lista todas las habitaciones.
     */
    public void listarHabitaciones() {
        System.out.println("\n=== LISTA DE HABITACIONES ===");
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas");
            return;
        }
        
        for (Habitacion h : habitaciones) {
            System.out.println(h);
        }
    }
    
    /**
     * Lista todos los servicios.
     */
    public void listarServicios() {
        System.out.println("\n=== LISTA DE SERVICIOS ===");
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados");
            return;
        }
        
        for (Servicio s : servicios) {
            System.out.println(s);
        }
    }
    
    /**
     * Lista todos los empleados.
     */
    public void listarEmpleados() {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }
        
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }
    
    /**
     * Busca un cliente por ID.
     * 
     * @param scanner Scanner para entrada de datos
     * @return Cliente encontrado
     */
    public Cliente buscarCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Cliente cliente = clientes.stream()
                .filter(c -> c.getIdPersona() == id)
                .findFirst().orElse(null);
        
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
        }
        return cliente;
    }
    
    /**
     * Muestra facturas pendientes de un cliente.
     * 
     * @param facturas Lista de facturas
     * @param cliente Cliente
     */
    public void mostrarFacturasCliente(List<Factura> facturas, Cliente cliente) {
        if (cliente == null) {
            System.out.println("No hay cliente seleccionado");
            return;
        }
        
        System.out.println("\n=== FACTURAS DE " + cliente.getNombre().toUpperCase() + " ===");
        List<Factura> facturasCliente = facturas.stream()
                .filter(f -> f.getReserva().getCliente().getIdPersona() == cliente.getIdPersona())
                .toList();
        
        if (facturasCliente.isEmpty()) {
            System.out.println("No hay facturas para este cliente");
            return;
        }
        
        double totalPendiente = 0;
        for (Factura f : facturasCliente) {
            System.out.println(f);
            if (!f.isPagada()) {
                totalPendiente += f.getTotal();
            }
        }
        System.out.println("\nTotal pendiente: $" + totalPendiente);
    }
    
    /**
     * Paga una factura.
     * 
     * @param scanner Scanner para entrada de datos
     * @param facturas Lista de facturas
     */
    public void pagarFactura(Scanner scanner, List<Factura> facturas) {
        System.out.print("ID de la factura: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Factura factura = facturas.stream()
                .filter(f -> f.getIdFactura() == id)
                .findFirst().orElse(null);
        
        if (factura == null) {
            System.out.println("Factura no encontrada");
            return;
        }
        
        factura.pagar();
    }
    
    /**
     * Obtiene la lista de clientes.
     * 
     * @return Lista de clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    /**
     * Obtiene la lista de habitaciones.
     * 
     * @return Lista de habitaciones
     */
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    /**
     * Obtiene la lista de servicios.
     * 
     * @return Lista de servicios
     */
    public List<Servicio> getServicios() {
        return servicios;
    }
    
}//fin de la clase