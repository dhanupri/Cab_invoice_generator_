import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class CabServiceTest {
    //calculate totalfare
    @Test
    public void testGenerateInvoice() throws SQLException {
        Cab cab=new Cab(1,"tn1234");
        Ride ride=new Ride(1,11,"aishu",cab,1,"1");
        Assert.assertEquals(11,CabService_JDBC.insert(ride));
    }
}
