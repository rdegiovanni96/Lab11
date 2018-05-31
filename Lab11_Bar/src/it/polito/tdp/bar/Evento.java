package it.polito.tdp.bar;

public class Evento implements Comparable<Evento>{
	
	private int tempo;
	private Gruppo gruppo;
	private EventType tipo;
	
	public Evento(int tempo, Gruppo gruppo, EventType tipo) {
		this.tempo = tempo;
		this.gruppo = gruppo;
		this.tipo = tipo;
	}

	public int getTempo() {
		return tempo;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public EventType getTipo() {
		return tipo;
	}

	@Override
	public int compareTo(Evento o) {
		
		return this.tempo - o.tempo;
	}
	
	
	
	

}
