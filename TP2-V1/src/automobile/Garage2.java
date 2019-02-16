package automobile;

import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Iterator;

public class Garage2 implements Collection<Vehicule>, VehiculeComparator {

	Set<Vehicule> vehicules;
	CompteurComparator compteurComparator;

	public Garage2() {
		vehicules = new TreeSet<Vehicule>();
		if (getCompteurComparator() == null) {
			setCompteurComparator(new CompteurComparator());
		}
	}

	public Garage2(CompteurComparator compteurComparator) {
		this();
		setCompteurComparator(compteurComparator);
	}

	private Set<Vehicule> getVehicules() {
		return vehicules;
	}

	private CompteurComparator getCompteurComparator() {
		return compteurComparator;
	}

	private void setCompteurComparator(CompteurComparator compteurComparator) {
		this.compteurComparator = compteurComparator;
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
		TreeSet<Vehicule> treeSet = new TreeSet<Vehicule>();
		treeSet.addAll(getVehicules());
		vehicules = treeSet;
		System.out.println("V¨¦hicules d¨¦j¨¤ tri¨¦s par ordre d'immatriculation");
	}

	@Override
	public void triCompteur() {
		TreeSet<Vehicule> treeSet = new TreeSet<Vehicule>(compteurComparator);
		treeSet.addAll(getVehicules());
		vehicules = treeSet;
		System.out.println("V¨¦hicules d¨¦j¨¤ tri¨¦s par ordre de compteur");
	}

}
