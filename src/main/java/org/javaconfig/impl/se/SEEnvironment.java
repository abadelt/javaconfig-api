package org.javaconfig.impl.se;

import java.net.InetAddress;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.config.Environment;
import javax.config.Stage;

/**
 * Default {@link Environment}.
 * 
 * @author Anatole Tresch
 */
public class SEEnvironment implements Environment {

	private Map<String, String> properties = new TreeMap<String, String>();
	private String stage;

	private static final String STAGE_PROP = "javax.config.stage";
	private static final String DEFAULT_STAGE = "TEST";

	public SEEnvironment() {
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
		out.append("SEEnvironment [stage=").append(stage)
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
