package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class AS {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AS object = new AS();
	
		while(true)
		{
			System.out.println("1: Unique Character");
			//System.out.println();
			//System.out.println("");
			//System.out.println();
			//System.out.println();
			//System.out.println("");
			//System.out.println();
			//System.out.println();
			//System.out.println("");
			//System.out.println();
			//System.out.println();
			//System.out.println("");
			//System.out.println();
			System.out.println("10: Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter String: ");
				String str = sc.next();
				if(object.isUnique(str))
					System.out.println("String is unique");
				else
					System.out.println("String is not unique");
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				System.exit(1);
			}
		}
		

	}
	
	boolean isUnique(String str)
	{
		boolean[] array = new boolean[128];
		int i;
		for(i = 0; i < str.length(); i++)
			array[i] = false;
		if(str.length() > 128)
			return false;
		
		for(i = 0; i < str.length(); i++)
		{
			if(array[(int) str.charAt(i)])
				return false;
			else
				array[(int) str.charAt(i)] = true;
		}
		return true;
	}

}
