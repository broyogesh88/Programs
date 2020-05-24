package sorting;
import java.util.*;

public class BitWise {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true)
		{
			System.out.println("1: Left Shift");
			System.out.println("2: Right Shift");
			System.out.println("3: Bitwise AND");
			System.out.println("4: Bitwise OR");
			System.out.println("5: Bitwise XOR");
			System.out.println("6: Bitwise NOT");
			System.out.println("7: check set bit");
			System.out.println("8: Convert Decimal to Binary");
			System.out.println("9: One Odd Occuring");
			System.out.println("10: Two Odd Occuring");
			System.out.println("11: Power Set");
			System.out.println("12: Count Set Bits");
			//System.out.println();
			System.out.println("13: Exit");
			BitWise object = new BitWise();
			System.out.print("\nEnter your choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				object.Shift(1);
				break;
			case 2:
				object.Shift(2);
				break;
			case 3:
				object.checkOperator(1);
				break;
			case 4:
				object.checkOperator(2);
				break;
			case 5:
				object.checkOperator(3);
				break;
			case 6:
				object.checkOperator(4);
				break;
			case 7:
				object.checkSetBit();
				break;
			case 8:
				object.convertToBinary();
				break;
			case 9:
				object.findOneOdd();
				break;
			case 10:
				object.findTwoOdd();
				break;
			case 11:
				object.powerSet();
				break;
			case 12:
				object.countSetBit();
				break;
			case 13:
				System.exit(1);
			}
		}
		
		
		

	}
	
	void findOneOdd()
	{
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		if(n % 2 == 0)
		{
			System.out.println("Wrong Input Size.");
			return;
		}
		int[] array = new int[n];
		
		System.out.println("Enter elements of array:");
		for(int i = 0; i < n; i++)
			array[i] = sc.nextInt();
		int res = 0;
		
		for(int i = 0; i < n; i++)
			res ^= array[i];
		
			
		System.out.println("Element witth odd count is : " + res);
		System.out.println();
		
	}
	
	void findTwoOdd()
	{
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		if(n % 2 != 0)
		{
			System.out.println("Wrong Input Size.");
			return;
		}
		int[] array = new int[n];
		
		System.out.println("Enter elements of array:");
		for(int i = 0; i < n; i++)
			array[i] = sc.nextInt();
		
		int res = 0;
		for(int i = 0; i < n; i++)
			res ^= array[i];
		
		int setbit = res &~(res - 1);
		int res1 = 0;
		int res2 = 0;
		
		for(int i = 0; i < n; i++)
		{
			if((array[i] & setbit) != 0)
				res1 ^= array[i];
			else
				res2 ^= array[i];
		}
		
		System.out.println("Two Odd occuring elements are : " + res1 + " & " + res2);
		System.out.println();
	}
	
	void powerSet()
	{
		System.out.println("Enter size of set: ");
		int n = sc.nextInt();
		int[] array = new int[n];
		System.out.println("Enter elements of set:");
		for(int i = 0; i < n; i++)
			array[i] = sc.nextInt();
		int count = (int)Math.pow(2, n);
		
		
		
		for(int i = 0; i < count; i++)
		{
			String str = "{";
			for(int j = 0; j < n; j++)
			{
				if((i & (1 << j)) != 0)
				{
					if(j != n - 1)
						str += array[j] + " ";
					else
						str += array[j];
				}
			}
			System.out.println(str + "}");
			
		}
		System.out.println();
		
		
	}
	
	
	void Shift(int option)
	{
		
		System.out.println("Enter number: ");
		int num1 = sc.nextInt();
		
		System.out.println("Enter by how much you want to shift: ");
		int num2 = sc.nextInt();
		
		if(option == 1)
		{
			System.out.println("Shifting bits of " + num1 + " by " + num2 + " left ");
			System.out.println(num1 << num2);
		}
		else
		{
			System.out.println("Shifting bits of " + num1 + " by " + num2 + " rightt ");
			System.out.println(num1 >> num2);
		}
		
		
	}
	
	void checkOperator(int option)
	{
		
		System.out.print("Enter first number: ");
		int num1 = sc.nextInt();
		
		System.out.print("Enter second number: ");
		int num2 = sc.nextInt();
		
		if(option == 1)
		{
			System.out.print("Bitwise AND operator gives you: ");
			System.out.println(num1 & num2);
		}
		else if(option == 2)
		{
			System.out.print("Bitwise OR operator gives you: ");
			System.out.println(num1 | num2);
		}
		else if(option == 3)
		{
			System.out.println("Bitwise XOR operator gives you: ");
			System.out.println(num1 ^ num2);
		}
		else if(option == 4)
		{
			System.out.println("Bitwise NOT operator gives you: ");
			System.out.println(~num1);
			System.out.println("Bitwise NOT operator gives you: ");
			System.out.println(~num2);
		}
	}
	void checkSetBit()
	{
		boolean flag = true;
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		
		System.out.print("Enter k (less than 32): ");
		int k = sc.nextInt();
		
		int val = num << k;
		
		if(num % 2 == 0)
			flag = false;
		
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
	
	void countSetBit()
	{
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		int count = 0;
		
		while(num >= 1)
		{
			if((num & 1) != 0)
				count++;
			num  = num >> 1;
		}
		System.out.println("Total no. of set bits is : " + count);
		System.out.println();
		
	}
	
	void convertToBinary()
	{
		int[] array = new int[32];
		
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		
		int i = 0;
		
		/*while(num > 0)
		{
			array[i++] = num % 2;
			num /= 2;
		}
		
		for(int j = i - 1; j >= 0; j--)
			System.out.print(array[j]);*/
		
		for(i = 31; i >= 0; i--)
		{
			int k = num >> i;
			
			if( (k & 1) > 0)
				System.out.print("1");
			else
				System.out.print("0");
			
		}
		
		System.out.println();
	}
	
	

}
