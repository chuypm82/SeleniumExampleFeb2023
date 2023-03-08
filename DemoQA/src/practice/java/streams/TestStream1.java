package practice.java.streams;

import java.util.ArrayList;


public class TestStream1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Practice - Streams - Exercise #1");
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Alejandro");
		names.add("Carlos");
		names.add("David");
		names.add("Gabriel");
		names.add("Adriana");
		
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		/*int count=0;
		for(int i=0; i< names.size(); i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		*/	

		System.out.println("End of Exercise ");

	}

}
