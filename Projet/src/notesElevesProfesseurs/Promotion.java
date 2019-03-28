/**
 * 
 */
package notesElevesProfesseurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author MO Fei
 *
 */
public class Promotion implements Collection<Eleve>, EleveComparator {
	
	List<Eleve> eleves;
	
	/**
	 * 
	 */
	public Promotion() {
		eleves = new ArrayList<Eleve>();
	}
	

	/**
	 * @return the eleves
	 */
	public List<Eleve> getEleves() {
		return eleves;
	}
	




	@Override
	public boolean add(Eleve e) {
		
		return false;
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
	public void classerParMoyenne() {
		Collections.sort(getEleves());
	}

	@Override
	public void classerParMediane() {
		Collections.sort(getEleves());	
	}

	@Override
	public void classerParMatiere() {
		Collections.sort(getEleves());	
	}

}
