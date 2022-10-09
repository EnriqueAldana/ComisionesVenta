package com.reactiv.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.reactiv.model.ComisionVenta;
import com.reactiv.model.MatrizConfiguracion;
import com.reactiv.model.MiniCierre;
import com.reactiv.model.PercepcionEconomicaMensual;
import com.reactiv.model.Venta;
import com.reactiv.utilerias.Utilerias;

public class CalcularComisionMensual {
	
	
	public static PercepcionEconomicaMensual calcularComisionMensual(List<PercepcionEconomicaMensual> listaMeses, PercepcionEconomicaMensual mes, List<Venta> listaVentas){
		
		// List<PercepcionEconomicaMensual> listaComisionesCalculadas = new ArrayList<PercepcionEconomicaMensual>();
		MatrizConfiguracion config = new MatrizConfiguracion();
		
		
		// Fijar el nombre del mes
		mes.setMes(Utilerias.mesNumeroAletra(mes.getMes_numero()));
		// Fijar ventas del mes.
		Double ventasMes= Utilerias.ventasDelMes(mes.getMes_numero(), mes.getAnio_numero() , listaVentas);
		mes.setVenta(ventasMes);
				
		// Fijar cuota mensual
		Double[] cuotaMensualConfiguracion = config.cuotaDeVentasAnuales.get(mes.getAnio_numero());
		Double cuotaVtasmes=ventasMes;  // por defecto lo vendido
		if(cuotaMensualConfiguracion != null) {	
			cuotaVtasmes= cuotaMensualConfiguracion[mes.getMes_numero()-1];
			if(cuotaVtasmes == 0) {
				cuotaVtasmes=ventasMes;
				mes.setMensaje("CUOTA Mensual fijada a Cero y por lo tanto se considera lo que se ha vendido");
				//throw new Exception("La configuracion de % de cuota mensual para el mes de " + mes.getMes() + " del "+mes.getAnio() + " no esta fijada.");
			}
		}else {
			mes.setMensaje("No se fijaron las cuotas mensuales para el año, se toma el valor de las ventas del mes.");
			cuotaVtasmes=ventasMes;
			//throw new Exception("No hay configuracion de % de cuota mensual para el año de " + mes.getAnio()); 
		}	
		mes.setCuota(cuotaVtasmes);
		
		// Fijar porcentaje cobertura mensual
		
		Double	porcientoCuotaMes= Utilerias.porcentaje(ventasMes,cuotaVtasmes);
		mes.setPorcentajeCoberturaMensual(porcientoCuotaMes);

		// Si EL PORCENTAJE DEL MES NO CUBRE LA META NO HAY COMISIONES
		Double[] porcentajeMinimoMensualParaComisionarLista= config.porcentajeMinimoMensualParaComisionar.get(mes.getAnio_numero());
		Double porcentajeMinimoMensualParaComisionar=0.0;
		if(porcentajeMinimoMensualParaComisionarLista != null){
			porcentajeMinimoMensualParaComisionar=porcentajeMinimoMensualParaComisionarLista[mes.getMes_numero()-1];
		}
		
		boolean cubre= porcientoCuotaMes >= porcentajeMinimoMensualParaComisionar ? true: false;
		//if (cubre || !config.REGLA_PORCIENTO_CUMPLIMIENTO_MENSUAL) {
		
			if(cubre) {
				mes.setMensaje("MES SI CUBRE");
			}else {
				 mes.setMensaje("MES NO CUBRE");
			}
			// Fijar bono de cuota mensual
			if(porcientoCuotaMes >= 100 && porcientoCuotaMes < 103 ) {
				mes.setCoberturaMensual(config.CoberturaMensual_100);
			}else if (porcientoCuotaMes >= 103 && porcientoCuotaMes < 106) {
				mes.setCoberturaMensual(config.CoberturaAnual_103);
			}else if (porcientoCuotaMes >= 106 && porcientoCuotaMes < 109) {
				mes.setCoberturaMensual(config.CoberturaMensual_106);
			}else if (porcientoCuotaMes >= 109 && porcientoCuotaMes < 115) {
				mes.setCoberturaMensual(config.CoberturaMensual_109);
			}else if (porcientoCuotaMes >= 115) {
				mes.setCoberturaMensual(config.CoberturaMensual_115);
			}
			
			// VARIABLE PARA MINICIERRES
			int numMinicierresCubiertos=0;
			// MINICIERRES
			
			// Fijar porcentaje meta MINICIERRE 1
			
			
			MiniCierre minicierreDelMes= new MiniCierre();
			String etiquetaminicierre= String.valueOf(mes.getMes_numero())+"-"+String.valueOf(mes.getAnio_numero());
			minicierreDelMes= config.miniCierres.get(etiquetaminicierre);
			
			if(Objects.isNull(minicierreDelMes)) {  // Asignar bonos ante la indefinicion
				mes.setMiniCierre1_bono(config.BonoMincierre1);
				mes.setMiniCierre2_bono(config.BonoMincierre2);
				mes.setMiniCierre3_bono(config.BonoMincierre3);
				mes.setMiniCierre4_bono(config.BonoMincierre4);
				mes.setMensaje("Los bonos de minicierres no han sido fijados. Se usaran por defecto.");
			}else{   // Usar las definiciones y calcular los bonos para cada minicierre
				// Minicierre 1
				Double ventasMinicierre1 = Utilerias.ventasAUnaFechaDelMes(minicierreDelMes.getMinicierre1Fecha(), listaVentas);
				Double porcentajeCobMinicierre1 = Utilerias.porcentaje(ventasMinicierre1, cuotaVtasmes);
				mes.setMiniCierre1_venta(ventasMinicierre1);
				mes.setMiniCierre1_porcentajeMeta(minicierreDelMes.getMinicierre1PorcentajeMeta());
				mes.setMiniCierre1_porcentajeCobertura(porcentajeCobMinicierre1);
				if(porcentajeCobMinicierre1 >= minicierreDelMes.getMinicierre1PorcentajeMeta()) {
					numMinicierresCubiertos++;
					mes.setMiniCierre1_bono(minicierreDelMes.getMinicierre1());
				}
				// Minicierre 2
				Double ventasMinicierre2 = Utilerias.ventasAUnaFechaDelMes(minicierreDelMes.getMinicierre2Fecha(), listaVentas);
				Double porcentajeCobMinicierre2 = Utilerias.porcentaje(ventasMinicierre2, cuotaVtasmes);
				mes.setMiniCierre2_venta(ventasMinicierre2);
				mes.setMiniCierre2_porcentajeMeta(minicierreDelMes.getMinicierre2PorcentajeMeta());
				mes.setMiniCierre2_porcentajeCobertura(porcentajeCobMinicierre2);
				if(porcentajeCobMinicierre2 >= minicierreDelMes.getMinicierre2PorcentajeMeta()) {
					numMinicierresCubiertos++;
					mes.setMiniCierre2_bono(minicierreDelMes.getMinicierre2());
				}
				// Miniierre 3
				Double ventasMinicierre3 = Utilerias.ventasAUnaFechaDelMes(minicierreDelMes.getMinicierre3Fecha(), listaVentas);
				Double porcentajeCobMinicierre3 = Utilerias.porcentaje(ventasMinicierre3, cuotaVtasmes);
				mes.setMiniCierre3_venta(ventasMinicierre3);
				mes.setMiniCierre3_porcentajeMeta(minicierreDelMes.getMinicierre3PorcentajeMeta());
				mes.setMiniCierre3_porcentajeCobertura(porcentajeCobMinicierre3);
				if(porcentajeCobMinicierre3 >= minicierreDelMes.getMinicierre3PorcentajeMeta()) {
					numMinicierresCubiertos++;
					mes.setMiniCierre3_bono(minicierreDelMes.getMinicierre3());
				}
				// minicierre 4
				Double ventasMinicierre4 = Utilerias.ventasAUnaFechaDelMes(minicierreDelMes.getMinicierre4Fecha(), listaVentas);
				Double porcentajeCobMinicierre4 = Utilerias.porcentaje(ventasMinicierre4, cuotaVtasmes);
				mes.setMiniCierre4_venta(ventasMinicierre4);
				mes.setMiniCierre4_porcentajeMeta(minicierreDelMes.getMinicierre4PorcentajeMeta());
				mes.setMiniCierre4_porcentajeCobertura(porcentajeCobMinicierre4);
				if(porcentajeCobMinicierre4 >= minicierreDelMes.getMinicierre4PorcentajeMeta()) {
					numMinicierresCubiertos++;
					mes.setMiniCierre4_bono(minicierreDelMes.getMinicierre4());
				}
			}
			
			
		//}  // Fin regla del 85
		
		// Fijar comisiones por Ventas cobradas.
		// Calcular Lo cobrado en el mes
		List<Venta> listaComisionesXCobranzaMes = new ArrayList<Venta>();
		listaComisionesXCobranzaMes = Utilerias.comisionesDelMes(mes.getMes_numero(), mes.getAnio_numero(), listaVentas);
		// Calcular lo pagado 
		// Regla de negocio.
		mes.setComisionPorCobranzaLista(listaComisionesXCobranzaMes);
		
		
		// Fijar bono trimestral. Si en el trimestre se cubrio se asigna un bono
		
		if(mes.getMes_numero() == 3 || mes.getMes_numero() == 6 || mes.getMes_numero() == 9 || mes.getMes_numero() == 12) {
			
			// El promedio del los ultimos 3 meses de la cobertura
			Double promedioTrimestre = 0.0;
			promedioTrimestre = (porcientoCuotaMes +
					            listaMeses.get(mes.getMes_numero()-2).getCoberturaMensual() +
					            listaMeses.get(mes.getMes_numero()-3).getCoberturaMensual())/3;
			
			if(promedioTrimestre >= 100.00 && promedioTrimestre < 103) {
				mes.setBonoTrimestral(MatrizConfiguracion.CoberturaTrimestral_100);
			}else if(promedioTrimestre >= 103.00 && promedioTrimestre < 106) {
				mes.setBonoTrimestral(MatrizConfiguracion.CoberturaTrimestral_103);
			}else if(promedioTrimestre >= 106.00 && promedioTrimestre < 109) {
				mes.setBonoTrimestral(MatrizConfiguracion.CoberturaTrimestral_106);
			}else if(promedioTrimestre >= 109.00 && promedioTrimestre < 115) {
				mes.setBonoTrimestral(MatrizConfiguracion.CoberturaTrimestral_109);
			}else if(promedioTrimestre >= 115.00 ) {
				mes.setBonoTrimestral(MatrizConfiguracion.CoberturaTrimestral_115);
			}
			
		}
		
		// Fijar bono Anual. Si se cubrio para el año hay un bono
		if(mes.getMes_numero() == 12 ) {
			
			// El promedio del los ultimos 3 meses de la cobertura
			Double promedioAnual = 0.0;
			
			for(int i=0; i< listaMeses.size(); i++) {
				promedioAnual= promedioAnual + listaMeses.get(i).getPorcentajeCoberturaMensual();
			}

			promedioAnual= (promedioAnual + porcientoCuotaMes) / 12;
			
			if(promedioAnual >= 100.00 && promedioAnual < 103) {
				mes.setBonoAnual(MatrizConfiguracion.CoberturaAnual_100);
			}else if(promedioAnual >= 103.00 && promedioAnual < 106) {
				mes.setBonoAnual(MatrizConfiguracion.CoberturaAnual_103);
			}else if(promedioAnual >= 106.00 && promedioAnual < 109) {
				mes.setBonoAnual(MatrizConfiguracion.CoberturaAnual_106);
			}else if(promedioAnual >= 109.00 && promedioAnual < 115) {
				mes.setBonoAnual(MatrizConfiguracion.CoberturaAnual_109);
			}else if(promedioAnual >= 115.00 ) {
				mes.setBonoAnual(MatrizConfiguracion.CoberturaAnual_115);
			}
			
		}
		
		return mes;
		
		
	}
	
	public CalcularComisionMensual() {
		
	}

}
