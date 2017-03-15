package com.telefonica.barcos;

public class Velero extends Barco implements INautica {
	
	public Velero(String matricula){
		super(matricula);
	}

	@Override
	public void arrancarMotor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void desplegarVela() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Desplegando vela... Velero "+this.getMatricula());
		}

	}

	@Override
	public void pararMotor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void replegarVela() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Replegando vela... Velero "+this.getMatricula());
		}

	}
	
	public void run(){

		System.out.println("Saliendo del puerto... Velero");

	}

}
