import java.util.Iterator;
import java.util.Stack;

/**
 * Implementation of the Binary Search Tree abstract data structure
 * which stores Strings and key-value pairs as a linked list.
 */
public class BST
{
    private Node root;

    /**
     * Inner class which models the abstract data structure of a binary node
     */
    private class Node
    {
        private String key;
        private int val;
        private Node left, right;

        public Node(String k, int value) {
            key = k;
            val = value;
        }
    }

    /**
     * Inner class which iterates over the keys in a Binary Search Tree in order
     */
    private class BSTIterator implements Iterator<String>
    {
        private Stack<Node> stack = new Stack<>();

        private void pushLeft(Node x)
        {
            while (x != null)
            {
                stack.push(x);
                x = x.left;
            }
        }

        /**
         * Stores keys a Binary Search tree in order
         */
        BSTIterator()
        {
            pushLeft(root);
        }

        /**
         * Checks whether the iterator has reached the end of the tree's ordered key list
         * @return Boolean true if a larger key than the previously iterated key exists
         */
        public boolean hasNext()
        {
            return !stack.isEmpty();
        }

        /**
         * Returns the next key in the tree's ordered key list
         * @return The next key in the tree's ordered key list
         */
        public String next()
        {
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public Integer get(String key)
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
     */
    public void put(String key)
    {
        root = put(root, key, 0);
    }

    /**
     *
     * @param x
     * @param key
     * @param val
     * @return
     */
    private Node put(Node x, String key, Integer val)
    {
        if (x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);
        val++;

        if      (cmp < 0) x.left  = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val = val;

        return x;
    }

    /**
     *
     * @return
     */
    public Iterator<String> iterator()
    {
        return new BSTIterator();
    }

    /**
     *
     * @param x
     */
    public void visit(Node x)
    {
        if (x == null) return;
        visit(x.left);
        System.out.println(x.key);
        visit(x.right);
    }

    public static void main(String[] args)
    {
        String[] words = {"it", "was", "the", "best", "of", "times", "yet"};
        BST tree = new BST();

        for (String word : words)
        {
            tree.put(word);
        }

        Iterator<String> iterator = tree.iterator();

        while(iterator.hasNext())
        {
            String next = iterator.next();
            System.out.println(next + " : " + tree.get(next));
        }
    }
}
