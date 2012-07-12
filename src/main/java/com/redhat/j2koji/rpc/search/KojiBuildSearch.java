package com.redhat.j2koji.rpc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiSearchBase;
import com.redhat.j2koji.entities.KojiBuild;
import com.redhat.j2koji.enums.KojiSearchMatchType;
import com.redhat.j2koji.enums.KojiSearchType;
import com.redhat.j2koji.factory.KojiBuildFactory;

/**
 * A class that represents the search method of the koji XML-RPC API. 
 * 
 * Note: Only the "id" and "name" attribute are populated by the search
 * method.
 * 
 * @author lnewson
 */
public class KojiBuildSearch extends KojiSearchBase<KojiBuild>
{
	private List<Object> hash = new ArrayList<Object>();
	
	public KojiBuildSearch(final String query)
	{
		super(query, KojiSearchType.BUILD);
	}
	
	public KojiBuildSearch(final String query, final KojiSearchMatchType matchType)
	{
		super(query, KojiSearchType.BUILD, matchType);
	}
	
	public void setResultMap(final Object hash)
	{
		this.hash = Arrays.asList((Object[])hash);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KojiBuild> getResults() throws IllegalAccessException
	{
		final List<KojiBuild> result = new ArrayList<KojiBuild>();

		for (final Object resultHash : hash)
		{
			result.add(new KojiBuildFactory().createBuild((Map<Object, Object>)resultHash));
		}
		return result;
	}

}
