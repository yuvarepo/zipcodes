package io.ws.zipcodesprocess;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import io.ws.zipcodes.exception.ZipcodeException;
import io.ws.zipcodes.model.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ZipCodeApplicationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	  @Test(expected = ZipcodeException.class) 
	  public void testValidateRange() throws ZipcodeException {
	  
	  new ZipCode(90, 12354); // not a 5-digit code 
	  new ZipCode(654321, 123456);// not a 5-digit code 
	  new ZipCode(90564, 12354); // startZip > endZip
	  
	  thrown.expectMessage("Validation Failed :: [90564, 12354] is not in valid Zipcode Range!"); 
	  thrown.expectMessage("Validation Failed :: 90 is not in valid 5-digit Zipcode Range!"); 
	  thrown.expectMessage("Validation Failed :: 654321 is not in valid 5-digit Zipcode Range!");
	  
	  }
	 

	@Test
	public void testConstructorBounds() throws ZipcodeException {
		ZipCode range = new ZipCode(90804, 95747);

		assertThat(range.getStartZip(), is(equalTo(90804)));
		assertThat(range.getEndZip(), is(equalTo(95747)));
	}

	
	  @Test public void testSetBounds() throws ZipcodeException {
	  thrown.expect(ZipcodeException.class);
	  
	  ZipCode range = new ZipCode(0, 123456);
	  thrown.expect(ZipcodeException.class);
	  
	  thrown.expectMessage("Validation Failed :: 0 is not in valid 5-digit Zipcode Range!");
	  range.setStartZip(45); range.setEndZip(145632); 
	  
	  }
	 

	@Test
	public void testEquals() throws ZipcodeException {
		ZipCode range1 = new ZipCode(90804, 95747);
		ZipCode range2 = new ZipCode(90815, 95677);
		ZipCode range3 = new ZipCode(90815, 95677);

		assertThat(range1, is(equalTo(range1)));
		assertThat(range2, is(not(equalTo(range1))));
		assertThat(range2, is(equalTo(range3)));
		assertThat(range3, is(not(equalTo(range1))));

		assertThat(range2, is(equalTo(range2)));
		assertThat(range2, is(not(equalTo(range1))));
		assertThat(range1, is(not(equalTo(range2))));
		assertThat(range3, is(not(equalTo(range1))));

	}

	@Test
	public void testHashCode() throws ZipcodeException {

		ZipCode range1 = new ZipCode(90804, 95747);
		ZipCode range2 = new ZipCode(90815, 95677);

		assertThat(range1.hashCode(), is(equalTo(range1.hashCode())));
		assertThat(range2.hashCode(), is(equalTo(range2.hashCode())));
	}

	@Test
	public void testToString() throws ZipcodeException {
		ZipCode range1 = new ZipCode(90804, 95747);
		ZipCode range2 = new ZipCode(90815, 95677);

		assertThat(range1.toString(), is(equalTo("[90804,95747]")));
		assertThat(range2.toString(), is(equalTo("[90815,95677]")));
	}
}