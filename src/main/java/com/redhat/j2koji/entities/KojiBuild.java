package com.redhat.j2koji.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.redhat.j2koji.enums.KojiBuildState;

/**
 * A class to hold and access information about a Koji Build.
 * 
 * @author lnewson
 */
public class KojiBuild
{
	private static final String ID 				= "id";
	private static final String BUILD_ID 		= "build_id";
	private static final String NAME 			= "name";
	private static final String VERSION 		= "version";
	private static final String RELEASE 		= "release";
	private static final String EPOCH 			= "epoch";
	private static final String STATE 			= "state";
	private static final String NVR 			= "nvr";
	private static final String PACKAGE_ID 		= "package_id";
	private static final String PACKAGE_NAME 	= "package_name";
	private static final String OWNER_ID 		= "owner_id";
	private static final String OWNER_NAME 		= "owner_name";
	private static final String VOLUME_ID		= "volume_id";
	private static final String VOLUME_NAME		= "volume_name";
	private static final String TASK_ID			= "task_id";
	private static final String CREATION_EVENT_ID	= "creation_event_id";
	private static final String CREATION_TIME	= "creation_time";
	private static final String CREATION_TS		= "creation_ts";
	private static final String COMPLETION_TIME	= "completion_time";
	private static final String COMPLETION_TS	= "completion_time";
	
	private Map<String, Object> internalState = new HashMap<String, Object>();
	
	public KojiBuild()
	{
		
	}
	
	/**
	 * Get the build id.
	 * 
	 * @return The id of the build.
	 */
	public Integer getId()
	{
		/* When returning a specific build, the id is in the id field */
		if (getInternalState().containsKey(ID))
			return (Integer) getInternalState().get(ID);
		/* When doing a list, the id is in the build_id field */
		return (Integer) getInternalState().get(BUILD_ID);
	}
	
	/**
	 * Set the id of the build.
	 * 
	 * @param buildId The id for the build.
	 */
	public void setId(final Integer buildId)
	{
		getInternalState().put(ID, buildId);
	}
	
	/**
	 * Get the name of the build.
	 * 
	 * @return The name of the build.
	 */
	public String getName()
	{
		return (String) getInternalState().get(NAME);
	}
	
	/**
	 * Set the name of the build.
	 * 
	 * @param name The name of the build.
	 */
	public void setName(final String name)
	{
		getInternalState().put(NAME, name);
	}
	
	/**
	 * Get the version of the product this build represents.
	 * 
	 * @return The products version.
	 */
	public String getVersion()
	{
		return (String) getInternalState().get(VERSION);
	}
	
	/**
	 * Set the version for the product in the build.
	 * 
	 * @param version The product version.
	 */
	public void setVersion(final String version)
	{
		getInternalState().put(VERSION, version);
	}
	
	public String getRelease()
	{
		return (String) getInternalState().get(RELEASE);
	}
	
	public void setRelease(final String release)
	{
		getInternalState().put(RELEASE, release);
	}
	
	public Integer getEpoch()
	{
		return (Integer) getInternalState().get(EPOCH);
	}
	
	public void setEpoch(final String epoch)
	{
		getInternalState().put(EPOCH, epoch);
	}
	
	/**
	 * Get the state of the build.
	 * 
	 * 0 - BUILDING
	 * 1 - COMPLETE
	 * 2 - DELETED
	 * 3 - FAILED
	 * 4 - CANCELED
	 * 
	 * @return The state of the build.
	 */
	public KojiBuildState getState()
	{
		return KojiBuildState.get((Integer) getInternalState().get(STATE));
	}
	
	/**
	 * Set the state of the build.
	 * 
	 * 0 - BUILDING
	 * 1 - COMPLETE
	 * 2 - DELETED
	 * 3 - FAILED
	 * 4 - CANCELED
	 * 
	 * @param state The state of the build.
	 */
	public void setState(final KojiBuildState state)
	{
		getInternalState().put(STATE, state.getValue());
	}
	
	/**
	 * Get the Name-Version-Release for the build.
	 * 
	 * @return The nvr for the build.
	 */
	public String getNvr()
	{
		return (String) getInternalState().get(NVR);
	}
	
	/**
	 * Set the Name-Version-Release value for the build.
	 * 
	 * 0 - CLOSED
	 * 1 - OPEN
	 * 
	 * @param nvr The Name-Version-Release for the build.
	 */
	public void setNvr(final String nvr)
	{
		getInternalState().put(NVR, nvr);
	}
	
	/**
	 * Get the id of the package that the build exists for.
	 * 
	 * @return The package id that this build exists for.
	 */
	public Integer getPackageId()
	{
		return (Integer) getInternalState().get(PACKAGE_ID);
	}
	
	/**
	 * Sets the id of the package that this build belongs to.
	 * 
	 * @param packageId The id of the package the build belongs to.
	 */
	public void setPackageId(final Integer packageId)
	{
		getInternalState().put(PACKAGE_ID, packageId);
	}
	
	/**
	 * Gets the name of the package that the build belongs to.
	 * 
	 * @return The name of the package the build belongs to.
	 */
	public String getPackageName()
	{
		return (String) getInternalState().get(PACKAGE_NAME);
	}
	
	/**
	 * Sets the name of the package that this build belongs to.
	 * 
	 * @param packageName The name of the package the build belongs to.
	 */
	public void setPackageName(final String packageName)
	{
		getInternalState().put(PACKAGE_NAME, packageName);
	}
	
	/**
	 * Gets the id of the owner of this build.
	 * 
	 * @return The user id of the owner of this build.
	 */
	public Integer getOwnerId()
	{
		return (Integer) getInternalState().get(OWNER_ID);
	}
	
	/**
	 * Sets the id of the owner of this build.
	 * 
	 * @param ownerId The user id of the owner of the build.
	 */
	public void setOwnerId(final Integer ownerId)
	{
		getInternalState().put(OWNER_ID, ownerId);
	}
	
	/**
	 * Gets the username of the owner of this build.
	 * 
	 * @return The username of the owner of this build.
	 */
	public String getOwnerName()
	{
		return (String) getInternalState().get(OWNER_NAME);
	}
	
	/**
	 * Sets the username of the owner of this build.
	 * 
	 * @param ownerName The username of the owner of the build.
	 */
	public void setOwnerName(final String ownerName)
	{
		getInternalState().put(OWNER_NAME, ownerName);
	}
	
	/**
	 * Gets the volume id that the build is stored on.
	 * 
	 * @return The volume id that the build is stored on.
	 */
	public Integer getVolumeId()
	{
		return (Integer) getInternalState().get(VOLUME_ID);
	}
	
	/**
	 * Sets the volume id that the build is stored on.
	 * 
	 * @param ownerId The volume id that the build is stored on.
	 */
	public void setVolumeId(final Integer ownerId)
	{
		getInternalState().put(VOLUME_ID, ownerId);
	}
	
	/**
	 * Gets the volume name that the build is stored on.
	 * 
	 * @return The volume name that the build is stored on.
	 */
	public String getVolumeName()
	{
		return (String) getInternalState().get(VOLUME_NAME);
	}
	
	/**
	 * Sets the name of the volume that the build is stored on.
	 * 
	 * @param ownerName The volume name that the build is stored on.
	 */
	public void setVolumeName(final String ownerName)
	{
		getInternalState().put(VOLUME_NAME, ownerName);
	}
	
	public Integer getTaskId()
	{
		return (Integer) getInternalState().get(TASK_ID);
	}
	
	public void setTaskId(final Integer taskId)
	{
		getInternalState().put(TASK_ID, taskId);
	}
	
	public Integer getCreationEventId()
	{
		return (Integer) getInternalState().get(CREATION_EVENT_ID);
	}
	
	public void setCreationEventId(final Integer creationEventId)
	{
		getInternalState().put(CREATION_EVENT_ID, creationEventId);
	}
	
	public String getCreationTime()
	{
		return (String) getInternalState().get(CREATION_TIME);
	}
	
	public void setCreationTime(final String creationTime)
	{
		getInternalState().put(CREATION_TIME, creationTime);
	}
	
	public Date getCreationTimestamp()
	{
		final Long date = (long)((Double) getInternalState().get(CREATION_TS) * 1000);
		return date == null ? null : new Date(date);
	}
	
	public void setCreationTimestamp(final Date creationTimestamp)
	{
		getInternalState().put(CREATION_TS, Double.toString(((double)creationTimestamp.getTime()) / 1000.0f));
	}
	
	public String getCompletionTime()
	{
		return (String) getInternalState().get(COMPLETION_TIME);
	}
	
	public void setCompletionTime(final String completionTime)
	{
		getInternalState().put(COMPLETION_TIME, completionTime);
	}
	
	public Date getCompletionTimestamp()
	{
		final Long date = (long)((Double) getInternalState().get(COMPLETION_TS) * 1000);
		return date == null ? null : new Date(date);
	}
	
	public void setCompletionTimestamp(final Date completionTimestamp)
	{
		getInternalState().put(COMPLETION_TS, Double.toString(((double)completionTimestamp.getTime()) / 1000.0f));
	}
	
	public Map<String, Object> getInternalState()
	{
		return internalState;
	}

	public void setInternalState(final Map<String, Object> internalState)
	{
		this.internalState = internalState;
	}
}
