package pl.kata.bowlinggame.game;

import org.springframework.stereotype.Component;

@Component
public class GameServiceDefault implements GameService {

	public String[] prepareFramesWithScores(int[] list) {
		
		String[] frames = new String[10];
		int rollTableIndex = 0;

		for (int i = 0; i < frames.length; i++) {
			
			frames[i] = list[rollTableIndex] + "/" + list[rollTableIndex + 1];
			rollTableIndex += 2;
			
			if(i>=9){
				frames[i] += "/" + list[list.length-1];
			}
		}
		return frames;
	}
}
