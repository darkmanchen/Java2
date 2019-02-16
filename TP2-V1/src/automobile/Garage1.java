package automobile;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Garage1 implements Collection<Vehicule>, VehiculeComparator {

	List<Vehicule> vehicules;

	public Garage1() {
		vehicules = new ArrayList<Vehicule>();
	}

	private List<Vehicule> getVehicules() {
		return vehicules;
	}

	@Override
	public boolean add(Vehicule vehicule) {
		return getVehicules().add(vehicule);
	}

	@Override
	public boolean addAll(Collection<? extends Vehicule> c) {
		return getVehicules().addAll(c);
	}

	@Override
	public void clear() {
		getVehicules().clear();
	}

	@Override
	public boolean contains(Object o) {
		return getVehicules().contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return getVehicules().containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return getVehicules().isEmpty();
	}

	@Override
	public Iterator<Vehicule> iterator() {
		return getVehicules().iterator();
	}

	@Override
	public boolean remove(Object o) {
		return getVehicules().remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return getVehicules().removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return getVehicules().retainAll(c);
	}

	@Override
	public int size() {
		return getVehicules().size();
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public String toString() {
		String result = "";
		for (Vehicule vehicule : vehicules) {
			result = result + vehicule + "\n";
		}
		return result;
	}

	public void resetPartielAll() {
		for (Vehicule vehicule : getVehicules()) {
			vehicule.getCompteur().resetPartiel();
		}
	}

	public void faireLePleinAll() {
		for (Vehicule vehicule : getVehicules()) {
			if (vehicule.getJauge() < 10.0) {
				vehicule.faireLePlein();
			}
		}
	}

	@Override
	public void triNoImmatriculion() {
		Collections.sort(getVehicules());
	}

	@Override
	public void triCompteur() {
		Collections.sort(getVehicules(), new CompteurComparator());
	}

}
