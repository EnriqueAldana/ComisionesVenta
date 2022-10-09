package com.reactiv.BO;

import java.util.ArrayList;
import java.util.List;

import com.reactiv.model.MatrizConfiguracion;
import com.reactiv.model.PercepcionEconomicaMensual;
import com.reactiv.model.Venta;
import com.reactiv.utilerias.Utilerias;

public class CalcularComisionAnual {
	
	
	public CalcularComisionAnual() {
		
	}
	

	public static List<PercepcionEconomicaMensual> calcularComisionAnual(int anio, List<Venta> listaVentasAnual){
		
		List<PercepcionEconomicaMensual> listaMesesAnual = new ArrayList<PercepcionEconomicaMensual>();
		
		for(int i=1; i<13; i++) {
			// Calcular mes del año configurado
			PercepcionEconomicaMensual calculoMensual = new PercepcionEconomicaMensual();
			calculoMensual.setAnio(String.valueOf(anio));
			calculoMensual.setAnio_numero(anio);
			calculoMensual.setMes_numero(i);
			calculoMensual=CalcularComisionMensual.calcularComisionMensual(listaMesesAnual,calculoMensual, listaVentasAnual);
			listaMesesAnual.add(calculoMensual);
		}
		
		return listaMesesAnual;
		
	}
}
