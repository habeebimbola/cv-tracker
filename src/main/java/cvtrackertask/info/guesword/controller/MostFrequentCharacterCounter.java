package cvtrackertask.info.guesword.controller;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacterCounter implements CharacterCounter{

    private String message;
    private Map<String, Integer> charFreq;

    public MostFrequentCharacterCounter(String message) {
        this.message = message;
        charFreq = new HashMap<>();
    }

    @Override
    public String getCharacter() {
        String result = "";
        char[] characters  = this.message.toCharArray();

        for (int index = 0; index < characters.length; index++)
        {
            if(this.charFreq.containsKey(  String.valueOf( characters[index])))
            {
               Integer count  = this.charFreq.get(String.valueOf( characters[index]));
                charFreq.put(String.valueOf( characters[index]), ++count);
            }
            else
            {
                this.charFreq.put(String.valueOf( characters[index]), 1 );
            }
        }

        for (String key: this.charFreq.keySet()) {
            this.charFreq.get(key);
        }

        return result;
    }
}
