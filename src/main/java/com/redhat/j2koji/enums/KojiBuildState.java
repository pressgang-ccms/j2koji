package com.redhat.j2koji.enums;

public enum KojiBuildState
{
	BUILDING(0), COMPLETE(1), DELETED(2), FAILED(3), CANCELED(4);
	
	private final Integer state;
	
	KojiBuildState(final Integer status)
	{
		this.state = status;
	}
	
	public Integer getValue()
	{
		return state;
	}
	
	@Override
	public String toString()
	{
		return state.toString();
	}
	
	public static KojiBuildState get(final Integer state)
	{
		switch (state)
		{
			case 0 : return BUILDING;
			case 1 : return COMPLETE;
			case 2 : return DELETED;
			case 3 : return FAILED;
			case 4 : return CANCELED;
		}
		return null;
	}
}
