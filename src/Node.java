public class Node {
    private Integer data;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer nodeData) {
        this.data = nodeData;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Node(Integer data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }


    public Integer getData() {
        return data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
