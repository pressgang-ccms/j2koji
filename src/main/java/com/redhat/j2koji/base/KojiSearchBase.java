package com.redhat.j2koji.base;

import java.util.ArrayList;
import java.util.List;

import com.redhat.j2koji.enums.KojiSearchMatchType;
import com.redhat.j2koji.enums.KojiSearchType;

/**
 * The base class that defines the setup for a search command.
 * 
 * @author lnewson
 *
 * @param <T> The type of object that the Search should return a list of. e.g. KojiBuild, KojiPackage, etc...
 */
public abstract class KojiSearchBase<T> implements KojiMethod
{
	/**
	 * The method name for this {@link KojiMethod}
	 */
	protected static final String SEARCH = "search";

	protected List<Object> params = new ArrayList<Object>();
	
	public KojiSearchBase(final String query, final KojiSearchType type, final KojiSearchMatchType matchType)
	{
		params.add(query);
		params.add(type.toString());
		params.add(matchType.toString());
	}
	
	public KojiSearchBase(final String query, final KojiSearchType type)
	{
		this(query, type, KojiSearchMatchType.GLOB);
	}

	public Object[] getParameters()
	{
		return params.toArray();
	}

	public String getMethodName()
	{
		return SEARCH;
	}

	/**
	 * Retrieves the {@link com.redhat.j2koji.entities.KojiPackage} corresponding to the given
	 * ID
	 * 
	 * @return A list of {@code T} matching the ID, or null if the returned hash does
	 *         not contain a match
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public abstract List<T> getResults() throws InstantiationException, IllegalAccessException;
}
