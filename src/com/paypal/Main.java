package com.paypal;
import com.paypal.utils.*;

import java.util.List;
import java.util.WeakHashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String word = "CLAY";
        word=word.toUpperCase();
        Graph G = new Graph();

        G.addVertex(word);

        //for(String s : G.getVertexList())
            System.out.print(SowpodsUtils.isWordInSowpods("CLAY"));
        for(int i=0;i<G.getVertexList().size();i++)
        {
            String temp=G.getVertexList().get(i);

            for(int j=0;j<temp.length();j++)
            {
             for(int k=0;k<26;k++)
             {
                 StringBuilder tempBuilder = new StringBuilder(temp);
                 tempBuilder.setCharAt(j,(char)((int)'A'+k));
                 String replace_word= tempBuilder.toString();

                 if(SowpodsUtils.isWordInSowpods(replace_word))
                 {  System.out.println(replace_word);
                     G.addVertex(replace_word);

                     G.addEdge(temp,replace_word);
                 }
             }
            }
        }

//        List<String> sowpodList = SowpodsUtils.getSowPodsList();
//
//        for(String s1 : sowpodList){
//            for(String s2: sowpodList){
//                G.addVertex(s1);
//                if(SowpodsUtils.areOneDiffApart(s1, s2)){
//                    G.addEdge(s1, s2);
//                }
//            }
//        }


        for(String s : G.getVertexList())
            System.out.print(s);
        G.printGraph();
        //System.out.println(G.shortestPath());



    }
}
