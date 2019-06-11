public class BinarySearchTree <Key extends Comparable, Value>{
    BSTNode root;

    private class BSTNode{
        Key key;
        Value value;

        BSTNode left;
        BSTNode right;

        BSTNode(Key k, Value v){
            key = k;
            value = v;
        }
    }

    //insertion
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    private BSTNode insert(BSTNode x, Key key, Value value){
        if (x == null) return new BSTNode(key, value);
        int cmp = x.key.compareTo(key);

        if (cmp < 0)
            x.left = insert(x.left, key, value);
        else if (cmp >0)
            x.right = insert(x.right, key, value);
        else
            x.value = value;

        return x;
    }

    //deletion
    public void delete(Key key){
        root = delete(root, key);
    }

    private BSTNode delete(BSTNode node, Key key){
        if (node == null) return null;
        if (key == null) return node;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else{
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            BSTNode temp = node;
            node = min(node.right);
            node.right = delMin(temp.right);
            node.left =temp.left;
        }
        return node;
    }

    private BSTNode min(BSTNode n){
        if (n.left == null) return n;
        return min(n.left);
    }

    private BSTNode delMin(BSTNode node){
        if (node.left == null) return node.right;
        node.left = delMin(node.left);
        return node;

    }
    //search

}
