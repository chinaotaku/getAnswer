package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copy extends Thread {
	File fileFromCopy;
	String root;
	FileInputStream fileReader;
	FileOutputStream fileWriter;

	public copy(String root) {
		this.root = root;
		fileFromCopy = new File(commondata.getfileSaveName());
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < fileFromCopy.listFiles().length; i++) {
				if (getString(fileFromCopy.listFiles()[i].getName(), "²âÊÔ½á¹û")) {
					fileReader = new FileInputStream(fileFromCopy.listFiles()[i]);
					fileWriter = new FileOutputStream(root
							+ fileFromCopy.listFiles()[i].getName());

					byte[] buffer = new byte[1024];
					int read;
					while ((read = fileReader.read(buffer, 0, 1024)) != -1) {
						fileWriter.write(buffer, 0, 1024);
					}
					fileWriter.close();
					fileReader.close();
				}
			}
			System.out.println("Íê±Ï");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean getString(String str, String s) {

		return str.matches(".*" + s + ".*");
	}
}
