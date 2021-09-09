/*
 * Copyright (c) 29/3/2021.
 * Created by Juan Ariza and Harrison Diaz
 * All rights reserved
 */

package persistence;

import java.io.IOException;
import java.util.Properties;

public class HandlerLanguage {
	public String fileName;
	public static String language = "undefined";
	public static Properties languageProperties;
	
	public HandlerLanguage(String fileName){
		this.fileName = fileName;
	}
	
	public void loadLanguage() throws IOException{		
		Properties handlerproperties = Utilities.generateProperties(fileName);
		language = handlerproperties.getProperty("Language");
		
		languageProperties = Utilities.generateProperties(language);
	}
	
	public void saveLanguage() throws IOException{
		Properties handlerproperties = Utilities.generateProperties(fileName);
		handlerproperties.setProperty("Language", language);
		Utilities.saveProperties( handlerproperties, fileName);
	}	
}