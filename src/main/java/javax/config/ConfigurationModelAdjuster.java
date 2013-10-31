package javax.config;

//@FunctionalInterface
public interface ConfigurationModelAdjuster {

	ConfigurationModel adjustInto(ConfigurationModel config);
	
}