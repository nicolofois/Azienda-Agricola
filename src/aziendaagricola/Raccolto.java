package aziendaagricola;

public class Raccolto {

	private String prodotto;
	private String data;
	private int quantita;
	private float prezzoIngrosso;

	public Raccolto(String prodotto, String data, int quantita) {
		this.prodotto = prodotto;
		this.data = data;
		this.quantita = quantita;
		this.prezzoIngrosso = 0;
	}

	public double getPrezzoIngrosso() {
		return this.prezzoIngrosso;
	}

	public String getProdotto() {
		return this.prodotto;
	}
	
	public String getData() {
		return this.data;
	}
	
	public int getQuantita() {
		return this.quantita;
	}
	
	public void setPrezzoIngrosso(int prezzoIngrosso) {
		this.prezzoIngrosso = prezzoIngrosso;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}
