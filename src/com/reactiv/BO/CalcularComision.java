package com.reactiv.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.reactiv.model.PercepcionEconomicaMensual;
import com.reactiv.model.Venta;

public class CalcularComision {
	
	public CalcularComision() {
		
	}
	
	
	public static List<PercepcionEconomicaMensual> calcularComisionesGlobales( LocalDate fechaIni, LocalDate fechaFin,List<Venta>  listaVentasGlobales) {
		
		List<PercepcionEconomicaMensual> listaMesesGlobal = new ArrayList<PercepcionEconomicaMensual>();
		
		int mesInicio= fechaIni.getMonthValue();
		int anioInicio= fechaIni.getYear();
		int mesFin= fechaFin.getMonthValue();
		int anioFin= fechaFin.getYear();
		for(int i=anioInicio; i<= anioFin ; i++) {
			for(int j=1; j<=12; j++) {
				// Calcular meses del año
				PercepcionEconomicaMensual calculoMensual = new PercepcionEconomicaMensual();
				calculoMensual.setAnio(String.valueOf(i));
				calculoMensual.setAnio_numero(i);
				calculoMensual.setMes_numero(j);
				calculoMensual=CalcularComisionMensual.calcularComisionMensual(listaMesesGlobal,calculoMensual, listaVentasGlobales);
				listaMesesGlobal.add(calculoMensual);
			}
		}
		
		
		return listaMesesGlobal;


	}

}
