package com.mime.minefront;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.mime.minefront.Display;

public class Configuration {
	Properties properties = new Properties();

	public void saveConfigurtion(String key, int value) {
		String path = "/settings/config.xml";
		try {

			File file = new File(path);
			boolean exists = file.exists();
			if (!exists) {
				file.createNewFile();
			}
			OutputStream write = new FileOutputStream(path);
			properties.setProperty(key, Integer.toString(value));
			properties.storeToXML(write, "Resolution");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void loadConfiguration(String path) {

		try {

			InputStream read = new FileInputStream(path);
			properties.loadFromXML(read);
			String width = properties.getProperty("width");
			String height = properties.getProperty("height");
			setResolution(Integer.parseInt(width), Integer.parseInt(height));

		} catch (FileNotFoundException e) {

			saveConfigurtion("width", 800);
			saveConfigurtion("height", 600);
			loadConfiguration(path);
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void setResolution(int width, int height) {

		Display.height = width;
		Display.height = height;
	}
}
