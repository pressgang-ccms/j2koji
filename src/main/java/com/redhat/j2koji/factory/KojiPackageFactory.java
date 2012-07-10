package com.redhat.j2koji.factory;

import java.util.HashMap;
import java.util.Map;

import com.redhat.j2koji.entities.KojiPackage;

public class KojiPackageFactory
{
	/**
	 * Creates a new {@link KojiPackage} based off of the provided {@code Map} of
	 * properties.
	 * 
	 * @param properties
	 *            A {@code Map<Object, Object>} describing the internal
	 *            structure of a package.
	 * @return A new {@code KojiPackage} object.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public KojiPackage createPackage(final Map<Object, Object> properties) throws InstantiationException, IllegalAccessException
	{
		final Map<String, Object> copy = new HashMap<String, Object>();
		for (final Object key : properties.keySet())
		{
			copy.put((String) key, properties.get(key));
		}
		final KojiPackage pack = new KojiPackage();
		pack.setInternalState(copy);
		return pack;
	}
}
