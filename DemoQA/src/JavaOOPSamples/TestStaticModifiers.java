package JavaOOPSamples;

import JavaSamples.Car;

public class TestStaticModifiers {

	public static void main(String[] args) {

		/*Car Toyota = new Car();
		
		Toyota.sModel="Camry";
		Toyota.iHighestSpeed=230;
		Toyota.iDoors=2;
		Car.iDoors =3;
		//Car.iSteering =10;
		
		Toyota.DisplayCharacterstics();
		//Toyota.DisplayStaticCharacterstics();*/
		Car Toyota = new Car();
		Toyota.sModel="Camry";
		Toyota.iHighestSpeed=230;
		//Toyota.steering=2; //Compile time error
		//Toyota.wheels=4; //Compile time error
		
		
		Car.DisplayStaticCharacterstics();		
		
	}
}
