import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;
import java.math.*;
import java.io.*;
public class algorithm {
    static class Edge {
        public int  to, cost;
        public Edge(int to, int cost) {

            this.to = to;
            this.cost = cost;
        }
    }
    static class pairs {
        public int from, to;

        public pairs(int from, int to) {
            this.from = from;
            this.to = to;
        }


    }
        static final int inf  = Integer.MAX_VALUE;
        static int num_stations = 67;
        static int n, s ,np, f = 0;
        static boolean used[];
        static int dist [];
        static int cost[][];
        static int parent[];
        static int mass[];
        static int stations_to_change[];
        static String[] stations ={
                //red one
                "Девяткино",//0
                "Гражданский проспект",//1
                "Академическая",//2
                "Политехническая",//3
                "Площадь Мужества",//4
                "Лесная",//5
                "Выборгская",//6
                "Площадь Ленина",//7
                "Чернышевская",//8
                "Площадь Восстания",//9
                "Владимирская",//10
                "Пушкинская",//11
                "Технологический институт-1",//12
                "Балтийская",//13
                "Нарвская",//14
                "Кировский завод",//15
                "Автово",//16
                "Ленинский проспект",//17
                "Проспект Ветеранов",//18

                //blue one
                "Парнас",//19
                "Проспект Просвещения",//20
                "Озерки",//21
                "Удельная",//22
                "Пионерская",//23
                "Чёрная речка",//24
                "Петроградская",//25
                "Горьковская",//26
                "Невский проспект",//27
                "Сенная площадь",//28
                "Технологический институт - 2",//29
                "Фрунзенская",//30
                "Московские ворота",//31
                "Электросила",//32
                "Парк Победы",//33
                "Московская",//34
                "Звёздная",//35
                "Купчино",//36


                //green one
                "Приморская",//37
                "Василеостровская",//38
                "Гостиный двор",//39
                "Маяковская",//40
                "Площадь Александра Невского - 1",//41
                "Елизаровская",//42
                "Ломоносовская",//43
                "Пролетарская",//44
                "Обухово",//45
                "Рыбацкое",//46


                //purple one
                "Комендантский проспект",//47
                "Старая Деревня",//48
                "Крестовский остров",//49
                "Чкаловская",//50
                "Спортивная",//51
                "Адмиралтейская",//52
                "Садовая",//53
                "Звенигородская",//54
                "Обводный канал",//55
                "Волковская",//56
                "Бухарестская",//57
                "Международная",//58


                //yellow one
                "Улица Дыбенко",//59
                "Проспект Большевиков",//60
                "Ладожская",//61
                "Новочеркасская",//62
                "Площадь Александра Невского - 2",//63
                "Лиговский проспект",//64
                "Достоевская",//65
                "Спасская"//66


        };

       /* static void dijkstra(int s, List<Edge>[] graph, int []dist, int[] parent) {
           // dist[s] = 0;
            Queue<Edge> q = new PriorityQueue<Edge>();
            q.add(new Edge(s, 0));
            //System.out.println(q.element().to + " "+q.element().cost);
            while(!q.isEmpty()) {
                Edge current_vertex = q.poll();

                if(dist[current_vertex.to] != inf) {

                    continue;
                }

                dist[current_vertex.to] = current_vertex.cost;
                for (Edge e:graph[current_vertex.to]) {
                    int per = dist[current_vertex.to] + e.cost;
                    if (dist[e.to] > per) {
                        dist[e.to] = per;

                        parent[e.to] = current_vertex.to;
                        int p = e.to;
                        q.add(((Edge) per << 32 )+e.to);
                        for (int i = 0; i < num_stations; ++i) {

                        }
                    }
                }

            }
*/





    static void dijkstra(int s, List<Edge>[] graph, int []dist, int[] parent, boolean []used) {
            dist[s] = 0;
            for(int i = 0;i < num_stations; ++i) {
                int v = -1;
                for (int j = 0;j < num_stations; ++j) {
                    if (!used[j] && (v == -1 || dist[j] < dist[v]))
                        v = j;
                }
                if (dist[v] == inf) {
                    break;
                }
                used[v] = true;
                for (Edge e:graph[v]) {
                    int to = e.to;
                    int cost = e.cost;
                    if (dist[v] + cost < dist[to]) {
                        dist[to] = dist[v]+ cost;
                        parent[to]  = v;
                    }
                }
            }
        }
        public static void main(String[] b) {
            Scanner in = new Scanner(System.in);
            String station1, station2;
            station1 = in.nextLine();
            station2 = in.nextLine();
            int num_station1 = 0;
            int num_station2 = 0;

            for (int i = 0;i<stations.length;++i) {
                if (stations[i].equals(station1)) {
                    num_station1 = i;
                }
                if (stations[i].equals(station2)) {
                    num_station2 = i;
                }
            }
            cost = new int[num_stations][num_stations];
            for (int i =0;i<num_stations;++i) {
                for (int j =0;j<num_stations;++j) {
                    cost[i][j] = 0;
                }
            }
            cost[0][1] = 3;cost[1][2] = 6;cost[2][3] = 2;cost[3][4] = 3;cost[4][5] = 3;cost[5][6] = 3;cost[6][7] = 2;
            cost[7][8] = 3;cost[8][9] = 2;cost[9][40] = 2;cost[9][10] = 2;cost[10][65] = 2;cost[10][11] = 2;
            cost[11][54] = 2;cost[11][12] = 2;cost[12][29] = 1;cost[12][13] = 2;cost[13][14]= 3;cost[14][15] = 4;
            cost[15][16] = 2;cost[16][17] = 3;cost[17][18] = 2;cost[19][20] = 3;cost[20][21] = 2;cost[21][22] = 3;
            cost[22][23] = 3;cost[23][24] = 3;cost[24][25] = 4;cost[25][26] = 2;cost[26][27] = 4;cost[27][39] = 2;
            cost[27][28] = 2;cost[28][66] = 3;cost[28][53] = 3;cost[28][29] = 3;cost[29][30] = 2;cost[30][31] = 2;
            cost[31][32] = 2;cost[32][33] = 2;cost[33][34] = 3;cost[34][35] = 4;cost[35][36] = 3;cost[37][38] = 4;
            cost[38][39] = 4;cost[39][28] = 4;cost[39][40] = 3;cost[40][9] = 2;cost[40][41] = 3;cost[41][63] = 2;
            cost[41][42] = 5;cost[42][43]=3;cost[43][44] = 3;cost[44][45] = 3;cost[45][46] = 4;cost[47][48] = 3;
            cost[48][49] = 3;cost[49][50] = 4;cost[50][51] =2;cost[51][52] = 3;cost[52][53] = 3;cost[53][66] = 3;
            cost[53][54] = 4;cost[54][55] = 3;cost[55][56] = 3;cost[56][57] = 3;cost[57][58] = 3;cost[59][60]=2;
            cost[60][61] = 3;cost[61][62 ] =3;cost[62][63] = 3;cost[63][64] = 2;cost[64][65] = 2;cost[65][66] = 4;
            for (int i = 0;i<cost.length;++i) {
                for (int j = 0;j<cost.length;++j) {
                    if (cost[i][j] != 0) {
                        cost[j][i] = cost[i][j];
                    }
                }
            }

            List<Edge> [] graph = new List[num_stations];


            for (int i =0;i < num_stations;++i) {
                graph[i] = new ArrayList<Edge>();
                for (int j =0;j<num_stations;++j) {
                    if (cost[i][j] != 0) {


                        graph[i].add(new Edge(j, cost[i][j]));
                    }
                }

            }

           dist = new int[num_stations];
            parent  = new int[num_stations];
            used = new boolean[num_stations];
            for (int i = 0; i < num_stations; i++) {
                dist[i] = inf;
                used[i] = false;
                parent[i] = -1;
            }

            stations_to_change = new int [18];

            stations_to_change[0] = 27; stations_to_change[1] = 39;
            stations_to_change[2] = 9; stations_to_change[3] = 40;
            stations_to_change[4] = 41; stations_to_change[5] = 63;
            stations_to_change[6] = 10; stations_to_change[7]= 65;
            stations_to_change[8] = 11; stations_to_change[9] = 54;
            stations_to_change[10] = 12; stations_to_change[11] = 29;
            stations_to_change[12] = 28; stations_to_change[13] = 53;
            stations_to_change[14] = 28; stations_to_change[15] = 66;
            stations_to_change[16] = 53; stations_to_change[17] = 66;


           dijkstra(num_station1, graph, dist, parent , used);
            if (dist[num_station2] == inf) {
                System.out.println("Вы никак не сможете приехать куда запланировалли, поэтому дойдите пешком");
            } else {
                System.out.println("Вы потратите столько времени : " + dist[num_station2]);
                int current_vertex = num_station2;
                Stack path = new Stack();
                System.out.println("Самый оптимальный путь : ");
                int fl = -1;
                do {
                    path.push(current_vertex);
                    current_vertex = parent[current_vertex];
                } while(current_vertex != -1);
                while(!path.empty()) {
                    String just_parse = path.peek().toString();
                    int p = Integer.parseInt(just_parse);
                    for (int i = 0;i<stations_to_change.length;i += 2) {
                        if (stations_to_change[i] == fl && stations_to_change[i+1] == p ||
                                stations_to_change[i+1] == p && stations_to_change[i] == fl) {
                            System.out.println("Нужно перейти на другую линию");
                        } else {
                            continue;
                        }
                    }
                    fl = p;

                    System.out.println(stations[p]);
                    path.pop();
                }
            }
        }
}
