package it.polito.tdp.bar;

public class TestSimulatore {

	public static void main(String[] args) {
		
		Simulazione sim = new Simulazione();
		
		sim.init();
		
		sim.run();
		
		System.out.println("Clienti totali: "+sim.getNumeroTotaleClienti()+"\nClienti soddisfatti: "+sim.getNumeroClientiSoddisfatti()+"\nClienti insoddisfatti: "+sim.getNumeroClientiInsoddisfatti());

	}

}
