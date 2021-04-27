package com.harsha.common;

public class Util {

    public static String secondsToMinute(int totalSecs){
       long hours = totalSecs / 3600;
       long minutes = (totalSecs % 3600) / 60;
       long seconds = totalSecs % 60;
       return String.format("%02d:%02d", minutes, seconds);
    }
}
