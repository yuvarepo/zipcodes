package io.ws.zipcodes.service.impl;

import java.util.ArrayList;
import java.util.List;

import io.ws.zipcodes.exception.ZipcodeException;
import io.ws.zipcodes.model.ZipCode;
import io.ws.zipcodes.service.ZipCodeService;

/**
 * This Service implements the process of Data Object called ZipRange to remove overlapping zipcodes
 */
public class ZipCodeServiceImpl implements ZipCodeService {

	/**
	 * Input List is list of Objects, goal of this method is to
	 * produce minimum number of ranges required to represent the same ranges
	 * from the input. Input Ranges may vary, can or cannot overlap but output
	 * has to be merged to minimum count of ranges
	 * 
	 * @param ranges
	 * @return a list of merged ranges for given Zip Code Objects
	 * @throws ZipcodeException
	 */
	
	@Override
	public List<ZipCode> process(List<ZipCode> ranges) {
		List<ZipCode> result = new ArrayList<>();

		// merging would take O(n)
		ZipCode prev = ranges.get(0);
		try {
		for (int i = 0; i < ranges.size(); i++) {
			ZipCode curr = ranges.get(i);
			if (curr.getStartZip() > prev.getEndZip()) {
				result.add(prev);
				prev = curr;
			} else {
				ZipCode merged;
				merged = new ZipCode(prev.getStartZip(), Math.max(prev.getEndZip(), curr.getEndZip()));
				prev = merged;
			}
		}
		} catch (ZipcodeException e) {
			e.getMessage();
		}
		result.add(prev);

		// total complexity would be, T(n) = O (n logn)
		return result;
	}



}