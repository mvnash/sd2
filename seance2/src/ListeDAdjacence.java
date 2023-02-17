import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence extends Graph{
	
	private Map<Airport,Set<Flight>> outputFlights;

	public ListeDAdjacence(){
		super();
		outputFlights=new HashMap<Airport,Set<Flight>>();

	}

	@Override
	// Complexité: 01
	protected void ajouterSommet(Airport a) {	
		outputFlights.put(a,new HashSet<>());
	}

	@Override
	// Complexité: 01
	protected void ajouterArc(Flight f) {
		outputFlights.get(f.getSource()).add(f);
	}

	@Override
	// Complexité: 01
	public Set<Flight> arcsSortants(Airport a) {
		return outputFlights.get(a);
	}

	@Override
	// Complexité: on²
	public boolean sontAdjacents(Airport a1, Airport a2) {
		Set<Flight> ensembleA = outputFlights.get(a1);
		Set<Flight> ensembleB = outputFlights.get(a2);

		for (Flight flight : ensembleA){
			if (flight.getDestination().equals(a2)) return true;
		}

		for (Flight f : ensembleB){
			if (f.getDestination().equals(a1)) return true;
		}

		return false;
	}

}
