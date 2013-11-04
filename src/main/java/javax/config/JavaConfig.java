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
package javax.config;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ServiceLoader;
import java.util.TimeZone;
import java.util.TreeMap;

/**
 * Singleton accessor for Java configuration.
 * 
 * @author Anatole Tresch
 */
public final class JavaConfig {
	/** The main delegate. */
	private static final ConfigService configurationService = loadConfigService();

	/**
	 * Private singleton constructor.
	 */
	private JavaConfig() {
		// Singleton
	}

	/**
	 * Get the {@link ConfigService}
	 * 
	 * @return the {@link ConfigService}, not {@code null}.
	 */
	public static ConfigService getConfigService() {
		return configurationService;
	}

	/**
	 * Loads the {@link ConfigService} from the {@link ServiceLoader}, or
	 * instantiates a {@link DefaultConfigService}.
	 * 
	 * @return the {@link ConfigService} to be used.
	 */
	private static ConfigService loadConfigService() {
		try {
			ServiceLoader<ConfigService> services = ServiceLoader
					.load(ConfigService.class);
			for (ConfigService service : services) {
				return service;
			}
		} catch (Exception e) {
			return new DefaultConfigService();
		}
		return new DefaultConfigService();
	}

	/**
	 * Default configuration service.
	 * 
	 * @author Anatole Tresch
	 */
	private static final class DefaultConfigService implements ConfigService {
		/** The default environment provider. */
		private Environment environment = new DefaultEnvironment();

		@Override
		public ConfigurationModel getConfiguration() {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public ConfigurationModel getConfiguration(String configId) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public ConfigurationModel getConfiguration(String configId,
				Environment environment) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}


		@Override
		public boolean isConfigurationDefined(String configId) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}


		@Override
		public Environment getCurrentEnvironment() {
			return environment;
		}

		@Override
		public ConfigurationQuery queryConfiguration() {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public ConfigurationUpdater updateConfiguration(Configuration config) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public ConfigurationUpdater createConfiguration(String configId, EnvironmentSelector targetEnvironment) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public void addConfigChangeListener(ConfigChangeListener l) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public void removeConfigChangeListener(ConfigChangeListener l) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public boolean isConfigurationDefined(String configId,
				Environment environment) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public Collection<String> getConfigurationIds() {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

		@Override
		public void configure(Object instance) {
			throw new UnsupportedOperationException(
					"No java-config implementation found.");
		}

	}

	/**
	 * Default {@link Environment}.
	 * 
	 * @author Anatole Tresch
	 */
	private static final class DefaultEnvironment implements Environment {

		private Map<String, String> properties = new TreeMap<String, String>();
		private String stage;

		private static final String STAGE_PROP = "javax.config.stage";
		private static final String DEFAULT_STAGE = "TEST";

		public DefaultEnvironment() {
			stage = System.getProperty(STAGE_PROP);
			if (stage == null) {
				stage = DEFAULT_STAGE;
			}
			// Copy system properties....
			for (Entry<Object, Object> en : System.getProperties().entrySet()) {
				this.properties.put(en.getKey().toString(), en.getValue()
						.toString());
			}
			this.properties.put("timezoneId", TimeZone.getDefault().getID());
			this.properties.put("timezoneName", TimeZone.getDefault()
					.getDisplayName(Locale.ENGLISH));
			this.properties.put("locale", Locale.getDefault().toString());
			try {
				this.properties.put("hostName", InetAddress.getLocalHost()
						.getHostName());
			} catch (Exception e) {

			}
			try {
				this.properties.put("hostAddress", InetAddress.getLocalHost()
						.getHostAddress());
			} catch (Exception e) {

			}
			// Copy env properties....
			for (Entry<String, String> en : System.getenv().entrySet()) {
				this.properties.put("env:" + en.getKey(), en
						.getValue()
						.toString());
			}
		}

		@Override
		public Stage getStage() {
			return Stage.Development;
		}

		@Override
		public Map<String, String> getProperties() {
			return properties;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder out = new StringBuilder();
			out.append("DefaultEnvironment [stage=").append(stage)
					.append(", properties:\n");
			for (Entry<String, String> en : this.properties.entrySet()) {
				out.append("  ").append(en.getKey().toString()).append(" = ")
						.append(en
								.getValue().toString()).append('\n');
			}
			out.append("]");
			return out.toString();
		}

	}

}
