package com.nt.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {

	public static boolean deleteFile(String path) {
		boolean f=false;
		
		try {
			//create the object of file
			File file=new File(path);
			//delete the file
			f   =  file.delete();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean saveFile(InputStream is , String path) {
			boolean f=false;
		
		try {
			//store the "is" data into a byte array
			byte b[]=new byte[is.available()];
			//read the data and store it into byte array "b"
			is.read(b);
			
			//write the data
			FileOutputStream fos=new FileOutputStream(path);
			
			fos.write(b);
			
			fos.flush();
			fos.close();
			f=true;	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
