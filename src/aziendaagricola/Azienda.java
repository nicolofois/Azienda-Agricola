package aziendaagricola;

import java.util.*;
import java.io.*;

public class Azienda {
	int zoneCode = 1000;
	TreeMap<Integer,Zona> zone = new TreeMap<>();
	LinkedList<Magazzino> magazzini = new LinkedList<>();

	public Zona aggiungiZona(){
		Zona z = new Zona(zoneCode);
		zone.put(zoneCode, z);
		zoneCode++;
		return z;
	}
	
	public Zona cercaZona(int codice){
		if (!zone.containsKey(codice)) {
			return aggiungiZona();
		}
		return zone.get(codice);
	}
	
	public void specificaCaratteristicheZona(int codice, String caratteristica){
		Zona z = zone.get(codice);
		z.aggiungiCaratteristica(caratteristica);
	}
	
	public Collection<Zona> elencoZone(){
		return zone.values();
	}
	
	public Collection<Zona> elencoZone(int ampiezza){
		return zone.values().stream()
							.filter(z -> z.getAmpiezza()>ampiezza)
							.sorted(Comparator.comparing(Zona::getCodice))
							.toList();
	}
	
	public Magazzino aggiungiMagazzino(String nome, String prodotto, int quantitaStoccabile){
		Magazzino m = new Magazzino(nome, prodotto, quantitaStoccabile);
		magazzini.add(m);
		return m;		
	}
	
	public int totaleMagazzino(){
		int total = 0;
		for (Magazzino m : magazzini) {
			total += m.getQuantitaStoccata();
		}
		return total;
	}
	
	public void leggi(String nomeFile) throws IOException, NumberFormatException, ColtivazioneDuplicataException{
		FileReader fr = new FileReader(nomeFile);
		BufferedReader br = new BufferedReader(fr);
		String riga = br.readLine();
		while (riga != null) {
			String[] dati = riga.split(",");
			if (dati[0].equals("C")) {
				zone.get(Integer.parseInt(dati[1])).aggiungiColtivazione(dati[2], Integer.parseInt(dati[3]), Integer.parseInt(dati[4]));
			} else if (dati[0].equals("R")) {
				zone.get(Integer.parseInt(dati[1])).nuovoRaccolto(dati[2], dati[3], Integer.parseInt(dati[4]));
			}
			riga = br.readLine();
		}
		br.close();	
	}
	
}
