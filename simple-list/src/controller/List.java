package controller;

import model.Node;

public class List {

    private Node firstPter;
    private Node currectPter;

    public List() {
        this.currectPter = this.firstPter = null;
    }

    private boolean empty() {
        return this.firstPter == null;
    }

    public void initializeCurrent() {
        this.currectPter = this.firstPter;
    }

    public boolean insertHead(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);

            if (!this.empty()) {
                newNode.setNextPter(firstPter);
            }

            this.currectPter = this.firstPter = newNode;

        } catch (Exception e) {
            throw new Exception("Al insertar el nodo, Intentelo de nuevo!...");
        }

        return true;
    }

    public boolean beginningInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);

            if (!this.empty()) {
                newNode.setNextPter(firstPter);
            }

            this.currectPter = this.firstPter = newNode;

        } catch (Exception e) {
            throw new Exception("Al insertar el nodo, Intentelo de nuevo!...");
        }

        return true;
    }

    public int through() throws Exception {
        int result = 0;
        try {
            if (this.currectPter == null || this.empty()) {
                return result;
            } else {
                result = this.currectPter.getInfo();
                this.currectPter = this.currectPter.getNextPter();
            }

        } catch (Exception e) {
            throw new Exception("Al recorrer la lista!...");
        }

        return result;
    }

    public boolean destroy() throws Exception {
        boolean result = false;
        try {

            if (!this.empty()) {
                Node previewPter = null;

                while (this.currectPter != null) {
                    previewPter = this.currectPter;
                    this.currectPter = this.currectPter.getNextPter();
                    previewPter.setNextPter(null);
                    this.firstPter = this.currectPter;
                    result = true;
                }
                previewPter = null;
            }
        } catch (Exception e) {
            throw new Exception("Al recorrer la lista!...");
        }
        return result;
    }

}
