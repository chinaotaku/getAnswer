package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class search extends Thread {
	File root;
	FileInputStream fileReader;
	FileOutputStream fileWriter;

	public search(File root) {
		this.root = root;
	}

	private void searchMethod(File file) throws IOException {
		File[] files = file.listFiles();
		File f = new File(commondata.getfileSaveName());
		if (!f.exists()) {
			f.mkdirs();
		}

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				searchMethod(files[i]);
			} else if (files[i].isFile()) {
				if (getString(files[i].getName(), "����")
						|| getString(files[i].getName(), "��ĩ")) {
					System.out.println("�ҵ�");
					fileReader = new FileInputStream(files[i]);
					File fileToSave = new File(commondata.getfileSaveName()
							+ "���Խ��" + commondata.getNumOfFileNames());
					fileWriter = new FileOutputStream(fileToSave);

					commondata.plussNumOfFileNames();
					byte[] buffer = new byte[1024];
					int read;
					while ((read = fileReader.read(buffer, 0, 1024)) != -1) {
						fileWriter.write(buffer, 0, read);
					}
					fileWriter.close();
					fileReader.close();
				}
			}
		}
		return;
	}

	public boolean getString(String str, String s) {

		return str.matches(".*" + s + ".*");
	}

	@Override
	public void run() {
		try {
			searchMethod(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
