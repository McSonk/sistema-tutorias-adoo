package util.reflection;

import java.lang.reflect.Method;

public class PrimitiveDefaults {
	// These gets initialized to their default values
	private static boolean DEFAULT_BOOLEAN;
	private static byte DEFAULT_BYTE;
	private static short DEFAULT_SHORT;
	private static int DEFAULT_INT;
	private static long DEFAULT_LONG;
	private static float DEFAULT_FLOAT;
	private static double DEFAULT_DOUBLE;

	public static boolean hasPrimitiveReturnType(Method method) {
		return method.getReturnType().isPrimitive();
	}

	public static Object getDefaultReturnValue(Method method) {
		return getDefaultReturnValue(method.getReturnType());
	}

	public static Object getDefaultReturnValue(Class<?> clazz) {
		if (clazz.equals(boolean.class)) {
			return DEFAULT_BOOLEAN;
		} else if (clazz.equals(byte.class)) {
			return DEFAULT_BYTE;
		} else if (clazz.equals(short.class)) {
			return DEFAULT_SHORT;
		} else if (clazz.equals(int.class)) {
			return DEFAULT_INT;
		} else if (clazz.equals(long.class)) {
			return DEFAULT_LONG;
		} else if (clazz.equals(float.class)) {
			return DEFAULT_FLOAT;
		} else if (clazz.equals(double.class)) {
			return DEFAULT_DOUBLE;
		} else {
			throw new IllegalArgumentException(
				  "Class type " + clazz + " not supported");
		}
	}
	
	public static boolean getDefaultBoolean() {
		return DEFAULT_BOOLEAN;
	}
	
	public static byte getDefaultByte() {
		return DEFAULT_BYTE;
	}
	
	public static short getDefaultShort() {
		return DEFAULT_SHORT;
	}
	
	public static int getDefaultInt() {
		return DEFAULT_INT;
	}
	
	public static long getDefaultLong() {
		return DEFAULT_LONG;
	}
	
	public static float getDefaultFloat() {
		return DEFAULT_FLOAT;
	}
	
	public static double getDefaultDouble() {
		return DEFAULT_DOUBLE;
	}

}

