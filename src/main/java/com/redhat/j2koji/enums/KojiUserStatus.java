package com.redhat.j2koji.enums;

public enum KojiUserStatus
{
	NORMAL(0), BLOCKED(1);
	
	private final Integer status;
	
	KojiUserStatus(final Integer status)
	{
		this.status = status;
	}
	
	public Integer getValue()
	{
		return status;
	}
	
	@Override
	public String toString()
	{
		return status.toString();
	}
	
	public static KojiUserStatus get(final Integer status)
	{
		switch (status)
		{
			case 0 : return NORMAL;
			case 1 : return BLOCKED;
		}
		return null;
	}
}
