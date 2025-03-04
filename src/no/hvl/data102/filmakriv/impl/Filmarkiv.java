package no.hvl.data102.filmakriv.impl;

import java.util.Arrays;

import no.hvl.data102.filmakriv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmer;
    private int antall;

    public Filmarkiv(int kapasitet) {
        if (kapasitet <= 0) {
        	kapasitet = 10;
        }
        this.filmer = new Film[kapasitet];
        this.antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getfilmNr() == nr) {
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvidLengde();
        }
        filmer[antall++] = nyFilm;
    }

    private void utvidLengde() {
        filmer = Arrays.copyOf(filmer, filmer.length * 2);
    }

    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getfilmNr() == filmnr) {
                	filmer[i] = filmer[antall - 1];
                	filmer[antall - 1] = null;
                	antall--;
                	return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] resultat = new Film[antall];
        int j = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getfilmTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                resultat[j++] = filmer[i];
            }
        }
        return Arrays.copyOf(resultat, j);
    }

    public Film[] soekProdusent(String delstreng) {
        Film[] Prod = new Film[antall];
        int j = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getfilmSkaper().toLowerCase().contains(delstreng.toLowerCase())) {
                Prod[j++] = filmer[i];
            }
        }
        return Arrays.copyOf(Prod, j);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallSjangere = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                antallSjangere++;
            }
        }
        return antallSjangere;
    }

    public int antall() {
        return antall;
    }

	@Override
	public int antallFilmer() {
		
		return 0;
	}
}
