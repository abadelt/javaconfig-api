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
package javax.config.spi;

import java.util.Collection;

import javax.config.ConfigurationModel;
import javax.config.Environment;

/**
 * This SPI allows to add additional scopes to the system.
 * 
 * @author Anatole Tresch
 */
public interface ConfigurationModelProviderSpi {

	/**
	 * Defines the {@link ConfigurationModel} provided by this SPI
	 * implementation.
	 * 
	 * @return the model ids to be introduced by this SPI implementation.
	 */
	Collection<String> getConfigurationModels();

	/**
	 * Called, when a given {@link ConfigurationModel} has to be evaluated.
	 * 
	 * @param modelId
	 *            the id of the model to be read.
	 * @param environment
	 *            The target environment.
	 * @return the corresponding {@link ConfigurationModel}, or {@code null}, if
	 *         not available for the given environment.
	 */
	ConfigurationModel getConfiguration(
			String modelId, Environment environment);

}
