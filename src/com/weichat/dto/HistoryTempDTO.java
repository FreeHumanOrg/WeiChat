package com.weichat.dto;

import java.io.Serializable;

import com.weichat.model.History;

public final class HistoryTempDTO implements Serializable {
	private static final long serialVersionUID = -3274613707734206083L;

	private static History historyEntity;

	public static History getHistoryEntity() {
		return historyEntity;
	}

	public static void setHistoryEntity(History historyEntity) {
		HistoryTempDTO.historyEntity = historyEntity;
	}
}
