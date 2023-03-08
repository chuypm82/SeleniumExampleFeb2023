package JavaOOPSamples;

public class AnimalTest {

	public static void main(String[] args) {

		Animal[] pets = new Animal[2];
		pets[0]= new Cat("yellow");
		pets[1]= new Dog("green");
		//pets[2]= new Animal("blue");
		
		//Animal pet= new Animal;
		
		Cat pet = new Cat("brown");
		System.out.println(pet.talk());
		
		for(int i=0; i<pets.length; i++) {
			System.out.println("Pet["+i+"]: " + pets[i].talk());			
		}
		System.out.println(pets[0].getColor());

	}

}
