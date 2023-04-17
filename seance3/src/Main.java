public class Main {
  public static void main(String[] args){
    Tree l9v2 = new Tree(9);
    Tree l1 = new Tree(1);
    Tree l1v2 = new Tree(1, new Tree[]{l9v2});
    Tree l3 = new Tree(3);
    Tree l5 = new Tree(5);
    Tree l5v2 = new Tree(5);
    Tree l7 = new Tree(7);
    Tree l7v2 = new Tree(7);
    Tree l3v2 = new Tree(3);
    Tree l9 = new Tree(9);


    Tree t2 = new Tree(2, new Tree[]{l1, l3});
    Tree t2v2 = new Tree(2, new Tree[]{l1v2, l3v2});
    Tree t6 = new Tree(6, new Tree[]{l7});
    Tree t6v2 = new Tree(6, new Tree[]{l7v2});

    Tree t4 = new Tree(4, new Tree[]{t2v2, l5, t6v2});
    Tree t1 = new Tree(1, new Tree[]{t2, l5v2, t6,t4});

    
    
    Tree[] ls = Trees.flattenLeaves(t4);
    System.out.println("Les " + ls.length + " feuilles");
    int i = 0;
    while(i != ls.length) {
      System.out.println(ls[i].getValue());
      i++;
    }

    System.out.println("Path V1");    
    Trees.pathV1(l7);

    System.out.println("----------------------------");

    System.out.println("Path V2");    
    Trees.pathV2(l7);

    System.out.println("----------------------------");

    System.out.println("Nbr nodes =>");
    System.out.println("3 => " + Trees.nbrNode(t2));
    System.out.println(" 7 => " + Trees.nbrNode(t4));

    System.out.println("----------------------------");

    System.out.println("Min =>");
    System.out.println("1 => " + Trees.min(t4));
    System.out.println("1 => " + Trees.min(t1));

    System.out.println("----------------------------");

    System.out.println("Seum =>");
    System.out.println("6 => " + Trees.sum(t2));
    System.out.println("53 => "+Trees.sum(t1));

    System.out.println("----------------------------");

    System.out.println("Equals =>");
    System.out.println("False => " + Trees.equals(t4,t1));
    System.out.println("True =>" + Trees.equals(t2,t2v2));

    System.out.println("----------------------------");

    System.out.println("Depth =>");
    System.out.println("2 => " + Trees.depth(l3));
    System.out.println("3 => " + Trees.depth(l1v2));

    System.out.println("----------------------------");

    System.out.println("sameOne =>");
    System.out.println("true => " + Trees.sameOne(l1,l5v2));
    System.out.println("false => " + Trees.sameOne(l3,l9));

    System.out.println("----------------------------");

    System.out.println("4 2 1 3 5 6 7 =>");
    Trees.dfsPrint(t4);

    System.out.println("----------------------------");

    System.out.println("4 2 5 6 1 3 7 9 =>");
    Trees.bfsPrint(t4);

    System.out.println("----------------------------");

    System.out.println("PrintPathV1 =>");
    Trees.printPathV1(l9v2);

    System.out.println("----------------------------");

    System.out.println("PrintPathV2 =>");
    Trees.printPathV2(l9v2);
  }
}
