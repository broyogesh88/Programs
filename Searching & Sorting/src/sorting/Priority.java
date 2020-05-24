package sorting;
import java.text.SimpleDateFormat;
import java.util.*;

public class Priority {

    public static void main(String[] args)
    {

        Priority O = new Priority();
        List<Booking> List = new ArrayList<Booking>();
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 6; i++)
        {
        	Booking B = new Booking();
        	B.setBookingId(i);
        	String type = sc.nextLine();
        	B.setType(type);
        	String date = sc.nextLine();
        	B.setBookingDate(date);
        	List.add(B);
        	
        }
        System.out.println("Enter Sort By : ");
        int type = sc.nextInt();
        ArrayList<Booking> newList = O.priorTize(11, List, type);
        
        List.clear();
        for(Booking B : newList)
        	System.out.println(B + "\n");
    }

    public ArrayList<Booking> priorTize(int capacity, List<Booking> List, int type)
    {
    	PriorityQueue<Booking> PQueue, PQueue1, PQueue2, PQueue3;
    	ArrayList<Booking> newList = new ArrayList<Booking>();
 
    	if(type == 1)
    	{
    		PQueue = new PriorityQueue<Booking>(capacity, new SortByUserType());
            for (Booking B : List)
            {
                PQueue.add(B);
            }
            
    	}
    	else if(type == 2)
    	{
    		PQueue = new PriorityQueue<Booking>(capacity, new SortByBookingDate());
            for(Booking B: List)
            	PQueue.add(B);
            
    	}
    		
    	else
    	{
    		PQueue1 = new PriorityQueue<Booking>(capacity, new SortByBookingDate());
    		PQueue2 = new PriorityQueue<Booking>(capacity, new SortByBookingDate());
    		PQueue3 = new PriorityQueue<Booking>(capacity, new SortByBookingDate());
    		
    		for (Booking B : List)
            {
    			if(B.getType().equals("d") || B.getType().equals("r"))
                	PQueue1.add(B);
    			else if(B.getType().equals("f") || B.getType().equals("n") || B.getType().equals("c"))
    				PQueue2.add(B);
    			else
    				PQueue3.add(B);
            }
    		while (!PQueue1.isEmpty())
            { 
    			newList.add(PQueue1.poll()); 
            }
    		while (!PQueue2.isEmpty())
            { 
    			newList.add(PQueue2.poll()); 
            }
    		while (!PQueue3.isEmpty())
            { 
    			newList.add(PQueue3.poll()); 
            }
    		
    	}  	
    	return newList;

    }


}


class SortByUserType implements Comparator<Booking> {


    @Override
    public int compare(Booking b1, Booking b2) {

        String type1 = b1.getType();
        String type2 = b2.getType();
        int P1, P2;
        if(type1.equals("d"))
        	P1 = 6;
        else if(type1.equals("r"))
        	P1 = 5;
        else if(type1.equals("f"))
        	P1 = 4;
        else if(type1.equals("n"))
        	P1 = 3;
        else if(type1.equals("c")) 
        	P1 = 2;
        else
        	P1 = 1;
        
        if(type2.equals("d"))
        	P2 = 6;
        else if(type2.equals("r"))
        	P2 = 5;
        else if(type2.equals("f"))
        	P2 = 4;
        else if(type2.equals("n"))
        	P2 = 3;
        else if(type2.equals("c")) 
        	P2 = 2;
        else
        	P2 = 1;
        
        
        if(P1 < P2)
        {
        	return 1;
        }
        else if(P1 > P2)
        {
        	return -1;
        }
        
        return 0;
    }
  
}

class SortByBookingDate implements Comparator<Booking> {


    @Override
    public int compare(Booking b1, Booking b2) {

    
        
        String d1 = b1.getBookingDate();
        String d2 = b2.getBookingDate();
        Date date1 = new Date();
        Date date2 = new Date();
        
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
            date1 = (Date) formatter.parse(d1);
            date2 = (Date) formatter.parse(d2);
            
            if(date2.before(date1))
            {
            	return 1;
            }
            else if(date1.before(date2))
            {
            	return -1;
            }
            return 0;
      
            
        }
        catch (Exception e)
        {
        	System.out.println("Error : " + e);
        }
        
        
        return 0;
    }
  
}
