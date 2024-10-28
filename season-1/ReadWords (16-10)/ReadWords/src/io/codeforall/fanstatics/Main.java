package io.codeforall.fanstatics;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        WordReader wordReader = new WordReader(FILE_PATH);
        for (String word : wordReader) {
            System.out.println(word);
        }
        Iterator<String> iterator = wordReader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
