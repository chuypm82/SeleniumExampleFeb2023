package JavaOOPSamples;

public class Cat extends Animal {
	
	Cat(String c){
		super(c);
		color=c;
	}
	String talk() {
		 return "Meow!";
	}
	
}
