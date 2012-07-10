package com.redhat.j2koji.entities;

import java.util.HashMap;
import java.util.Map;

import com.redhat.j2koji.enums.KojiUserStatus;
import com.redhat.j2koji.enums.KojiUserType;

/**
 * A class to hold and access information about a Koji User.
 * 
 * @author lnewson
 */
public class KojiUser
{
	private static final String NAME 		= "name";
	private static final String ID 			= "id";
	private static final String STATUS 		= "status";
	private static final String USERTYPE 	= "usertype";
	private static final String KRB_PRINCIPAL	= "krb_principal";
	
	private Map<String, Object> internalState = new HashMap<String, Object>();
	
	public KojiUser()
	{
		
	}
	
	/**
	 * Get the id of the user.
	 * 
	 * @return The users id.
	 */
	public Integer getId()
	{
		return (Integer) getInternalState().get(ID);
	}
	
	/**
	 * Set the id for the user.
	 * 
	 * @param id The integer value for the users id.
	 */
	public void setId(final Integer id)
	{
		getInternalState().put(ID, id);
	}
	
	/**
	 * Get the username for the user.
	 * 
	 * @return The username for the user.
	 */
	public String getName()
	{
		return (String) getInternalState().get(NAME);
	}
	
	/**
	 * Set the username for the user.
	 * 
	 * @param name The username of the user.
	 */
	public void setName(final String name)
	{
		getInternalState().put(NAME, name);
	}
	
	/**
	 * Get the status of the user.
	 * 
	 * 0 - NORMAL
	 * 1 - BLOCKED
	 * 
	 * @return The integer value for the status of the user.
	 */
	public KojiUserStatus getStatus()
	{
		return KojiUserStatus.get((Integer) getInternalState().get(STATUS));
	}
	
	/**
	 * Set the status of the user.
	 * 
	 * 0 - NORMAL
	 * 1 - BLOCKED
	 * 
	 * @param status The integer value for the status of the user.
	 */
	public void setStatus(final KojiUserStatus status)
	{
		getInternalState().put(STATUS, status.getValue());
	}
	
	/**
	 * Get the usertype for the user.
	 * 
	 * 0 - NORMAL
	 * 1 - HOST
	 * 2 - GROUP
	 * 
	 * @return The usertype for the user.
	 */
	public KojiUserType getUserType()
	{
		return KojiUserType.get((Integer) getInternalState().get(USERTYPE));
	}
	
	/**
	 * Set the usertype for the user.
	 * 
	 * 0 - NORMAL
	 * 1 - HOST
	 * 2 - GROUP
	 * 
	 * @param userType The usertype for the user.
	 */
	public void setUserType(final KojiUserType userType)
	{
		getInternalState().put(USERTYPE, userType.getValue());
	}
	
	/**
	 * Get the Kerberos Principal for the user if the koji
	 * build server is set-up to use kerberos.
	 * 
	 * @return The kerberos principal for the user.
	 */
	public String getKrbPrincipal()
	{
		return (String) getInternalState().get(KRB_PRINCIPAL);
	}
	
	/**
	 * Set the Kerberos Principal for the use. This is only used if 
	 * the koji build server is set-up to use kerberos.
	 * 
	 * param krbPrincipal The kerberos principal for the user.
	 */
	public void setKrbPrincipal(final String krbPrincipal)
	{
		getInternalState().put(KRB_PRINCIPAL, krbPrincipal);
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
