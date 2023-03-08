package JavaSamples;

import java.util.Scanner;

public class Swapping {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("enter the num for which u want the factorial");

		int num = in.nextInt();

		for(int i=num-1; i>0; i-- ){

		num = num*i;

		}

		System.out.println(num);

	}

}
