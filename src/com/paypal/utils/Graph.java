package com.paypal.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
    ArrayList<String> vertices;
    ArrayList<ArrayList<Integer>> edges;

    public Graph() {
        vertices = new ArrayList<String>();
        edges = new ArrayList<ArrayList<Integer>>();

    }

    public ArrayList<String> getVertexList(){
        return vertices;
    }
    public ArrayList<String> getVertices() {
        return vertices;
    }

    public ArrayList<ArrayList<Integer>> getEdges() {
        return edges;
    }

    public void addVertex(String word) {
        if(!vertexExists(word)) {
            vertices.add(word);
            edges.add(new ArrayList<Integer>());
        }


    }

    public boolean vertexExists(String word) {
        for(String s: vertices) {
            if(s.equals(word))
                return true;
        }
        return false;
    }

    public void addEdge(String word1, String word2) {

        if(!vertexExists(word1)) addVertex(word1);
        if(!vertexExists(word2)) addVertex(word2);

        if(edges.get(vertices.indexOf(word1)).indexOf(vertices.indexOf(word2)) < 0) {
            edges.get(vertices.indexOf(word1)).add(vertices.indexOf(word2));
            edges.get(vertices.indexOf(word2)).add(vertices.indexOf(word1));
        }
    }

    boolean DFSUtil(String curr, String dest, boolean visited[], ArrayList<String> path) {
        // Mark the current node as visited and print it
        visited[vertices.indexOf(curr)] = true;
        if(curr.equals(dest)) {
            path.add(curr);
            return true;
        }

        // Recur for all the vertices adjacent to this vertex
        ArrayList<Integer> adjVertIdx = edges.get(vertices.indexOf(curr));
        for(int i: adjVertIdx) {
            if(!visited[i]) {
                if (DFSUtil(vertices.get(i), dest, visited, path)) {
                    path.add(curr);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> dfs(String src, String dest)
    {


        boolean visited[] = new boolean[vertices.size()];

        ArrayList<String> path = new ArrayList<String>();
        if(vertexExists(dest))
            DFSUtil(src, dest, visited, path);
        return path;
    }


    public void printGraph()
    {
        for(int i=0;i<edges.size();i++)
        {
            ArrayList<Integer> temparray = edges.get(i);
            for(int j=0;j<temparray.size();j++)
            {
                System.out.print(vertices.get(temparray.get(j))+" ");
            }
            System.out.println();

        }
    }

}
