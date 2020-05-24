package sorting;

import java.util.*;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an Array : ");
		int size = sc.nextInt();
		ArrayList<Integer> array = new ArrayList<>();
	
		
		System.out.println("Enter the elements of Array : ");
		for(int i = 0; i < size; i++)
			array.add(sc.nextInt());
		System.out.println("Enter the number of times you want to rotate Array : ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter the position from which you want to rotae : ");
			int rotate = sc.nextInt();
			Collections.rotate(array, rotate);
			
		}
		System.out.println("Array after rotation :");
		for(int i = 0; i < size; i++)
			System.out.print(array.get(i) + ", ");
		System.out.println();
		System.out.println("Enter the elements you want to search in an Array : ");
		int num = sc.nextInt();
		Q2 O = new Q2();
		if(O.search(array, 0, size, num))
		{
			System.out.println(num + " is present in an Array.");
		}
		else
		{
			System.out.println(num + " is not present in an Array.");
		}
		
		sc.close();

	}
	
	public boolean search(ArrayList<Integer> array, int left, int right, int num)
	{
		int mid = (left + right) / 2;
		if(array.get(mid) == num)
			return true;
		if(right < left)
			return false;
		
		if(array.get(left) < array.get(mid))
		{
			if(num >= array.get(left) && num < array.get(mid))
			{
				return search(array,left, mid - 1, num);
			}
			else
			{
				return search(array, mid + 1, right, num);
			}
		}
		else if(array.get(left) > array.get(mid))
		{
			if(num > array.get(mid) && num <= array.get(right))
			{
				return search(array,mid + 1, right, num);
			}
			else
			{
				return search(array,left, mid - 1, num);
			}
		}
		else if(array.get(left) == array.get(mid))
		{
			if(array.get(right) != array.get(mid))
			{
				return search(array, mid + 1, right, num);
			}
			else
			{
				boolean result =  search(array,left, mid - 1, num);
				if(result == false)
					return search(array, mid + 1, right, num);
				else
					return result;
			}
		}
		return false;
	}

}

