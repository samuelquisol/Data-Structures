
package model;

public class Node {
    private Node lefLink;
    private int info;
    private Node rightLink;

    public Node getLefLink() {
        return lefLink;
    }

    public void setLefLink(Node lefLink) {
        this.lefLink = lefLink;
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
        this.lefLink = null;
        this.info = 0;
        this.rightLink = null;
    }
}
