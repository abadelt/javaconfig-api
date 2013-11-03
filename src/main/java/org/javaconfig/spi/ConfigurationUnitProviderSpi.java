package org.javaconfig.spi;

import java.util.Collection;

import javax.config.ConfigurationUnit;
import javax.config.Environment;

public interface ConfigurationUnitProviderSpi {

	/**
	 * Evaluates a {@link ConfigurationUnit}.
	 * 
	 * @param configUnitId
	 *            The configUnitId, not {@code null}.
	 * @return a {@link ConfigurationUnit} corresponding to the configUnitId and
	 *         {@link Environment}.
	 */
	ConfigurationUnit getConfigurationUnit(
			String configUnitId, Environment environment);

	/**
	 * Access the ids of all {@link ConfigurationUnit} provided by this
	 * instance.
	 * 
	 * @return all ids of all {@link ConfigurationUnit}, never {@code null}.
	 */
	Collection<String> getConfigurationUnits();

}
