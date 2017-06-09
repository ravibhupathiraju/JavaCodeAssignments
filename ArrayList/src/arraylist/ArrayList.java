// Array list program. Size doubles after the initial set size of 5 has reached. 
package arraylist;

public class ArrayList {

	private static Object[] things = new Object[5];
	private static int index = 0;

	public static void main(String[] args) { // Main method
		try {
			set(23, 0);    //setting up the array list and testing them by printing them to the console
			set(45, 1);
			set(73, 2);
			System.out.println(size()); // result should be 3
			append(1);
			System.out.println(things[3]); // result should be 1
			append(2);
			System.out.println(things[4]); // result should be 2
			System.out.println(size()); // result should be 5
			set(60, 5);
			System.out.println(size()); // result should be 6
			System.out.println(things[5]); // result should be 60
			append(45);
			append(9);
			append(40);
			append(30);
			append(2);
			// set(70,32);
			System.out.println(size()); // result should be 11
			System.out.println(get(10)); // result should be 2
			append(11);
			System.out.println(get(11)); // result should be 11
		} catch (IndexOutOfBoundsException e) {
			System.out
					.println("Wrong index number, please enter correct number. "
							+ e);
		}

		catch (Exception e) {
			System.out.println("Exception issue, report to IT department" + e);
		}
	}

	public static Object get(int idx) { // this will return the Object at the
										// corresponding index
		return things[idx];
	}

	public static void set(Object obj, int idx) { // setting the object at that
													// index
		if (idx >= things.length) {
			Object[] thingsNew = new Object[index * 2];
			for (int i = 0; i < index; i++) {
				thingsNew[i] = things[i];
			}
			things = thingsNew;
		}

		things[idx] = obj;

		if (idx >= index) {
			index++;
		}
	}

	public static void append(Object obj) { // This method is to add new data to the end of the array list
		set(obj, index);
	}

	public static int size() { // this method will return the size of the array list
		return index;
	}

}