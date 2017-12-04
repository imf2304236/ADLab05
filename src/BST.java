/**
 * ADLab05
 * Created by IF on 04.12.17.
 */
public class BST <Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
//        private int N;

//        public Node(Key key, Value val, int N) {
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
//            this.N = N;
        }
    }

/*
    public int size()
    {
        return size(root);
    }
*/

/*
    private int size(Node x)
    {
        if (x == null) return 0;
        else           return x.N;
    }
*/

/*
    public Value get(Key key)
    {
        return get(root, key);
    }
*/

/*
    private Value get(Node x, Key key)
    {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
*/

    private Value get(Key key)
    {
        Node x = root;

        while(x != null)
        {
            int cmp = key.compareTo(x.key);

            if (cmp == 0)     return x.val;
            else if (cmp < 0) x = x.left;
            else              x = x.right;
        }
        return null;
    }

    /**
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }

/*
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) x.left  = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val = val;

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }
*/

    /**
     *
     * @param x
     * @param key
     * @param val
     * @return
     */
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) x.left  = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val = val;

        return x;
    }
}
