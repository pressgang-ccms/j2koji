package com.redhat.j2koji.base;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.redhat.j2koji.exceptions.KojiException;
import com.redhat.j2koji.exceptions.XmlExceptionHandler;
import com.redhat.j2koji.rpc.KrbLogIn;
import com.redhat.j2koji.rpc.LogIn;
import com.redhat.j2koji.rpc.LogOut;

/**
 * 
 * @see http://git.fedorahosted.org/git/?p=eclipse-fedorapackager.git;a=tree;f=org.fedoraproject.eclipse.packager.koji;h=775cefecc37cb6ae6e5541d0d3e484c2d79a35a6;hb=HEAD
 */
public class KojiConnector
{
	/**
	 * URL of the Koji Hub/XMLRPC interface
	 */
	protected URL kojiHubUrl = null;
	protected XmlRpcClientConfigImpl xmlRpcConfig = null;
	protected XmlRpcClient xmlRpcClient = null;
	
	/**
	 * Connect to the specified URL.
	 * 
	 * @param kojiHubUrl The koji hub URL.
	 * @throws MalformedURLException If the hub URL was invalid.
	 */
	public void connectTo(final String kojiHubUrl) throws MalformedURLException
	{
		this.kojiHubUrl = new URL(kojiHubUrl);
		setupXmlRpcConfig();
		setupXmlRpcClient();
	}
		
	/**
	 * Store session info in XMLRPC configuration.
	 * 
	 * @param sessionKey
	 * @param sessionID
	 */
	protected void saveSessionInfo(final String sessionKey, final String sessionID)
	{
		try
		{
			xmlRpcConfig.setServerURL(new URL(this.kojiHubUrl.toString()
					+ "?session-key=" + sessionKey
					+ "&session-id=" + sessionID));
		}
		catch (MalformedURLException e)
		{
			// ignore, URL should be valid
		}
	}

	/**
	 * Discard session info previously stored in server URL via
	 * {@link KojiConnector#saveSessionInfo(String, String)}.
	 */
	protected void discardSession()
	{
		xmlRpcConfig.setServerURL(this.kojiHubUrl);
	}

	/**
	 * Login to the Koji Build Server using basic Username/Password authentication.
	 * Logging in is only required when uploading build requests, etc to the server.
	 * 
	 * (Note: Untested function)
	 * 
	 * @param username The username that identifies the user to be logged in.
	 * @param password The password that identifies the user to be logged in.
	 * @throws KojiException If the XML-RPC library returns a fault, a {@link KojiException}
	 * with a descriptive error message for that fault will be thrown.
	 */
	public void login(final String username, final char[] password) throws KojiException
	{
		final LogIn login = new LogIn(username, password);
		this.executeMethod(login);
		saveSessionInfo(login.getSessionKey(), login.getSessionId().toString());
	}
	
	/**
	 * Login to the Koji Build Server using kerberos. Logging
	 * in is only required when uploading build requests, etc to the server.
	 * 
	 * (Note: Untested function)
	 * 
	 * @param krbTicket The base64 encoded value for a kerberos ticket.
	 * @throws KojiException If the XML-RPC library returns a fault, a {@link KojiException}
	 * with a descriptive error message for that fault will be thrown.
	 */
	public void krbLogin(final String krbTicket) throws KojiException
	{
		final KrbLogIn login = new KrbLogIn(krbTicket);
		this.executeMethod(login);
		saveSessionInfo(login.getSessionKey(), login.getSessionId().toString());
	}
	
	/**
	 * Login to the Koji Build Server using kerberos. Logging
	 * in is only required when uploading build requests, etc to the server.
	 * 
	 * (Note: Untested function)
	 * 
	 * @param krbTicket The base64 encoded value for a kerberos ticket.
	 * @param proxyUser A kerberos principal to use when logging in instead of the principal
	 * in the ticket.
	 * @throws KojiException If the XML-RPC library returns a fault, a {@link KojiException}
	 * with a descriptive error message for that fault will be thrown.
	 */
	public void krbLogin(final String krbTicket, final String proxyUser) throws KojiException
	{
		final KrbLogIn login = new KrbLogIn(krbTicket, proxyUser);
		this.executeMethod(login);
		saveSessionInfo(login.getSessionKey(), login.getSessionId().toString());
	}

	/**
	 * Logout of the koji build server. 
	 * 
	 * @throws KojiException If the XML-RPC library returns a fault, a {@link KojiException}
	 * with a descriptive error message for that fault will be thrown.
	 */
	public void logout() throws KojiException
	{
		final LogOut logout = new LogOut();
		this.executeMethod(logout);
		discardSession();
	}
	
	/**
	 * Configure XMLRPC connection
	 */
	protected void setupXmlRpcConfig()
	{
		xmlRpcConfig = new XmlRpcClientConfigImpl();
		xmlRpcConfig.setServerURL(this.kojiHubUrl);
		xmlRpcConfig.setEnabledForExtensions(true);
		xmlRpcConfig.setConnectionTimeout(30000);
	}
	
	/**
	 * Set up XMLRPC client.
	 * 
	 * @throws IllegalStateException If XMLRPC configuration hasn't been
	 *         properly set up.
	 */
	protected void setupXmlRpcClient() throws IllegalStateException
	{
		if (xmlRpcConfig == null)
		{
			throw new IllegalStateException("XMLRPCConfig Not Initialized!");
		}
		xmlRpcClient = new XmlRpcClient();
		xmlRpcClient.setTypeFactory(new KojiTypeFactory(this.xmlRpcClient));
		xmlRpcClient.setConfig(this.xmlRpcConfig);
	}
	
	/**
	 * Allows the API to execute any properly encoded XML-RPC method.
	 * If the method completes properly, the {@link KojiMethod#setResultMap(Map)}
	 * method will be called, and the implementation class will provide
	 * methods to access any data returned. 
	 * 
	 * @param method A {@link KojiMethod} to call on the connected installation
	 * @throws KojiException If the XML-RPC library returns a fault, a {@link KojiException}
	 * with a descriptive error message for that fault will be thrown.
	 */
	public void executeMethod(final KojiMethod method) throws KojiException
	{
		if(xmlRpcClient == null)
		{
			//We are not currently connected to an installation
			throw new IllegalStateException("Cannot execute a method without connecting!");
		}
		
		final Object[] obj = method.getParameters();
		try
		{
			final Object results = xmlRpcClient.execute(method.getMethodName(), obj);
			method.setResultMap(results);
		}
		catch (XmlRpcException e)
		{
			KojiException wrapperException = XmlExceptionHandler.handleFault(e);
			throw wrapperException;
		}
	}
}
