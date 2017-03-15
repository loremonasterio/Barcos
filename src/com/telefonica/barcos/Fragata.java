package com.telefonica.barcos;

public class Fragata extends Barco implements INautica {
	
	public Fragata(String matricula){
		super(matricula);
	}	
	
	
	@Override
	public void arrancarMotor() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Arrancando motor...Fragata "+this.getMatricula());
		}

	}

	@Override
	public void desplegarVela() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Desplegando velas...Fragata "+this.getMatricula());
		}

	}

	@Override
	public void pararMotor() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Parando motor...Fragata "+this.getMatricula());
		}
	}

	@Override
	public void replegarVela() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Plegando velas...Fragata "+this.getMatricula());
		}

	}
	
	public void run(){

		System.out.println("Saliendo del puerto... Fragata");

	}

}
