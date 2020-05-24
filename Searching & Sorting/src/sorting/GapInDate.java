package sorting;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GapInDate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		Date date1 = new Date();
        Date date2 = new Date();
        int gap = 0;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
            date1 = (Date) formatter.parse(str1);
            date2 = (Date) formatter.parse(str2);
            while (date1.before(date2)){
            	gap++;
                Calendar c = Calendar.getInstance();
                c.setTime(date1);
                c.add(Calendar.DAY_OF_MONTH, 1);
                date1 = c.getTime();
                System.out.println(date1);
            		
            }
            System.out.println("Gap is : "+ gap);
        }
        catch (Exception e)
        {
        	System.out.println(e);
        }
	}

}
/*
 * 
 * if(P1 == 6 && P2 == 5)
        {
        	if(gap1 > 5)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 6 && P1 == 5)
        {
        	if(gap2 > 5)
        		return -1;
        	else
        		return 1;
        }
        if(P1 == 6 && P2 == 4)
        {
        	if(gap1 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 6 && P1 == 4)
        {
        	if(gap2 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 6 && P2 == 3)
        {
        	if(gap1 > 20)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 6 && P1 == 3)
        {
        	if(gap2 > 20)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 5 && P2 == 4)
        {
        	if(gap1 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 5 && P1 == 4)
        {
        	if(gap2 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 5 && P2 == 3)
        {
        	if(gap1 > 15)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 5 && P1 == 3)
        {
        	if(gap2 > 15)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 4 && P2 == 3)
        {
        	if(gap1 > 5)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 4 && P1 == 3)
        {
        	if(gap2 > 5)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 4 && P2 == 2)
        {
        	if(gap1 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 4 && P1 == 2)
        {
        	if(gap2 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 3 && P2 == 2)
        {
        	if(gap1 > 5)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 3 && P1 == 2)
        {
        	if(gap2 > 5)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 3 && P2 == 1)
        {
        	if(gap1 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 3 && P1 == 1)
        {
        	if(gap2 > 10)
        		return 1;
        	else
        		return -1;
        }
        if(P1 == 2 && P2 == 1)
        {
  
        	if(gap1 > 5)
        		return 1;
        	else
        		return -1;
        }
        if(P2 == 2 && P1 == 1)
        {
        	if(gap2 > 5)
        		return 1;
        	else
        		return -1;
        }  
        else
        	return 0; 
 */
