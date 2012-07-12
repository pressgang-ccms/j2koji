package com.redhat.j2koji.rpc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.redhat.j2koji.base.KojiSearchBase;
import com.redhat.j2koji.entities.KojiPackage;
import com.redhat.j2koji.enums.KojiSearchMatchType;
import com.redhat.j2koji.enums.KojiSearchType;
import com.redhat.j2koji.factory.KojiPackageFactory;

public class KojiPackageSearch extends KojiSearchBase<KojiPackage>
{
	private List<Object> hash = new ArrayList<Object>();
	
	public KojiPackageSearch(final String query)
	{
		super(query, KojiSearchType.PACKAGE);
	}
	
	public KojiPackageSearch(final String query, final KojiSearchMatchType matchType)
	{
		super(query, KojiSearchType.PACKAGE, matchType);
	}
	
	public void setResultMap(final Object hash)
	{
		this.hash = Arrays.asList((Object[])hash);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KojiPackage> getResults()
	{
		final List<KojiPackage> result = new ArrayList<KojiPackage>();

		for (final Object resultHash : hash)
		{
			result.add(new KojiPackageFactory().createPackage((Map<Object, Object>)resultHash));
		}
		return result;
	}

}
