/**
 * 
 */
package com.bowling.game.service;

import java.util.List;

import com.bowling.game.entity.Player;
import com.bowling.game.entity.ScoreVO;

/**
 * @author Richard
 *
 */
public interface IBowlingGameService {

	/**
	 * Encuentra los resultados del juego.
	 * 
	 * @param fileLst
	 * @return
	 */
	List<Player> findResults(List<String> fileLst);

	/**
	 * Obtener el score total de pinfall y puntuacion.
	 * 
	 * @param scores
	 * @return
	 */
	ScoreVO score(List<Integer> scores);

	/**
	 * Imprime resultados en consola.
	 * 
	 * @param playerLst
	 */
	void printResults(List<Player> playerLst);
}
