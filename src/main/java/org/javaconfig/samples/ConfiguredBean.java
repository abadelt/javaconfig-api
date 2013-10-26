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

import java.io.InputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.javaconfig.api.ConfigService;
import org.javaconfig.api.annot.AggregateScope;
import org.javaconfig.api.annot.ConfigFilter;
import org.javaconfig.api.annot.Configured;
import org.javaconfig.api.annot.Selector;

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
@AggregateScope(AggregateScope.DOMAIN)
@ConfigFilter(attributes = {
		@Selector(key = "stage", value = "${STAGE}") })
public class ConfiguredBean {

	@Inject
	private ConfigService configService;

	@Configured
	private String gValue;

	@Configured("testValue")
	private String value;
	
	@Configured("number")
	@ConfigFilter(scopes={"myOverridingScope", "!GLOBAL"})
	private int myNum;
	
	@Configured("XML stream")
	private InputStream myXmlConfig;

}
