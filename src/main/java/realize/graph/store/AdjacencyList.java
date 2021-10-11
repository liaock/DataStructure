package realize.graph.store;

import realize.linkedList.LinkedList;

/**
 * Created by dell on 2021/10/7.
 *
 * 邻接表.
 */
public class AdjacencyList {
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public AdjacencyList(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
}
