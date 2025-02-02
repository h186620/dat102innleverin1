package no.hvl.data102.filmakriv.klient;

import java.util.Scanner;

import no.hvl.data102.filmakriv.adt.FilmarkivADT;
import no.hvl.data102.filmakriv.impl.Film;
import no.hvl.data102.filmakriv.impl.Sjanger;

public class Tekstgrensesnitt {
	
	public Film lesFilm(Scanner scanner) {
			System.out.print("Filmnummer: ");
	        int nr = Integer.parseInt(scanner.nextLine());

	        System.out.print("Tittel: ");
	        String tittel = scanner.nextLine();

	        System.out.print("År: ");
	        int aar = Integer.parseInt(scanner.nextLine());
	        
	        System.out.print("Sjanger (ACTION, DRAMA, FANTASY, SCIFI): ");
	        String sjangerStr = scanner.nextLine().toUpperCase();
	        Sjanger sjanger;

	        try {
	        	sjanger = Sjanger.valueOf(sjangerStr);
	        } catch (IllegalArgumentException e) {
	        	System.out.println("Ugyldig sjanger. Standarverdi (ACTION) brukes.");
	        	sjanger = Sjanger.ACTION;
	        }
	        System.out.print("Produsent: ");
	    	String produsent = scanner.nextLine();
	    	
	    	return new Film(nr, tittel, aar, sjanger, "", produsent);
	}
	
	public void skrivUtFilm(Film film) {
		if (film!= null) {
			System.out.println(film.toString());
		} else {
			System.out.println("Ingen informasjon tilgjenelig");
		}
	}
	
	public void SkrivUtFilmDelstrengTittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekTittel(delstreng);
		if(filmer.length > 0) {
			System.out.println("Filmer som matcher: ");
			for (Film film : filmer) {
				System.out.print(film.toString());
			}
		} else {
			System.out.println("Ikke funnet");
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekProdusent(delstreng);
		if (filmer.length > 0) {
			System.out.println("Produsentnavn som matcher: ");
			for (Film film : filmer) {
				if (filmer != null) {
					System.out.print(film.toString());
				}
			} 
		} else {
			System.out.println("Ikke funnet");
		}
	}
	
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Total antall: " + arkiv.antallFilmer());
		for (Sjanger sjanger : Sjanger.values()) {
			int antall = arkiv.antall(sjanger);
			System.out.println("Anatll filmer i sjanger: " + sjanger + ":" + antall);
		}
	}
}
