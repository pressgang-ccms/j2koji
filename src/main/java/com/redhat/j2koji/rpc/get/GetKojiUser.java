package com.redhat.j2koji.rpc.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;
import com.redhat.j2koji.entities.KojiUser;
import com.redhat.j2koji.factory.KojiUserFactory;

public class GetKojiUser implements KojiMethod
{
	/**
	 * The method name for this {@link KojiMethod}
	 */
	private static final String GET_USER = "getUser";

	private Map<Object, Object> hash = new HashMap<Object, Object>();
	private List<Object> params = new ArrayList<Object>();
	
	public GetKojiUser(final Integer userId)
	{
		params.add(userId);
	}
	
	public GetKojiUser(final String krbPrincipal)
	{
		params.add(krbPrincipal);
	}
	
	@SuppressWarnings("unchecked")
	public void setResultMap(final Object hash)
	{
		this.hash = (Map<Object, Object>) hash;
	}

	public Object[] getParameters()
	{
		return params.toArray();
	}

	public String getMethodName()
	{
		return GET_USER;
	}

	/**
	 * Retrieves the {@link com.redhat.j2koji.entities.KojiPackage} corresponding to the given
	 * ID
	 * 
	 * @return A {@code KojiBuild} matching the ID, or null if the returned hash does
	 *         not contain a match
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public KojiUser getUser() throws InstantiationException, IllegalAccessException
	{
		KojiUser result = null;
		result = new KojiUserFactory().createUser(hash);
		return result;
	}
}
