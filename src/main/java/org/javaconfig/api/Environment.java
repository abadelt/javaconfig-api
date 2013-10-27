package org.javaconfig.api;

import java.util.Map;

public interface Environment {

	public String getStage();

	public Map<String, String> getProperties();

}
