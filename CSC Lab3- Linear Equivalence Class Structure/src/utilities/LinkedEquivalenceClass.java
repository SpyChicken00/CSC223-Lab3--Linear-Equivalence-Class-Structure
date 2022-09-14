package utilities;
import java.util.Comparator;
/**
 * A LinkedEquivalence Class, determines if two objects
 * can be compared based on a specified criteria or something 
 * idk fix this later
 * 
 * <p>Bugs: ???
* 
* @author Jace Rettig and Sally Stahl
* @Date 9-12-22
* @param <T>
*/
public class LinkedEquivalenceClass<T> {

	protected T _canonical;
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest;
	
	public LinkedEquivalenceClass(Comparator<T> comparator) {
		_canonical = null;
		_comparator = comparator;
		_rest = new LinkedList<T>();
	}
	
	public T canonical() {
		//establish canonical
		return _canonical;
	}
	
	public boolean isEmpty() {
		//check that list is empty AND that canonical is null;
		if (_canonical == null && _rest.isEmpty()) return true;
		//if not empty
		return false;
	}
	
	public void clear() {
		//TODO test
		//clear list AND clear canonical;
		_canonical = null;
		_rest.clear();
		
	}
	
	public void clearNonCanonical() {
		//clear list but NOT canonical
		_rest.clear();
	}
	
	public int size() {
		//if canonical is not null size = linked list size + 1
		if (!(_canonical == null)) return _rest._size + 1;
		//return the size of the rest of the linked list 
		return _rest.size();
	}

	public boolean add(T element) {
		//TODO WIP- review
		if(_rest.contains(element)) {
			_rest.addToBack(element);
			return true;
		}
		return false;
	}
	
	public boolean contains(T target) {
		//TODO
		return false;
	}
	
	public boolean belongs(T target) {
		//TODO
		return false;
	}
	
	public boolean remove(T target) {
		//TODO 
		return false;
	}
	
	public boolean removeCanonical() {
		//TODO
		
		return false;
	}
	
	public boolean demoteAndSetCanonical(T element) {
		//add canonical to front of list if its not null
		if (!(_canonical == null)) _rest.addToFront(_canonical);
		//set input value to canonical
		if (_canonical != element) {
			_canonical = element;
			return true;
		}
		//if canonical is the same as the element
		return false;
	}
	
	public String toString() {
		//TODO test
		//Create a string that represents list/canonical EX: {2 | 4, 6, 8, 12}
		StringBuilder s = new StringBuilder();
		s.append("{" + _canonical + " | ");
		s.append(_rest.toString() + "}");
		return s.toString();
	}
}








