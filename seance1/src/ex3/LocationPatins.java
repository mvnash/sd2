package ex3;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {
	private int[] casiers;
	private HashMap estOccupe;
	private HashMap casiersLibres;
	public LocationPatins(int[] casiers) {
		this.casiers = casiers;
		this.estOccupe = new HashMap<Integer, LocalTime>();
		this.casiersLibres = new HashMap<Integer, ArrayDeque<Integer>>();

		for (int i = 33; i<48;i++){
			casiersLibres.put(i,new ArrayDeque<Integer>());
		}

		for (int i = 0 ; i<casiers.length;i++){
			ArrayDeque<Integer> list = (ArrayDeque<Integer>) casiersLibres.get(casiers[i]);
			list.add(i);
			estOccupe.put(i,null);
		}
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();

		ArrayDeque<Integer> casiers = (ArrayDeque<Integer>) casiersLibres.get(pointure);
		if (casiers.isEmpty()) return -1;
		Integer casier = casiers.removeFirst();
		estOccupe.replace(casier,l);

		return casier;
	}

	public double libererCasier(int numeroCasier) {
		LocalTime dateDebutLoc = (LocalTime) estOccupe.get(numeroCasier);
		estOccupe.replace(numeroCasier,null);
		ArrayDeque<Integer> listCasierLibre = (ArrayDeque<Integer>) casiersLibres.get(casiers[numeroCasier]);
		listCasierLibre.add(numeroCasier);
		return prix(dateDebutLoc, LocalTime.now());
	}

}
