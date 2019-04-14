/**
 * 
 */
package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author MO Fei
 *
 */
public class Promotion implements Collection<Eleve>, EleveComparator {

	String promotionNom;
	List<Eleve> eleves;

	/**
	 * 
	 */
	public Promotion(String promotionNom) {
		this.promotionNom = promotionNom;
		eleves = new ArrayList<Eleve>();
	}

	/**
	 * @return the nom
	 */
	public String getPromotionNom() {
		return promotionNom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setPromotionNom(String nom) {
		this.promotionNom = nom;
	}

	/**
	 * @return the eleves
	 */
	public List<Eleve> getEleves() {
		return eleves;
	}

	@Override
	public boolean add(Eleve eleve) {
		eleves.add(eleve);
		eleve.setPromotion(this);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Eleve> c) {

		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean contains(Object o) {

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return false;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public Iterator<Eleve> iterator() {

		return null;
	}

	@Override
	public boolean remove(Object o) {

		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return false;
	}

	@Override
	public int size() {

		return 0;
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
	public void classerParMoyenneDesNotes(Ordre ordre) {
		if (ordre == Ordre.croissant) {
			Collections.sort(getEleves(), new Comparator<Eleve>() {
				@Override
				public int compare(Eleve eleve1, Eleve eleve2) {
					if (eleve1.moyenne() < eleve2.moyenne()) {
						return -1;
					} else if (eleve1.moyenne() > eleve2.moyenne()) {
						return 1;
					} else {
						return eleve1.compareTo(eleve2);
					}
				}
			});
		} else if (ordre == Ordre.decroissant) {
			Collections.sort(getEleves(), new Comparator<Eleve>() {
				@Override
				public int compare(Eleve eleve1, Eleve eleve2) {
					if (eleve1.moyenne() > eleve2.moyenne()) {
						return -1;
					} else if (eleve1.moyenne() < eleve2.moyenne()) {
						return 1;
					} else {
						return eleve1.compareTo(eleve2);
					}
				}
			});
		} else {
		}
	}

	@Override
	public void classerParMedianeDesNotes(Ordre ordre) {
		if (ordre == Ordre.croissant) {
			Collections.sort(getEleves(), new Comparator<Eleve>() {
				@Override
				public int compare(Eleve eleve1, Eleve eleve2) {
					if (eleve1.mediane() < eleve2.mediane()) {
						return -1;
					} else if (eleve1.mediane() > eleve2.mediane()) {
						return 1;
					} else {
						return eleve1.compareTo(eleve2);
					}
				}
			});
		} else if (ordre == Ordre.decroissant) {
			Collections.sort(getEleves(), new Comparator<Eleve>() {
				@Override
				public int compare(Eleve eleve1, Eleve eleve2) {
					if (eleve1.mediane() > eleve2.mediane()) {
						return -1;
					} else if (eleve1.mediane() < eleve2.mediane()) {
						return 1;
					} else {
						return eleve1.compareTo(eleve2);
					}
				}
			});
		} else {
		}
	}

	@Override
	public void classerParMatiere() {
		Collections.sort(getEleves(), new Comparator<Eleve>() {
			@Override
			public int compare(Eleve eleve1, Eleve eleve2) {
				return eleve1.compareTo(eleve2); // need to be fixed.
			}
		});
	}

	public Eleve rechercher(int numeroID) {
		for (Eleve eleve : getEleves()) {
			if (eleve.getNumeroID() == numeroID) {
				return eleve;
			}
		}
		return null;
	}

	/* 
	 * 
	 */
	@Override
	public String toString() {
		String result = "Promotion : " + getPromotionNom() + "\n";
		result += "NumeroID\tPrenom\tNom\tMediane\tMoyenne\n";
		for (Eleve eleve : eleves) {
			result += eleve.getNumeroID() + "\t\t" + 
						eleve.getNom() + "\t" + 
						eleve.getPrenom() + "\t" + 
						eleve.mediane() + "\t" + 
						eleve.moyenne() + "\n";
		}
		return result;
	}

}
