package sorting;
import java.util.Date;


public class Booking
{
    private int bookingId;
    private int noOfRooms;
    public  String bookingDate;
    private String checkInDate;
    private String checkOutDate;
    private boolean foodServices;
    private String bookingStatus;
    private String userId;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBookingId(){
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isFoodServices() {
        return foodServices;
    }

    public void setFoodServices(boolean foodServices) {
        this.foodServices = foodServices;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    public float calculatePrice()
    {
        int totalRooms = getNoOfRooms();
        return 250 * totalRooms;
    }


    public String toString()
    {
    	return String.format("Booking Id : " + bookingId + "\nBooking Date : " + bookingDate + "\nUser Type : " + type);
    	//return String.format(type);
    }
    
 


}
