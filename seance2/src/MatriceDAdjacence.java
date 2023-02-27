import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatriceDAdjacence extends Graph{
	
	private Map<Integer, Airport>  correspondanceIndiceAirport;
	private Map<Airport, Integer>  correspondanceAirportIndice;
	private Flight[][] matrice= new Flight[0][0];
	private int nbAirport=0;

	public MatriceDAdjacence() {
		super();
		correspondanceAirportIndice= new HashMap<Airport,Integer>();
		correspondanceIndiceAirport= new HashMap<Integer,Airport>();
	}

	@Override
	// Complexité: ?
	protected void ajouterSommet(Airport a) {
		Flight[][] matriceClone = new Flight[nbAirport+1][nbAirport+1];

		for (int i = 0 ; i<nbAirport;i++){
			for (int j = 0 ; j < nbAirport;j++){
				matriceClone[i][j] = matrice[i][j];
			}
		}
		matrice = matriceClone;
		correspondanceAirportIndice.put(a,nbAirport);
		correspondanceIndiceAirport.put(nbAirport,a);
		nbAirport++;
	}

	@Override
	// Complexité: ?
	protected void ajouterArc(Flight f) {
		matrice[correspondanceAirportIndice.get(f.getSource())][correspondanceAirportIndice.get(f.getDestination())] = f;
	}

	@Override
	// Complexité: ?
	public Set<Flight> arcsSortants(Airport a) {
		Set<Flight> flights = new HashSet<>();
		int indexAirport = correspondanceAirportIndice.get(a);
		for (int i = 0 ; i<nbAirport;i++){
			if (matrice[indexAirport][i] != null){
				flights.add(matrice[indexAirport][i]);
			}
		}
		return flights;
	}

	@Override
	// Complexité: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		int indA1 = correspondanceAirportIndice.get(a1);
		int indA2 = correspondanceAirportIndice.get(a2);

		if (matrice[indA1][indA2]!= null) return true;
		if (matrice[indA2][indA1]!= null) return true;

		return false;
	}
	
	

}
