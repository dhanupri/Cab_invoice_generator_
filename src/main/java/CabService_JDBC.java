import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
            PreparedStatement ps = connection.prepareStatement("SELECT SUM(total_fare) AS total FROM rider_detail1");
            ResultSet resultSet=ps.executeQuery();
            if(resultSet.next()){
                total+=resultSet.getDouble("total");
            }
            return  total;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int Total_number_of_Ride(){
        Connection connection=null;
        try{
            connection=Sql_connection.getCon();
            PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS row_count FROM rider_detail1 ");
            ResultSet resultSet=ps.executeQuery();
            int rowcount = 0;
            if(resultSet.next()) {
                rowcount = resultSet.getInt("row_count");
                System.out.println("the total number of rides:" + rowcount);
            }
            return rowcount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Integer> Enhanced_Invoice(int cabId){
        ArrayList<Integer> arr=new ArrayList<>();
        Connection connection=null;
        try{
            connection=Sql_connection.getCon();
            PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS row_count FROM rider_detail1 where cab_id=? ");
            ps.setInt(1, cabId);
            ResultSet resultSet=ps.executeQuery();
            int ride=0;
            if (resultSet.next()){
                ride=resultSet.getInt("row_count");
            }
            arr.add(ride);
            System.out.println("total number of ride bu cab"+cabId+"is:"+ride);
            PreparedStatement ps1=connection.prepareStatement("SELECT total_fare from rider_detail1 where cab_id=? ");
            ps1.setInt(1, cabId);
            int totalFare=0;
            ResultSet resultSet1=ps1.executeQuery();
            if (resultSet1.next()){
                totalFare+=resultSet1.getInt("total_fare");
            }
            arr.add(totalFare);
            System.out.println("total fare for cab"+cabId+" is:"+totalFare);
            arr.add(totalFare/ride);
            System.out.println("average fare per ride for cab"+cabId+" is:"+totalFare/ride);
            return arr;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
