package com.telefonica.barcos;

public class Portaaviones extends Barco implements INautica {
	
	public Portaaviones(String matricula){
		super(matricula);
	}
	
	@Override
	public void arrancarMotor() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Arrancando motores... Portaaviones "+this.getMatricula());
		}

	}

	@Override
	public void desplegarVela() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pararMotor() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Parando motores... Portaaviones "+this.getMatricula());
		}

	}

	@Override
	public void replegarVela() {
		// TODO Auto-generated method stub

	}
	
	public void run(){

		System.out.println("Saliendo del puerto... Portaaviones");

	}
}
