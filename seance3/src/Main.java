public class Main {
  public static void main(String[] args){
    Tree l1 = new Tree(1);
    Tree l3 = new Tree(3);
    Tree l5 = new Tree(5);
    Tree l7 = new Tree(7);
    Tree l3v2 = new Tree(3);

    Tree t2 = new Tree(2, new Tree[]{l1, l3});
    Tree t2v2 = new Tree(2, new Tree[]{l1, l3v2});
    Tree t6 = new Tree(6, new Tree[]{l7});
    
    Tree t4 = new Tree(4, new Tree[]{t2, l5, t6});
    Tree t1 = new Tree(1, new Tree[]{t2, l5, t6,t4});

    System.out.println(Trees.nbrLeaves(t4));
    
    
    Tree[] ls = Trees.flattenLeaves(t4);
    System.out.println("Les " + ls.length + " feuilles");
    int i = 0;
    while(i != ls.length) {
      System.out.println(ls[i].getValue());
      i++;
    }

    System.out.println("Path V1");    
    Trees.pathV1(l7);

    System.out.println("Path V2");    
    Trees.pathV2(l7);

    System.out.println("Nbr nodes =>");
    System.out.println(Trees.nbrNode(t2));
    System.out.println(Trees.nbrNode(t4));

    System.out.println("Min =>");
    System.out.println(Trees.min(t4));
    System.out.println(Trees.min(t1));

    System.out.println("Seum =>");
    System.out.println(Trees.sum(t4));
    System.out.println(Trees.sum(t1));

    System.out.println("Equals =>");
    System.out.println("False => " + Trees.equals(t4,t1));
    System.out.println("True =>" + Trees.equals(t2,t2v2));

  }
}
