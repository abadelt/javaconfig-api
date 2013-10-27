package org.javaconfig.spi;

import java.util.Collection;

import org.javaconfig.api.ConfigurationNode;
import org.javaconfig.api.ConfigurationUnit;

public interface ScopeManager {

	
	/**
	 * Evaluates a scope.
	 * 
	 * @param scope
	 * @return
	 */
	ConfigurationNode getConfiguration(ConfigurationUnit scope);

	

}
