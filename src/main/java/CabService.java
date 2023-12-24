import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class CabService {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Cab Service");
        System.out.println("Enter type of cab service normal/premium");
        String type=sc.nextLine();
        if (type.toLowerCase().equals("normal")) {
            System.out.println("Enter the cab id");
            int cabid = sc.nextInt();
            System.out.println("Enter Rider ID");
            int riderID = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Rider Name");
            String riderName = sc.nextLine();
            System.out.println("Enter km");
            int km = sc.nextInt();
            System.out.println("Enter minutes");
            String mins = sc.next();
            Ride ride = new Ride(cabid, riderID, riderName, km, mins);
            CabService_JDBC.insert(ride);
            System.out.println("multiple rides and aggregate total" + CabService_JDBC.total_amout());
            CabService_JDBC.Total_number_of_Ride();
            System.out.println("enter the cabId: ");
            int cabId = sc.nextInt();
            ArrayList<Integer> arr1 = CabService_JDBC.Enhanced_Invoice(cabId);
            CabService_JDBC.DisplayRide(cabId);
        }
        else if (type.toLowerCase().equals("premium")){
            System.out.println("Enter the cab id");
            int cabid = sc.nextInt();
            System.out.println("Enter Rider ID");
            int riderID = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Rider Name");
            String riderName = sc.nextLine();
            System.out.println("Enter km");
            int km = sc.nextInt();
            System.out.println("Enter minutes");
            String mins = sc.next();
            Premium_ride ride1 = new Premium_ride(cabid, riderID, riderName, km, mins);
            CabService_JDBC.insert_premium_ride(ride1);
            System.out.println("multiple rides and aggregate total" + CabService_JDBC.Totalof_Premium_Ride());
            System.out.println("enter the cabId: ");
            int cabId = sc.nextInt();
            ArrayList<Integer> arr1 = CabService_JDBC.Enhanced_Invoice_premiumRide(cabId);
            CabService_JDBC.DisplayPremiumRide(cabId);

        }
    }
}
