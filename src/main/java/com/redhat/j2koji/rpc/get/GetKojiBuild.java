package com.redhat.j2koji.rpc.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;
import com.redhat.j2koji.entities.KojiBuild;
import com.redhat.j2koji.factory.KojiBuildFactory;

public class GetKojiBuild implements KojiMethod
{
	/**
	 * The method name for this {@link KojiMethod}
	 */
	private static final String GET_BUILD = "getBuild";

	private Map<Object, Object> hash = new HashMap<Object, Object>();
	private List<Object> params = new ArrayList<Object>();
	
	public GetKojiBuild(final Integer buildId)
	{
		params.add(buildId);
	}
	
	public GetKojiBuild(final String buildNvr)
	{
		params.add(buildNvr);
	}
	
	public GetKojiBuild(final String name, final String version, final String release)
	{
		final Map<String, String> vars = new HashMap<String, String>();
		vars.put("name", name);
		vars.put("version", version);
		vars.put("release", release);
		params.add(vars);
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
		return GET_BUILD;
	}

	/**
	 * Retrieves the {@link com.redhat.j2koji.entities.KojiPackage} corresponding to the given
	 * ID
	 * 
	 * @return A {@code KojiBuild} matching the ID, or null if the returned hash does
	 *         not contain a match
	 * @throws IllegalAccessException 
	 */
	public KojiBuild getBuild() throws IllegalAccessException
	{
		KojiBuild result = null;
		result = new KojiBuildFactory().createBuild(hash);
		return result;
	}
}
