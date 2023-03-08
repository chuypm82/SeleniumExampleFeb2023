package JavaOOPSamples;

public class Dog extends Animal {
	
	Dog(String c){
		super(c);
		color=c;
	}
	
	String talk() {
		return "Woof";
	}

}
