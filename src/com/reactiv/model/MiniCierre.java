package com.reactiv.model;

import java.time.LocalDate;

public class MiniCierre {

	private Double Minicierre1;
	//= 500.0;
	private LocalDate Minicierre1Fecha;
	//= LocalDate.of(2021, 01, 06);
	// Este dato lo dan cada mes
	private Double Minicierre1PorcentajeMeta;
	//= 30.0;
	
	private Double Minicierre2;
	//= 800.0;
	private LocalDate Minicierre2Fecha;
	//= LocalDate.of(2021, 01, 13);
	// Este dato lo dan cada mes
		private Double Minicierre2PorcentajeMeta; 
		//= 55.0;
	private Double Minicierre3= 1100.0;
	private LocalDate Minicierre3Fecha;
	//= LocalDate.of(2021, 01, 20);
	// Este dato lo dan cada mes
		private Double Minicierre3PorcentajeMeta ;
		//= 80.0;
		
	private Double Minicierre4;
	//= 1300.0;
	private LocalDate Minicierre4Fecha;
	//= LocalDate.of(2021, 01, 27);
	// Este dato lo dan cada mes
	private Double Minicierre4PorcentajeMeta;
	//= 95.0;
	/**
	 * @param minicierre1
	 * @param minicierre1Fecha
	 * @param minicierre1PorcentajeMeta
	 * @param minicierre2
	 * @param minicierre2Fecha
	 * @param minicierre2PorcentajeMeta
	 * @param minicierre3
	 * @param minicierre3Fecha
	 * @param minicierre3PorcentajeMeta
	 * @param minicierre4
	 * @param minicierre4Fecha
	 * @param minicierre4PorcentajeMeta
	 */
	public MiniCierre() {
		
	}
	public MiniCierre(Double minicierre1, LocalDate minicierre1Fecha, Double minicierre1PorcentajeMeta,
			Double minicierre2, LocalDate minicierre2Fecha, Double minicierre2PorcentajeMeta, Double minicierre3,
			LocalDate minicierre3Fecha, Double minicierre3PorcentajeMeta, Double minicierre4,
			LocalDate minicierre4Fecha, Double minicierre4PorcentajeMeta) {
		Minicierre1 = minicierre1;
		Minicierre1Fecha = minicierre1Fecha;
		Minicierre1PorcentajeMeta = minicierre1PorcentajeMeta;
		Minicierre2 = minicierre2;
		Minicierre2Fecha = minicierre2Fecha;
		Minicierre2PorcentajeMeta = minicierre2PorcentajeMeta;
		Minicierre3 = minicierre3;
		Minicierre3Fecha = minicierre3Fecha;
		Minicierre3PorcentajeMeta = minicierre3PorcentajeMeta;
		Minicierre4 = minicierre4;
		Minicierre4Fecha = minicierre4Fecha;
		Minicierre4PorcentajeMeta = minicierre4PorcentajeMeta;
	}
	public Double getMinicierre1() {
		return Minicierre1;
	}
	public void setMinicierre1(Double minicierre1) {
		Minicierre1 = minicierre1;
	}
	public LocalDate getMinicierre1Fecha() {
		return Minicierre1Fecha;
	}
	public void setMinicierre1Fecha(LocalDate minicierre1Fecha) {
		Minicierre1Fecha = minicierre1Fecha;
	}
	public Double getMinicierre1PorcentajeMeta() {
		return Minicierre1PorcentajeMeta;
	}
	public void setMinicierre1PorcentajeMeta(Double minicierre1PorcentajeMeta) {
		Minicierre1PorcentajeMeta = minicierre1PorcentajeMeta;
	}
	public Double getMinicierre2() {
		return Minicierre2;
	}
	public void setMinicierre2(Double minicierre2) {
		Minicierre2 = minicierre2;
	}
	public LocalDate getMinicierre2Fecha() {
		return Minicierre2Fecha;
	}
	public void setMinicierre2Fecha(LocalDate minicierre2Fecha) {
		Minicierre2Fecha = minicierre2Fecha;
	}
	public Double getMinicierre2PorcentajeMeta() {
		return Minicierre2PorcentajeMeta;
	}
	public void setMinicierre2PorcentajeMeta(Double minicierre2PorcentajeMeta) {
		Minicierre2PorcentajeMeta = minicierre2PorcentajeMeta;
	}
	public Double getMinicierre3() {
		return Minicierre3;
	}
	public void setMinicierre3(Double minicierre3) {
		Minicierre3 = minicierre3;
	}
	public LocalDate getMinicierre3Fecha() {
		return Minicierre3Fecha;
	}
	public void setMinicierre3Fecha(LocalDate minicierre3Fecha) {
		Minicierre3Fecha = minicierre3Fecha;
	}
	public Double getMinicierre3PorcentajeMeta() {
		return Minicierre3PorcentajeMeta;
	}
	public void setMinicierre3PorcentajeMeta(Double minicierre3PorcentajeMeta) {
		Minicierre3PorcentajeMeta = minicierre3PorcentajeMeta;
	}
	public Double getMinicierre4() {
		return Minicierre4;
	}
	public void setMinicierre4(Double minicierre4) {
		Minicierre4 = minicierre4;
	}
	public LocalDate getMinicierre4Fecha() {
		return Minicierre4Fecha;
	}
	public void setMinicierre4Fecha(LocalDate minicierre4Fecha) {
		Minicierre4Fecha = minicierre4Fecha;
	}
	public Double getMinicierre4PorcentajeMeta() {
		return Minicierre4PorcentajeMeta;
	}
	public void setMinicierre4PorcentajeMeta(Double minicierre4PorcentajeMeta) {
		Minicierre4PorcentajeMeta = minicierre4PorcentajeMeta;
	}
	


	
}
