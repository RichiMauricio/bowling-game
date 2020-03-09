/**
 * 
 */
package com.bowling.game.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bowling.game.entity.Player;
import com.bowling.game.entity.ScoreVO;

/**
 * @author Richard
 *
 */
@Service
public class BowlingGameService implements IBowlingGameService {

	private static final java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(BowlingGameService.class.getName());

	@Override
	public List<Player> findResults(List<String> fileLst) {
		try {
			List<String> playersNames = new ArrayList<>();
			List<Player> playerLst = new ArrayList<>();
			fileLst.stream().forEach(line -> {
				String[] parts = line.split("\t");
				playersNames.add(parts[0]);
			});
			List<String> distinctPlayers = playersNames.stream().distinct().collect(Collectors.toList());
			distinctPlayers.stream().forEach(distinctPlayer -> {
				Player newPlayer = new Player();
				List<Integer> scores = new ArrayList<>();
				fileLst.stream().forEach(line -> {
					String[] parts = line.split("\t");
					if (parts[0].equals(distinctPlayer)) {
						scores.add("F".equals(parts[1]) ? 0 : Integer.parseInt(parts[1]));
					}
				});
				newPlayer.setNombre(distinctPlayer);
				ScoreVO scroresFrame = score(scores);
				newPlayer.setScoresFrame(scroresFrame.getScoresFrame());
				newPlayer.setScoresFrameValue(scroresFrame.getScoresFrameValue());
				newPlayer.setFinalScore(scroresFrame.getScoresFrame().get(scroresFrame.getScoresFrame().size() - 1));
				playerLst.add(newPlayer);
			});
			return playerLst;
		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	@Override
	public ScoreVO score(List<Integer> rolls) {

		int score = 0;
		int frame = 0;
		List<Integer> scoresFrame = new ArrayList<>();
		List<String> scoresFrameValue = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (isStrike(frame, rolls)) {
				score += 10 + strikeBonus(frame, rolls);
				scoresFrameValue.add("\tX");
				frame++;
			} else if (isSpare(frame, rolls)) {
				score += 10 + spareBonus(frame, rolls);
				scoresFrameValue.add(rolls.get(frame) + "\t/");
				frame += 2;
			} else {
				score += sumOfRolls(frame, rolls);
				scoresFrameValue.add(rolls.get(frame) + "\t" + rolls.get(frame + 1));
				frame += 2;
			}
			scoresFrame.add(score);
		}
		ScoreVO scoresVO = new ScoreVO();
		scoresVO.setScoresFrame(scoresFrame);
		scoresVO.setScoresFrameValue(scoresFrameValue);
		return scoresVO;
	}

	/**
	 * @param playerLst
	 */
	@Override
	public void printResults(List<Player> playerLst) {
		List<String> frame = loadFrames();
		log.info("Frame\t" + Arrays.toString(frame.toArray()).replace("[", "").replace("]", "").replace(",", ""));
		playerLst.stream().forEach(player -> {
			List<String> scoreString = new ArrayList<>();
			player.getScoresFrame().forEach(score -> scoreString.add("\t" + score));
			log.info(player.getNombre());
			log.info("Pinfalls\t" + Arrays.toString(player.getScoresFrameValue().toArray()).replace("[", "")
					.replace("]", "").replace(",", ""));
			log.info("Score\t"
					+ Arrays.toString(scoreString.toArray()).replace("[", "").replace("]", "").replace(",", ""));
		});
	}

	/**
	 * @return
	 */
	private List<String> loadFrames() {
		List<String> frame = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			frame.add("\t" + i);
		}
		return frame;
	}

	private boolean isStrike(int frame, List<Integer> rolls) {
		try {
			return rolls.get(frame) == 10;
		} catch (IndexOutOfBoundsException iobe) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean isSpare(int frame, List<Integer> rolls) {
		return sumOfRolls(frame, rolls) == 10;
	}

	private int strikeBonus(int frame, List<Integer> rolls) {
		return sumOfRolls(frame + 1, rolls);
	}

	private int spareBonus(int frame, List<Integer> rolls) {
		return rolls.get(frame + 2);
	}

	private int sumOfRolls(int frame, List<Integer> rolls) {
		return rolls.get(frame) + rolls.get(frame + 1);
	}

}
