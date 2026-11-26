import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    // ---------- helpers ----------

    private BinaryTree treeOf(Integer... values) {
        BinaryTree t = new BinaryTree();
        for (Integer v : values) {
            t.insert(v);
        }
        return t;
    }

    private List<Integer> inorderList(BinaryTree t) {
        List<Integer> out = new ArrayList<>();
        collect(t.getRoot(), out);
        return out;
    }

    private void collect(Node n, List<Integer> out) {
        if (n == null) return;
        collect(n.getLeftNode(), out);
        out.add(n.getData());
        collect(n.getRightNode(), out);
    }

    //testing if a found not has the correct right node attached to it
    @Test
    void find() {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(70);
        bt.insert(60);
        bt.insert(80);

        Integer actual = bt.find(70).getRightNode().getData();
        Integer expected = 80;
        assertEquals(expected, actual);
    }

    //Testing if it adds nodes correctly to the left Node of a node
    @Test
    void findTest2() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(60);

        Integer actual = bt.find(80).getLeftNode().getData();
        Integer expected = 70;
        assertEquals(expected, actual);
    }

    //Testing if node that already exist in the data set get added correctly
    @Test
    void findTest3() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(60);

        Integer actual = bt.find(50).getRightNode().getData();
        Integer expected = 60;
        assertEquals(expected, actual);
    }

    //Testing if it can find the correct node
    @Test
    void findTest4() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(60);

        Integer actual = bt.find(50).getData();
        Integer expected = 50;
        assertEquals(expected, actual);
    }



    //testing if the root gets added
    @Test
    void insert() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);

        Integer actual = bt.getRoot().getData();
        Integer expected = 10;
        assertEquals(expected, actual);

    }

    //testing if a right node can be added
    @Test
    void insertTest2() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);

        Integer actual = bt.getRoot().getRightNode().getData();
        Integer expected = 60;
        assertEquals(expected, actual);
    }

    //testing if a left node can be added
    @Test
    void insertTest3() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);

        Integer actual = bt.getRoot().getLeftNode().getData();
        Integer expected = 5;
        assertEquals(expected, actual);
    }

    //testing if a subsequence node can be added
    @Test
    void insertTest4() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);

        Integer actual = bt.getRoot().getRightNode().getRightNode().getData();
        Integer expected = 80;
        assertEquals(expected, actual);
    }

    //testing if a subsequence node can be added
    @Test
    void insertTest5() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);

        Integer actual = bt.getRoot().getRightNode().getLeftNode().getData();
        Integer expected = 20;
        assertEquals(expected, actual);
    }

    //testing if a subsequence node can be added
    @Test
    void insertTest6() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);
        bt.insert(6);
        bt.insert(2);

        Integer actual = bt.getRoot().getLeftNode().getLeftNode().getData();
        Integer expected = 2;
        assertEquals(expected, actual);
    }

    //testing if a subsequence node can be added
    @Test
    void insertTest7() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);
        bt.insert(6);
        bt.insert(2);

        Integer actual = bt.getRoot().getLeftNode().getRightNode().getData();
        Integer expected = 6;
        assertEquals(expected, actual);
    }

    //testing if you get the correct root node replaced
    @Test
    void remove() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);
        bt.insert(6);
        bt.insert(2);

        bt.remove(10);

        System.out.println(bt.getRoot().getData());

        System.out.println(bt.getRoot().getRightNode().getLeftNode().getData());
        Integer actual = bt.getRoot().getData();
        Integer expected = 20;
        assertEquals(expected, actual);
    }

    //testing if the root node is replaced will the node you took get replaced correctly
    @Test
    void removeTest2() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);
        bt.insert(6);
        bt.insert(2);

        bt.remove(10);

        Integer actual = bt.getRoot().getRightNode().getLeftNode().getData();
        Integer expected = 50;
        assertEquals(expected, actual);
    }

    //testing if a node in the middle of the tree will be replaced correctly
    @Test
    void removeTest3() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);
        bt.insert(6);
        bt.insert(2);

        bt.remove(60);

        Integer actual = bt.getRoot().getRightNode().getData();
        Integer expected = 70;
        assertEquals(expected, actual);
    }

    //testing if it can correctly see if no node exists in the list to remove
    @Test
    void removeTest4() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(60);
        bt.insert(20);
        bt.insert(80);
        bt.insert(90);
        bt.insert(50);
        bt.insert(70);
        bt.insert(5);
        bt.insert(6);
        bt.insert(2);

        assertFalse(bt.remove(600));
    }

    //test below are testing the get height method for both types of get height to see if they correctly give the right height.
    @Test
    void height_emptyTree() {
        assertEquals(0, new BinaryTree().heightIterative());
    }

    @Test
    void height_singleNode() {
        assertEquals(0, treeOf(5).heightIterative());
    }

    @Test
    void height_balanced() {
        assertEquals(2, treeOf(10, 5, 15, 3, 7, 12, 20).heightIterative());
    }

    @Test
    void height_skewed() {
        assertEquals(4, treeOf(1, 2, 3, 4, 5).heightIterative());
    }

    @Test
    void height_emptyTree2() {
        assertEquals(0, new BinaryTree().getHeight());
    }

    @Test
    void height_singleNode2() {
        assertEquals(0, treeOf(5).getHeight());
    }

    @Test
    void height_balanced2() {
        assertEquals(2, treeOf(10, 5, 15, 3, 7, 12, 20).getHeight());
    }

    @Test
    void height_skewed2() {
        assertEquals(4, treeOf(1, 2, 3, 4, 5).getHeight());
    }

    @Test
    void height_skewed3() {

        BinaryTree bt = new BinaryTree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        System.out.println(bt.getHeight());
        assertEquals(4, bt.getHeight());
    }





    //Testing a balance tree
    @Test
    void findNodesNumToFindValue() {
        ArrayList<Integer> list = new ArrayList<>(List.of(10,5,15,3,7,12,20));
        BinaryTree bt = new BinaryTree();
        for (Integer i : list) {
            bt.insert(i);
        }


        double actual = bt.findAverageNodeTraversal(list);
        double expected = 2.43;
        assertEquals(expected, actual);
    }

    //Testing an unbalanced tree
    @Test
    void findNodesNumToFindValueTest2() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
        BinaryTree bt = new BinaryTree();
        for (Integer i : list) {
            bt.insert(i);
        }


        double actual = bt.findAverageNodeTraversal(list);
        double expected = 3;
        assertEquals(expected, actual);
    }

    //Testing a tree with 1 node
    @Test
    void findNodesNumToFindValueTest3() {
        ArrayList<Integer> list = new ArrayList<>(List.of(50));
        BinaryTree bt = new BinaryTree();
        for (Integer i : list) {
            bt.insert(i);
        }


        double actual = bt.findAverageNodeTraversal(list);
        double expected = 1;
        assertEquals(expected, actual);
    }

    //Testing a tree with no nodes
    @Test
    void findNodesNumToFindValueTest4() {
        ArrayList<Integer> list = new ArrayList<>(List.of());
        BinaryTree bt = new BinaryTree();
        for (Integer i : list) {
            bt.insert(i);
        }


        double actual = bt.findAverageNodeTraversal(list);
        double expected = 0;
        assertEquals(expected, actual);
    }

}