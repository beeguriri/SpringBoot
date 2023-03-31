package edu.pnu.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogDAO implements LogDAO {

	
	
	@Override
	public void addLog(String method, String sqlstring, boolean tf) {
		
		try {
			String filePath = "C:/workspace/SpringBoot/Mission4-1/src/Log.txt";
			
			File file = new File(filePath);
			if(!file.exists())
				file.createNewFile();
		
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			
			bw.write(method + "		");
			bw.write(sqlstring + "		");
			bw.write(String.valueOf(tf) + "		");
			bw.write(String.valueOf(new Date()));
			bw.newLine();
			
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
