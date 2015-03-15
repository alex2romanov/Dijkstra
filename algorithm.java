import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;
import java.math.*;

public class algorithm {
        static final int inf  = Integer.MAX_VALUE;
        static int n, s ,np, f = 0;
        static boolean used[];
        static int dist [];
        static int graph[][];
        static int parent[];

        static void dijkstra(int s, int[][] graph, int []dist, boolean []used, int n, int[] parent) {
            dist[s] = 0;
            for(int i = 0;i < n; ++i) {
                int v = -1;
                for (int j = 0;j < n; ++j) {
                    if (!used[j] && (v == -1 || dist[j] < dist[v]))
                        v = j;
                }
                used[v] = true;
                for (int j = 0;j < n; ++j) {
                    if (dist[v] + graph[v][j] < dist[j] && graph[v][j] != -1) {
                        dist[j] = dist[v]+ graph[v][j];
                        parent[j]  = v;
                    }
                }
            }
        }
        public static void main(String[] b) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            s = in.nextInt() - 1;
            f = in.nextInt() - 1;
            graph = new int[n][n];
            used = new boolean[n];
            dist = new int[n];
            parent  = new int[n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    graph[i][j] = in.nextInt();
            for (int i = 0; i < n; i++) {
                dist[i] = inf;
                used[i] = false;
                parent[i] = -1;
            }
            dijkstra(s, graph, dist, used, n, parent);
            if (dist[f] == inf) {
                System.out.println("there is no way to destination point");
            } else {
                System.out.println("the best distance is: " + dist[f]);
                int current_vertex = f;
                Stack path = new Stack();
                System.out.print("the path is: ");
                do {
                    path.push(current_vertex);
                    current_vertex = parent[current_vertex];
                } while(current_vertex != -1);
                while(!path.empty()) {
                    String just_parse = path.peek().toString();
                    int p = Integer.parseInt(just_parse);
                    System.out.print(p + 1 +  " ");
                    path.pop();
                }

            }
        }
}
