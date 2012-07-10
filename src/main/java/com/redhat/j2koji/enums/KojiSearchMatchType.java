package com.redhat.j2koji.enums;

public enum KojiSearchMatchType
{
	REGEXP("regexp"), GLOB("glob");
	
	private final String title;
	
	KojiSearchMatchType(final String title)
	{
		this.title = title;
	}
	
	@Override
	public String toString()
	{
		return title;
	}
}
