public class Trees {

    // *******************************************************
    // Un premier exemple: le nombre de feuilles d'un arbre
    // *******************************************************
    public static int nbrLeaves(Tree t) {
        int r;
        if (t.isLeaf()) {
            r = 1;
        } else {
            r = 0;
            for (Tree child : t) {
                r += nbrLeaves(child);
            }
        }
        return r;
    }

    // *******************************************************
    // Un deuxième exemple: aplanir un arbre
    // *******************************************************
    public static Tree[] flattenLeaves(Tree t) {
        int nl = nbrLeaves(t);
        Tree[] r = new Tree[nl];
        flattenLeaves(t, r, 0);
        return r;
    }

    private static int flattenLeaves(Tree t, Tree[] a, int idx) {
        int r;
        if (t.isLeaf()) {
            a[idx] = t;
            r = 1;
        } else {
            r = 0;
            for (Tree child : t) {
                r += flattenLeaves(child, a, idx + r);
            }
        }
        return r;
    }

    // *******************************************************
    // Un troisième exemple:
    // tous les algorithmes ne sont pas récursifs
    // *******************************************************
    public static void pathV1(Tree t) {
        System.out.println(t.getValue());
        if (t.getParent() != null) {
            pathV1(t.getParent());
        }
    }

    public static void pathV2(Tree t) {
        while (t != null) {
            System.out.println(t.getValue());
            t = t.getParent();
        }
    }

    // *******************************************************
    // Exercices 1
    // *******************************************************

    // 1.1)
    public static int nbrNode(Tree t) {
        int cmpt = 1;
        if (t.isLeaf())
            return 1;
        for (Tree child : t) {
            cmpt += nbrNode(child);
        }
        return cmpt;
    }

    // 1.2)
    public static int min(Tree t) {
        int min = t.getValue();

        for (Tree child : t) {
            int minChild = min(child);
            if (minChild < min) min = minChild;
        }
        return min;
    }

    // 1.3)
    public static int sum(Tree t) {
        int sum = t.getValue();

        for (Tree child : t) {
            sum += sum(child);
        }
        return sum;
    }

    // 1.4)
    public static boolean equals(Tree t1, Tree t2) {
        if (t1.getValue() != t2.getValue() || t1.nbrChildren() != t2.nbrChildren()) return false;
        for (int i = 0; i < t1.nbrChildren(); i++) {
            if (!equals(t1.getChildren()[i], t2.getChildren()[i])) return false;
        }
        return true;
    }

    // 1.5)
    public static int depth(Tree n) {
        return 42;
    }

    // 1.6)
    public static boolean sameOne(Tree n1, Tree n2) {
        return true;
    }

    // 1.7)
    public static void dfsPrint(Tree t) {
    }

    // 1.8)
    public static void bfsPrint(Tree t) {
    }

    // *******************************************************
    // Exercices 2
    // *******************************************************

    // 2.1)
    static void printPathV1(Tree node) {
    }

    // 2.2)
    static void printPathV2(Tree node) {
    }

    // 2.3
    static void printPathV3(Tree t, int v) {
    }

    // *******************************************************
    // Exercices 3
    // *******************************************************

    // 3.1
    public static int[][] toArray(Tree t) {
        return null;
    }

    // 3.2
    public static Tree toTree(int[][] t) {
        return null;
    }

    // *******************************************************
    // Exercices 4
    // *******************************************************

    public static Tree lca(Tree n1, Tree n2) {
        return null;
    }
}