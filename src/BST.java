/**
 * ADLab05
 * Created by IF on 04.12.17.
 */
public class BST <Key extends Comparable<Key>, Value>
{
    private Node root;

    /**
     *
     */
    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    /**
     *
     * @return
     */
    public int size()
    {
        return size(root);
    }

    /**
     *
     * @param x
     * @return
     */
    private int size(Node x)
    {
        if (x == null)
        {
            return 0;
        }
        else
        {
            return x.N;
        }
    }
}
