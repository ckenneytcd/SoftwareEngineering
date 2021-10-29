// Code is has been modified from algs4.cs.princeton.edu 

import java.io.*;
import java.util.*;

public class LCAjava
{
    private static int V = 0;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    
    public LCAjava(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
        this.V = V;
        
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    public int V() {
        return V;
    }  
    
    public int E() {
        return E;
    }
    
    public Bag<Integer> adj(int v) {
        return adj[v];
    }  
	    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }
    
    
    public static int getLCA(LCAjava G, int s, int z) {
    	System.out.println("VCHECK: " + V);
    	if(s >= V || z  >= V) return -1;
    	
    	Stack<Integer> pathS = new Stack<Integer>();
    	Stack<Integer> pathZ = new Stack<Integer>();
    	
		//Get the nodes that have a path to s
		for (int v = 0; v < G.V(); v++) {
			System.out.println("v: " + v);
			BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G, v);
            if (bfs.hasPathTo(s) && s != v) {
                pathS.push(v);
                System.out.println(v + " has path to " + s);
                System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else        System.out.print("->" + x);
                }
                System.out.println();
            }
        }
		
		//Get the nodes that have a path to z
		for (int v = 0; v < V; v++) {
			BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G, v);
            if (bfs.hasPathTo(z) && z != v) {
                pathZ.push(v);
                System.out.println();
            }
        }
		
		System.out.println("PathS: " + Arrays.toString(pathS.toArray()));
		System.out.println("PathZ: " + Arrays.toString(pathZ.toArray()));
		
		if(pathZ.isEmpty()||pathS.isEmpty()) {
			return -1;
		}
		else {
			int sSize  = pathS.size();
			int zSize  = pathZ.size();
			//if there is a path from x to s and x to z, the most recent x is the LCA
			for (int i = 0; i < sSize; i++) {
				int S = pathS.pop();
				Stack<Integer> pathZCopy = (Stack<Integer>) pathZ.clone();
				
				//System.out.println("S=" + S + " size=" +pathS.size());
				//System.out.println("PathZ: " + Arrays.toString(pathZ.toArray()));
				
				for (int j = 0; j < zSize; j++) {
					int Z = pathZCopy.pop();
					//System.out.println("PathZ: " + Arrays.toString(pathZ.toArray()));
					
					//System.out.println("?" + S + "=" + Z);
					if(S == Z) {
						//System.out.println("LCA of " + s + " and " + z + " is "+ S + ".");
						return S;
					}
					
				}
				
			}
		}
		return -1;


	}


	
}

