import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ListeDArc extends Graph{
	
	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
	}

	@Override
	// Complexit�: ?
	protected void ajouterSommet(Airport a) {	
		// Normal que c'est vide, non utilis�
	}

	@Override
	// Complexit�: oN
	protected void ajouterArc(Flight f) {
		flights.add(f);
	}

	@Override
	// Complexit�: on�
	public Set<Flight> arcsSortants(Airport a) {

		return flights.stream().filter(e-> e.getSource().equals(a)).collect(Collectors.toSet());
	}

	@Override
	// Complexit�: on�
	public boolean sontAdjacents(Airport a1, Airport a2) {
		for (Flight f : flights){
			if ((f.getSource().equals(a1) && f.getDestination().equals(a2)) || (f.getSource().equals(a2) && f.getDestination().equals(a1))) return true;
		}
		return false;
	}

}
