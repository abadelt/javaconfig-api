/*
 * Copyright (c) 2013, Anatole Tresch.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.javaconfig.spi;

import java.util.Collection;

import org.javaconfig.api.ConfigurationType;
import org.javaconfig.api.Configuration;
import org.javaconfig.api.ConfigurationUnit;
import org.javaconfig.api.Environment;

/**
 * This SPI allows to add additional scopes to the system.
 * 
 * @author Anatole Tresch
 */
public interface AggregateProviderSpi {

	/**
	 * Defines the {@link ConfigurationUnit} accessible by this SPI
	 * implementation.
	 * 
	 * @return the {@link ConfigurationUnit}s to be introduced by this SPI
	 *         implementation.
	 */
	Collection<ConfigurationType> getAggregates();

	/**
	 * Called, when a given {@link ConfigurationType} has to be evaluated for inclusion
	 * into a configuration.
	 * 
	 * @param aggregate
	 *            the{@link ConfigurationType} to be read.
	 * @param environment
	 *            The target environment.
	 * @return the corresponding {@link AggregateInstance}, or {@code null}, if
	 *         not available for the given environment.
	 */
	Configuration getConfiguration(
			ConfigurationType aggregate, Environment environment);

}
