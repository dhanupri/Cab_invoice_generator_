import java.sql.SQLException;
import java.util.Scanner;
public class CabService {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Cab Service");
        System.out.println("Enter the cab id");
        int cabid=sc.nextInt();
        System.out.println("Enter Rider ID");
        int riderID=sc.nextInt();
        System.out.println("Enter Rider Name");
        sc.next();
        String riderName=sc.nextLine();
        System.out.println("Enter km");
        int km=sc.nextInt();
        System.out.println("Enter minutes");
        String mins=sc.next();
        Ride ride=new Ride(cabid,riderID,riderName,km,mins);
        CabService_JDBC.insert(ride);
        System.out.println("multiple rides and aggregate total"+CabService_JDBC.total_amout());
    }
}
