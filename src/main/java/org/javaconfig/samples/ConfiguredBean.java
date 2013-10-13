package org.javaconfig.samples;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.javaconfig.api.ConfigService;
import org.javaconfig.api.annot.ConfigScope;
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
@ConfigScope(value = "DOMAIN")
public class ConfiguredBean {

	@Inject
	private ConfigService configService;

	@Configured("TEST")
//	@ConfigScope(value = Scope.GLOBAL, attributes = {
//			@Selector(key = "stage", value = "IT"),
//			@Selector(key = "tier", value = "PT") })
	private String gValue;

	@Configured("TEST")
//	@NamedConfigScope(value = "MyCustomScope")
	private String value;

}
