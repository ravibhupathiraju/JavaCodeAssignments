package hospital;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Hospital {

	Care[] employees;
	Patient[] patients;

	//Main method
	public static void main(String[] args) {
		Patient[] p_array = new Patient[4];
		p_array[0] = new Patient("superman", 86);
		p_array[1] = new Patient("batman", 50);
		p_array[2] = new Patient("spiderman", 100);
		p_array[3] = new Patient("ironman", 100);		
		Doctor d1 = new Doctor("d1", 40);
		Doctor d2 = new Doctor("d2", 30);
		Doctor d3 = new Doctor("d3", 60);
		Doctor d4 = new Doctor("d4", 50);
		Nurse n1 = new Nurse("n1", 30);
		Nurse n2 = new Nurse("n2", 40);
		Nurse n3 = new Nurse("n3", 60);
		Nurse n4 = new Nurse("n4", 50);
		//send patient information to output file patient.data
		try {
			FileOutputStream fileOut = new FileOutputStream("patient.data");  
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for (int i=0;i<p_array.length;i++) {
				System.out.println("writing in progress");
				out.writeObject(p_array[i]);	
			}
			// out.writeObject(c);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in patient.data file");
		} catch (IOException ex) {
			System.out.println(ex);
		}
		// Read from input
		try {
			FileInputStream fileIn = new FileInputStream("patient.data");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			for (int i=0;i<(p_array.length);i++) {
				p_array[i] = (Patient) in.readObject();
				System.out.println("patient name: " + p_array[i].name);
				System.out.println("reading in progress");
			}
			in.close();
			fileIn.close();
			System.out.println("Serialized data is retrieved from patient.data file");
		} catch (IOException ex) {
			System.out.println(ex);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
	}

}

class Person implements java.io.Serializable {
	public String name;
	public int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Doctor extends Person implements Care {

	public double takeTemperature(Patient p) {
		return p.temperature;
	}

	public String readChart(Patient p) {
		return p.illness;
	}

	public BloodPressure readBloodPressure(Patient p) {
		return p.bloodpressure;
	}

	Doctor(String name, int age) {
		super(name, age);
	}
}

class Patient extends Person  {
	int daysInHospital;
	String illness;
	BloodPressure bloodpressure;
	int temperature;
	
	Patient(String name, int age) {
		super(name, age);
	}
	
}

class Nurse extends Person implements Care {

	Nurse(String name, int age) {
		super(name, age);
	}

	public double takeTemperature(Patient p) {
		return p.temperature;
	}

	public String readChart(Patient p) {
		return p.illness;
	}

	public BloodPressure readBloodPressure(Patient p) {
		return p.bloodpressure;
	}
}

class BloodPressure {
	public int systolic;
	public int dyastolic;

	BloodPressure(int systolic, int dyastolic) {
		this.systolic = systolic;
		this.dyastolic = dyastolic;
	}
}

interface Care {
	String department = "";

	double takeTemperature(Patient p);

	String readChart(Patient p);

	BloodPressure readBloodPressure(Patient p);
}