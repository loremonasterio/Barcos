package com.telefonica.barcos;

public class PrincipalBarcos {
	public static void main(String[] args) {
		Velero velero = new Velero("12345A");
		velero.setName("Velero");
		Fragata fragata = new Fragata("78945z");
		fragata.setName("Fragata");
		Portaaviones portaaviones = new Portaaviones("564548R");
		portaaviones.setName("Portaaviones");
		velero.start();
		fragata.start();
		portaaviones.start();
	}
}
