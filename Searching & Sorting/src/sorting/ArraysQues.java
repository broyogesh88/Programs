package sorting;

import java.util.Scanner;

public class ArraysQues {

	static Scanner sc = new Scanner(System.in);
	
public static void main(String[] args) {
	

	
		while(true)
		{
			System.out.println("1: Reverse Array.");
			System.out.println("2: Find Leader.");
			System.out.println("3: Rotate Left By One.");
			System.out.println("4: Left Rotate by d.");
			System.out.println("5: Maximum Difference in Array.");
			System.out.println("6: Maximum COnsecutive Ones.");
			System.out.println("7: Check Water Tapping.");
			System.out.println("8: Maximum Sub array sum (Kadane's Algotrithm).");
			System.out.println("9: Longest Alternating(odd, even) subarray.");
			System.out.println("10: Exit");
			ArraysQues object = new ArraysQues();
			System.out.print("\nEnter your choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				object.reverseArray();
				break;
			case 2:
				object.findLeader();
				break;
			case 3:
				object.leftRotateByOne();
				break;
			case 4:
				object.LeftRotate();
				break;
			case 5:
				object.maxDifference();
				break;
			case 6:
				object.maxConsecutiveOnes();
				break;
			case 7:
				object.checkWaterContain();
				break;
			case 8:
				object.maxSubArraySum();
				break;
			case 9:
				object.longestAlternatingSubarray();
				break;
			case 10:
				System.exit(1);
			}
		}
		

	}

	void maxSubArraySum()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		if(n < 1)
			return;
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		int sum = array[0];
		int prevMax = array[0];
		
		for(int i = 1; i < n; i++)
		{
			prevMax = max(prevMax + array[i], array[i]);
			sum = max(sum, prevMax);
		}
		
		System.out.println("Sum of a maximum Sub array is : " + sum + "\n");
			
		
	}
	
	void longestAlternatingSubarray()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		if(n < 1)
			return;
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		int length = 1;
		int res = 1;
		for(int i = 1; i < n; i++)
		{
			if((array[i] % 2 == 0 && array[i - 1] % 2 != 0) || (array[i] % 2 != 0 && array[i - 1] % 2 == 0))
				res++;
			else
				res = 1;
			length = max(length, res);
			
		}
		
		System.out.println("Length of longest alternating subarray is : " + length + "\n");
	}

	void reverseArray()
	{
		
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		int low = 0;
		int high = n - 1;
		
		while(high > low)
		{
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			low++;
			high--;	
		}
		
		System.out.print("Reverse array is : { ");

		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i]);
			if(i != n - 1)
				System.out.print(", ");
		}
		System.out.println(" }\n");
		
		
	}
	
	void findLeader()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		int max = array[n - 1];
		System.out.print("Leaders in this array are: { " + max);
		
		for(int i = n - 1 ; i >= 0; i--)
		{
			if(array[i] <= max)
				max = array[i];
			else
				System.out.print( ", " + array[i]);
		}
		System.out.println(" }\n");	
	}
	
	void leftRotateByOne()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		int ele = array[0];
		
		for(int i = 0; i < n - 1; i++)
		{
			array[i] = array[i + 1];
		}
		array[n - 1] = ele;
		
		System.out.print("Rotated array is : { ");

		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i]);
			if(i != n - 1)
				System.out.print(", ");
		}
		System.out.println(" }\n");
		
		
	}
	
	void LeftRotate()
	{
		
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		System.out.print("Enter the value of d by which you want to roate: ");
		int d = sc.nextInt();
		
		reverse(array, 0, d - 1);
		reverse(array, d, n - 1);
		reverse(array, 0, n - 1);
		
		System.out.print("Reverse array is : { ");
		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i]);
			if(i != n - 1)
				System.out.print(", ");
		}
		System.out.println(" }\n");
		
		
		
	}
	
	void reverse(int[] array, int low, int high)
	{
		
		while(high > low)
		{
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			low++;
			high--;	
		}
		
	}
	
	void maxDifference()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		if(n < 2)
		{
			System.out.println("Sorry Array SIze must be atleast 2.\n");
			return;
		}
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		int minVal = array[0];
		int maxDiff = array[1] - array[0];
		
		for(int i = 1; i < n; i++)
		{	
			maxDiff = max(maxDiff, array[i] - minVal);
			minVal = min(minVal, array[i]);

		}
		System.out.println("Maximum DIfference is : " + maxDiff + "\n");
		
		
		
		
	}
	
	int max(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
	
	int min(int a, int b)
	{
		if(a < b)
			return a;
		else
			return b;
	}
	
	void maxConsecutiveOnes()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		int count = 0;
		
		int res = 0;
		
		for(int i = 0; i < n; i++)
		{
			if(array[i] == 1)
				res++;
			else
			{
				if(count < res)
					count = res;
				res = 0;
			}
		}
		
		System.out.println("Maximum Consecutive ones is : " + count +"\n");
		
	}
	
	void checkWaterContain()
	{
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		if( n < 3)
		{
			System.out.println("Sorry 0 units of water can be hold.\n");
			return;
		}
		
		int[] array = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextInt();
		}
		
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
	
		leftMax[0] = array[0];
		for(int i = 1; i < n - 1; i++)
		{
			leftMax[i] = max(array[i], leftMax[i - 1]);
		}
		
		rightMax[n - 1] = array[n - 1];
		for(int i = n - 2; i >= 0; i--)
		{
			rightMax[i] = max(array[i], rightMax[i + 1]);
		}
		
		int units = 0;
		for(int i = 1; i < n - 1; i++)
		{
			units += (min(leftMax[i], rightMax[i])) - array[i];
		}
		
		System.out.println("Total units of water can be tapped is : " + units + "\n");
		
		
	}
}
