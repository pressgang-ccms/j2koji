package com.redhat.j2koji.enums;

public enum KojiUserType
{
	NORMAL(0), HOST(1), GROUP(2);
	
	private final Integer userType;
	
	KojiUserType(final Integer userType)
	{
		this.userType = userType;
	}
	
	public Integer getValue()
	{
		return userType;
	}
	
	@Override
	public String toString()
	{
		return userType.toString();
	}
	
	public static KojiUserType get(final Integer userType)
	{
		switch (userType)
		{
			case 0 : return NORMAL;
			case 1 : return HOST;
			case 2 : return GROUP;
		}
		return null;
	}
}
