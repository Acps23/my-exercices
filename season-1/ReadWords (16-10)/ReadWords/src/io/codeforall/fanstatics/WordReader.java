package io.codeforall.fanstatics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class WordReader implements Iterable<String>{
    private String org = "rsc/TESTE.rtf";
    private FileInputStream in = new FileInputStream(org);


    public WordReader(String FILE_PATH) throws FileNotFoundException {
        String line = "";
        String result = "";



    }
    @Override
    public Iterator<String> iterator() {
        return null;
    }

}
