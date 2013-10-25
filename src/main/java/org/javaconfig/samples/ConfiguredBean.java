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
