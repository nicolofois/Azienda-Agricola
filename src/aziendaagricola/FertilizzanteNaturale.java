package aziendaagricola;

public class FertilizzanteNaturale extends Fertilizzante{
    private char tipo;
	
    public FertilizzanteNaturale(String nome, float costo, int periodicita, int quantitaImpiego) {
        super(nome, costo, periodicita, quantitaImpiego);
        this.tipo = 'N';
    }
    
    public char getTipo() {
		return tipo;
	}
}
