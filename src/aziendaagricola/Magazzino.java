package aziendaagricola;

public class Magazzino {
	private String nome;
	private String prodotto;
	private int quantitaStoccabile;
	private int quantitaStoccata;

	public Magazzino(String nome, String prodotto, int quantitaStoccabile) {
        this.nome = nome;
		this.prodotto = prodotto;
		this.quantitaStoccabile = quantitaStoccabile;
		this.quantitaStoccata = 0;
    }

    public String getNome() {
		return this.nome;
	}

	public String getProdotto() {
		return this.prodotto;
	}
	
	public int getQuantitaStoccabile() {
		return this.quantitaStoccabile;
	}

	public int getQuantitaStoccata() {
		return this.quantitaStoccata;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setQuantitaStoccabile(int quantitaStoccabile) {
		this.quantitaStoccabile = quantitaStoccabile;
	}

	public void setQuantitaStoccata(int quantitaStoccata) {
		this.quantitaStoccata = quantitaStoccata;
	}	
	
	public int stocca(Raccolto raccolto) throws ProdottoNonCompatibileException{
		if (!raccolto.getProdotto().equals(this.prodotto)) {
			throw new ProdottoNonCompatibileException();
		}
		if (raccolto.getQuantita() + this.quantitaStoccata <= this.quantitaStoccabile) {
			this.quantitaStoccata += raccolto.getQuantita();
			return quantitaStoccabile - quantitaStoccata;
		}
		if (raccolto.getQuantita() + this.quantitaStoccata > this.quantitaStoccabile) {
			this.quantitaStoccata = this.quantitaStoccabile;
			return (raccolto.getQuantita() + this.quantitaStoccata) - this.quantitaStoccabile;
		}
		return -1;
	}
	
	public void preleva(int quantita){
		this.quantitaStoccata -= quantita;
	}
	
}
