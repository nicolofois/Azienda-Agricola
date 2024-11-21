package aziendaagricola;

import java.util.LinkedList;

public class Coltivazione {
	private String prodotto;
	private int meseSemina;
	private int meseRaccolta;
	private LinkedList<Fertilizzante> fertilizzanti;

	public Coltivazione(String prodotto, int meseSemina, int meseRaccolta) {
		this.prodotto = prodotto;
		this.meseSemina = meseSemina;
		this.meseRaccolta = meseRaccolta;
		this.fertilizzanti = new LinkedList<>();
	}

	public String getProdotto() {
		return this.prodotto;
	}

	public int getMeseSemina() {
		return this.meseSemina;
	}

	public int getMeseRaccolta() {
		return this.meseRaccolta;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setMeseSemina(int meseSemina) {
		this.meseSemina = meseSemina;
	}

	public void setMeseRaccolta(int meseRaccolta) {
		this.meseRaccolta = meseRaccolta;
	}

   public Fertilizzante richiedeFertilizzante(char tipo, String nome, float costo, int periodicita, int quantitaImpiego){
		if (tipo == 'N') {
			FertilizzanteNaturale n = new FertilizzanteNaturale(nome, costo, periodicita, quantitaImpiego);
			this.fertilizzanti.add(n);
			return n;

		}
		if (tipo == 'A') {
			FertilizzanteArtificiale a = new FertilizzanteArtificiale(nome, costo, periodicita, quantitaImpiego);
			this.fertilizzanti.add(a);
			return a;
		}
	   return null;
   }
	
}
