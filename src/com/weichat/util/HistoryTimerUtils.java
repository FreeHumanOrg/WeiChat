package com.weichat.util;

import java.util.Timer;

public class HistoryTimerUtils {
	Timer timer;

	public HistoryTimerUtils() {

	}

	public HistoryTimerUtils(Integer seconds) {
		getInstance();
		timer.schedule(new RemindTask(), seconds * 1000);
	}

	/**
	 * 获取Timer对象
	 * 
	 * @return
	 */
	public synchronized Timer getInstance() {
		if (null == timer) {
			timer = new Timer();
		}
		return timer;
	}
}
