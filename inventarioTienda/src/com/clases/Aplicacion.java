package com.clases;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductoElectrodomestico prod = 
				new Televisor("TV grande", 123456d, 10, 51, "Full HD");
		//prod.mostrarInformacion();
		
		ProductoElectrodomestico notebook =
				new ComputadoraPortatil("HP Victus", 
						1000000d, 5, 32, 432423, "LG");
		//notebook.mostrarInformacion();
		TiendaElectronica tienda = new TiendaElectronica();
		tienda.agregarProducto(prod);
		tienda.agregarProducto(notebook);
	//	tienda.mostrarInformacion();
		
		tienda.ventaProducto("TV grandedsa", 13);
		tienda.mostrarInformacion();
		
	}
}
