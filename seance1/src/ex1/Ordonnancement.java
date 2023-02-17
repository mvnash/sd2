package ex1;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Ordonnancement {
	public static final int NIVEAU_PRIORITE_MAX=5;
	private HashMap<Integer, ArrayDeque<Tache>> map;

	public Ordonnancement(){
		map = new HashMap<Integer, ArrayDeque<Tache>>();

		for (int i = 0 ; i<= NIVEAU_PRIORITE_MAX;i++){
			map.put(i,new ArrayDeque<>());
		}
	}
	public void ajouterTache (String descriptif, int priorite){
		if (priorite<0 || priorite > NIVEAU_PRIORITE_MAX) return;

		map.get(priorite).add(new Tache(descriptif, priorite));
	}
	
	//renvoie la tache prioritaire
	//renvoie null si plus de tache presente
	public Tache attribuerTache(){
		Tache tache = null;
		for (int i = NIVEAU_PRIORITE_MAX; i>=0;i--){
			if (map.get(i).isEmpty()) continue;
			tache = map.get(i).removeFirst();
			break;
		}
		return tache;
	}
}
