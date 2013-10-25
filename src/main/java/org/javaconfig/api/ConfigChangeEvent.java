package org.javaconfig.api;

public class ConfigChangeEvent {

	public static enum Type{
		REPLACED,
		UPDATED,
		REMOVED,
		ADDED
	}
	
}
