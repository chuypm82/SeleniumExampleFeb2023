package JavaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;


public class Stream3 {

	public static void main(String[] args) {

		ArrayList<String> names= new ArrayList<String>();
		names.add("Alejandro");
		names.add("Carlos");
		names.add("David");
		names.add("Gabriel");
		names.add("Adrina");
		
		Long c= names.stream().filter(n->n.startsWith("A")).count();
		System.out.println(c);
		
		long d= Stream.of("Alejandro","Carlos","Emanda","Gabriel","Adriana","Juan").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		
		// print strings with more than 4 characters
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		System.out.println("****New Stream");
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		System.out.println("****New Stream sorted");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("****New Stream - Second List");
		
		ArrayList<String> names1= new ArrayList<String>();
		names1.add("Jesus");
		names1.add("Adrian");
		
		names1.stream().sorted().forEach(s->System.out.println(s));
		
		System.out.println("****New Stream - Merge 2 lists");
		
		Stream<String> newStream=Stream.concat(names.stream(),names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));   // you can only do an stream one time only
			
		System.out.println("****New Stream - Merge 2 lists to another list NAME2"); 		
		List<String> names2=newStream.sorted().collect(Collectors.toList());
		System.out.println(names2);
		
		//System.out.println("****Print Flag");		
		//boolean flag=newStream.anyMatch(s->s.equals("Carlos"));
		//System.out.println(flag);
		//Assert.assertTrue(flag);
		
		System.out.println("****New Stream - Print list ls"); 
		List<String> ls= names2.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls);
		System.out.println(ls.get(1));
		
		System.out.println("****New Stream - Print list ls2 with Stream of"); 
		List<String> ls2= Stream.of("Juan","Pedro","Adrian").filter(s->s.startsWith("P")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls2);
		
		/*int count = 0;
		for(int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if (actual.startsWith("A"))
			{
				count++;				
			}				
		}
		System.out.println(count);*/
		
	}

}
