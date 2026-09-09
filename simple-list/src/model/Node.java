
package model;


public class Node {
    private int info;
    private Node nextPter;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNextPter() {
        return nextPter;
    }

    public void setNextPter(Node nextPter) {
        this.nextPter = nextPter;
    }

    public Node() {
        this.info = 0;
        this.nextPter = null;
    }
}
