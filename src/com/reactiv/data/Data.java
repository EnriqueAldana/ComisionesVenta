package com.reactiv.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.reactiv.model.Venta;

public class Data {
	
	public static List<Venta> listaVentas= new ArrayList<Venta>();
	
	
	
	public Data() {
		
		listaVentas.add(new Venta(
				 LocalDate.of(2022, 01, 1),"Folio1", "1","Cliente Uno", 1000000.0, LocalDate.of(2022, 01, 1).plusDays(0) ));
		listaVentas.add(new Venta(
				 LocalDate.of(2022, 01, 6),"Folio2", "1","Cliente Dos", 2000000.0,  LocalDate.of(2022, 02, 1).plusDays(30)));
		listaVentas.add(new Venta(
				 LocalDate.of(2022, 01, 13),"Folio3", "1","Cliente Tres", 500000.0,  LocalDate.of(2022, 03, 1).plusDays(15)));
		listaVentas.add(new Venta(
				 LocalDate.of(2022, 01, 20),"Folio4", "1","Cliente Cuatro", 500000.0, LocalDate.of(2022, 04, 20).plusDays(0)));
		listaVentas.add(new Venta(
				 LocalDate.of(2022, 01, 27),"Folio5", "1","Cliente Cinco", 592914.35,  LocalDate.of(2022, 05, 2).plusDays(7)));
	}

}
