package no.hvl.data102.filmakriv.klient;

import java.util.Scanner;

import no.hvl.data102.filmakriv.adt.FilmarkivADT;
import no.hvl.data102.filmakriv.impl.Film;
import no.hvl.data102.filmakriv.impl.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	public void start() {
		Scanner scanner = new Scanner(System.in);
	filmarkiv.leggTilFilm(new Film(1,  "Bonnie Arnold", 2010, Sjanger.FANTASY, "Dreamworks", "Dragetrenen" ));
	filmarkiv.leggTilFilm(new Film(2, "Gareth Edwards", 2014, Sjanger.ACTION, "Legendary Pictures", "Godzilla"));
	filmarkiv.leggTilFilm(new Film(3, "Suzanna Buirgy", 2015, Sjanger.SCIFI, "20th Century Fox", "Home"));
	filmarkiv.leggTilFilm(new Film(4, "Albert S. Ruddy", 1972, Sjanger.DRAMA, "Paramount Pictures", "The Godfather"));
	
	 System.out.println("\nVelkommen til filmarkivet!");
		while(true) {
			
		     System.out.println("1: Finne film basert på filmnummer");
		     System.out.println("2: Legge til en ny film");
		     System.out.println("3: Slette en film bsaert på filmnummer");
		     System.out.println("4: Finn filmer med tittel som inneholder en delstreng");
		     System.out.println("5: Finn filmer basert på produsent");
		     System.out.println("6: Se statistikk over sjangere");
		     System.out.println("0: Avslutt");
		     
		     String valg = scanner.nextLine();
		     
		     switch(valg) {
		     case "1":
		    	 System.out.print("Skriv inn filmnummer: ");
		    	 int filmnummerSoek = Integer.parseInt(scanner.nextLine());
		    	 Film funnetFilm = filmarkiv.finnFilm(filmnummerSoek);
		    	 if (funnetFilm != null) {
		    		 tekstgr.skrivUtFilm(funnetFilm);
		    	 } else {
		    		 System.out.println("Ingen film funnet med dette nummeret");
		    	 }
		         break;
		     case "2":
		         System.out.println("Legg til en ny film: ");
		         Film nyFilm = tekstgr.lesFilm(scanner);
		         filmarkiv.leggTilFilm(nyFilm);
		         System.out.println("Filmen er lagt til.");
		         break;
		     case "3":
		         System.out.print("Skriv inn nummer for filmen som skal slettes: ");
		         int filmnummer = Integer.parseInt(scanner.nextLine());
		         boolean slettet = filmarkiv.slettFilm(filmnummer);
		         if (slettet) {
		        	 System.out.println("Filmen ble slettet.");
		         } else {
		        	 System.out.println("Ingen film med dette nummeret ble funnet.");
		         }
		         break;
		     case "4":
		         System.out.print("Skriv inn en del av tittelen: ");
		         String delTittel = scanner.nextLine();
		         tekstgr.SkrivUtFilmDelstrengTittel(filmarkiv, delTittel);
		         break;
		     case "5":
		         System.out.print("Skriv inn navn til produsenten: ");
		         String produsent = scanner.nextLine();
		         tekstgr.skrivUtFilmProdusent(filmarkiv, produsent);
		         break;
		     case "6":
		     	 tekstgr.skrivUtStatistikk(filmarkiv);
		     	 break;
		     case "0":
		     	 System.out.println("Avslutter programmet...");
		         return;
		     default:
		         System.out.println("Ugyldig valg, prøv igjen.");
		         break;
		         }
		     }
	}
	public Tekstgrensesnitt getTekstgr() {
		return tekstgr;
	}
	public void setTekstgr(Tekstgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}
	public FilmarkivADT getFilmarkiv() {
		return filmarkiv;
	}
	public void setFilmarkiv(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
	}
}



