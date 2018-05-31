package it.polito.tdp.bar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Simulazione {
	
	
	private List<Tavolo> tavoli;
	
	private int numeroTotaleClienti;
	private int numeroClientiSoddisfatti;
	private int numeroClientiInsoddisfatti;
	
	private PriorityQueue<Evento> queue;
	
	public void init() {
		tavoli = new ArrayList<Tavolo>();
		Tavolo t1 = new Tavolo(10);
		tavoli.add(t1);
		Tavolo t2 = new Tavolo(10);
		tavoli.add(t2);
		Tavolo t3 = new Tavolo(8);
		tavoli.add(t3);
		Tavolo t4 = new Tavolo(8);
		tavoli.add(t4);
		Tavolo t5 = new Tavolo(8);
		tavoli.add(t5);
		Tavolo t6 = new Tavolo(8);
		tavoli.add(t6);
		Tavolo t7 = new Tavolo(6);
		tavoli.add(t7);
		Tavolo t8 = new Tavolo(6);
		tavoli.add(t8);
		Tavolo t9 = new Tavolo(6);
		tavoli.add(t9);
		Tavolo t10 = new Tavolo(6);
		tavoli.add(t10);
		Tavolo t11 = new Tavolo(4);
		tavoli.add(t11);
		Tavolo t12 = new Tavolo(4);
		tavoli.add(t12);
		Tavolo t13 = new Tavolo(4);
		tavoli.add(t13);
		Tavolo t14 = new Tavolo(4);
		tavoli.add(t14);
		Tavolo t15 = new Tavolo(4);
		tavoli.add(t15);
		Collections.sort(tavoli);
		
		int ora = 0;
		queue = new PriorityQueue<>();
		
		this.numeroTotaleClienti = 0;
		this.numeroClientiSoddisfatti = 0;
		this.numeroClientiInsoddisfatti = 0;
		
		for(int i=0; i<2000; i++) {
			Gruppo g = new Gruppo();
			Evento e = new Evento(ora+g.getTime(), g, EventType.ARRIVA_GRUPPO_CLIENTI);
			queue.add(e);
			ora += g.getTime();
			this.numeroTotaleClienti += g.getNum();
		}
		
	}
	
	public void run() {
		Evento e;
		while((e = queue.poll()) != null) {
			processEvent(e);
			//queue.comparator();
		}
	}

	private void processEvent(Evento e) {
		switch(e.getTipo()) {
		case ARRIVA_GRUPPO_CLIENTI:
			boolean assegnato = false;
			for(Tavolo t: tavoli) {
				if(t.isLibero() == true && t.getDimensione() >= e.getGruppo().getNum() && e.getGruppo().getNum() >= (0.5*t.getDimensione()) && assegnato==false) {
					e.getGruppo().setTavolo(t);
					e.getGruppo().getTavolo().setLibero(false);
					assegnato = true;
				}
			}
			
			if(e.getGruppo().getTavolo() == null) { // non c'è tavolo libero quindi devo indirizzarli al bancone
				double random = Math.random();
				if(random > e.getGruppo().getTolleranza()) {
					// scontenti
					this.numeroClientiInsoddisfatti += e.getGruppo().getNum();
				} else {
					// bancone
					this.numeroClientiSoddisfatti += e.getGruppo().getNum();
				}
			} else {
				this.numeroClientiSoddisfatti += e.getGruppo().getNum();
				
				Evento e1 = new Evento(e.getTempo()+e.getGruppo().getDurata(), e.getGruppo(), EventType.ESCE_GRUPPO_CLIENTI);
				queue.add(e1);
			}
			break;
		case ESCE_GRUPPO_CLIENTI:
			e.getGruppo().getTavolo().setLibero(true);
			
			break;
		}
		
	}

	public int getNumeroTotaleClienti() {
		return numeroTotaleClienti;
	}

	public int getNumeroClientiSoddisfatti() {
		return numeroClientiSoddisfatti;
	}

	public int getNumeroClientiInsoddisfatti() {
		return numeroClientiInsoddisfatti;
	}
	
	

}
