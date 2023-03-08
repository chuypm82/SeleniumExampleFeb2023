package JavaOOPSamples;

public class SportsCar extends Car {
	
	double maxSpeed;
	
	public SportsCar(int i_NumberOfseats, double d_MaxSpeed) {
		super(i_NumberOfseats);
		//perform other initialization here
		maxSpeed=d_MaxSpeed;
	}
	
	@Override
	public void setLicensePlate(String license) {
		this.licensePlate=license.toLowerCase();
		//super.licensePlate=license.toLowerCase();
	}
	
	@Override
	public String toString() {
		return super.toString() + ". Its max speed is " + maxSpeed;
	}

}
