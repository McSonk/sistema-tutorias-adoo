package util.pojo;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>This awesome class has methods that returns object(s) that has
 * implemented all the setter's and getter's of a {@link POJO} interface.
 * <p>The interface must have the usual getXXX(), isXXX() and setXXX()
 * methods and the behavior of those methods is the expected one.
 * <p>A setter method should have a void return type, however if the
 * return type is declared as the same type as the interface, then
 * the same object will be returned.
 * <p>The code was taken and rewritten from this
 * <a href="http://alturl.com/fdwt9">POJOS for the lazy</a>
 * @see
 * 	{@link POJO}
 * 	{@link MappedPOJOHandler}
 */
public class POJOInstantiator {

	/**
	 * <p>Returns an List of POJO objects with an indicated size
	 * @param subInterface the interface class that is intended to be
	 * implemented in all the objects
	 * @param numberOfInstances
	 * @return List<T>
	 */
	public static <T extends POJO> List<T> newList(
			Class<T> subInterface, int numberOfInstances) {
		List<T> list = new ArrayList<T>(numberOfInstances);
		while(numberOfInstances-- != 0)
			list.add(newInstance(subInterface));
		return list;
	}

	/**
	 * <p>Returns a single instance of the POJO interface
	 * @param subInterface class of the interface
	 * @return instance of a POJO interface
	 */
	public static <T extends POJO> T newInstance(Class<T> subInterface) {
		int numberOfDeclaredMethods = subInterface
			.getDeclaredMethods().length;
		return getMapBackedImplementation(
			subInterface,
			new HashMap<String, Object>(numberOfDeclaredMethods)
		);
	}

	private static <T extends POJO> T getMapBackedImplementation(
			Class<T> interfaceClass,
			Map<String, Object> container) {
		return interfaceClass.cast(
			Proxy.newProxyInstance(
				interfaceClass.getClassLoader(),
				new Class[] { interfaceClass },
				new MappedPOJOHandler(container,
				                      interfaceClass)
			)
		);
	}

}

