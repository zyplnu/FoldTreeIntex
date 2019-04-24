package cn.edu.lnu.pojo;

/**
 * 边节点类
 */
public class EdgeNode {

    private VertexNode vertex;
    private EdgeNode next;

    public VertexNode getVertex() {
        return vertex;
    }

    public void setVertex(VertexNode vertex) {
        this.vertex = vertex;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "EdgeNode{" +
                "vertex=" + vertex +
                ", next=" + next +
                '}';
    }
}
