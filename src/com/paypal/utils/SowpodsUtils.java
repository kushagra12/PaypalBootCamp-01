package com.paypal.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SowpodsUtils {

    public static boolean areOneDiffApart(String s1, String s2){
        int count = 0;

        if(s1.length() == s2.length())
            for(int i = 0; i < s1.length(); i++) {
                if( (s1.charAt(i) != s2.charAt(i) )) {
                    if(count > 0) {
                       return false;
                    }
                    count++;
                }
            }

       if(count == 1)
           return true;

        return false;

    }

    public static List<String> getSowPodsList(){

        if(SowpodStore.getInstance().getSowpodList() != null)
            return SowpodStore.getInstance().getSowpodList();

        List<String> sowpodsList = new ArrayList<>();
        File file = new File("./src/com/paypal/sowpods.txt");

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                sowpodsList.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SowpodStore.getInstance().setSowpodList(sowpodsList);

        return sowpodsList;
    }

    public static boolean isWordInSowpods(String s){
        List<String> sowpodsList = getSowPodsList();

        if(sowpodsList.indexOf(s) > -1)
            return true;

        return false;
    }

    public static void main(String[] args){
        List<String> sowpodsList = getSowPodsList();
        isWordInSowpods("THE");
        areOneDiffApart("THE", "TEE");
    }
}
