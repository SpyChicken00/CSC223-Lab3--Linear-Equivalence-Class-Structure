package utilities;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class LinkedEquivalenceClassTest {
	

	LinkedEquivalenceClass<Integer> l; 

			
			
	public LinkedEquivalenceClassTest() {
		
		
		Comparator<Integer> c = new Comparator<Integer>() {
			// All even integers are 'equivalent' // All odd integers are 'equivalent'
			public int compare(Integer x, Integer y) {
				return x % 2 == y % 2 ? 0 : 1; }
			};
			
			l = new LinkedEquivalenceClass<Integer>(c);	
	}

	@Test
	void testCanonical() {
		//TODO- CHECK THAT THE NEW CANONICAL BELONGS
		
		
		//clear the list
		l.clear();
		
		//check that the canonical is null
		assertEquals(null , l.canonical());
		
		//test with a canonical that is null
		assertTrue(l.demoteAndSetCanonical(null));
		
		//test that the canonical is empty
		assertEquals(null , l.canonical());
		
		//test on an empty canonical
		//TODO- change this once demote and set is finalized
		assertEquals(true , l.demoteAndSetCanonical(2));
		
		//check that the canonical is 1
		assertEquals(2, l.canonical());
		
		//test on a canonical element
		l.demoteAndSetCanonical(4);
		
		//check that the new canonical is 2
		assertEquals(4 , l.canonical());
		
		
	}
	
	
	@Test
	void testisEmpty() {
		//clear the list
		l.clear();
		
		//test on an empty canonical and empty rest
		assertTrue(l.isEmpty());
		
		//add a canonical 
		l.demoteAndSetCanonical(2);
		
		//check that the canonical and rest are not empty
		assertFalse(l.isEmpty());
		
		//add element to canonical and have an element in the rest
		l.add(4);
		
		//check that it is still containing elements
		assertFalse(l.isEmpty());
		
		//clear the list
		l.clearNonCanonical();
		
		//check that there is still an element in canonical
		assertFalse(l.isEmpty());
		
		//clear the whole thing
		l.clear();
		
		//check that everything is empty
		assertTrue(l.isEmpty());

	}
	
	
	
	@Test
	public void testClear() {
		//clear the list
		l.clear();
		
		
		//test that the list is empty
		assertTrue(l.isEmpty());
		
		//add elements to the list
		l.demoteAndSetCanonical(2);
		l.add(4);
		l.add(6);
		l.add(8);
		
		//test that the list is not empty
		assertFalse(l.isEmpty());
		
		//clear the list 
		l.clear();
		
		//test that the canonical is null
		assertEquals(null, l.canonical());
		
		//check that the list is now empty
		assertTrue(l.isEmpty());
	
		
	}
	
	
	
	
	@Test
	public void testClearNonCanonical() {
		l.clear();
		//check that size is 1 after clearing list but not canonical
		l.demoteAndSetCanonical(2);
		l.clearNonCanonical();
		assertEquals(1, l.size());
	}
	
	
	
	@Test
	public void testSize() {
		//add canonical, should be 1 item in linked list
		l.clear();
		//test size of linked equivalence class 
		assertEquals(0, l.size());
	}
	
	@Test
	public void testAdd() {
		//TODO CHECK WITH ELEMENTS THAT DO NOT BELONG
	}
	
	
	@Test
	public void testContains() {
		
	}
	
	
	@Test public void testBelongs() {
	
		
	}
	
	
	
	
	
	@Test
	public void testRemove() {
		//clear the list
		l.clear();
		//check that the list is empty
		assertTrue(l.isEmpty());
		
		//test on an empty list
		assertFalse(l.remove(2));
		
		
		
		//add elements to the list
		l.demoteAndSetCanonical(2);
		l.add(4);
		l.add(6);
		l.add(8);
		
		//remove an element
		assertTrue(l.remove(2));
		
		//check that a new canonical has been set to the next element in list
		assertEquals(4 , l.canonical());
		
		//remove an element that is the canonical
		assertTrue(l.remove(4));
		
		
		//remove an element
		assertTrue(l.remove(6));

		
		//check that the canonical is still there but the list is empty
		assertFalse(l.isEmpty());
		
		//double check the size
		assertEquals(1 , l.size());
		
		//try to remove the canonical
		//will return false since it is the last element in the list
		assertFalse(l.remove(8));
		
		//remove an element that is not in the list
		assertFalse(l.remove(2));
		
	}
	
	
	
	
	
	
	@Test
	public void testRemoveCanonical() {
		//clear the list
		l.clear();
		//check that the list is empty
		assertTrue(l.isEmpty());
		
		//add elements to the list
		l.demoteAndSetCanonical(2);
		l.add(4);
		l.add(6);
		l.add(8);
		
		
		//check that the new canonical is 3
		assertEquals(2 , l.canonical());
		
		//remove the canonical
		assertTrue(l.removeCanonical());
		
		//check that the new canonical is 3
		assertEquals(4 , l.canonical());
		
		//remove the canonical again
		assertTrue(l.removeCanonical());
		
		//check that the new canonical is 3
		assertEquals(6 , l.canonical());
		
		//remove canonical again
		assertTrue(l.removeCanonical());
		
		//check that the canonical is the only one
		assertEquals(8 , l.canonical());
		
		//ensure the size
		assertEquals(1 , l.size());

		
	}
	
	
	
	
	@Test
	public void testDemoteAndSetCanonical() {
		//TODO CHECK THAT THE ELEMENT BEING SET TO THE CANONICAL BELONGS
		
		//clear the list
		l.clear();
		
		//check that the canonical is null
		assertTrue(l.demoteAndSetCanonical(null));
		
		//ensure the size is 0 and everything is empty
		assertEquals( 0, l.size());
		
		//add a canonical to the list
		assertTrue(l.demoteAndSetCanonical(2));
		
		//check that the canonical is 2
		assertEquals(2 ,l.canonical());
		
		//check with a canonical value that is not allowed and doesnt belong
		assertFalse(l.demoteAndSetCanonical(3));
		
		//demote the canonical and add element to the front
		assertTrue(l.demoteAndSetCanonical(4));
		
		//verify that the canonical is now 3
		assertEquals(4 , l.canonical());
		
		
		//try to add canonical that is of the same value as existing canonical
		assertFalse(l.demoteAndSetCanonical(4));
		
		//try to add a canonical that is null
		assertFalse(l.demoteAndSetCanonical(null));
		
	
		

	}
	
	@Test
	public void testToString() {
		//set initial canonical
		l.demoteAndSetCanonical(2);
		l.add(4);
		l.add(6);
		l.add(8);
		l.add(10);
		//check string
		assertEquals("{2 | 4 6 8 10 }", l.toString());
		l.demoteAndSetCanonical(4);
		//duplicate element removed when canonical switched
		assertEquals("{4 | 2 6 8 10 }", l.toString());
	}

}

