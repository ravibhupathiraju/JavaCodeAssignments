//Queue program. Size of the queue doubles after reaching initial max set size of 4
package queue;
public class Queue {
    
    private int[] vals;
    private int size;
    
    public int size() {
        return 4;
    }
    
    public void enqueue(int newValue) {
    	try {
        if (this.size >= this.vals.length) {
            System.out.println("Here: " + this.size);
            int[] arr = new int[this.vals.length * 2];
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.vals[i];
            }
            this.vals = arr;
        }
        
        this.vals[this.size] = newValue;
        this.size ++;
        return;
    	}
    	catch (IndexOutOfBoundsException e) {
    		System.out.println("Index issue, please  check and correct the code " + e);
    	}
    	catch (Exception e) {
    		System.out.println("Exception in enqueue method, please check and correct the code " + e);
    	}
    }
    
    public int dequeue() {
        int val = this.vals[0];
        for (int i = 0; i < this.size; i++){
            this.vals[i] = this.vals[i+1];
        }
        this.size--;
        return val;
    }
    
    public Queue() {
        this.vals = new int[10];
        this.size = 0;
    }
    
    public static void main(String[] args) {
        Queue qu = new Queue();
        qu.enqueue(13);
        qu.enqueue(14);
        qu.enqueue(15);
        qu.enqueue(16);
        for (int i = 0; i < qu.size; i++){
            System.out.println("Enqueue: " + qu.vals[i]);
        }
        qu.dequeue();
        qu.dequeue();
        qu.enqueue(17);
        qu.enqueue(18);
        qu.dequeue();
        qu.enqueue(19);
        qu.enqueue(20);
        qu.enqueue(21);
        qu.enqueue(22);
        qu.enqueue(23);
        qu.enqueue(24);
        qu.enqueue(25);
        qu.enqueue(26);
        qu.enqueue(27);
        qu.enqueue(28);
        qu.enqueue(29);
        
        for (int i = 0; i < qu.size; i++){
            System.out.println("Dequeue: " + qu.vals[i]);
        }
    }   
}