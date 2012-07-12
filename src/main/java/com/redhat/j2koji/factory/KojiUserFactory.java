package com.redhat.j2koji.factory;

import java.util.HashMap;
import java.util.Map;

import com.redhat.j2koji.entities.KojiUser;
import com.redhat.j2koji.enums.KojiUserStatus;
import com.redhat.j2koji.enums.KojiUserType;

public class KojiUserFactory
{
	/**
	 * Creates a new {@link KojiUser} based off of the provided {@code Map} of
	 * properties.
	 * 
	 * @param properties
	 *            A {@code Map<Object, Object>} describing the internal
	 *            structure of a package.
	 * @return A new {@code KojiUser} object.
	 * @throws IllegalAccessException 
	 */
	public KojiUser createUser(final Map<Object, Object> properties) throws IllegalAccessException
	{
		final Map<String, Object> copy = new HashMap<String, Object>();
		for (final Object key : properties.keySet())
		{
			copy.put((String) key, properties.get(key));
		}
		final KojiUser user = new KojiUser();
		user.setInternalState(copy);
		return user;
	}
	
	/**
	 * Creates a new {@link KojiUser} based off of the provided {@code Map} of
	 * properties.
	 * 
	 * @param username The name of the user.
	 * @return A new {@code KojiUser} object.
	 * @throws IllegalAccessException 
	 */
	public KojiUser createUser(final String username) throws IllegalAccessException
	{
		final KojiUser user = new KojiUser();
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", username);
		params.put("status", KojiUserStatus.NORMAL.getValue());
		params.put("usertype", KojiUserType.NORMAL.getValue());
		user.setInternalState(params);
		return user;
	}
}
