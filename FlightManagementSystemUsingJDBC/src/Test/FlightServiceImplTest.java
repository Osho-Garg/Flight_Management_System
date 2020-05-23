package Test;
/**
 * @author  ramesh
 * Test Package to perform Junit Testing for Flight
 * Using Junit5
 */

import com.capgemini.entities.Flight;
import com.capgemini.service.Impli.IFlightServiceImpl;
import com.capgemini.service.Interface.IFlightService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightServiceImplTest {

	IFlightService service;

	/**
	 * Initialization of Testing Process Declaration of aetup method
	 */
	// Initialization Method for Testing Process
	@Before
	public void setup() {
		// Declaration of Object
		service = new IFlightServiceImpl();

	}

	/**
	 * Creating Test for addFlight method
	 */
	@Test
	public void testaddFlight() {
		// setting Local Object of Flight type
		// To Perform Assert Operations for Test
		Flight flight1 = new Flight();
		flight1.setFlightNumber(96356);
		flight1.setFlightModel("s12");
		flight1.setCarrierName("Indigo");
		flight1.setSeatCapacity(100);
		// Checking Output of the method addFlight()
		Assert.assertEquals(flight1, service.addFlight(flight1));

	}

	/**
	 * Creating Test for modifyFlight method
	 */
	@Test
	public void testmodifyFlight() {
		// setting Local Object of Flight type
		// To Perform Assert Operations for Test
		Flight flight2 = new Flight();
		flight2.setFlightNumber(96356);
		flight2.setFlightModel("s13");
		flight2.setCarrierName("spicejet");
		flight2.setSeatCapacity(200);
		// Checking Output of the method modifyFlight()
		Assert.assertNotNull(service.modifyFlight(flight2));

	}

	/**
	 * Creating Test for ViewFlight method
	 */
	@Test
	public void testViewFlight() {
		// Checking Output of the method ViewFlight()
		Assert.assertNotNull(service.viewFlight(96356));
	}

}
