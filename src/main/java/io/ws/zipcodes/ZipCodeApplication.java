/**
 * 
 */
package io.ws.zipcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.ws.zipcodes.exception.ZipcodeException;
import io.ws.zipcodes.model.ZipCode;
import io.ws.zipcodes.service.impl.ZipCodeServiceImpl;

/**
 * ZipCodeApplication process the overlapping zip codes for the input Data Object called ZipRange
 *
 */
public class ZipCodeApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			List<ZipCode> formattedInputZipCodes = formatInputZipCodes(args);
			
			ZipCodeServiceImpl zipCodeService = new ZipCodeServiceImpl();
			
			List<ZipCode> processedZipCodes = zipCodeService.process(formattedInputZipCodes);
			
			printResult(processedZipCodes);
			
		} catch (NumberFormatException | ZipcodeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Formats the zip code inputs and sorts 
	 * @param args
	 * @throws ZipcodeException
	 */
	private static List<ZipCode> formatInputZipCodes(String[] args) throws ZipcodeException {
		if (args == null || args.length == 0) {
			throw new ZipcodeException("No ZipCodes to process, Please try with valid Input !!");
		}else {
			List<ZipCode> formattedInput = new ArrayList<>();
			for (String s : args) {
				String[] str = s.split(",");
				ZipCode zipcodes = new ZipCode(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				formattedInput.add(zipcodes);
			}
			
			// takes O(n logn)
			Collections.sort(formattedInput, (Comparator<? super ZipCode>) (ZipCode r1, ZipCode r2) -> {
				if (r1.getStartZip() != r2.getStartZip())
					return r1.getStartZip() - r2.getStartZip();
				else
					return r1.getEndZip() - r2.getEndZip();
			});
			
			return formattedInput;
		}
	}
	
	
	/**
	 * To display the output of processed zip codes list
	 * @param resultList
	 * @throws ZipcodeException
	 */
	public static void printResult(List<ZipCode> resultList) throws ZipcodeException {

		if (!resultList.isEmpty()) {
			for (ZipCode result : resultList) {
				System.out.println(result.toString());
			}
		} else {
			throw new ZipcodeException("No Result to display, please check Input or Input Format");
		}
	}

}
