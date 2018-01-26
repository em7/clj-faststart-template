package {{namespace}};
import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class Main {

	public static void main(String[] args) {

		// Here the JVM starts. Usually blazing fast.
		long start = System.nanoTime();
		System.out.println("Hello from Java");

		// This takes quite a long time because Clojure is being loaded.
		final IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("{{namespace}}.core"));

        long coreLoaded = System.nanoTime();
        System.out.println(String.format("Clojure core loaded: %f s", (coreLoaded - start) / 1000000000.0));

        // Simple function call
        final IFn helloFunc = Clojure.var("{{namespace}}.core", "hello");
        final String ret = (String) helloFunc.invoke();

        long funCalled = System.nanoTime();
        System.out.println(String.format("Function called: %f s", (funCalled - coreLoaded)  / 1000000000.0));
        System.out.println(ret);

        // And some Java stuff
        // Every Java project should have a factory method for creating "Hello World" factory
        IFn greetingsFactoryFactoryMethod = Clojure.var("{{namespace}}.core", "create-greetings-factory");
        GreetingsFactory greetingsFactory = (GreetingsFactory) greetingsFactoryFactoryMethod.invoke();
        String helloWorld = greetingsFactory.createGreetingsFor("Enterprise World");

        long objCreated = System.nanoTime();
        System.out.println(String.format("Object created and method invoked: %s s", (objCreated - funCalled)  / 1000000000.0));
        System.out.println(helloWorld);
	}

}
