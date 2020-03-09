/**
 * 
 */
package com.bowling.game.config.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bowling.game.config.IBowlingGame;
import com.bowling.game.entity.Player;
import com.bowling.game.service.IBowlingGameService;
import com.bowling.game.util.IFileLoad;

/**
 * @author Richard
 *
 */
@Component
public class BowlingGame implements IBowlingGame {

	@Autowired
	private IFileLoad ifileLoad;
	@Autowired
	private IBowlingGameService bowlingGameService;

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(BowlingGame.class.getName());

	@Override
	public void startGame() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			log.info("\nIngrese la ruta del archivo: ");
			String url = reader.readLine();
			Path filePath = Paths.get(url);
			List<Player> playerLst = bowlingGameService.findResults(ifileLoad.loadFile(filePath));
			if (!playerLst.isEmpty()) {
				bowlingGameService.printResults(playerLst);
			}else {
				log.severe("La informacion del archivo no es la correcta");
			}
		} catch (IOException e) {
			log.severe("Error ===> " + e.getStackTrace());
		}
	}

}
