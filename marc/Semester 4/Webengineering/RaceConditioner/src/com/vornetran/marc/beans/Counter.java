package com.vornetran.marc.beans;

/**
 * Created by Marc on 21.05.2015.
 */
public class Counter {

    private Counter other;
    private int count = 0;

    public synchronized void increase(){
        count++;
    }

    public synchronized int getCounter(){
        return count;
    }

    public void setOther(Counter other){
        this.other = other;
    }

    public synchronized void increaseBoth(){
        this.increase();
        this.other.increase();

        try{
            Thread.sleep(1000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
