package cn.edu.lnu.pojo;

import java.util.*;

/**
 * 图类
 */
public class Graph {

    private static Integer VERTEX_NUM = 0;//节点数目

    private static Integer EDGE_NUM = 0;

    private VertexNode[] vertexNodes;//节点数组

    /**
     * 创建graph
     * @param map
     * @return 逻辑视图
     */
    public Graph createGraph(Map<Integer , List<Integer>> map){
        VERTEX_NUM = map.size();
        vertexNodes = new VertexNode[VERTEX_NUM];
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>();
        for(Integer i : set){//为了将map中的值循环赋给vertexNode而做的set-->list映射
            list.add(i);
            EDGE_NUM += map.get(i).size();
        }
        for (int i = 0; i < VERTEX_NUM; i++){//设置点表
            vertexNodes[i] = new VertexNode();
            vertexNodes[i].setData(list.get(i));
            vertexNodes[i].setFirst(null);
        }

        for(int s = 0; s < VERTEX_NUM ; s++){
            if(!map.containsKey(list.get(s))){
                continue;
            }else{
                for (int n = 0; n < map.get(list.get(s)).size(); n++){
                    EdgeNode edge =  new EdgeNode();
                    edge.setVertex(new VertexNode());
                    edge.getVertex().setData(map.get(list.get(s)).get(n));
                    edge.setNext(vertexNodes[s].getFirst());
                    vertexNodes[s].setFirst(edge);
                }
            }
        }
        return this;
    }

    public VertexNode[] getVertexNodes() {
        return vertexNodes;
    }

    public void setVertexNodes(VertexNode[] vertexNodes) {
        this.vertexNodes = vertexNodes;
    }

}
