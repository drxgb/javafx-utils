package com.drxgb.javafxutils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesManager {

	public static Properties load(File path) {
		try (BufferedInputStream fs = new BufferedInputStream(new FileInputStream(path))) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			if (!create(path))
				return null;
			return load(path);
		}
	}
	
	public static boolean save(File path, Properties props) {
		try (BufferedOutputStream fs = new BufferedOutputStream(new FileOutputStream(path))) {
			props.store(fs, null);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	private static boolean create(File path) {
		try (BufferedOutputStream fs = new BufferedOutputStream(new FileOutputStream(path))) {
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
}
