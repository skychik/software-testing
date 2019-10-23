package ru.ifmo.cs.software_testing.lab1.domain_model;

import java.rmi.UnexpectedException;
import java.util.Timer;
import java.util.TimerTask;

public class DomainModel {
	static int TIME_TO_LIVE = 5000;
	static int TIME_TO_REALIZE = 10000;
	static int TOTAL_TIME = 12000;
	private final static String FACT = "I am whale";
	private static Whale whale;

	public static void main(String[] args) {
		try {
			Timer timer = new Timer(true);
			TimerTask killWhale = new TimerTask() {
				@Override
				public void run() {
					try {
						whale.die();
						System.out.println("Whale died ;(");
					} catch (UnexpectedException e) {
						e.printStackTrace();
					}
				}
			};
			TimerTask realizeItselfAWhale = new TimerTask() {
				@Override
				public void run() {
					try {
						if (whale.isAlive()) {
							whale.beAwareOf(FACT);
							System.out.println(FACT);
						}
						System.out.println("Couldn't beAwareOf such fact: " + FACT);
					} catch (UnexpectedException e) {
						e.printStackTrace();
					}
				}
			};

			System.out.println("Whale appears");
			whale = new Whale(true, Position.NOT_NORMAL);
			timer.schedule(killWhale, TIME_TO_LIVE);

			System.out.println("Whale starts realizing itself as a whale");
			whale.beginToUnderstand(FACT);
			timer.schedule(realizeItselfAWhale, TIME_TO_REALIZE);
		} catch (UnexpectedException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(TOTAL_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("whale awarenesses=" + whale.getFactAwarenesses().toString());
	}
}
