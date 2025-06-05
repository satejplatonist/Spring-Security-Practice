package main;

public class Main 
{
  public static void main(String[] args) 
  {
	  MyTree tree = new MyTree();
	  tree.add(null, 10);
      // Now the tree looks like:
      //      (10)
      //
	  MyTree.Node rootRef = tree.findNodeByValue(10);
      tree.add(rootRef, 20);
      tree.add(rootRef, 30);
      tree.add(rootRef, 40);
      //
      // Now the tree is:
      //        (10)
      //       /  |   \
      //    (20) (30) (40)
      //
      MyTree.Node node20 = tree.findNodeByValue(20);
      tree.add(node20, 21);
      tree.add(node20, 22);
      MyTree.Node node30 = tree.findNodeByValue(30);
      tree.add(node30, 31);
      //
      // Final structure:
      //           (10)
      //        /    |     \
      //     (20)  (30)   (40)
      //     /   \     \
      //  (21)  (22)  (31)
      //
      System.out.println("===== BFS from root =====");
      tree.bfs();
      System.out.println("=== BFS from node 20 sub‐tree ===");
      tree.bfs(node20);
      System.out.println("===== DFS from root =====");
      tree.dfs();
      System.out.println("=== DFS from node 20 sub‐tree ===");
      tree.dfs(node20);
      
      System.out.println("findNodeByValue(31): " + tree.findNodeByValue(31).getValue());
      MyTree.Node missing = tree.findNodeByValue(999);
      System.out.println("findNodeByValue(999) returned: " + missing);
      boolean present20 = tree.isPresent(node20);
      System.out.println("node20 present? " + present20); // true
      MyTree.Node fake = new MyTree.Node(555);
      System.out.println("Removing leaf 31...");
      tree.remove(31);
      System.out.println("After removing 31, BFS shows:");
      tree.bfs();
      tree.clear();
      System.out.println("After clear(), try BFS—(nothing should print):");
      tree.bfs();
      tree.add(null, 50);
      MyTree.Node newRoot = tree.findNodeByValue(50);
      tree.add(newRoot, 20);
      tree.add(newRoot, 75);
      tree.add(tree.findNodeByValue(20), 10);
      tree.add(tree.findNodeByValue(20), 30);
      tree.add(tree.findNodeByValue(75), 60);
      tree.add(tree.findNodeByValue(75), 80);
      
      System.out.println("Height of tree: " + tree.height());
      
      System.out.println("=== Leaf‐Order Traversal ===");
      tree.leafOrderTraversal();

      int minimum = tree.min();
      int maximum = tree.max();
      System.out.println("Minimum value in tree: " + minimum); // should print 10
      System.out.println("Maximum value in tree: " + maximum); // should print 80

      int[] pair = tree.minmax();
      System.out.println("minmax array: [" + pair[0] + ", " + pair[1] + "]");
      tree.clear();
      System.out.println("Done with all methods.");
      
  }
}
