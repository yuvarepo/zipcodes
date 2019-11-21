/**
 * 
 */
package io.ws.zipcodes.service;

import java.util.List;

/**
 * Generic service
 * @param <T>
 */
public interface GenericService<T> {
	public List<T> process(List<T> codes);
}
