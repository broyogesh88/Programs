package sorting;

import java.util.Scanner;

public class Bits {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Bits object = new Bits();
		
		while(true)
		{
			System.out.println("Enter two numbers: ");
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int result = object.maxNaive(num1, num2);
			System.out.println("Return value is : " + result + "\n");
			System.out.println("Press 1 to continue 2 to exit.");
			if(sc.nextInt() == 1)
				continue;
			else
				break;
			
		}
		

	}
	
	int flip(int bit)
	{
		return 1^bit;
	}
	
	int sign(int a)
	{
		return flip((a >> 31) & 1);
	}
	
	int maxNaive(int a, int b)
	{
		int k = sign(a - b);
		System.out.println(k);
		int q = flip(k);
		System.out.println(q);
		return a * k + b * q;
	}

}
