import java.util.*;
import java.math.*;

class Base5add {

	public static void main(String[] args) {

		int a = 0, b = 0, status = 1, temp, carry = 0, power = 0, sum = 0;

		Scanner in = new Scanner(System.in);

		System.out.println("Enter first number");
		a = in.nextInt();

		System.out.println("Enter second number");
		b = in.nextInt();

		for (int i = a; i != 0; i /= 10)
			if (i % 10 > 4) {
				System.out.println("Invalid Input in Number 1");
				status = 0;
				break;
			}
		for (int i = b; i != 0; i /= 10)
			if (i % 10 > 4) {
				System.out.println("Invalid Input in Number 2");
				status = 0;
				break;
			}

		if (status != 0) {

			while (a != 0 || b != 0) {

				temp = a % 10 + b % 10;
				if (temp + carry > 4) {
					temp -= 5;
					sum += Math.pow(10, power) * (temp + carry);
					carry = 1;
				} else {
					sum += Math.pow(10, power) * (temp + carry);
					carry = 0;
				}
				a /= 10;
				b /= 10;
				power++;
			}

			if (carry == 1) {
				sum += Math.pow(10, power) * 1;
			}

			System.out.println("Sum is " + sum);

		}
	}
}
