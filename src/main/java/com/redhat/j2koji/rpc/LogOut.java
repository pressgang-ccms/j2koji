package com.redhat.j2koji.rpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;

/**
 * A Koji Method to send to XML-RPC to log the current logged in user out.
 * 
 * @author lnewson
 */
public class LogOut implements KojiMethod
{
	/**
	 * The method Koji will execute via XML-RPC
	 */
	private static final String METHOD_NAME = "logout";

	private List<Object> params = new ArrayList<Object>();
	@SuppressWarnings("unused")
	private Map<Object, Object> hash = new HashMap<Object, Object>();
	
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
}
