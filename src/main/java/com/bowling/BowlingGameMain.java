/**
 * 
 */
package com.bowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bowling.game.config.IBowlingGame;

/**
 * @author Richard
 *
 */
@Component
public class BowlingGameMain {

	@Autowired
	private IBowlingGame bowlingGame;

	public void run() {
		bowlingGame.startGame();
	}

}
