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

            this.firstPter = newNode;
            this.currectPter = this.firstPter;

        } catch (Exception e) {
            throw new Exception("Al insertar el nodo, Intentelo de nuevo!...");
        }

        return true;
    }

    public boolean beginningDelete() throws Exception {
        boolean result = true;
        try {
            // Handle empty list case
            if (this.empty()) {
                result = false;
            } else {
                // Delete nextPointer of the first node
                this.currectPter = this.firstPter.getNextPter();
                this.firstPter = null;
                this.firstPter = this.currectPter;
            }

        } catch (Exception e) {
            throw new Exception("Al insertar el nodo, Intentelo de nuevo!...");
        }

        return result;
    }

    public boolean endInsert(int value) throws Exception {

        try {
            // Create node
            Node newNode = new Node();
            newNode.setInfo(value);

            // Handle empty list case
            if (this.empty()) {
                this.firstPter = newNode;
            } else {
                // Initialize current pointer
                currectPter = this.firstPter;

                // Go through the whole list to find the last node
                while (this.currectPter.getNextPter() != null) {
                    this.currectPter = this.currectPter.getNextPter();
                }

                // Set the next pointer of the last node to the new node
                currectPter.setNextPter(newNode);
            }
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
