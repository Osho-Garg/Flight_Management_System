package Test;

import com.capgemini.entities.Booking;
import com.capgemini.service.Impli.BookingServiceImpl;
import com.capgemini.service.Interface.IBookingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookingTest {



    /**
     *
     * @author ramesh
     * Testing Booking Service Implementation
    */
        IBookingService service;
        @Before
        public void setup()
        {
            service=new BookingServiceImpl();
        }
        @Test
        public void testAddBooking()
        {
            Booking b=new Booking();
            b.setBookingId(4001);
            b.setUserId(1001);
            b.setDate("22-jan-2020");
            b.setTicketCost(55000);
            b.setNoOfPassengers(420);
            Assert.assertEquals(b, service.addBooking(b));
        }
        @Test
        public void testViewBooking()
        {
            Assert.assertNotNull(service.viewBooking(123));
        }
        @Test
        public void testModifyBooking()
        {
            Booking b=new Booking();
            b.setBookingId(1002);
            b.setDate("22-JAN-2020");
            b.setTicketCost(2000);
            b.setNoOfPassengers(120);
            Assert.assertNotNull(service.modifyBooking(b));
        }
    }
