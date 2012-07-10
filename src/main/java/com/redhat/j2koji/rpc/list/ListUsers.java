package com.redhat.j2koji.rpc.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;
import com.redhat.j2koji.entities.KojiPackage;
import com.redhat.j2koji.enums.KojiUserType;
import com.redhat.j2koji.factory.KojiPackageFactory;

public class ListUsers implements KojiMethod
{
	/**
	 * The method name for this {@link KojiMethod}
	 */
	private static final String LIST_USERS = "listUsers";

	private List<Object> hash = new ArrayList<Object>();
	private List<Object> params = new ArrayList<Object>();
	
	public ListUsers(final KojiUserType userType)
	{
		params.add(userType.getValue());
	}
	
	public void setResultMap(final Object hash)
	{
		this.hash = Arrays.asList((Object[])hash);
	}

	public Object[] getParameters()
	{
		return params.toArray();
	}

	public String getMethodName()
	{
		return LIST_USERS;
	}

	/**
	 * Retrieves the {@link com.redhat.j2koji.entities.KojiPackage} corresponding to the given
	 * ID
	 * 
	 * @return A {@code KojiPackage} matching the ID, or null if the returned hash does
	 *         not contain a match
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public List<KojiPackage> getPackages() throws InstantiationException, IllegalAccessException
	{
		final List<KojiPackage> result = new ArrayList<KojiPackage>();

		for (final Object buildHash : hash)
		{
			result.add(new KojiPackageFactory().createPackage((Map<Object, Object>)buildHash));
		}
		return result;
	}
}
