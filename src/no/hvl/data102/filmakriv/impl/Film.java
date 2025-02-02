package no.hvl.data102.filmakriv.impl;

import java.util.Objects;

public class Film {
	
	private int filmNr;
	private String filmSkaper;
	private String filmTittel;
	private int lanseringsÅr;
	private Sjanger sjanger;
	private String filmSelskap;
	
	public Film() {
		this.filmNr = 0;
		this.filmSkaper = "";
		this.lanseringsÅr = 0;
		this.sjanger = null;
		this.filmSelskap = "";
		this.filmTittel = "";
	}
	
	public Film(int filmNr, String filmSkaper, int lanseringsÅr, Sjanger sjanger, String filmSelskap, String filmTittel) {
		this.filmNr = filmNr;
		this.filmSkaper = filmSkaper;
		this.filmTittel = filmTittel;
		this.lanseringsÅr = lanseringsÅr;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;
	}
	
	public int getfilmNr() {
		return filmNr;
	}
	public void setfilmNr(int filmNr) {
		this.filmNr = filmNr;
	}
	
	public String getfilmSkaper() {
		return filmSkaper;
	}
	public void setfilmSkaper(String filmSkaper) {
		this.filmSkaper = filmSkaper;
	}
	
	public String getfilmTittel() {
		return filmTittel;
	}
	public void setfilmTittel(String filmTittel) {
		this.filmTittel = filmTittel;
	}
	
	public int getlanseringsÅr() {
		return lanseringsÅr;
	}
	public void setlanseringsÅr(int lanseringsÅr) {
		this.lanseringsÅr = lanseringsÅr;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void SetSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
		
	
	public String getfilmSelskap() {
		return filmSelskap;
	}
	public void setfilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Film film = (Film) obj;
		return filmNr == film.filmNr;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(filmNr, filmSelskap, filmSkaper, sjanger, lanseringsÅr);
	}
	
	@Override
	public String toString() {
		return "Film: " + filmTittel + "( " + lanseringsÅr + ")";
	}
	
}
