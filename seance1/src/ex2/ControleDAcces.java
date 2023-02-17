package ex2;

import java.util.HashMap;
import java.util.HashSet;

public class ControleDAcces {
	private HashMap<Badge,Employe> ensembleEmployes;
	private HashSet<Employe> ensembleEmployesDansBat;
	public ControleDAcces(){
		ensembleEmployesDansBat = new HashSet<Employe>();
		ensembleEmployes = new HashMap<>();
	}
	
	// associe le badge � un employ�
	public void donnerBadge (Badge b, Employe e){
		ensembleEmployes.put(b,e);
	}
	
	// met � jour les employ�s pr�sents dans le batiment
	public void entrerBatiment (Badge b){
		Employe employe = ensembleEmployes.get(b);
		ensembleEmployesDansBat.add(employe);
	}

	// met � jour les employ�s pr�sents dans le batiment
	public void sortirBatiment (Badge b){
		Employe employe = ensembleEmployes.get(b);
		ensembleEmployesDansBat.remove(employe);
	}
	
	// renvoie vrai si l'employ� est dans le batiment, faux sinon
	public boolean estDansBatiment (Employe e){
		return ensembleEmployesDansBat.contains(e);
	}

}
