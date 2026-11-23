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
            if (root.getLeftNode() == null) {
                if (root.getRightNode() == null) {
                    root = null;
                    return true;
                } else {
                    root = root.getRightNode();
                    return true;
                }
            } else if (root.getRightNode() == null) {
                root = root.getLeftNode();
                return true;
            } else {
                Node pnb = findParentNextBiggest(root);
                if (pnb == root) {
                    root.setData(pnb.getRightNode().getData());
                    root.setRightNode(pnb.getRightNode().getRightNode());
                    return true;
                } else {
                    root.setData(pnb.getLeftNode().getData());
                    pnb.setLeftNode(pnb.getLeftNode().getLeftNode());
                    return true;
                }
            }
        } else {
            Node nodeToRemove = find(v);
            Node pnb = findParentNextBiggest(nodeToRemove);
            if (pnb == nodeToRemove) {
                nodeToRemove.setData(pnb.getRightNode().getData());
                nodeToRemove.setRightNode(pnb.getRightNode().getRightNode());
                return true;
            } else {
                nodeToRemove.setData(pnb.getLeftNode().getData());
                pnb.setLeftNode(pnb.getLeftNode().getLeftNode());
                return true;
            }

        }
    }


    // Method to print the tree inorder
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getRightNode());
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


}
