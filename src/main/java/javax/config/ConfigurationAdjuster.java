package javax.config;

//@FunctionalInterface
public interface ConfigurationAdjuster {

	public Configuration adjustInto(Configuration config);
	
}