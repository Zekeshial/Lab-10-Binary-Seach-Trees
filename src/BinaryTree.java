public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node find(Integer v) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while(curr != null && curr.getData() != v) {
            if (v < curr.getData()) {
                curr = curr.getLeftNode();
            } else {
                curr = curr.getRightNode();
            }
        }
        return curr;
    }

    public void insert(Integer v) {
        if (root == null) {
            root = new Node(v);
            return;
        } else {
            Node par = null;
            Node curr = root;
            while (curr != null) {
                if (v <= curr.getData()) {
                    par = curr;
                    curr = curr.getLeftNode();
                } else {
                    par = curr;
                    curr = curr.getRightNode();
                }
            }
            if (v <= par.getData()) {
                par.setLeftNode(new Node(v));
                return;
            } else {
                par.setRightNode(new Node(v));
                return;
            }
        }
    }

    public boolean remove(Integer v) {
        if (root == null) {
            return false;
        }
        if (root.getData() == v) {

        }
    }


}
