package util.pojo;

import java.lang.reflect.Method;
import java.util.Map;

import util.reflection.PrimitiveDefaults;

public class MappedPOJOHandler extends ChainedInvocationHandler {

	private Map<String,Object> container;
   
	private Class<? extends POJO> interfaceClass;

	public MappedPOJOHandler(
			Map<String,Object> container,
			Class<? extends POJO> interfaceClass) {
		this.container = container;
		this.interfaceClass = interfaceClass;
	}

	public boolean canHandle(Object proxy,
	                         Method method,
	                         Object[] args) throws Throwable {
		return container != null &&
		       method.getName()
		             .matches("^((get|is|set).*)|^toString$");
	}

	public Object handle(Object proxy, Method method, Object[] args)
		   throws Throwable {
		if (isSetterMethod(method)) {
			setObject(method, args);
		} else if (isGetterMethod(method)) {
			return getObject(method);
		} else if (isChainedSetterMethod(method)) {
			setObject(method, args);
			return proxy;
		}
		return null;
	}

	private boolean isSetterMethod(Method method) {
		return method.getName().matches("^set.*") &&
		       method.getReturnType() == void.class;
	}

	private boolean isGetterMethod(Method method) {
		return method.getReturnType() != void.class && (
		       method.getName().matches("^(get|is).*") ||
		       method.getName().matches("^toString"));
	}

	private boolean isChainedSetterMethod(Method method) {
		return method.getName().matches("^set.*") &&
				 method.getReturnType() == interfaceClass;
	}

	private void setObject(Method method, Object[] args) {
		if(args.length != 1)
			return;

		String objectName = getObjectName(method);
		setObjectInContainer(objectName, args[0]);
	}

	private Object getObject(Method method) {
		if(method.getName().equals("toString"))
			return container.toString();

		String objectName = getObjectName(method);
		Object object = getObjectFromContainer(objectName);
		if(object == null &&
		   PrimitiveDefaults.hasPrimitiveReturnType(method))
			object = PrimitiveDefaults
			         .getDefaultReturnValue(method);

		return object;
	}

	private String getObjectName(Method method) {
		return method.getName()
		       .toLowerCase()
		       .replaceFirst("^(get|is|set)(.*)", "$2");
	}

	private Object getObjectFromContainer(String objectName) {
		return container.get(objectName);
	}

	private void setObjectInContainer(String name, Object object) {
		container.put(name, object);
	}

}

