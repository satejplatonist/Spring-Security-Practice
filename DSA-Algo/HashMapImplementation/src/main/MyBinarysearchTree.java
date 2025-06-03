package main;

public class MyBinarysearchTree 
{
   private static class Node
   {
	   private final int value;
	   
	   private Node left,right;

	   public Node(int value) {
			super();
			this.value = value;
	   }
	      
   }
   
   public MyBinarysearchTree() {} 
   
   public MyBinarysearchTree(Node root) {
	 this.root = root;
   }

   private Node root;
   
   public void add(int number)
   {
	   if(root==null)
	   {
		   root = new Node(number);
	   }
	   else
	   {
		   insert(number, root);
	   }
   }
   
   private void insert(int number, Node node)
   {
	   if(node.value < number)
	   {
		   if(node.left!=null) 
		   {
		      insert(number,node.left);
		   }
		   Node newNode = new Node(number);
		   newNode.left = null;
		   newNode.right = null;
		   node.left = newNode;
	   }
	   else if (node.value > number)
	   {
		   if(node.right!=null)
		   {
			   insert(number,node.right);
		   }
		   Node newNode  = new Node(number);
		   newNode.left = null;
		   newNode.right = null;
		   node.right = newNode;
	   }
   }
   
   public void preOrder()
   {
	   parseTreePreOrder(root);
   }
   
   private void parseTreePreOrder(Node node)
   {
	   if (node == null) return;
	   System.out.println(node.value);
	   parseTreePreOrder(node.left);
	   parseTreePreOrder(node.right);
   }
   
   public void InOrder()
   {
	   parseTreeInOrder(root);
   }
  
   private void parseTreeInOrder(Node node)
   {
	   if (node == null) return;
	   parseTreeInOrder(node.left);
	   System.out.println(node.value);
	   parseTreeInOrder(node.right);
   }
   
   public void postOrder()
   {
	   parseTreePostOrder(root);   
   }

   private void parseTreePostOrder(Node node) 
   {
	  if (node == null) return;
	  parseTreePostOrder(node.left);
	  parseTreePostOrder(node.right);
	  System.out.println(node.value);
   }
}
