package dev.geunho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class myCode3 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEdges = Integer.valueOf(br.readLine());
        Edge[] edges = new Edge[numberOfEdges];

        for (int i = 0; i < numberOfEdges; i++) {
            String[] edge = br.readLine().split(" ");
            edges[i] = new Edge(Integer.valueOf(edge[0]), Integer.valueOf(edge[1]));
        }

        boolean anyCyclicPath = cyclic(edges);

        System.out.println(anyCyclicPath);
    }

    public static boolean cyclic(Edge[] edges) {
        List<GraphPath> paths = new ArrayList<>();
        GraphPath current = new GraphPath();
        paths.add(current);

        // 모든 edge를 탐색해서 가능한 그래프 경로를 모두 저장한다.
        for (Edge edge : edges) {
            GraphPath next = current.addEdge(edge);
            if (current != next) {
                paths.add(next);
                current = next;
            }
        }

        // 경로를 순회하면서 cyclic인 경우 참을 반환한다.
        for (GraphPath path : paths) {
            if (path.isCyclic())
                return true;
        }

        return false;
    }
}

class Edge {
    private int from;
    private int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int from() {
        return this.from;
    }

    public int to() {
        return this.to;
    }
}

// 그래프의 한 경로를 표현한다.
class GraphPath {
    // cyclic 0 -> 1 -> 2 -> 0
    // acyclic 0 -> 1
    private List<Edge> nodes;

    public GraphPath() {
        nodes = new ArrayList<>();
    }

    public GraphPath(Edge edge) {
        nodes = new ArrayList<>();
        nodes.add(edge);
    }

    public boolean isCyclic() {
        if (nodes.size() < 2)
            return false;

        return head().from() == tail().to();
    }

    private Edge head() {
        return nodes.get(0);
    }

    private Edge tail() {
        return nodes.get(nodes.size() - 1);
    }

    public GraphPath addEdge(Edge edge) {
        if (nodes.isEmpty()) {
            nodes.add(edge);
        }
        // 새로운 엣지의 시작점이 경로 마지막의 끝점과 일치
        else if (edge.from() == tail().to()) {
            nodes.add(edge);
        }
        // 새로운 엣지의 끝점이 경로 첫 번째의 시작점과 일치
        else if (edge.to() == head().from()) {
            nodes.add(0, edge);
        }
        // 경로에 포함될 수 없다면 새로운 경로 반환
        else {
            return new GraphPath(edge);
        }

        return this;
    }
}