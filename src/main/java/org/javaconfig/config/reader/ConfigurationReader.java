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
package org.javaconfig.config.reader;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.config.ConfigurationUnit;
import javax.config.Environment;

import org.javaconfig.spi.ConfigReaderSpi;

/**
 * Singleton accessor to access registered reader mechanism.
 * 
 * @author Anatole Tresch
 */
public final class ConfigurationReader {

	private static final Map<String, ConfigReaderSpi> READERS = new ConcurrentHashMap<>();

	static{
		// reader readers
		try {
			ServiceLoader<ConfigReaderSpi> spis = ServiceLoader.load(ConfigReaderSpi.class);
			for (ConfigReaderSpi configReaderSpi : spis) {
				ConfigurationReader.READERS.put(configReaderSpi.getPrefix(), configReaderSpi);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private ConfigurationReader() {
		// Singleton
	}

	public static ConfigReaderSpi getReader(String readerId) {
		return READERS.get(readerId);
	}

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
	public static ConfigurationUnit readConfig(String readerId, String source,
			Environment environment,
			Set<String> sourcesRead) {
		ConfigReaderSpi reader = getReader(readerId);
		if (reader == null) {
			throw new IllegalArgumentException("no such reader: " + readerId);
		}
		return reader.readConfig(source, environment, sourcesRead);
	}

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
	public static ConfigurationUnit readConfig(String source,
			Environment environment) {
		throw new UnsupportedOperationException();
	}
}
