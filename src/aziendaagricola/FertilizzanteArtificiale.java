package aziendaagricola;

public class FertilizzanteArtificiale extends Fertilizzante{
	private int rischio;
	private char tipo;


	public FertilizzanteArtificiale(String nome, float costo, int periodicita, int quantitaImpiego) {
		super(nome, costo, periodicita, quantitaImpiego);
		this.rischio = 0;
		this.tipo = 'A';
	}

	public void setRischio(int rischio){
		this.rischio = rischio;
	}

	public int getRischio(){
		return this.rischio;
	}

	public char getTipo() {
		return tipo;
	}

}
