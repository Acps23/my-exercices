package io.codeforall.fanstatics;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp implements Iterable<String>{

    private String STRING;
    private int counterNumber = 0;
    private HashMap<String,Integer> histogram;
    public WordHistogramComp(String STRING){
        this.STRING = STRING;
        this.histogram = new HashMap<>();
        for (String word:STRING.split(" ")){
            if(this.histogram.containsKey(word)) {
                counterNumber=this.histogram.get(word);

            }
            this.histogram.put(word,++counterNumber);
            counterNumber=0;


        }

    }

    public int size(){
    return this.histogram.size();
    }

    @Override
    public Iterator iterator() {
        return this.histogram.keySet().iterator();
    }

    public Integer get(String word) {
        return this.histogram.get(word);
    }
}
