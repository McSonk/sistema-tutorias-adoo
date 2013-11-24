package util.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class ChainedInvocationHandler
		implements InvocationHandler {

	private InvocationHandler nextHandler;

	public void setNextHandler(InvocationHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (canHandle(proxy, method, args ))
			return handle(proxy, method, args);
		else
			return invokeNextHandler(proxy, method, args);
	}

	private Object invokeNextHandler(Object proxy, Method method,
	                                 Object[] args) throws Throwable {
		if (nextHandler != null)
			return nextHandler.invoke(proxy, method, args);
		return null;
	}

	public abstract boolean canHandle(Object proxy,
	                                  Method method,
	                                  Object[] args ) throws Throwable;

	public abstract Object handle(Object proxy,
	                              Method method,
	                              Object[] args) throws Throwable;

}

