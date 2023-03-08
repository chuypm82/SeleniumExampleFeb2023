package JavaDataStructs;

import java.util.LinkedList;
public class ObjectSamples {

	public static void main(String[] args) {
		
		Object obj = new String("GeeksForGeeks");
        Class c = obj.getClass();
        System.out.println("Class of Object obj is : "
                           + c.getName());
	}
}
