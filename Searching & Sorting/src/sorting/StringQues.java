package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class StringQues {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while(true)
		{
			System.out.println("1: Check Permutation.");
			System.out.println("2: Check Permutation (Efficient Method).");
			//System.out.println("");
			//System.out.println("");
			
			System.out.println("7: Exit");
			StringQues object = new StringQues();
			System.out.print("\nEnter your choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				object.isPermutation1();
				break;
			case 2:
				object.isPermutation2();
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
				System.exit(1);
			}
		}

	}
	
	void isPermutation1()
	{
		System.out.print("Enter first String : ");
		String str1 = sc.next();
		System.out.print("Enter Second String : ");
		String str2 = sc.next();
		
		if(str1.length() != str2.length())
		{
			System.out.println("No, both strings are not permutation of each other\n");
			return;
		}
		if(sort(str1).equals(sort(str2)))
			System.out.println("Yes, both strings are permutation of each other\n");
		else
			System.out.println("No, both strings are not permutation of each other\n");
		
	}
	
	void isPermutation2()
	{
		System.out.print("Enter first String : ");
		String str1 = sc.next();
		System.out.print("Enter Second String : ");
		String str2 = sc.next();
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 != len2)
		{
			System.out.println("No, both strings are not permutation of each other\n");
			return;
		}
		
		int[] array = new int[128];
		
		for(int i = 0; i < len1; i++)
		{
			int val = str1.charAt(i);
			array[val]++;
		}
		
		for(int i = 0; i < len1; i++)
		{
			int val = str1.charAt(i);
			array[val]--;
		}
		
		for(int i = 0; i < 128; i++)
		{
			if(array[i] != 0)
			{
				System.out.println("No, both strings are not permutation of each other\n");
				return;
			}
		}
		System.out.println("Yes, both strings are permutation of each other\n");
		
		
		
	}
	
	String sort(String str)
	{
		char[] array = str.toCharArray();
		
		Arrays.sort(array);
		str = new String(array);
		return str;
	}

}
