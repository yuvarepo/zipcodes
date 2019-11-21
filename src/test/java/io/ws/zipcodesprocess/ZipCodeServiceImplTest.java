package io.ws.zipcodesprocess;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.ws.zipcodes.exception.ZipcodeException;
import io.ws.zipcodes.model.ZipCode;
import io.ws.zipcodes.service.impl.ZipCodeServiceImpl;

public class ZipCodeServiceImplTest {

	/**
	 * Asserts input with expected output(hardcoded)
	 * @throws ZipcodeException
	 */
	@Test
	public void testWithInput1() throws ZipcodeException {
			
		List<ZipCode> input = new ArrayList<ZipCode>();	
		List<ZipCode> output = new ArrayList<ZipCode>();
		
		input.add(new ZipCode(94133, 94133));
		input.add(new ZipCode(94200, 94299));
		input.add(new ZipCode(94600, 94699));
		
		output.addAll(input);
		ZipCodeServiceImpl zipCodeService = new ZipCodeServiceImpl();
		assertThat(zipCodeService.process(input), is(equalTo(output)));
	}

	/**
	 * Asserts input with expected output(hardcoded)
	 * @throws ZipcodeException
	 */
	@Test
	public void testWithInput2() throws ZipcodeException {
		List<ZipCode> input  = new ArrayList<ZipCode>();	
		List<ZipCode> output = new ArrayList<ZipCode>();
		
		input.add(new ZipCode(94133, 94133));
		input.add(new ZipCode(94200, 94299));
		input.add(new ZipCode(94226, 94399));
		
		output.add(new ZipCode(94133, 94133));
		output.add(new ZipCode(94200, 94399));
		ZipCodeServiceImpl zipCodeService = new ZipCodeServiceImpl();
		assertThat(zipCodeService.process(input), is(equalTo(output)));
	}
}