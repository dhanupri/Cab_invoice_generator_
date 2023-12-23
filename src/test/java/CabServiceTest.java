import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class CabServiceTest {
    //calculate totalfare
    @Test
    public void testGenerateInvoice() throws SQLException {
        Cab cab=new Cab(1,"tn1234");
        Ride ride=new Ride(1,11,"aishu",1,"1");
        Assert.assertEquals(11,CabService_JDBC.insert(ride));
    }
    //uc2 aggregate total
    @Test
    public void testTotal(){
        Assert.assertEquals(532.0,CabService_JDBC.total_amout(),0.001);
    }
    //uc3 total number of rides
    @Test
    public void TotalRideTest(){
        Assert.assertEquals(9,CabService_JDBC.Total_number_of_Ride());
    }
    //uc3 total number of ride,total fare,average per ride
    @Test
    public void EnhancedInvoice(){
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(6);
        arr1.add(122);
        arr1.add(20);
        Assert.assertEquals(arr1,CabService_JDBC.Enhanced_Invoice(1));
    }
}
