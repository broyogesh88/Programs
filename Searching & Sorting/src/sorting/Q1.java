package sorting;
import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[20];
		int[] arr2 = new int[10];
		System.out.println("Enter the value of n1 & n2 : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println("Enter the elements of first array : ");
		for(int i = 0; i < n1; i++)
			arr1[i] = sc.nextInt();
		System.out.println("Enter the elements of second array : ");
		for(int i = 0; i < n2; i++)
			arr2[i] = sc.nextInt();
		
		Arrays.sort(arr1, 0, n1 - 1);
		Arrays.sort(arr2, 0, n2 - 1);
		
		Q1 O = new Q1();
		
		O.append(arr1, arr2, n1, n2);
		
		System.out.println("Array1 after appending Array2 :");
		for(int i = 0; i < n1 + n2; i++)
			System.out.print(arr1[i] + ", ");
		
		sc.close();
	}
	
	public void append(int[] arr1, int[] arr2, int n1, int n2)
	{
		int newSize = n1 + n2 - 1;
		int indexA = n1 - 1;
		int indexB = n2 - 1;
		
		while(indexB >= 0)
		{
			if(indexA >= 0 && arr1[indexA] > arr2[indexB])
			{
				arr1[newSize] = arr1[indexA];
				indexA--;
			}
			else
			{
				arr1[newSize] = arr2[indexB];
				indexB--;
			}
			newSize--;
		}	
	}

}
