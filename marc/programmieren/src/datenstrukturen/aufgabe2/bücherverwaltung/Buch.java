package datenstrukturen.aufgabe2.bücherverwaltung;

public class Buch {

	private String autor;
	private String title;
	private int year;
	private String verlag;
	
	public Buch(String autor, String title, int year, String verlag){
		this.autor = autor;
		this.title = title;
		this.year = year;
		this.verlag = verlag;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getVerlag() {
		return verlag;
	}
	
}
