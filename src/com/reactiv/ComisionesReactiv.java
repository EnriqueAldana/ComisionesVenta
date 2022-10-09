/**
 * 
 */
package com.reactiv;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.reactiv.BO.CalcularComision;
import com.reactiv.BO.CalcularComisionAnual;
import com.reactiv.data.Data;
import com.reactiv.model.PercepcionEconomicaMensual;
import com.reactiv.model.Venta;
import com.reactiv.utilerias.Utilerias;

/**
 * @author enrique
 *
 */
public class ComisionesReactiv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.print("Calculo de las comisiones para ejecutivo comercial");

		//  1.- Recibir una lista de facturas con los datos
		// Lista de ventas globales, significa que incluye años y meses ordenadas cronologicamente por fecha de emision.
		
		List<Venta>  listaVentas = new ArrayList<Venta>();
		listaVentas = Utilerias.CSVCargar();

		System.out.print("\n" + " ======== Detalle de ventas ==========");
		for(Venta venta:listaVentas) {
			System.out.print(venta.toString());
		}
		
		// Determinar fecha inicial del calculo y fecha final
		Map<String, LocalDate> fechasIniYFin= Utilerias.fechaIniYFinDeLista(listaVentas);
		
		if(fechasIniYFin.isEmpty()) {
			System.out.print("\n");
			System.out.print("No hay lista de datos por gestionar. Asegure de cargar datos desde el archivo");
			// exit(0) - Indicates successful termination
			// exit(1) - Indicates unsuccessful termination
			// exit(-1) - Indicates unsuccessful termination with Exception
			System.exit(1);
		}
		
		LocalDate fechaIni=null;
		LocalDate fechaFin=null;
		if(fechasIniYFin.containsKey("fechaIni")) {
			fechaIni=fechasIniYFin.get("fechaIni");
			System.out.print("\n"+"Fecha inicial de registro de ventas: " + fechaIni.toString());	
		}
			
		if(fechasIniYFin.containsKey("fechaFin")) {
			fechaFin=fechasIniYFin.get("fechaFin");
			System.out.print("\n"+"Fecha final de registro de ventas: " + fechaFin.toString());
		}
		
		if(fechaIni != null && fechaFin!= null ) {
			if( fechaIni.isBefore(fechaFin)) {
				
				// Aqui calcular anualidades
				// 3.- Calcular Comisiones
				// 3.1 Calcular para todo el año. considerando datos de 61 dias atras.
				
				List<PercepcionEconomicaMensual> listaMeses = CalcularComision.calcularComisionesGlobales(fechaIni,fechaFin,listaVentas);
						//CalcularComisionAnual.calcularComisionAnual(2021,listaVentas);
				
				
				for(int x=0; x< listaMeses.size() ; x++) {
					System.out.print("");
					System.out.print(listaMeses.get(x).toString());
					
				}
				
			}else {
				System.out.print("\n");
				System.out.print("Las fechas de inicio y fin de los registros de ventas no son adecuados. Asegurece de ordenar los registros de fecha de manera ascendente");
				// exit(0) - Indicates successful termination
				// exit(1) - Indicates unsuccessful termination
				// exit(-1) - Indicates unsuccessful termination with Exception
				System.exit(1);
			}
		}
		
	}


}
