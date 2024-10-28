package io.codeforall.fanstatics;

public class Main {

public static final String STRING = "test test word words test 1 10 1";

    public static void main(String[] args) {
        WordHistogramComp wordHistogram = new WordHistogramComp(STRING);
        System.out.println("MAP has "+ wordHistogram.size()+" distinct words");

        for (String word: wordHistogram) {
            System.out.println(word + " : " + wordHistogram.get(word));
        }

        WordHistogramInhe wordHistogram1 = new WordHistogramInhe(STRING);
        System.out.println("MAP has "+ wordHistogram1.size()+" distinct words");

        for (String word: wordHistogram1) {
            System.out.println(word + " : " + wordHistogram1.get(word));
        }
    }
}
