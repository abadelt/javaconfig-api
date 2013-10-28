package javax.config;

import java.util.Collections;
import java.util.Map;

public interface Environment {

	// Which properties hould be explicit?
	// Stage
	// Development Mode?
	// Global Log Level?
	// Tier?
	// AppId?
	// EarID?
	// RuntimeID?
	// Timezone?
	// Country?
	// Language?
	// User?
	
	public static final Environment ANY = new Environment(){

		@Override
		public String getStage() {
			return "<ANY>";
		}

		@Override
		public Map<String, String> getProperties() {
			return Collections.emptyMap();
		}};

	public String getStage();

	public Map<String, String> getProperties();

}
