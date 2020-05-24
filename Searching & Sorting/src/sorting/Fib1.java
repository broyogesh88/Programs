package sorting;
import java.util.*;

public class Fib1 {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of cases : ");
		int test = sc.nextInt();
		
		while(test-- > 0)
		{
			System.out.println("Enter fibonacci number you want to get: ");
			int n = sc.nextInt();
			Fib1 F = new Fib1();
			int num = F.Fibonacci(n);
			System.out.println(n + " Fibonacci number is : " + num);
		}
		
		sc.close();
	}
	
	public int Fibonacci(int n)
	{
		int[] F = new int[n + 1];
		F[0] = 1;
		F[1] = 1;
		
		for(int i = 2; i <= n; i++)
		{
			F[i] = F[i - 1] + F[i - 2];
		}	
		return F[n];
	}

}


