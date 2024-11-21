package aziendaagricola;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class Zona {
	int codice;
	int ampiezza;
	int temperaturaMedia;
	float irraggiamentoMedio;
	LinkedList<String> caratteristiche;
	TreeMap<String,LinkedList<Coltivazione>> coltivazioni;
	LinkedList<Coltivazione> listaColtivazioni;
	LinkedList<Raccolto> raccolti;
	
	public Zona(int codice) {
		this.codice = codice;
		this.caratteristiche = new LinkedList<>();
		this.coltivazioni = new TreeMap<>();
		this.listaColtivazioni = new LinkedList<>();
		this.raccolti = new LinkedList<>();
	}

	public int getCodice() {
		return this.codice;
	}
	
	public int getAmpiezza() {
		return this.ampiezza;
	}

	public int getTemperaturaMedia() {
		return this.temperaturaMedia;
	}

	public float getIrraggiamentoMedio() {
		return this.irraggiamentoMedio;
	}
	
	public void setAmpiezza(int ampiezza) {
		this.ampiezza = ampiezza;
	}

	public void setTemperaturaMedia(int temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public void setIrraggiamentoMedio(float irraggiamentoMedio) {
		this.irraggiamentoMedio = irraggiamentoMedio;
	}

	public int aggiungiCaratteristica(String c) {
		if (caratteristiche.contains(c)) {
			return 0;
		}
		this.caratteristiche.add(c);
		return 1;
	}

	public Collection<String> elencoCaratteristiche(){
		return this.caratteristiche.stream().sorted().toList();
	}
	
	public Coltivazione aggiungiColtivazione(String prodotto, int meseSemina, int meseRaccolto) throws ColtivazioneDuplicataException{
		Coltivazione c = new Coltivazione(prodotto, meseSemina, meseRaccolto);
		if (coltivazioni.containsKey(prodotto)) {
			if (coltivazioni.get(prodotto).stream().map(co -> co.getMeseSemina()).toList().contains(meseSemina)) {
				throw new ColtivazioneDuplicataException();
			}
			else {
				coltivazioni.get(prodotto).add(c);
				listaColtivazioni.add(c);
				return c;
			}
		}
		coltivazioni.put(prodotto, new LinkedList<>());
		coltivazioni.get(prodotto).add(c);
		listaColtivazioni.add(c);
		return c;
	}


	public Collection<Coltivazione> elencoColtivazioni(){
		return listaColtivazioni;
	}
	
	

	public Raccolto nuovoRaccolto(String prodotto, String data, int quantita){
		Raccolto r = new Raccolto(prodotto, data, quantita);
		raccolti.add(r);
		return r;
	}
	
	public Raccolto cercaRaccolto(String prodotto, String data){
		return raccolti.stream()
					   .filter(r -> r.getProdotto()
					   .equals(prodotto) && r.getData().equals(data))
					   .findFirst()
					   .orElse(null);
	}
	
	public Collection<Raccolto> elencoRaccolti(){
		return raccolti.stream()
						.sorted(Comparator.comparing(Raccolto::getData)
						.thenComparing(Raccolto::getQuantita))
						.toList();
	}
	
}
