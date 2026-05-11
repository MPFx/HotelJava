package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa la factura de una reserva.
 * Calcula el total incluyendo IVA (19%).
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Reserva
 */
public class Factura {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la factura. */
    private int idFactura;
    
    /** Reserva asociada. */
    private Reserva reserva;
    
    /** Fecha de emision. */
    private LocalDateTime fechaEmision;
    
    /** Subtotal (sin IVA). */
    private double subtotal;
    
    /** IVA (19%). */
    private double iva;
    
    /** Total a pagar. */
    private double total;
    
    /** Indica si la factura fue pagada. */
    private boolean pagada;
    
    /** Contador estatico para generar IDs. */
    private static int contadorIds = 1;
    
    /** Porcentaje de IVA (19%). */
    private static final double IVA_PORCENTAJE = 0.19;
    
    /**
     * Constructor para crear una factura.
     * 
     * @param reserva Reserva asociada
     */
    public Factura(Reserva reserva) {
        this.idFactura = contadorIds++;
        this.reserva = reserva;
        this.fechaEmision = LocalDateTime.now();
        this.pagada = false;
        calcularTotal();
    }
    
    /**
     * Calcula el total incluyendo IVA.
     */
    private void calcularTotal() {
        this.subtotal = reserva.calcularTotal();
        this.iva = subtotal * IVA_PORCENTAJE;
        this.total = subtotal + iva;
    }
    
    /**
     * Marca la factura como pagada.
     */
    public void pagar() {
        this.pagada = true;
        System.out.println("Factura pagada. Total: $" + total);
    }
    
    // ==================== GETTERS ====================
    
    /** @return Identificador de la factura */
    public int getIdFactura() {
        return idFactura;
    }
    
    /** @return Reserva asociada */
    public Reserva getReserva() {
        return reserva;
    }
    
    /** @return Fecha de emision */
    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }
    
    /** @return Subtotal */
    public double getSubtotal() {
        return subtotal;
    }
    
    /** @return IVA */
    public double getIva() {
        return iva;
    }
    
    /** @return Total */
    public double getTotal() {
        return total;
    }
    
    /** @return true si esta pagada */
    public boolean isPagada() {
        return pagada;
    }
    
    /**
     * Devuelve una representacion textual de la factura.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String estado = pagada ? "PAGADA" : "PENDIENTE";
        return "Factura #" + idFactura + " - " + reserva.getCliente().getNombre() +
               " - Subtotal: $" + subtotal + " + IVA $" + iva + " = $" + total +
               " - " + estado + " - " + fechaEmision.format(formatter);
    }
    
}//fin de la clase