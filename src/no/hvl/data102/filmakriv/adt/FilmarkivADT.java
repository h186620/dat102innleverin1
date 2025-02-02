package no.hvl.data102.filmakriv.adt;

import no.hvl.data102.filmakriv.impl.Film;
import no.hvl.data102.filmakriv.impl.Sjanger;

public interface FilmarkivADT {
	
	Film finnFilm(int nr);

	void leggTilFilm(Film nyfilm);
	
	boolean slettFilm(int filmnr);
	
	Film[] soekTittel(String delstreng);
	
	Film[] soekProdusent(String delstreng);

	 int antall(Sjanger sjanger);
	
	int antallFilmer();

}
