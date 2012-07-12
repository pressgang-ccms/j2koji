package com.redhat.j2koji.rpc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiSearchBase;
import com.redhat.j2koji.entities.KojiUser;
import com.redhat.j2koji.enums.KojiSearchMatchType;
import com.redhat.j2koji.enums.KojiSearchType;
import com.redhat.j2koji.factory.KojiUserFactory;

public class KojiUserSearch extends KojiSearchBase<KojiUser>
{
	private List<Object> hash = new ArrayList<Object>();
	
	public KojiUserSearch(final String query)
	{
		super(query, KojiSearchType.USER);
	}
	
	public KojiUserSearch(final String query, final KojiSearchMatchType matchType)
	{
		super(query, KojiSearchType.USER, matchType);
	}
	
	public void setResultMap(final Object hash)
	{
		this.hash = Arrays.asList((Object[])hash);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KojiUser> getResults() throws IllegalAccessException
	{
		final List<KojiUser> result = new ArrayList<KojiUser>();

		for (final Object resultHash : hash)
		{
			result.add(new KojiUserFactory().createUser((Map<Object, Object>)resultHash));
		}
		return result;
	}

}
