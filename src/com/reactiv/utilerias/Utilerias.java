package com.reactiv.utilerias;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;

import com.opencsv.*;
import com.reactiv.model.ComisionVenta;
import com.reactiv.model.MatrizConfiguracion;
import com.reactiv.model.Venta;

public class Utilerias {
	
	// Manejo de fechas
	
	public static Double ventasDelMes(int mes,int anio, List<Venta> listaVentas) {
		
		Double ventas=0.0;
		for(int i=0; i < listaVentas.size(); i++) {
			LocalDate fechaVenta = listaVentas.get(i).getFecha();
			if(fechaVenta.getMonthValue() == mes && fechaVenta.getYear() == anio) {
				ventas = ventas + listaVentas.get(i).getMonto();
			}
		}
		return ventas;
		
	}

public static int diasEntre2Fechas(LocalDate fechaIni, LocalDate fechaFin) {
	LocalDateTime horaIni=fechaIni.atTime(0, 0);
	LocalDateTime horaFin=fechaFin.atTime(0, 0);
	Duration duracionTiempo = Duration.between(horaIni, horaFin);
	long duracionDias= duracionTiempo.toDays();
	Long l = new Long(duracionDias);
	int i = l.intValue();
	return i;
	
}
public static  List<Venta>  comisionesDelMes(int mes,int anio, List<Venta> listaVentas) {
		
	List<Venta> ventas= new ArrayList<Venta>();
		for(int i=0; i < listaVentas.size(); i++) {
			LocalDate fechaVenta = listaVentas.get(i).getFecha();
			LocalDate fechaCobro = listaVentas.get(i).getFechaPago();
			if(fechaVenta.getMonthValue() == mes && fechaVenta.getYear() == anio) {

				int diasPago = diasEntre2Fechas(fechaVenta, fechaCobro);
				Venta venta= new Venta();
				venta=listaVentas.get(i);
				Double comisionMonto=0.0;
				Double comisionPorciento=0.0;
					if(diasPago <= MatrizConfiguracion.DiasCredito_7) {
						// Factura pagada anticipadamente , en fecha o antes de una semana se considera contado.
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasContado1_7/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasContado1_7;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_7 && diasPago <= MatrizConfiguracion.DiasCredito_15) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito8_15/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito8_15;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_15 && diasPago <= MatrizConfiguracion.DiasCredito_21) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito16_21/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito16_21;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_21 && diasPago <= MatrizConfiguracion.DiasCredito_30) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito22_30/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito22_30;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_30 && diasPago <= MatrizConfiguracion.DiasCredito_40) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito31_40/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito31_40;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_40 && diasPago <= MatrizConfiguracion.DiasCredito_50) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito41_50/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito41_50;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_50 && diasPago <= MatrizConfiguracion.DiasCredito_60) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito51_60/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito51_60;	
					}else if(diasPago>MatrizConfiguracion.DiasCredito_60) {
						comisionMonto = venta.getMonto() * (MatrizConfiguracion.BonoDiasCredito60_999/100);
						comisionPorciento = MatrizConfiguracion.BonoDiasCredito60_999;	
					}
					venta.setDiasPago(diasPago);
					venta.setComisionPorcentaje(comisionPorciento);
					venta.setComisionMonto(comisionMonto);
					ventas.add(venta);
				
				
					//ventas = ventas + listaVentas.get(i).getMonto();
			}
		}
		return ventas;
		
	}
public static Double ventasAUnaFechaDelMes(LocalDate fecha, List<Venta> listaVentas) {
		
		Double ventas=0.0;
		for(int i=0; i < listaVentas.size(); i++) {
			LocalDate fechaVenta = listaVentas.get(i).getFecha();
			if(fechaVenta.getDayOfMonth() >= 1 && fechaVenta.getDayOfMonth() <= fecha.getDayOfMonth()) {
				ventas = ventas + listaVentas.get(i).getMonto();
			}
		}
		
		return ventas;
		
	}

	
	public static Double porcentaje(Double numerador, Double denominador) {
		
		Double ret=0.0;
		
		if(denominador != 0) {
			ret = (numerador/denominador) * 100;
		}
		
		return ret;
	}
	
	public static String mesNumeroAletra(int mes) {
		String ret="";
		
		if(mes == 1) {
			ret="Enero";
		}else if(mes == 2) {
			ret="Febrero";
		}else if(mes == 3) {
			ret="Marzo";
		}else if(mes == 4) {
			ret="Abril";
		}else if(mes == 5) {
			ret="Mayo";
		}else if(mes == 6) {
			ret="Junio";
		}else if(mes == 7) {
			ret="Julio";
		}else if(mes == 8) {
			ret="Agosto";
		}else if(mes == 9) {
			ret="Septiembre";
		}else if(mes == 10) {
			ret="Octubre";
		}else if(mes == 11) {
			ret="Noviembre";
		}else if(mes == 12) {
			ret="Diciembre";
		}
		
		
		
		return ret;
		
	}
	
	// Carga de CSV
	
	public static List<Venta> CSVCargar() {
		
		CSVReader reader = null;
		List<Venta> listaVentas = new ArrayList<Venta>();
		int numLinea=0;
		/*
		private LocalDate fecha= LocalDate.now();
		private String folio="";
		private String cliente="";
		private String nombre="";
		private Double monto=0.0;
		private LocalDate fechaPago= LocalDate.now();
		*/
		try {
			String archCSV = "/Users/enrique/DiscoDeEnrique/2022/Proyectos/Reactiv/Diciembre2021conPagos.csv";
			CSVReader csvReader = new CSVReader(new FileReader(archCSV));
			String[] fila = null;
			
			
			while((fila = csvReader.readNext()) != null) {	
				
					numLinea++;
					// Saltar los renglones que no tienen fecha en el primer campo
					if(numLinea >1)  // saltamos los encabezados
					if(!fila[0].equals("")) {
						// Viene Dia/Mes/Año
						String[] fechaEmision = fila[0].split("/");
						// Validar que tenga fecha de pago
						String[] fechaPago = {"","",""};
						if(!fila[5].equals("")) {
							fechaPago =fila[5].split("-");
						}else {
							// Poner una fecha lejana mayor a 60 dias
							fechaPago[0] = "31";
							fechaPago[1] = "dic";
							fechaPago[2] = "2100";
						}
						 
						
						LocalDate fechaEmisionDate = LocalDate.of(Integer.parseInt(fechaEmision[2]), Integer.parseInt(fechaEmision[1]), Integer.parseInt(fechaEmision[0]));
						
						String mesPagoLetra = fechaPago[1];
						int mesPago=0;
						if(mesPagoLetra.equals( "ene")) {
							mesPago=1;
						}else if(mesPagoLetra.equals( "feb")) {
							mesPago=2;
						}else if(mesPagoLetra.equals( "mar")) {
							mesPago=3;
						}else if(mesPagoLetra.equals( "abr")) {
							mesPago=4;
						}else if(mesPagoLetra.equals( "may")) {
							mesPago=5;
						}else if(mesPagoLetra.equals( "jun")) {
							mesPago=6;
						}else if(mesPagoLetra.equals( "jul")) {
							mesPago=7;
						}else if(mesPagoLetra.equals( "ago")) {
							mesPago=8;
						}else if(mesPagoLetra.equals( "sep")) {
							mesPago=9;
						}else if(mesPagoLetra.equals( "oct")) {
							mesPago=10;
						}else if(mesPagoLetra.equals("nov")) {
							mesPago=11;
						}else if(mesPagoLetra.equals("dic")) {
							mesPago=12;
						}
						
						// Limpiar de comas el monto de la venta
						String montoVentaString = fila[4];
						montoVentaString= montoVentaString.replace(",", "");
						LocalDate fechaPagoDate = LocalDate.of(Integer.parseInt(fechaPago[2]), mesPago, Integer.parseInt(fechaPago[0]));
						
						Venta venta = new Venta(fechaEmisionDate,fila[1],fila[2],fila[3],Double.valueOf(montoVentaString),fechaPagoDate);
						
						listaVentas.add(venta);
					
					
				}
			
					
			}

			csvReader.close();
		} catch (Exception e) {
			System.out.print("\n");
			System.out.print("Error cargando datos en la linea" + numLinea);
			System.out.print("\n");
			e.printStackTrace();
		}finally {
			
		}
		
		
		return listaVentas;
								  
				
	}

/*
 * Recibe una lista de ventas ordenada cronologicamente por fecha de emision de la factura de ventas
 */
	public static Map<String,LocalDate>fechaIniYFinDeLista(List<Venta> listaVentasGlobal) {
		
		
		Map<String, LocalDate> fechaIniYFin = new HashMap<String, LocalDate>();
		
		Venta ventaIni = new Venta();
		Venta ventaFin = new Venta();
		
		if(listaVentasGlobal.size()> 0) {
			ventaIni= listaVentasGlobal.get(0);
			ventaFin= listaVentasGlobal.get(listaVentasGlobal.size()-1);
			fechaIniYFin.put("fechaIni", ventaIni.getFecha());
			fechaIniYFin.put("fechaFin", ventaFin.getFecha());
			
		}
		
		return fechaIniYFin;
		
	}
}
