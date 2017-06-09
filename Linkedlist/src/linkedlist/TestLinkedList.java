package linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {
	
	private LinkedList list;
	
    @Before
    public void setup() {
        this.list = new LinkedList();
        System.out.println("before each");
    }
	
	@Test //tests to see if the list is empty, list cannot be empty
	public final void testNewListIsEmpty() {
		 int i = this.list.size();
	        assertEquals(0, i);  //fail if the list created is empty
	}

	@Test //Append method testing
	public final void testAppendList() {
		 list.append("hi");
		 int i = this.list.size();
		 System.out.println(i);
		 list.append("hi2");
		 int j = this.list.size();
		 System.out.println(j);
		 assertTrue(j > i);
	}
	
	@Test //Insert and Append combination testing
	public final void testInsert() {
		 list.append("hi");
		 list.insert(0, "replace");
		 list.insert(1, "new");
		 int i = this.list.size();
		 System.out.println(i);
		 assertEquals(3, i);
	}
	
	@Test //set method testing
	public final void testSet() {
		 list.append("hi");
		 list.append("hi2");
		 list.insert(0, "replace");
		 list.insert(1, "old");
		 list.set(1, "new");
		 Object o = list.get(1);
//		 int i = this.list.size();
		 System.out.println(o);
		 assertEquals("new", o);
	}

}
