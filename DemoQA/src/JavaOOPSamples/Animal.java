package JavaOOPSamples;

 abstract class Animal {
	 protected String color;
	 
	 Animal(String c){
		 color = c;
	 }
	 abstract String talk();
	 
	 public String getColor() {
		 return color;
	 }
	
}
