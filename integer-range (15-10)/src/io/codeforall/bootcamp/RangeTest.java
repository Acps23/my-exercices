package io.codeforall.bootcamp;

import java.util.Iterator;

/**
 * Created by ferrao on 30/05/16.
 */
public class RangeTest {

    public static void main(String[] args) {

        Range r = new Range(3, 9);

        System.out.println("--- USING FORWARD ITERATOR ---");
        Iterator<Integer> it = r.iterator();


        for (Integer i : r) {
            System.out.println("Iterated: " + i);
            if (i == 8) {
                it.remove();
                System.out.println("removed 8");
            }
            if (it.hasNext()) {
                i = it.next();
            }
            if (i == 9) {
                it.remove();
                System.out.println("removed 9");

            }
        }

        System.out.println("--- USING NEW FORWARD ITERATOR ---");
//        Iterator<Integer> it1 = r.iterator();

        for (Integer i : r) {
            System.out.println("Iterated: " + i);

        }
    }

}

