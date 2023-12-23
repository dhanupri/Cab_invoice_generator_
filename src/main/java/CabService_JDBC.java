import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
public class CabService_JDBC {
    public Ride ride;
    //insert into cab details;
    public static void insertCab_details(Cab cab){
        Connection connection=null;
        try {
            connection = Sql_connection.getCon();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cab_details VALUES(?,?)");
            ps.setInt(1, cab.getCabID());
            ps.setString(2, cab.getCabNumber());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //insert into rider_details table
    public static Object insert(Ride ride) throws SQLException {
        final int perkm=10;
        final int permin=1;
        Connection connection=null;
        try {
            connection=Sql_connection.getCon();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO rider_detail1 VALUES(?,?,?,?,?,?)");
            ps.setInt(1, ride.getCabId());
            ps.setInt(2, ride.getRiderID());
            ps.setString(3, ride.getRiderName());
            ps.setInt(4, ride.getKm());
            ps.setString(5, ride.getTime());
            //calculate total fare per ride
            int total = (ride.getKm() * perkm) + (Integer.parseInt(ride.getTime()) * permin);
            if (total < 5) {
                ps.setInt(6, 5);
                System.out.println("The total amount :" + "5");
                total=5;
            } else {
                ps.setInt(6, total);
                System.out.println("The total amount :" + total);

            }
           ps.executeUpdate();
            return total;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
    //multiple rides and aggregate total
    public static double total_amout(){
        Connection connection=null;
        double total=0.0;
        try{
            connection=Sql_connection.getCon();
            PreparedStatement ps = connection.prepareStatement("SELECT AVG(total_fare) AS average_fare FROM rider_detail1");
            ResultSet resultSet=ps.executeQuery();
            if(resultSet.next()){
                total+=resultSet.getDouble("average_fare");
            }
            return  total;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
