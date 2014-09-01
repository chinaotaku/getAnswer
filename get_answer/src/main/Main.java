package main;

import java.util.Timer;

import controller.timetask;

public class Main {
	public static void main(String[] args){
		Timer timer = new Timer();
		timetask timetask = new timetask();
		timer.schedule(timetask, 1000, 1000);
	
		while (true) {
			try {
				Thread.currentThread().sleep(100000000000000000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
