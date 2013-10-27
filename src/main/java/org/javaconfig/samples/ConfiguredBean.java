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
package org.javaconfig.samples;

import java.net.URL;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.javaconfig.api.ConfigService;
import org.javaconfig.api.PropertyAdapter;
import org.javaconfig.api.PropertyValue;
import org.javaconfig.api.annot.ConfigAdapter;
import org.javaconfig.api.annot.ConfigType;
import org.javaconfig.api.annot.Configured;

/*
 * <pre>
 * 
 * ConfigurationScope(location):
 * 
 * SERVICE APP EAR DOMAIN SERVER TIER CLUSTER NETWORKZONE ORGANIZATIONUNIT
 * ENTERPRISE GLOBAL
 * 
 * Selectors:
 * 
 * stage=PROD,PTA,TEST,DEV server=abc.myinc.com tier=PT zone=DMZ
 * application=PortfolioManager
 * 
 * Types:
 * 
 * CODE DEPLOYMENT ANY
 * 
 * Aggregates:
 * 
 * APP, DOMAIN, CLUSTER, VM </pre>
 */
@Singleton
@ConfigType(ConfigType.DOMAIN)
// @ConfigFilter(MyFilter.class)
public class ConfiguredBean {

	@Inject
	private ConfigService configService;

	@Configured
	private String gValue;

	@Configured("testValue")
	private String value;

	@Configured("number")
	// @ConfigFilter(MyFilter.class)
	private int myNum;

	@Configured("XML stream")
	private URL myXmlConfig;

	@Configured("mySimpleMap")
	@ConfigAdapter(SimpleMapAdapter.class)
	private Map<String, String> myMappedConfig;

	
	/**
	 * Example adapter (not implemented).
	 * 
	 * @author Anatole Tresch
	 */
	private static class SimpleMapAdapter implements
			PropertyAdapter<Map<String, String>> {

		@Override
		public Class getTargetType() {
			return Map.class;
		}

		@Override
		public void init(PropertyValue property) {
			// TODO Auto-generated method stub

		}

		@Override
		public Map<String, String> getAdapted() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
