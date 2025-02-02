package no.hvl.data102.filmakriv.impl;

import no.hvl.data102.filmakriv.impl.Sjanger;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI, FANTASY;
	
	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}
}

