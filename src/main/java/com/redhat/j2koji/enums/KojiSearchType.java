package com.redhat.j2koji.enums;

public enum KojiSearchType
{
	PACKAGE("package"), BUILD("build"), TAG("tag"), TARGET("target"), USER("user"), HOST("host"), RPM("rpm"), MAVEN("maven");
	
	private final String title;
	
	KojiSearchType(final String title)
	{
		this.title = title;
	}
	
	@Override
	public String toString()
	{
		return title;
	}
}
