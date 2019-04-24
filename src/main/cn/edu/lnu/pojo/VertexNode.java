package cn.edu.lnu.pojo;

/**
 * @description节点类
 * @author Administrator
 *
 */
public class VertexNode {

    private int data;
    private EdgeNode first;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public EdgeNode getFirst() {
        return first;
    }

    public void setFirst(EdgeNode first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "VertexNode{" +
                "data=" + data +
                ", first=" + first +
                '}';
    }
}
