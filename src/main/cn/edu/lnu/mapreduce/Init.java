package cn.edu.lnu.mapreduce;

import cn.edu.lnu.pojo.EdgeNode;
import cn.edu.lnu.pojo.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void main(String[] args) {
        Map<Integer , List<Integer>> map = initGraph();
        Graph graph = new Graph().createGraph(map);
        for(int i = 0; i < graph.getVertexNodes().length; i++){
            System.out.print(graph.getVertexNodes()[i].getData());
            EdgeNode edge = graph.getVertexNodes()[i].getFirst();
            while(edge != null){
                System.out.print("->" + edge.getVertex().getData());
                edge = edge.getNext();
            }
            System.out.println();
        }
    }
}
