package Test;
import com.capgemini.service.Impli.AirportServiceImpl;
import com.capgemini.service.Interface.IAirportService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirportTest {
    static IAirportService Service;

    @Before
    public void setUp() {
        Service = new AirportServiceImpl();
    }

    @Test
    public void testviewAirportString() {
      /*  source=new Airport();
        source.setAirportCode("LKO");
        source.setAirportLocation("Lucknow");
        source.setAirportName("Chaudhary Charan Singh International Airport");
        dest=new Airport();
        dest.setAirportCode("MUM");
        dest.setAirportLocation("Mumbai");
        dest.setAirportName("Chhatrapati Shivaji International Airport");*/
        //Assert.assertEquals(source,Service.viewAirport("LKO"));
        Assert.assertNotNull(Service.viewAirport("LKO"));
    }
}

