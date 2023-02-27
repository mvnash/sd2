package ex5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Doodle {
	private PlageHoraire[] plages;
	// a compl�ter
	private HashMap<String,boolean[]> dispoParticipants;

	public Doodle(PlageHoraire... plages) {
		this.plages = plages;
		// a compl�ter
		dispoParticipants = new HashMap<>();
	}

	// ajoute les disponibilit�s d'un participant sous forme d'un tableau de booleen.
	// les indices du tableau correspondent aux indices du tableau plages
	// true � l'indice i veut dire que le participant est disponible pour la plage � l'indice i du tableau plages
	// false � l'indice i veut dire que le participant n'est pas disponible pour la plage � l'indice i du tableau plages
	public void ajouterDisponibilites(String participant, boolean[] disponibilites) {
		if (disponibilites.length != plages.length)
			throw new IllegalArgumentException();
		//a compl�ter
		dispoParticipants.put(participant,disponibilites);
;
		for (int i = 0 ;  i<plages.length; i++){
			if (disponibilites[i]){
				plages[i].setNbParticipantPresent(plages[i].getNbParticipantPresent()+1);
			}
		}
	}
	
	// Hypoth�se: la PlageHoraire plage en param�tre fait bien partie du tableau plages
	// renvoie vrai si le participant est disponible pour cette plage horaire
	// renvoie faux si le participant n'est pas disponible ou s'il n'a pas rempli le
	// sondage doodle
	public boolean estDisponible(String participant, PlageHoraire plage) {
		boolean[] dispoDuParticipant = dispoParticipants.get(participant);
		int indexPlage = 0;
		for (int i = 0 ; i< plages.length;i++){
			if (plages[i].equals(plage)) {
				indexPlage = i;
				break;
			}
		}
		return dispoDuParticipant[indexPlage];
	}

	// renvoie une des plages horaires qui a le maximum de participants pr�vus
	// cette m�thode est appel�e apr�s que les participants aient rempli leurs disponibilit�s
	public PlageHoraire trouverPlageQuiConvientLeMieux() {
		return Arrays.stream(plages).sorted(Comparator.comparing(PlageHoraire::getNbParticipantPresent).reversed()).findFirst().orElse(null);
	}

}
