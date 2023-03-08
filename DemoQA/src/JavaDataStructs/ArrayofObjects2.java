package JavaDataStructs;

//Java program to illustrate creating
//an array of objects

class Student2 {
	   public String name;
	   Student2(String name)
	    {
	        this.name = name;
	    }
	      @Override
	    public String toString(){
	        return name;
	    }
}

public class ArrayofObjects2 {

	public static void main(String[] args) {

		   // declares an Array and initializing  the elements of the array
		Student2[] myStudents = new Student2[]{new Student2("Dharma"),new Student2("sanvi"),new Student2("Rupa"),new Student2("Ajay")};
   
        // accessing the elements of the specified array
        for(Student2 m:myStudents){   
            System.out.println(m);
        }
        
	}
}
