package controller;

import model.Node;

public class DoubleListController {

    private Node firsPter;
    private Node currentPter;
    private Node lastPter;

    public DoubleListController() {
        this.firsPter = null;
        this.currentPter = null;
        this.lastPter = null;
    }

    // First Node
    private boolean emptyNodePointers() {
        return this.firsPter == null && this.lastPter == null;
    }

    // Start Position
    public void resetCurrentPointer() {
        this.currentPter = this.firsPter;
    }

    public boolean leftInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);

            if (this.emptyNodePointers()) {
                this.firsPter = newNode;
                this.lastPter = newNode;
            } else {
                this.firsPter.setLefLink(newNode);
                newNode.setRightLink(this.firsPter);
                this.firsPter = this.firsPter.getLefLink();
            }
        } catch (Exception e) {
            throw new Exception("No se logro ingresar el valor!...");
        }

        return true;
    }

    public boolean rightInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);

            if (this.emptyNodePointers()) {
                this.firsPter = newNode;
                this.lastPter = newNode;
            } else {
                this.lastPter.setRightLink(newNode);
                newNode.setLefLink(this.lastPter);
                this.lastPter = this.lastPter.getRightLink();
            }
        } catch (Exception e) {
            throw new Exception("No se logro ingresar el valor!...");
        }

        return true;
    }
    
    public int through() throws Exception {
        int result = 0;
        try {
            if (this.currentPter == null || this.emptyNodePointers()) {
                return result;
            } else {
                result = this.currentPter.getInfo();
                this.currentPter = this.currentPter.getRightLink();
            }

        } catch (Exception e) {
            throw new Exception("Al recorrer la lista!...");
        }

        return result;
    }    
    
    public boolean destroy() throws Exception {
        boolean result = false;
        try {

            if (!this.emptyNodePointers()) {
                Node previousPter = null;
                
                while ( this.currentPter != null ){
                    previousPter = this.currentPter;
                    previousPter.setRightLink(null);
                    this.currentPter.setLefLink(null);
                    this.currentPter = this.currentPter.getRightLink();                    
                    this.firsPter = this.currentPter;
                    result = true;
                }
                previousPter = null;
                this.lastPter = null;
            }
        } catch (Exception e) {
            throw new Exception("Al recorrer la lista!...");
        }
        return result;
    }    
    
    public int removeNodes(int reference) throws Exception {
        int value = 0;
        try {
            if (!this.emptyNodePointers()) {
                Node previousPter = null;

                while (this.currentPter != null) {
                    if ((this.currentPter.getInfo() == reference)
                            && (this.currentPter.getLefLink() == null)
                            && (this.currentPter.getRightLink() == null)) {
                        this.lastPter = this.currentPter = this.firsPter = null;
                        value = reference;
                    } else if (this.firsPter.getInfo() == reference) {
                        this.firsPter.getRightLink().setLefLink(null);
                        previousPter = this.firsPter;
                        this.firsPter = this.firsPter.getRightLink();
                        previousPter.setRightLink(null);
                        previousPter = null;
                        this.currentPter = this.firsPter;
                        value = reference;
                    } else if (this.currentPter.getInfo() == reference) {
                        previousPter.setRightLink(this.currentPter.getRightLink());
                        this.currentPter.setLefLink(null);
                        if (this.currentPter.getRightLink() != null) {
                            this.currentPter.getRightLink().setLefLink(previousPter);
                        }
                        if (previousPter.getRightLink() == null) {
                            this.lastPter = previousPter;
                        }
                        previousPter = this.currentPter;
                        this.currentPter = this.currentPter.getRightLink();
                        previousPter.setRightLink(null);
                        value = reference;
                    } else {
                        previousPter = this.currentPter;
                        this.currentPter = this.currentPter.getRightLink();
                    }
                }
            }
            return value;
        } catch (Exception e) {
            throw new Exception("No se logro recorrer la lista!...");
        }
    }
    

}
