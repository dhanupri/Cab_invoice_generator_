import java.sql.SQLException;
import java.util.Scanner;
public class CabService {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Cab Service");
        Cab cab1=new Cab(1,"TN116054");
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
        Ride ride=new Ride(cabid,riderID,riderName,cab1,km,mins);
        CabService_JDBC.insert(ride);
    }
}
