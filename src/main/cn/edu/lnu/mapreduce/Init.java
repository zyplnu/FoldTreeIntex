package cn.edu.lnu.mapreduce;

import java.io.*;
import java.util.*;

/**
 * 通过MapReduce函数，初始化图，并通过后续函数进行可达判断
 */
public class Init {

    public static Map<Integer, List<Integer>> initGraph(){
        Map<Integer , List<Integer>> map = new HashMap<>();
        File file = new File("D:/out.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] str = line.split("\t");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                List<Integer> list = new ArrayList<>();
                if(!map.containsKey(start)){
                    boolean flag = list.add(end);
                    if(flag){
                        map.put(start , list);
                    }
                }else {
                    list = map.get(start);
                    list.add(end);
                    map.put(start , list);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    static Map<Integer , List<Integer>> map;

    public static void main(String[] args) {
        map = initGraph();

        String flag = "no";

        while (true){
            Scanner scanner1 = new Scanner(System.in);
            int start = scanner1.nextInt();
            Scanner scanner2 = new Scanner(System.in);
            int end = scanner2.nextInt();

            try {
                query(start , end);
                System.out.println(flag);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        /*Graph graph = new Graph().createGraph(map);
        for(int i = 0; i < graph.getVertexNodes().length; i++){
            System.out.print(graph.getVertexNodes()[i].getData());
            EdgeNode edge = graph.getVertexNodes()[i].getFirst();
            while(edge != null){
                System.out.print("->" + edge.getVertex().getData());
                edge = edge.getNext();
            }
            System.out.println();
        }*/

    }

    /**
     * 判断两点之间是否可达
     * @description 迭代中当找到两点存在可达时，直接退出所有循环，通过throw exception来实现
     * @param start
     * @param end
     * @throws Exception
     */
    public static void query(int start , int end) throws Exception {
        List<Integer> list = new ArrayList<>();
        if(map.containsKey(start)){
            list = map.get(start);
        }
        if(!list.isEmpty()){
            if(list.contains(end)){
                throw new Exception("can");
            }else{
                for(int i = 0; i < list.size(); i++){
                    query(list.get(i) , end);
                }
            }
        }
        return;
    }
}
