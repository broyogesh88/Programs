package sorting;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class RegexDemo {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Bits object = new Bits();
		
		while(true)
		{
			System.out.print("Enter Pattern : ");
			String str1 = sc.next();
			System.out.print("Enter String : ");
			String str2 = sc.next();
			
			Pattern p = Pattern.compile(str1);
			Matcher m = p.matcher(str2);
			int count = 0;
			ArrayList<Integer> list = new ArrayList<>();
			while(m.find())
			{
				list.add(m.start());
				count++;
			}
			System.out.println("\nNo. of times " + str1 + " appears in " + str2 + " = " + count);
			System.out.print("\nIt appears in indexes : ");
			for(int i = 0; i < list.size(); i++)
			{	
				System.out.print(list.get(i));
				if(i != list.size() - 1)
					System.out.print(", ");
			}
			
			System.out.println("\n\nPress 1 to continue 2 to exit.");
			if(sc.nextInt() == 1)
				continue;
			else
				break;
			
		}

	}

}
