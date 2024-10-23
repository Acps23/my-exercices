package io.codeforall.fanstatics;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramInhe extends HashMap<String, Integer> implements Iterable<String> {

    private String STRING;
    private int counterNumber = 0;

    public WordHistogramInhe(String STRING) {
        this.STRING = STRING;
        for (String word : STRING.split(" ")) {
            if (containsKey(word)) {
                counterNumber = get(word);

            }
            put(word, ++counterNumber);
            counterNumber=0;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

}