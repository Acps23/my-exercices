package io.codeforall.fanstatics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class UniqueWord implements Iterable<String>{
    HashSet<String> set;
    public UniqueWord (String STRING){
        this.set = new HashSet<>(List.of(STRING.split(" ")));
    }
    @Override
    public Iterator iterator() {
        return set.iterator();
    }
}
