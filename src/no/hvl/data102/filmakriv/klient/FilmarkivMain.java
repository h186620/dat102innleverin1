package no.hvl.data102.filmakriv.klient;

import no.hvl.data102.filmakriv.impl.Filmarkiv;

public class FilmarkivMain {

	public static void main(String[] args) {
		Filmarkiv filmer = new Filmarkiv(100);
		Meny meny = new Meny(filmer);
		meny.start();

	}

}
