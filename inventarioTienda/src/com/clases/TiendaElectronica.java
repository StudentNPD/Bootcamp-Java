package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
	private ArrayList<ProductoElectrodomestico> productos;

	public TiendaElectronica() {
		super();
		productos= new ArrayList<>();
	}
	public void agregarProducto(ProductoElectrodomestico producto) {
		productos.add(producto);
	}
	public void mostrarInformacion() {
		for(int i=0; i<productos.size(); i++) {
			productos.get(i).mostrarInformacion();
		}
	}
	public ProductoElectrodomestico buscarPorNombre(String nombre) {
		for(int i=0; i<productos.size(); i++) {
			if(productos.get(i).getNombre().equals(nombre)) {
				return productos.get(i);
			}
		}
		return null;
	}
	
	public void ventaProducto(String nombre, Integer cantidad) {
		ProductoElectrodomestico producto = buscarPorNombre(nombre);
		if(producto == null) {
			System.out.println("Producto no encontrado");
		} else {
			
			producto.vender(cantidad);
		}
	}
	
	
}
