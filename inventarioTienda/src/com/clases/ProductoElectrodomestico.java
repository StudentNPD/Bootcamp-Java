package com.clases;

public class ProductoElectrodomestico {
	private String nombre;
	private Double precio;
	private Integer cantidadDisponible;
	public ProductoElectrodomestico(String nombre, Double precio, Integer cantidadDisponible) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}
	public ProductoElectrodomestico(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = 0;
		
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre: "+ this.nombre+ "\nPrecio: "+this.precio+
				"\nCantidad disponible: "+this.cantidadDisponible);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	public void vender(Integer cantidad) {
		if(cantidadDisponible<cantidad) {
			System.out.println("Stock: Insuficiente");
		}else {
			cantidadDisponible-=cantidad;
		}
	}
	
}
