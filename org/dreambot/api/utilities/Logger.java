package org.dreambot.api.utilities;

import net.eternalclient.api.utilities.Log;

import java.util.function.Supplier;

public class Logger {
	public static void debug(Object object) {
		Log.debug(objToStr(object));
	}
	
	public static void debug(Supplier<Object> objectSupplier) {
		debug(objectSupplier.get());
	}
	
	public static void error(Object object) {
		Log.error(objToStr(object));
	}
	
	public static void error(Supplier<Object> objectSupplier) {
		error(objectSupplier.get());
	}
	
	public static void format(String format, Object... args) {
		Log.info(format, args);
	}
	
	public static void info(Object object) {
		Log.info(objToStr(object));
	}
	
	public static void log(Object object) {
		info(object);
	}
	
	public static void warn(Object object) {
		Log.warn(objToStr(object));
	}
	
	private static String objToStr(Object object) {
		return object != null ? object.toString() : "NULL";
	}
}
