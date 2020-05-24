package sorting;
import java.util.*;

public class gasStation {

	public static void main(String[] args) {
		
		gasStation object = new gasStation();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		System.out.println("Enter the Amount of Gas : ");
		for(int i = 0; i < size; i++)
		{
			int num = sc.nextInt();
			A.add(num);
		
		}
		
		System.out.println("Enter the required gas to travel next station : ");
		for(int i = 0; i < size; i++)
		{
			int num = sc.nextInt();
			B.add(num);
		
		}
		int index = object.canCompleteCircuit(A, B, size);
		if(index == -1)
			System.out.println("Circuit cannot be completed");
		else
			System.out.println("Driver can complete circuit from station : " + index);
			
		
		sc.close();

	}
	
	int canCompleteCircuit(ArrayList<Integer> A, ArrayList<Integer> B, int size)
	{
		int i, j;
		
		for(i = 0; i < size; i++)
		{
			int result = checkForStation(A, B, size, i);
			if(result == i)
				return i;	
		}
		return -1;
	}
	
	int checkForStation(ArrayList<Integer> A, ArrayList<Integer> B, int size, int origin)
	{
		int totalGas = 0;
		int count = 0;
		
		for(int i = origin; i < size; i++)
		{
			totalGas += A.get(i);
			if(totalGas >= B.get(i))
			{
				totalGas -= B.get(i);
				count++;
				if(count == size)
					break;
			}
			else
				break;
			if(i == size - 1 && origin != 0)
				i = 0;
			
		}
		if(count == size)
			return origin;
		else
			return -1;
	}

}
