package com.vornetran.marc;

/**
 * Created by Marc on 21.05.2015.
 */
public class Visitors {

    private static int visitors = 0;

    public static void count(){
        visitors++;
    }

    public static int get(){
        return visitors;
    }

}
