package JavaStream;

import java.util.ArrayList;


public class NoStream3 {

	public static void main(String[] args) {

		ArrayList<String> names= new ArrayList<String>();
		names.add("Alejandro");
		names.add("Carlos");
		names.add("David");
		names.add("Gabriel");
		names.add("Adrina");
		
		int count = 0;
		for(int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if (actual.startsWith("A"))
			{
				count++;				
			}				
		}
		System.out.println(count);
	}

}
