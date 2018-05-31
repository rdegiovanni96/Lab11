package it.polito.tdp.bar;

import java.util.Random;

public class Gruppo {
	
	private int time;
	private int num;
	private int durata;
	private double tolleranza;
	private Random rand;
	private Tavolo tavolo;
	
	public Gruppo() {
		rand = new Random();
		time = rand.nextInt(10) +1;
		num = rand.nextInt(10) +1;
		int minDurata = 60; 
		int maxDurata = 120; 
		int c = ((maxDurata - minDurata) + 1); // = 61
		durata = rand.nextInt(c) + minDurata; // 
		tolleranza = Math.random();
		if(tolleranza > 0.9)
			tolleranza = tolleranza - 0.1;
		tavolo = null;
	}

	public int getTime() {
		return time;
	}

	public int getNum() {
		return num;
	}

	public int getDurata() {
		return durata;
	}

	public double getTolleranza() {
		return tolleranza;
	}

	public Random getRand() {
		return rand;
	}
	
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	
	public Tavolo getTavolo() {
		return tavolo;
	}
	
	
}
