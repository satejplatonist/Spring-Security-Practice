package main;

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
		 this.children = null;
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
  
  
}
