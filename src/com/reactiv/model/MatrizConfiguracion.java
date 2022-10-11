/**
 * 
 */
package com.reactiv.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author enrique
 *
 */
public class  MatrizConfiguracion {
	
	public static boolean REGLA_PORCIENTO_CUMPLIMIENTO_MENSUAL= true;
	
	public static int anioXCalcular = 2021;

	// Cuotas de Ventas mensuales para el año por calcular, establecer doce valores en Pesos
	public static Double[] cuotaDeVentasMensual2021=
				{1000.00,2000.00,3000.00,4000.00,5000.0,6000.0,7000.0,8000.0,9000.0,10000.0,11000.0,4399299.0};
	
	public static Map<Integer,Double[]> cuotaDeVentasAnuales=  new HashMap<Integer, Double[]>();
	
	//  Porcentaje minimo mensual para tener derecho a comisionar
	public static Double[] porcentajeMinimoMensualParaComisionar2021= {85.00,85.00,85.00,85.00
			,85.00,85.00,85.00,85.00,85.00,85.00,85.00,85.00};
	
	public static Map<Integer,Double[]> porcentajeMinimoMensualParaComisionar=  new HashMap<Integer, Double[]>();
	
	
	MiniCierre minicierreDiciembre2021= new MiniCierre(
			500.00, LocalDate.of(2021, 01, 06),30.00,
			800.00,LocalDate.of(2021, 01, 13),55.00,
			1100.00,LocalDate.of(2021, 01, 20),80.00,
			1300.00,LocalDate.of(2021, 01, 27),95.00
			);
	

	public static Map<String,MiniCierre> miniCierres=  new HashMap<String, MiniCierre>();
	
	public static Double BonoMincierre1= 500.00;
	public static Double BonoMincierre2= 800.00;
	public static Double BonoMincierre3= 1100.00;
	public static Double BonoMincierre4= 1300.00;
	
	public static Double Minicierre2_3= 600.0;
	public static Double Minicierre3_4= 1800.0;
	
	// Ventas del mes con respecto a la cuota mensual
	public static Double CoberturaMensual_100=1300.0;
	public static Double CoberturaMensual_103=1700.0;
	public static Double CoberturaMensual_106=2000.0;
	public static Double CoberturaMensual_109=2400.0;
	public static Double CoberturaMensual_115=3000.0;
	
	// El promedio de ventas por trimestre
	public static Double CoberturaTrimestral_100= 4200.0;
	public static Double CoberturaTrimestral_103= 5400.0;
	public static Double CoberturaTrimestral_106= 6900.0;
	public static Double CoberturaTrimestral_109= 8400.0;
	public static Double CoberturaTrimestral_115= 11000.0;
	
	public static Double CoberturaAnual_100= 12000.0;
	public static Double CoberturaAnual_103= 15000.0;
	public static Double CoberturaAnual_106= 18000.0;
	public static Double CoberturaAnual_109= 22000.0;
	public static Double CoberturaAnual_115= 30000.0;
	
	public static int DiasCredito_7 = 7;
	public static int DiasCredito_15 = 15;
	public static int DiasCredito_21 = 21;
	public static int DiasCredito_30 = 30;
	public static int DiasCredito_40 = 40;
	public static int DiasCredito_50 = 50;
	public static int DiasCredito_60 = 60;
	
	// Porcentaje
	public static Double BonoDiasContado1_7= 2.0;
	public static Double BonoDiasCredito8_15=1.80;
	public static Double BonoDiasCredito16_21=1.70;
	public static Double BonoDiasCredito22_30=1.60;
	public static Double BonoDiasCredito31_40=1.30;
	public static Double BonoDiasCredito41_50=1.0;
	public static Double BonoDiasCredito51_60=0.7;
	public static Double BonoDiasCredito61_999=0.00;
	
	
	
	public MatrizConfiguracion(){
		
		cuotaDeVentasAnuales.put(2021, cuotaDeVentasMensual2021);
		porcentajeMinimoMensualParaComisionar.put(2021,  porcentajeMinimoMensualParaComisionar2021);
		miniCierres.put("12-2021", minicierreDiciembre2021);
		
	}
}
