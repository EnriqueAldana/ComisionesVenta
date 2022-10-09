package com.reactiv.model;
import java.time.LocalDate;

import com.reactiv.model.Venta;

public class ComisionVenta extends Venta {
	
	Double comisionPorcentaje=0.0;
	Double comisionMonto=0.0;
	/**
	 * 
	 */
	public ComisionVenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fecha
	 * @param folio
	 * @param cliente
	 * @param nombre
	 * @param monto
	 * @param fechaPago
	 */
	public ComisionVenta(LocalDate fecha, String folio, String cliente, String nombre, Double monto,
			LocalDate fechaPago) {
		super(fecha, folio, cliente, nombre, monto, fechaPago);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fecha
	 * @param folio
	 * @param cliente
	 * @param nombre
	 * @param monto
	 * @param fechaPago
	 * @param comisionPorcentaje
	 * @param comisionMonto
	 */
	public ComisionVenta(LocalDate fecha, String folio, String cliente, String nombre, Double monto,
			LocalDate fechaPago, Double comisionPorcentaje, Double comisionMonto) {
		super(fecha, folio, cliente, nombre, monto, fechaPago);
		this.comisionPorcentaje = comisionPorcentaje;
		this.comisionMonto = comisionMonto;
	}
	public Double getComisionPorcentaje() {
		return comisionPorcentaje;
	}
	public void setComisionPorcentaje(Double comisionPorcentaje) {
		this.comisionPorcentaje = comisionPorcentaje;
	}
	public Double getComisionMonto() {
		return comisionMonto;
	}
	public void setComisionMonto(Double comisionMonto) {
		this.comisionMonto = comisionMonto;
	}
	@Override
	public String toString() {
		return "\n" +"ComisionVenta [comisionPorcentaje=" + comisionPorcentaje + ", comisionMonto=" + comisionMonto
				+ ", getFecha()=" + getFecha() + ", getFolio()=" + getFolio() + ", getCliente()=" + getCliente()
				+ ", getNombre()=" + getNombre() + ", getMonto()=" + getMonto() + ", getFechaPago()=" + getFechaPago()
				+ "]";
	}
	
	

}
