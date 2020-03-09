package com.bowling.game.entity;

import java.util.List;

/**
 * @author Richard
 *
 */
public class ScoreVO {

	private List<Integer> scoresFrame;
	private List<String> scoresFrameValue;

	public List<Integer> getScoresFrame() {
		return scoresFrame;
	}

	public void setScoresFrame(List<Integer> scoresFrame) {
		this.scoresFrame = scoresFrame;
	}

	public List<String> getScoresFrameValue() {
		return scoresFrameValue;
	}

	public void setScoresFrameValue(List<String> scoresFrameValue) {
		this.scoresFrameValue = scoresFrameValue;
	}

}
