package org.javaconfig.api;

public interface PropertyAdapter<T> {

	public Class<T> getTargetType();
	
	public void init(PropertyValue property);

	public T getAdapted();

}
