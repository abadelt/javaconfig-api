package javax.config;

//@FunctionalInterface
public interface ConfigurationAdjuster {

	Configuration adjustInto(Configuration config);
	
}