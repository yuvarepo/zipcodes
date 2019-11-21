/**
 * 
 */
package io.ws.zipcodes.service;

import java.util.List;

import io.ws.zipcodes.model.ZipCode;

/**
 * ZipcodeService interface for process zip codes
 */
public interface ZipCodeService extends GenericService<ZipCode> {
	public List<ZipCode> process(List<ZipCode> zipCode) ;
}
