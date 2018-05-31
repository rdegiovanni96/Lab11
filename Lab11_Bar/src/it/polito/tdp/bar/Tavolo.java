package it.polito.tdp.bar;

public class Tavolo implements Comparable<Tavolo>{
	
	private int dimensione;
	private boolean libero;
	private Gruppo gruppo;
	
	public Tavolo(int dimensione) {
		this.dimensione = dimensione;
		this.libero = true;
		
	}
	
	public int getDimensione() {
		return dimensione;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	@Override
	public int compareTo(Tavolo o) {
		return this.dimensione - o.getDimensione() ;
	}
	
	

}
