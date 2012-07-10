package com.redhat.j2koji.exceptions;

/**
 * A {@code KojiException} indicates that Koji has returned a fault rather 
 * than the expected return value for a method. It wraps the 
 * {@link org.apache.xmlrpc.XmlRpcException XmlRpcException} which caused the error.
 * @author Tom
 *
 */
public class KojiException extends Exception
{
	private static final long serialVersionUID = -5427986526722263296L;

	/**
	 * Constructs a new {@link KojiException} with the specified summary and cause.
	 * @param message A customized error message describing the issue
	 * @param cause The nested cause, typically a {@link org.apache.xmlrpc.XmlRpcException XmlRpcException}.
	 */
	public KojiException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * Constructs a new {@link KojiException} with the specified summary
	 * @param message A short, descriptive message of the error
	 */
	public KojiException(final String message)
	{
		super(message);
	}
}
