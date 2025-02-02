package no.hvl.data102.filmakriv.impl;

import no.hvl.data102.filmakriv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2(int antall, LinearNode<Film> start) {
		this.setAntall(0);
		this.start = null;
	}
	
	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> current = start;
		
		while (current != null) {
			if (current.data.getfilmNr() == nr) {
				return current.data;
			} else {
				current = current.neste;
			}
		}
		return null;
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.neste = start;
		start = nyNode;
		setAntall(getAntall() + 1);
	}
	
	@Override
	public boolean slettFilm(int filmNr) {
		LinearNode<Film> current = start;
		LinearNode<Film> forrige = null;
		boolean slettet = false;
		
		while (current.data.getfilmNr() == filmNr) {
			if (forrige == null) {
				start = current.neste;
			} else {
				forrige.neste = current.neste;
			}
		}
		return slettet;
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		int antallFunnet = 0;
		LinearNode<Film> current = start;
		
		while (current != null) {
			if (current.data.getfilmTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				antallFunnet++;
			}
			current = current.neste;
		}
		
		Film[] resultater = new Film[antallFunnet];
		current = start;
		int index = 0;
		while (current != null) {
			if (current.data.getfilmTittel().contains(delstreng)) {
				resultater[index] = current.data;
				index++;
			}
			current = current.neste;
		}
		return resultater;
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		int antallFunnet = 0;
		LinearNode<Film> current = start;
		
		while (current != null) {
			if (current.data.getfilmSkaper().toLowerCase().contains(delstreng.toLowerCase())) { 
				antallFunnet++;
			}
			current = current.neste;
		}
		Film[] resultater = new Film[antallFunnet];
		current = start;
		int index = 0;
		
		while (current != null) {
			if (current.data.getfilmSkaper().contains(delstreng)) {
				resultater[index] = current.data;
				index++;
			}
			current = current.neste;
		}
		return resultater;
	}
	
	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> current = start;
		int antall = 0;
		
		while (current != null) {
			if (current.data.getSjanger() == sjanger) {
				antall++;
			}
			current = current.neste;
		}
		return antall;
	}
	
	

	@Override
	public int antallFilmer() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}
}
