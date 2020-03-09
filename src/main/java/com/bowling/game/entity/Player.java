/**
 * 
 */
package com.bowling.game.entity;

import java.util.List;

/**
 * @author Richard
 *
 */
public class Player {

	private String nombre;
	private int finalScore;
	private List<Integer> scoresFrame;
	private List<String> scoresFrameValue;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

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
