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

import java.util.Set;

import javax.config.ConfigurationUnit;
import javax.config.Environment;

/**
 * A configuration reader implements a strategy for reading configuration.
 * Examples for readers are classpath, file and db reader. Readers may support
 * multiple configuration formats, whereas the details are hidden to the
 * clients.
 * 
 * @author Anatole Tresch
 * 
 */
public interface ConfigReaderSpi {

	/**
	 * Read the configuration from the given source expression.
	 * 
	 * @param source
	 *            the source expression, not {@code null}.
	 * @param environment
	 *            the target environment, not {@code null}.
	 * @param sourcesRead
	 *            the sources already read, or {@code null}. If defined the
	 *            sources in the list will not reevaluted/included into the
	 *            result, which prevents resources read multiple times within
	 *            the same class loader hierarchy.
	 * @return the configuration read, never {@code null}.
	 */
	ConfigurationUnit readConfig(String source, Environment environment,
			Set<String> sourcesRead);

	/**
	 * Return the prefix that identifiers this reader.
	 * 
	 * @return the reader's prefix, never {@code null}.
	 */
	String getPrefix();
}
