package com.redhat.j2koji.base;

public interface KojiMethod
{
	/**
	 * Allows the {@link KojiConnector} to set the returned <code>Object</code> for
	 * this {@link KojiMethod} so that its implementation can provide access
	 * to any returned data from the webservice
	 * 
	 * @param hash
	 */
	void setResultMap(Object hash);

	/**
	 * Allows the {@link KojiConnector} to access this
	 * {@link KojiMethod}'s parameters in a form that can be passed to the
	 * Koji webservice over XML-RPC
	 * 
	 * @return An array of <code>Objects</code> required as parameters for
	 *         the Koji webservice method
	 */
	Object[] getParameters();

	/**
	 * Allows the {@link KojiConnector} to access this
	 * {@link KojiMethod}'s name to pass in the XML-RPC request along with
	 * the parameters
	 * 
	 * @return A <code>String</code> representing the appropriate webservice
	 *         method to call on the Koji installation
	 */
	String getMethodName();
}
