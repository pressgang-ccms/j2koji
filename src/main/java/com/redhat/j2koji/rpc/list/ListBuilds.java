package com.redhat.j2koji.rpc.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiMethod;
import com.redhat.j2koji.entities.KojiBuild;
import com.redhat.j2koji.factory.KojiBuildFactory;

public class ListBuilds implements KojiMethod
{
	/**
	 * The method name for this {@link KojiMethod}
	 */
	private static final String LIST_BUILDS = "listBuilds";

	private List<Object> hash = new ArrayList<Object>();
	private List<Object> params = new ArrayList<Object>();
	
	public ListBuilds(final Integer packageId)
	{
		params.add(packageId);
	}
	
	public ListBuilds(final Integer packageId, final Integer userId)
	{
		params.add(packageId);
		params.add(userId);
	}
	
	public ListBuilds(final Integer packageId, final Integer userId, final Integer taskId)
	{
		params.add(packageId);
		params.add(userId);
		params.add(taskId);
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
		return LIST_BUILDS;
	}

	/**
	 * Retrieves the {@link com.redhat.j2koji.entities.KojiBuild} corresponding to the given
	 * ID
	 * 
	 * @return A {@code KojiBuild} matching the ID, or null if the returned hash does
	 *         not contain a match
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public List<KojiBuild> getBuilds() throws InstantiationException, IllegalAccessException
	{
		final List<KojiBuild> result = new ArrayList<KojiBuild>();

		for (final Object buildHash : hash)
		{
			result.add(new KojiBuildFactory().createBuild((Map<Object, Object>)buildHash));
		}
		return result;
	}
}
