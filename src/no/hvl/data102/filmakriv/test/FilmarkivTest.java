package no.hvl.data102.filmakriv.test;

import no.hvl.data102.filmakriv.impl.Film;
import no.hvl.data102.filmakriv.impl.Filmarkiv;
import no.hvl.data102.filmakriv.impl.Sjanger;

public class FilmarkivTest {
    private Filmarkiv filmarkiv;

    @BeforeEach
    void setUp() {
        Filmarkiv filmarkiv = new Filmarkiv(10); 
  
        filmarkiv.leggTilFilm(new Film(1, "Bonnie Arnold", 2010, Sjanger.FANTASY, "Dreamworks", "Dragetrenen" ));
    	filmarkiv.leggTilFilm(new Film(2, "Gareth Edwards", 2014, Sjanger.ACTION, "Legendary Pictures", "Godzilla"));
    	filmarkiv.leggTilFilm(new Film(3, "Suzanna Buirgy", 2015, Sjanger.SCIFI, "20th Century Fox", "Home"));
    	
    }
    
    @Test
    void testfinnFilm() {
        Film film = filmarkiv.finnFilm(1);
        assertNotNull(film, "Film med nummer 1 skal finnes");
        assertEquals(1, film.getfilmNr());
        assertEquals("Dragetreneren", film.getfilmTittel());
        
    }
    @Test
    void testLagtTilFilm() {
        Film nyFilm = new Film(4, "Albert S. Ruddy", 1972, Sjanger.DRAMA, "Paramount Pictures", "The Godfather");
        filmarkiv.leggTilFilm(nyFilm);
        Film film = filmarkiv.finnFilm(4);
        assertNotNull(film, "Filmen er lagt til");
        assertEquals(4, film.getfilmNr());
        assertEquals("The Godfather", film.getfilmTittel());
    }
    @Test
    void testSlettFilm() {
       boolean slettet = filmarkiv.slettFilm(1);
       assertTrue(slettet, "Film 1 slettet");
       Film film = filmarkiv.finnFilm(1);
       assertNull(film, "Filmen skal ikke finnes lenger");
    }

    @Test
    void testSoekTittel() {
        Film[] filmer = filmarkiv.soekTittel("Godzilla");
        assertNotNull(filmer, "Listen skal ikek være null");
        assertEquals(true, filmer.length > 0, "det skal finnes minst en film med denne tittelen");
        assertEquals("Godzilla", filmer[0].getfilmTittel());
    }

    @Test
    void testSoekProdusent() {
        Film[] filmer = filmarkiv.soekProdusent("Suzanna Buirgy");
        assertNotNull(filmer, "Listen over filmer skal ikke være null");
        assertEquals(1, filmer.length, "Det skal finnes minst en film med denne produsenten");
        assertEquals("Suzanna Buirgy", filmer[0].getfilmSkaper());
    }

}
