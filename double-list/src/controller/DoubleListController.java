package controller;

import model.Node;

public class DoubleListController {

    private Node firsPter;
    private Node currentPter;
    private Node targetPter;
    private Node lastPter;

    public DoubleListController() {
        this.firsPter = null;
        this.currentPter = null;
        this.targetPter = null;
        this.lastPter = null;
    }

    // Empty List Validator
    private boolean emptyNodeList() {
        return this.firsPter == null && this.lastPter == null;
    }

    // Only one existing node validator
    private boolean onlyOneNode() {
        return this.firsPter == this.lastPter;
    }

    // Find Node by Reference
    public Node findByReference(int reference) throws Exception {
        Node result = new Node();
        resetCurrentPointer();

        if (emptyNodeList()) {
            result = null;
        } else {
            resetCurrentPointer();
            targetPter = null;

            while (targetPter == null) {

                // Target Pointer as a Flag
                if (this.currentPter.getInfo() == reference) {
                    targetPter = currentPter;
                }

                currentPter = currentPter.getRightLink();
            }

            result = targetPter;
        }

        return result;
    }

    // Start Position
    public void resetCurrentPointer() {
        this.currentPter = this.firsPter;
    }

    public boolean leftInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);

            if (this.emptyNodeList()) {
                this.firsPter = newNode;
                this.lastPter = newNode;
            } else {
                this.firsPter.setleftLink(newNode);
                newNode.setRightLink(this.firsPter);
                this.firsPter = this.firsPter.getleftLink();
            }
        } catch (Exception e) {
            throw new Exception("No se logro ingresar el valor!...");
        }

        return true;
    }

    public boolean insertBeforeReference(Node referenceNode, int value) throws Exception {
        boolean result = true;
        try {
            // Existing Reference Case
            if (referenceNode != null) {
                // Only One Node Case
                if (onlyOneNode()) {
                    leftInsert(value); // Recursive call

                } else {
                    // Multiple Nodes Case
                    Node newNode = new Node();
                    newNode.setInfo(value);

                    // First Pointer
                    if (referenceNode == firsPter) {
                        // Find Nodes
                        this.currentPter = firsPter;

                        // Replace Pointers
                        this.currentPter.setleftLink(newNode);
                        newNode.setRightLink(currentPter);

                        // Reset Pointers
                        firsPter = newNode;
                        resetCurrentPointer();
                    } else {
                        // Find Nodes
                        this.currentPter = referenceNode;
                        this.targetPter = this.currentPter.getleftLink();

                        // Replace Pointers
                        this.currentPter.setleftLink(newNode);
                        this.targetPter.setRightLink(newNode);
                        newNode.setleftLink(targetPter);
                        newNode.setRightLink(currentPter);

                        // Reset Pointers
                        resetCurrentPointer();
                        targetPter = null;
                    }
                }
            } else {
                result = false;
            }
        } catch (Exception e) {
            throw new Exception("No se logro ingresar el valor!...");
        }

        return result;
    }

    public boolean rightInsert(int value) throws Exception {
        try {
            Node newNode = new Node();
            newNode.setInfo(value);

            if (this.emptyNodeList()) {
                this.firsPter = newNode;
                this.lastPter = newNode;
            } else {
                this.lastPter.setRightLink(newNode);
                newNode.setleftLink(this.lastPter);
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
            if (this.currentPter == null || this.emptyNodeList()) {
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

            if (!this.emptyNodeList()) {
                this.targetPter = null;

                while (this.currentPter != null) {
                    this.targetPter = this.currentPter;
                    this.targetPter.setRightLink(null);
                    this.currentPter.setleftLink(null);
                    this.currentPter = this.currentPter.getRightLink();
                    this.firsPter = this.currentPter;
                    result = true;
                }
                this.targetPter = null;
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
            if (!this.emptyNodeList()) {
                this.targetPter = null;

                while (this.currentPter != null) {
                    if ((this.currentPter.getInfo() == reference)
                            && (this.currentPter.getleftLink() == null)
                            && (this.currentPter.getRightLink() == null)) {
                        this.lastPter = this.currentPter = this.firsPter = null;
                        value = reference;
                    } else if (this.firsPter.getInfo() == reference) {
                        this.firsPter.getRightLink().setleftLink(null);
                        this.targetPter = this.firsPter;
                        this.firsPter = this.firsPter.getRightLink();
                        this.targetPter.setRightLink(null);
                        this.targetPter = null;
                        this.currentPter = this.firsPter;
                        value = reference;
                    } else if (this.currentPter.getInfo() == reference) {
                        this.targetPter.setRightLink(this.currentPter.getRightLink());
                        this.currentPter.setleftLink(null);
                        if (this.currentPter.getRightLink() != null) {
                            this.currentPter.getRightLink().setleftLink(this.targetPter);
                        }
                        if (this.targetPter.getRightLink() == null) {
                            this.lastPter = this.targetPter;
                        }
                        this.targetPter = this.currentPter;
                        this.currentPter = this.currentPter.getRightLink();
                        this.targetPter.setRightLink(null);
                        value = reference;
                    } else {
                        this.targetPter = this.currentPter;
                        this.currentPter = this.currentPter.getRightLink();
                    }
                }
            }
            return value;
        } catch (Exception e) {
            throw new Exception("No se logro recorrer la lista!...");
        }
    }

    // Delete the first node in the list
    public boolean deleteFirstNode() throws Exception {
        boolean result = true;
        try {
            if (this.emptyNodeList()) {
                result = false;

            } else if (this.onlyOneNode()) { // If there is only one node in the list, set all pointers to null
                this.firsPter = null;
                this.lastPter = null;
                this.targetPter = null;
                this.currentPter = null;
            } else { // If there are multiple nodes in the list, remove the first node and update the
                     // pointers accordingly
                // Restart the current pointer to the first node
                resetCurrentPointer();

                // Get the next node after the current pointer
                this.targetPter = this.currentPter.getRightLink();

                // Disconnect the current pointer from the list and set the target pointer's
                // left link to null
                this.currentPter.setRightLink(null);
                this.targetPter.setleftLink(null);
                ;

                // Reset Pointers
                this.firsPter = this.targetPter;
                resetCurrentPointer();
                this.targetPter = null;
            }
        } catch (Exception e) {
            throw new Exception("No se logro ingresar el valor!...");
        }

        return result;
    }

    // Delete the last node in the list
    public boolean deleteLastNode() throws Exception {
        boolean result = true;
        try {
            if (this.emptyNodeList()) {
                result = false;

            } else if (this.onlyOneNode()) { // If there is only one node in the list, set all pointers to null
                this.firsPter = null;
                this.lastPter = null;
                this.targetPter = null;
                this.currentPter = null;
            } else { // If there are multiple nodes in the list, remove the last node and update the
                     // pointers accordingly
                // Find the previous node to the last node
                this.targetPter = this.lastPter.getleftLink();

                // Clean Node Pointers
                this.lastPter.setleftLink(null);
                this.targetPter.setRightLink(null);

                // Reset Pointers
                this.lastPter = this.targetPter;
                this.targetPter = null;
            }
        } catch (Exception e) {
            throw new Exception("No se logro ingresar el valor!...");
        }

        return result;
    }

}
