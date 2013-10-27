package org.javaconfig.spi;

import java.util.Collection;

import org.javaconfig.api.ConfigurationUnit;
import org.javaconfig.api.Environment;

public interface ConfigurationUnitLoader {

	/**
	 * Evaluates a {@link ConfigurationNode} ({@link ConfigurationUnit}
	 * sub-configuration tree).
	 * 
	 * @param unit
	 *            The unit, not {@code null}.
	 * @return the current {@link ConfigurationUnitInstance} corresponding to
	 *         the {@link ConfigurationUnit}.
	 */
	Collection<ConfigurationNode> getConfigurationNodes(
			ConfigurationUnit unit, Environment environment);
	
	/**
	 * Access all scopes.
	 * 
	 * @return all scopes, never {@code null}.
	 */
	Collection<ConfigurationUnit> getConfigUnits();

	/**
	 * Allows to check if a scope with the given id is defined.
	 * 
	 * @param unitId
	 *            The unit id to be looked up, not {@code null}.
	 * @return true, if the given {@link ConfigurationUnit} is defined.
	 */
	boolean isConfigUnitDefined(String unitId);

	/**
	 * Access a configuration scope, by its id.
	 * 
	 * @param unitId
	 *            The scope id, not {@code null}.
	 * @return the according scope.
	 * @throws IllegalArgumentException
	 *             if the scope is not defined.
	 */
	ConfigurationUnit getConfigUnit(String unitId);

}
