package automobile;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Garage1 implements Collection<Vehicule> {

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
		for (Vehicule vehicule : this.getVehicules()) {
			vehicule.getCompteur().resetPartiel();
		}
	}

	public void faireLePleinAll() {
		for (Vehicule vehicule : this.getVehicules()) {
			vehicule.faireLePlein();
		}
	}

	public void triNoImmatriculion() {
		Collections.sort(this.getVehicules());
	}

	public void triStatiqueCompteur() {
		Collections.sort(getVehicules(), new Comparator<Vehicule>() {
			@Override
			public int compare(Vehicule vehicule1, Vehicule vehicule2) {
				System.out.println("here!");
				if (vehicule1.getCompteur().getTotalisateur() < vehicule2.getCompteur().getTotalisateur()) {
					return -1;
				} else if (vehicule1.getCompteur().getTotalisateur() > vehicule2.getCompteur().getTotalisateur()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	public void triCompteur() {
		Collections.sort(getVehicules(), new Comparator<Vehicule>() {
			@Override
			public int compare(Vehicule vehicule1, Vehicule vehicule2) {
				if (vehicule1.getCompteur().getTotalisateur() < vehicule2.getCompteur().getTotalisateur()) {
					return -1;
				} else if (vehicule1.getCompteur().getTotalisateur() > vehicule2.getCompteur().getTotalisateur()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

}
