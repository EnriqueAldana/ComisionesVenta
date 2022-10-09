package com.reactiv.model;

import java.time.LocalDate;

public class Venta {
	
	
	private LocalDate fecha= LocalDate.now();
	private String folio="";
	private String cliente="";
	private String nombre="";
	private Double monto=0.0;
	private LocalDate fechaPago= LocalDate.now();
	private int diasPago= 0;
	private Double comisionPorcentaje=0.0;
	private Double comisionMonto=0.0;
	
	/**
	 * @param fecha
	 * @param folio
	 * @param cliente
	 * @param nombre
	 * @param monto
	 * @param fechaPago
	 */
	public Venta(LocalDate fecha, String folio, String cliente, String nombre, Double monto, LocalDate fechaPago) {
		this.fecha = fecha;
		this.folio = folio;
		this.cliente = cliente;
		this.nombre = nombre;
		this.monto = monto;
		this.fechaPago = fechaPago;
	}
	public Venta() {
		// TODO Auto-generated constructor stub
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
	public int getDiasPago() {
		return diasPago;
	}
	public void setDiasPago(int diasPago) {
		this.diasPago = diasPago;
	}
	@Override
	public String toString() {
		return "\n"+"Venta [fecha=" + fecha + ", folio=" + folio + ", cliente=" + cliente + ", nombre=" + nombre + ", monto="
				+ monto + ", fechaPago=" + fechaPago + ", diasPago=" + diasPago + ", comisionPorcentaje="
				+ comisionPorcentaje + ", comisionMonto=" + comisionMonto + "]";
	}
	
	
	
	
	

}
