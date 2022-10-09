package com.reactiv.model;

import java.util.ArrayList;
import java.util.List;

public class PercepcionEconomicaMensual {
	
	private String mes="";
	private int mes_numero=0;

	private String anio="";
	private int anio_numero=0;
	
	private Double cuota=0.0;
	private Double venta=0.0;
	private Double porcentajeCoberturaMensual=0.0;
	
	private Double miniCierre1_porcentajeMeta=0.0;
	private Double miniCierre1_venta=0.0;
	private Double miniCierre1_porcentajeCobertura=0.0;
	private Double miniCierre1_bono=0.0;
	
	private Double miniCierre2_porcentajeMeta=0.0;
	private Double miniCierre2_venta=0.0;
	private Double miniCierre2_porcentajeCobertura=0.0;
	private Double miniCierre2_bono=0.0;
	
	private Double miniCierre3_porcentajeMeta=0.0;
	private Double miniCierre3_venta=0.0;
	private Double miniCierre3_porcentajeCobertura=0.0;
	private Double miniCierre3_bono=0.0;
	
	private Double miniCierre4_porcentajeMeta=0.0;
	private Double miniCierre4_venta=0.0;
	private Double miniCierre4_porcentajeCobertura=0.0;
	private Double miniCierre4_bono=0.0;
	
	// Solo si se cubrieron dos de los primeros tres
	private Double miniCierre2_3_bono=0.0;
	
	// Solo si el cuarto minicierre se cubrió.
	private Double miniCierre3_4_bono=0.0;
	
	// Bono por cobertura mensual con respecto a la meta mensual
	private Double coberturaMensual=0.0;
	
	private Double comisionPorCobranza=0.0;
	
	private List<Venta> comisionPorCobranzaLista= new ArrayList<Venta>();
	
	private Double bonoTrimestral=0.0;
	
	private Double bonoAnual=0.0;
	
	private String mensaje= "";
	
	public PercepcionEconomicaMensual() {
		
	}

	StringBuffer imprimeDetalleComisionVenta() {
		
		StringBuffer sb = new StringBuffer("");
		for(Venta comision: comisionPorCobranzaLista) {
			
			sb.append(comision.toString());
		}
		
		return sb;
	}

	public List<Venta> getComisionPorCobranzaLista() {
		return comisionPorCobranzaLista;
	}


	public void setComisionPorCobranzaLista(List<Venta> comisionPorCobranzaLista) {
		this.comisionPorCobranzaLista = comisionPorCobranzaLista;
	}

	
	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public int getMes_numero() {
		return mes_numero;
	}


	public void setMes_numero(int mes_numero) {
		this.mes_numero = mes_numero;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public int getAnio_numero() {
		return anio_numero;
	}


	public void setAnio_numero(int anio_numero) {
		this.anio_numero = anio_numero;
	}


	public Double getCuota() {
		return cuota;
	}


	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}


	public Double getVenta() {
		return venta;
	}


	public void setVenta(Double venta) {
		this.venta = venta;
	}


	public Double getPorcentajeCoberturaMensual() {
		return porcentajeCoberturaMensual;
	}


	public void setPorcentajeCoberturaMensual(Double porcentajeCoberturaMensual) {
		this.porcentajeCoberturaMensual = porcentajeCoberturaMensual;
	}


	public Double getMiniCierre1_porcentajeMeta() {
		return miniCierre1_porcentajeMeta;
	}


	public void setMiniCierre1_porcentajeMeta(Double miniCierre1_porcentajeMeta) {
		this.miniCierre1_porcentajeMeta = miniCierre1_porcentajeMeta;
	}


	public Double getMiniCierre1_venta() {
		return miniCierre1_venta;
	}


	public void setMiniCierre1_venta(Double miniCierre1_venta) {
		this.miniCierre1_venta = miniCierre1_venta;
	}


	public Double getMiniCierre1_porcentajeCobertura() {
		return miniCierre1_porcentajeCobertura;
	}


	public void setMiniCierre1_porcentajeCobertura(Double miniCierre1_porcentajeCobertura) {
		this.miniCierre1_porcentajeCobertura = miniCierre1_porcentajeCobertura;
	}


	public Double getMiniCierre1_bono() {
		return miniCierre1_bono;
	}


	public void setMiniCierre1_bono(Double miniCierre1_bono) {
		this.miniCierre1_bono = miniCierre1_bono;
	}


	public Double getMiniCierre2_porcentajeMeta() {
		return miniCierre2_porcentajeMeta;
	}


	public void setMiniCierre2_porcentajeMeta(Double miniCierre2_porcentajeMeta) {
		this.miniCierre2_porcentajeMeta = miniCierre2_porcentajeMeta;
	}


	public Double getMiniCierre2_venta() {
		return miniCierre2_venta;
	}


	public void setMiniCierre2_venta(Double miniCierre2_venta) {
		this.miniCierre2_venta = miniCierre2_venta;
	}


	public Double getMiniCierre2_porcentajeCobertura() {
		return miniCierre2_porcentajeCobertura;
	}


	public void setMiniCierre2_porcentajeCobertura(Double miniCierre2_porcentajeCobertura) {
		this.miniCierre2_porcentajeCobertura = miniCierre2_porcentajeCobertura;
	}


	public Double getMiniCierre2_bono() {
		return miniCierre2_bono;
	}


	public void setMiniCierre2_bono(Double miniCierre2_bono) {
		this.miniCierre2_bono = miniCierre2_bono;
	}


	public Double getMiniCierre3_porcentajeMeta() {
		return miniCierre3_porcentajeMeta;
	}


	public void setMiniCierre3_porcentajeMeta(Double miniCierre3_porcentajeMeta) {
		this.miniCierre3_porcentajeMeta = miniCierre3_porcentajeMeta;
	}


	public Double getMiniCierre3_venta() {
		return miniCierre3_venta;
	}


	public void setMiniCierre3_venta(Double miniCierre3_venta) {
		this.miniCierre3_venta = miniCierre3_venta;
	}


	public Double getMiniCierre3_porcentajeCobertura() {
		return miniCierre3_porcentajeCobertura;
	}


	public void setMiniCierre3_porcentajeCobertura(Double miniCierre3_porcentajeCobertura) {
		this.miniCierre3_porcentajeCobertura = miniCierre3_porcentajeCobertura;
	}


	public Double getMiniCierre3_bono() {
		return miniCierre3_bono;
	}


	public void setMiniCierre3_bono(Double miniCierre3_bono) {
		this.miniCierre3_bono = miniCierre3_bono;
	}


	public Double getMiniCierre4_porcentajeMeta() {
		return miniCierre4_porcentajeMeta;
	}


	public void setMiniCierre4_porcentajeMeta(Double miniCierre4_porcentajeMeta) {
		this.miniCierre4_porcentajeMeta = miniCierre4_porcentajeMeta;
	}


	public Double getMiniCierre4_venta() {
		return miniCierre4_venta;
	}


	public void setMiniCierre4_venta(Double miniCierre4_venta) {
		this.miniCierre4_venta = miniCierre4_venta;
	}


	public Double getMiniCierre4_porcentajeCobertura() {
		return miniCierre4_porcentajeCobertura;
	}


	public void setMiniCierre4_porcentajeCobertura(Double miniCierre4_porcentajeCobertura) {
		this.miniCierre4_porcentajeCobertura = miniCierre4_porcentajeCobertura;
	}


	public Double getMiniCierre4_bono() {
		return miniCierre4_bono;
	}


	public void setMiniCierre4_bono(Double miniCierre4_bono) {
		this.miniCierre4_bono = miniCierre4_bono;
	}


	public Double getMiniCierre2_3_bono() {
		return miniCierre2_3_bono;
	}


	public void setMiniCierre2_3_bono(Double miniCierre2_3_bono) {
		this.miniCierre2_3_bono = miniCierre2_3_bono;
	}


	public Double getMiniCierre3_4_bono() {
		return miniCierre3_4_bono;
	}


	public void setMiniCierre3_4_bono(Double miniCierre3_4_bono) {
		this.miniCierre3_4_bono = miniCierre3_4_bono;
	}


	public Double getCoberturaMensual() {
		return coberturaMensual;
	}


	public void setCoberturaMensual(Double coberturaMensual) {
		this.coberturaMensual = coberturaMensual;
	}


	public Double getComisionPorCobranza() {
		return comisionPorCobranza;
	}


	public void setComisionPorCobranza(Double comisionPorCobranza) {
		this.comisionPorCobranza = comisionPorCobranza;
	}


	public Double getBonoTrimestral() {
		return bonoTrimestral;
	}


	public void setBonoTrimestral(Double bonoTrimestral) {
		this.bonoTrimestral = bonoTrimestral;
	}


	public Double getBonoAnual() {
		return bonoAnual;
	}


	public void setBonoAnual(Double bonoAnual) {
		this.bonoAnual = bonoAnual;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	@Override
	public String toString() {
		return 	"\n"+ 
				"\n"+ 
				"Percepcion Economica Mensual del mes de " + mes + " año " + anio +
				"\n"+
				mensaje +
				 "\n"+"Cuota de ventas: " + cuota + 
				 "\n"+"Venta del mes: " + venta + 
				 "\n"+ "Porcentaje Cobertura Mensual: " + porcentajeCoberturaMensual +
				 "\n"+
				 "\n"+"Mini Cierre 1 % Meta: "+ miniCierre1_porcentajeMeta + 
				 "\n"+"Mini Cierre 1 Venta: " + miniCierre1_venta +
				 "\n"+"Mini Cierre 1 % Cobertura: " + miniCierre1_porcentajeCobertura + 
				 "\n"+"Mini Cierre 1 Bono: "+ miniCierre1_bono + 
				 "\n"+
				 "\n"+ "Mini Cierre 2 % Meta: " + miniCierre2_porcentajeMeta +
				 "\n"+ "Mini Cierre 2 Venta: " + miniCierre2_venta + 
				 "\n"+ "Mini Cierre 2 % Cobertura: "+ miniCierre2_porcentajeCobertura + 
				 "\n"+ "Mini Cierre 2 Bono: " + miniCierre2_bono +
				 "\n"+
				 "\n"+ "Mini Cierre 3 % Meta:" + miniCierre3_porcentajeMeta +
				 "\n"+ "Mini Cierre 3 Venta: "+ miniCierre3_venta + 
				 "\n"+ "Mini Cierre 3 % Cobertura: " + miniCierre3_porcentajeCobertura +
				 "\n"+ "Mini Cierre 3 Bono: " + miniCierre3_bono + 
				 "\n"+
				 "\n"+ "Mini Cierre 4 % Meta:"+ miniCierre4_porcentajeMeta + 
				 "\n"+ "Mini Cierre 4 Venta: " + miniCierre4_venta +
				 "\n"+ "Mini Cierre 4 % Cobertura: " + miniCierre4_porcentajeCobertura + 
				 "\n"+ "Mini Cierre 4 Bono: "+ miniCierre4_bono + 
				 "\n"+
				 "\n"+"Cobertura de 2 cuotas de mini cierre: " + miniCierre2_3_bono + 
				 "\n"+"Cobertura de 3 cuotas de mini cierre: "+ miniCierre3_4_bono + 
				 "\n"+
				 "\n"+"Bono por cobertura mensual minima: " + coberturaMensual + 
				 "\n"+"Comisiones por cobranza: "+ comisionPorCobranza +
				 "\n"+"Detalle Ventas: "+ imprimeDetalleComisionVenta() +
				 "\n"+"Bono trimestral: " + bonoTrimestral + 
				 "\n"+"Bono anual : " + bonoAnual + "\n";
	}


	
	
	
	
	
}
