package controller;

import java.io.File;

public class commondata {
	private static File[] fileOfRoots = null;
	private static int numOfFileNames = 0;
	private static final String fileSaveName = "D:\\Program Files\\"; //必须是路径，不能是文件夹
	
	public static String getfileSaveName(){
		return fileSaveName;
	}
	
	public static int getNumOfFileNames(){
		return numOfFileNames;
	}
	
	public static void plussNumOfFileNames(){
		numOfFileNames++;
	}
	
	public static void setRoots(File[] file) {
		fileOfRoots = file;
	}

	public static File[] getRoots() {
		return fileOfRoots;
	}
}
