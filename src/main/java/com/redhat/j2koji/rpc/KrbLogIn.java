package com.redhat.j2koji.rpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;

/**
 * A Koji Method to login using kerberos. This is done by sending the local
 * Kerberos Ticket as a Base64 encoded string. See the krbLogin method in
 * {@link http://git.fedorahosted.org/git/?p=koji;a=blob;f=koji/auth.py;h=e1a9c46ef8745a06fa87fe45dfa5bea5db2bb482;hb=HEAD}
 * for more information.
 * 
 * @author lnewson
 *
 */
public class KrbLogIn implements KojiMethod
{
	/**
	 * The method Koji will execute via XML-RPC
	 */
	private static final String METHOD_NAME = "krbLogin";

	private List<Object> params = new ArrayList<Object>();
	private Map<Object, Object> hash = new HashMap<Object, Object>();
	
	/**
	 * Constructor to create a new krbLogin method
	 * to send to the koji hub server.
	 * 
	 * @param krbTicket A Base64 encoded string for the
	 * kerberos ticket.
	 */
	public KrbLogIn(final String krbTicket)
	{
		params.add(krbTicket);
	}
	
	/**
	 * Constructor to create a new krbLogin method
	 * to send to the koji hub server.
	 * 
	 * @param krbTicket A Base64 encoded string for the
	 * kerberos ticket.
	 */
	public KrbLogIn(final String krbTicket, final String proxyUser)
	{
		params.add(krbTicket);
		params.add(proxyUser);
	}
	
	@SuppressWarnings("unchecked")
	public void setResultMap(final Object hash)
	{
		this.hash = (Map<Object, Object>)hash;
	}

	public Object[] getParameters()
	{
		return params.toArray();
	}

	public String getMethodName()
	{
		return METHOD_NAME;
	}

	/**
	 * Get the session key from the response variables.
	 * 
	 * @return The session key or null if the method hasn't been executed or failed.
	 */
	public String getSessionKey()
	{
		if (hash.containsKey("session-key"))
		{
			return (String) hash.get("session-key");
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Get the session id from the response variables.
	 * 
	 * @return The session id or null if the method hasn't been executed or failed.
	 */
	public Integer getSessionId()
	{
		if (hash.containsKey("session-id"))
		{
			Integer i = (Integer) hash.get("session-id");
			return i.intValue();
		}
		else
		{
			return null;
		}
	}
}
