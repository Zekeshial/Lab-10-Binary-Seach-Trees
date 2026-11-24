import java.util.Objects;

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
        while(curr != null && !Objects.equals(curr.getData(), v)) {
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
        Node parent = null;
        Node curr = root;

        while (curr != null && !curr.getData().equals(v)) {
            parent = curr;
            curr = (v < curr.getData()) ? curr.getLeftNode() : curr.getRightNode();
        }
        if (curr == null) return false;  // not found

        // Two children: replace data with successor's, then remove successor instead
        if (curr.getLeftNode() != null && curr.getRightNode() != null) {
            Node succParent = curr;
            Node succ = curr.getRightNode();
            while (succ.getLeftNode() != null) {
                succParent = succ;
                succ = succ.getLeftNode();
            }
            curr.setData(succ.getData());
            parent = succParent;
            curr = succ;            // now remove succ, which has at most a right child
        }

        // Zero or one child
        Node child = (curr.getLeftNode() != null) ? curr.getLeftNode() : curr.getRightNode();

        if (parent == null) {
            root = child;
        } else if (parent.getLeftNode() == curr) {
            parent.setLeftNode(child);
        } else {
            parent.setRightNode(child);
        }
        return true;
    }




    // Method to print the tree inorder
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeftNode());
            System.out.print(root.getData() + " ");
            inorderRec(root.getRightNode());
        }
    }

    private Node findParentNextBiggest(Node curr) {
        Node next = curr.getRightNode();
        while (next.getLeftNode() != null) {
            curr = next;
            next = next.getLeftNode();
        }
        return curr;
    }

    public Node getRoot() {
        return root;
    }

    public int heightIterative() {
        if (root == null) {
            return 0;
        }
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node n = queue.poll();
                if (n.getLeftNode() != null) queue.add(n.getLeftNode());
                if (n.getRightNode() != null) queue.add(n.getRightNode());
            }
        }
        return height;
    }
}
