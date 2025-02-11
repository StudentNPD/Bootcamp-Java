package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
	private Integer memoriaRam;
	private Integer numeroSerie;
	private String marca;
	public ComputadoraPortatil(String nombre, Double precio, Integer cantidadDisponible, Integer memoriaRam,
			Integer numeroSerie, String marca) {
		super(nombre, precio, cantidadDisponible);
		this.memoriaRam = memoriaRam;
		this.numeroSerie = numeroSerie;
		this.marca = marca;
	}
	@Override
	public void mostrarInformacion() {
		// TODO Auto-generated method stub
		super.mostrarInformacion();
		System.out.println("Marca: "+ this.marca +"\nMemoria Ram: "+this.memoriaRam +"\nNumero de serie: "+
		this.numeroSerie);
	}
	
	

	
	
	
	
}
