package org.javaconfig.impl;

import java.util.Collection;

import javax.config.Configuration;
import javax.config.Environment;

public interface ConfigurationLoader {

	/**
	 * Evaluates a {@link ConfigurationNode} ({@link ConfigurationUnit}
	 * sub-configuration tree).
	 * 
	 * @param unit
	 *            The unit, not {@code null}.
	 * @return the current {@link ConfigurationUnitInstance} corresponding to
	 *         the {@link ConfigurationUnit}.
	 */
	Configuration getConfigurations(
			String unit, Environment environment);

	/**
	 * Access all scopes.
	 * 
	 * @return all scopes, never {@code null}.
	 */
	Collection<String> getConfigurations();

	/**
	 * Allows to check if a scope with the given id is defined.
	 * 
	 * @param configId
	 *            The config id to be looked up, not {@code null}.
	 * @return true, if the given {@link Configuration} is defined.
	 */
	boolean isConfigurationDefined(String configId);

	/**
	 * Access a configuration scope, by its id.
	 * 
	 * @param configId
	 *            The config id, not {@code null}.
	 * @return the according {@link Configuration}.
	 * @throws IllegalArgumentException
	 *             if the scope is not defined.
	 */
	Configuration getConfiguration(String configId);

}
