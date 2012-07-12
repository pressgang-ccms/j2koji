package com.redhat.j2koji.factory;

import java.util.HashMap;
import java.util.Map;

import com.redhat.j2koji.entities.KojiBuild;

public class KojiBuildFactory
{	
	
	/**
	 * Creates a new {@link KojiBuild} based off of the provided {@code Map} of
	 * properties.
	 * 
	 * @param properties
	 *            A {@code Map<Object, Object>} describing the internal
	 *            structure of a package.
	 * @return A new {@code KojiBuild} object.
	 */
	public KojiBuild createBuild(final Map<Object, Object> properties)
	{
		final Map<String, Object> copy = new HashMap<String, Object>();
		for (final Object key : properties.keySet())
		{
			copy.put((String) key, properties.get(key));
		}
		final KojiBuild build = new KojiBuild();
		build.setInternalState(copy);
		return build;
	}
}
