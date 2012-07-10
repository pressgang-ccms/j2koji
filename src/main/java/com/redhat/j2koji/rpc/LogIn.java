package com.redhat.j2koji.rpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;

public class LogIn implements KojiMethod
{
	/**
	 * The method Koji will execute via XML-RPC
	 */
	private static final String METHOD_NAME = "login";

	private List<Object> params = new ArrayList<Object>();
	private Map<Object, Object> hash = new HashMap<Object, Object>();
	
	/**
	 * Constructor
	 * 
	 * @param username The username of the user to be logged in.
	 * @param password The password of the user to be logged in.
	 */
	public LogIn(final String username, final char[] password)
	{
		params.add(username);
		params.add(password);
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
