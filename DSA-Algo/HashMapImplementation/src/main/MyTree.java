package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyTree 
{
  private Node root;
  
  private static class Node
  {
	  private int value;
	  private List<Node> children;
	  
	  public Node(int value) {
		 super();
		 this.value = value;
		 this.children = new ArrayList<Node>();
	  }
  }
  
  public void bfs()
  {
	  if(root == null ) {return;} 
	  bfsTraverse(root);  
  }
  
  public void bfs(Node node)
  {
	  if(node == null ) {return;} 
	  bfsTraverse(node);  
  }
  
  private void bfsTraverse(Node node)
  {
	  Queue<Node> queue = new LinkedList<Node>();
	  queue.add(node);
	  while(!queue.isEmpty())
	  {
		  var current = queue.poll();
		  System.out.println(current.value);
		  for (Node c : current.children) {
			 queue.add(c);
		  }
	  }
  }
  
  public void dfs()
  {
	  if(root == null) {return;}
	  dfsTraverse(root);
  }
  
  public void dfs(Node node)
  {
	  if(node == null) {return;}
	  dfsTraverse(node);
  }
  
  private void dfsTraverse(Node node)
  {
	  Stack<Node> stack = new Stack<Node>();
	  stack.add(node);
	  while(!stack.isEmpty())
	  {
		  var current = stack.pop();
		  System.out.println(current.value);
		  for (Node c : current.children) {
			  stack.push(c);
		  }
	  }
  }
  
  public void add(Node parent, int number)
  {
     if (root == null) {
	     root = new Node(number);
	     return;
	 }
	 if(parent == null) {return;}  
	 if(!isPresent(parent)) {throw new RuntimeException("No such node present");}
	 Node newNode = new Node(number);
	 parent.children.add(newNode);
  }
  
  public void remove(Node node)
  {
	  if(node == null || root == null) {
          return;
      }
	  if(root.equals(node))
	  {
		  root = null;
		  return;
	  }
	  Node parent = findParent(node);
	  if(parent==null)
	  {
		  throw new RuntimeException("Node not found in tree");
	  }
	  parent.children.remove(node);
  }
  
  public void remove(int number)
  {
	  Node node = findNodeByValue(number);
	  if(node==null) {throw new RuntimeException("Node not found in tree");}
	  remove(node);
  }
  
  public Node findNodeByValue(int number)
  {
	  Queue<Node> queue = new LinkedList<Node>();
	  if(root == null) {throw new RuntimeException("root is null no element in tree"); }
	  queue.add(root);
	  while (!queue.isEmpty()) {
		 var current = queue.poll();
		 if (current.value == number) {
             return current;
         }
		 for (Node c : current.children) {
			 if(c.value==number)
			 {
				 return c;
			 }
			 queue.add(c);
		 }
	  }
	  return null;
  }
  
  private Node findParent(Node node)
  {
	  if(node == null) {throw new RuntimeException("No such node present");}
	  Queue<Node> queue = new LinkedList<Node>();
	  if(root == null) {throw new RuntimeException("root is null no element in tree"); }
	  queue.add(root);
	  while(!queue.isEmpty())
	  {
		  var current = queue.poll();
		  for (Node c : current.children) {
			 if(c.equals(node))
			 {
				 return current;
			 }
			 queue.add(c);
		  }
	  }
	  return null;
  }
  
  public boolean isPresent(Node node)
  {
	  if (root == null || node == null) return false;
	  Queue<Node> queue = new LinkedList<Node>();
	  queue.add(root);
	  while(!queue.isEmpty())
	  {
		  var current = queue.poll();
		  if(current.equals(node))
		  {
			  return true;
		  }
		  for (Node c : current.children) {
			  queue.add(c);
		  }
	  }
	  return false;
  }
  
  public void clear()
  {
	  root = null;
  }
  
  public int height() {
      if (root == null) {
        throw new RuntimeException("root is null");
      }
      return heightRec(root);
  }


  private int heightRec(Node node) {
      if (node.children.isEmpty()) {
         return 1;
      }
      int maxChildHeight = 0;
      for (Node c : node.children) {
        int childH = heightRec(c);
        if (childH > maxChildHeight) {
            maxChildHeight = childH;
        }
      }
      return maxChildHeight + 1;
  }
  
  public void leafOrderTraversal()
  {
	  if (root == null) {return;}
	  Queue<Node> queue = new LinkedList<Node>();
	  if(root.children.size()==0)
	  {
		  System.out.println(root.value);
		  return;
	  }
	  queue.add(root);
	  while(!queue.isEmpty())
	  {
		  var current = queue.poll();
		  if(current.children.size()==0)
		  {
			  System.out.println(current.value);
		  }
		  for (Node c : current.children) {
			 queue.add(c);
		  }
	  }
  }

  
  public int min()
  {
	  int[] array = minmax();
	  if(array==null) {throw new RuntimeException("root is null");}
	  return array[0];
  }
  
  public int max()
  {
	  int[] array = minmax();
	  if(array==null) {throw new RuntimeException("root is null");}
	  return array[1];
  }
  
  public int[] minmax()
  {
	  int min = Integer.MAX_VALUE;
	  int max = Integer.MIN_VALUE;
	  Queue<Node> queue = new LinkedList<Node>();
	  if(root==null)
	  {
		  return null;
	  }
	  queue.add(root);
	  while(!queue.isEmpty())
	  {
		  var current = queue.poll();
		  
		  if(current.value>max) {max = current.value;}
		  if(current.value<min) {min = current.value;}
		  
		  for(Node c: current.children)
		  {		  
			  queue.add(c);
		  }
	  }
	  int[] array = new int[2];
	  array[0] = min;
	  array[1] = max;
	  return array;
  }
  
}
