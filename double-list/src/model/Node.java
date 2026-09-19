
package model;

public class Node {
    private Node leftLink;
    private int info;
    private Node rightLink;

    public Node getleftLink() {
        return leftLink;
    }

    public void setleftLink(Node leftLink) {
        this.leftLink = leftLink;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getRightLink() {
        return rightLink;
    }

    public void setRightLink(Node rightLink) {
        this.rightLink = rightLink;
    }

    public Node() {
        this.leftLink = null;
        this.info = 0;
        this.rightLink = null;
    }
}
