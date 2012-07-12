package com.redhat.j2koji.rpc.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;
import com.redhat.j2koji.entities.KojiPackage;
import com.redhat.j2koji.factory.KojiPackageFactory;

public class GetKojiPackage implements KojiMethod
{
	/**
	 * The method name for this {@link KojiMethod}
	 */
	private static final String GET_PACKAGE = "getPackage";

	private Map<Object, Object> hash = new HashMap<Object, Object>();
	private List<Object> params = new ArrayList<Object>();
	
	public GetKojiPackage(final String packageName)
	{
		params.add(packageName);
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
		return GET_PACKAGE;
	}

	/**
	 * Retrieves the {@link com.redhat.j2koji.entities.KojiPackage} corresponding to the given
	 * ID
	 * 
	 * @return A {@code KojiPackage} matching the ID, or null if the returned hash does
	 *         not contain a match
	 */
	public KojiPackage getPackage()
	{
		KojiPackage result = null;
		result = new KojiPackageFactory().createPackage(hash);
		return result;
	}
}
