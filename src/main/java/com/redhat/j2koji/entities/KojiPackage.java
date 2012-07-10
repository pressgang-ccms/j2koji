package com.redhat.j2koji.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to hold and access information about a Koji Package.
 * 
 * @author lnewson
 */
public class KojiPackage
{
	private static final String NAME 		= "name";
	private static final String ID 			= "id";
	private static final String PACKAGE_ID 	= "package_id";
	
	private Map<String, Object> internalState = new HashMap<String, Object>();

	public KojiPackage()
	{
		
	}
	
	public String getName()
	{
		return (String) getInternalState().get(NAME);
	}
	
	public void setName(final String name)
	{
		getInternalState().put(NAME, name);
	}
	
	public Integer getId()
	{
		/* When returning a specific package, the id is in the id field */
		if (getInternalState().containsKey(ID))
			return (Integer) getInternalState().get(ID);
		/* When doing a list, the id is in the package_id field */
		return (Integer) getInternalState().get(PACKAGE_ID);
	}
	
	public void setId(final Integer id)
	{
		getInternalState().put(ID, id);
	}
	
	public Map<String, Object> getInternalState()
	{
		return internalState;
	}

	public void setInternalState(final Map<String, Object> internalState)
	{
		this.internalState = internalState;
	}
	
}
