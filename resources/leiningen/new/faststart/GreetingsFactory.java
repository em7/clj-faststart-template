package {{namespace}};

/**
 * No Java project can be complete without an abuse of GoF design pattern.
 * </p>
 * <pre>
 * Roses are red
 * Leaves are green
 * Only Java has
 * AbstractSingletonProxyFactoryBean
 * </pre>
 */
public interface GreetingsFactory {

	/**
	 * Creates a new instance of greeting
	 * for person with name.
	 *
	 * @param name name of the person to be greeted
	 */
	String createGreetingsFor(String name);

}
