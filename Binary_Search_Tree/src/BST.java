public class BST {

    Node root;

    public void addNode(int key, String value) {
        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key == focusNode.key) {
                    focusNode.value = newNode.value;
                    return;
                }
                if (key < parent.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public static void main(String[] args) throws Exception {
        BST the_tree = new BST();
        the_tree.addNode(50, "A");
        the_tree.addNode(25, "B");
        the_tree.addNode(15, "C");
        the_tree.addNode(30, "D");
        the_tree.addNode(75, "E");
        the_tree.addNode(85, "F");

        System.out.println(the_tree.findNode(30));
    }
}

class Node {
    int key;
    String value;

    Node leftChild;
    Node rightChild;

    Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "key: " + key + " value: " + value;
    }
}