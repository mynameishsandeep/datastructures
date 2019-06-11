public class UnionFind {

    int[] root;
    int components;

    UnionFind(int numberOfitems){
        root = new int[numberOfitems];
        for (int i = 0; i < numberOfitems; i ++){
            root[i] = i;
        }

        components = numberOfitems;
    }

    int getRoot(int i){

        while(root[i] != i){
            root[i] = root[root[i]];
            i = root[i];
        }

        return i;
    }

    void connect(int i, int j){
        int iRoot = getRoot(i);
        int jRoot = getRoot(j);

        root[jRoot] = iRoot;
        if (iRoot != jRoot)
            components -= 1;
    }

    boolean checkConnected(int i, int j){

        if (getRoot(i) != getRoot(j))
            return false;

        return true;
    }
}
