class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	  /**
	   * Inserts a new value into the binary search tree, as a leaf node
	   * @param value the value to insert into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null) {
	         root = new Node(value);
	         return;
	      }
		  else {
	         Node current = root;
	         Node parent = null;
	         
	         while(true) {
	            parent = current;
	            
	            if(value < current.value) {
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }
				else {
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	  /**
	   * Prints the value of every node in preorder order
	   * @param root the root of the tree
	   */
	   public void preOrderTraversal(Node root) {
		   	if(root == null)
		   		return;
			
			// print value of this node
			System.out.print(root.value + " ");

			// traverse left subtree
			preOrderTraversal(root.left);

			// traverse right subtree
			preOrderTraversal(root.right);

	   }

	   
	   
	   /**
		* Prints the value of every node in inorder order
		* @param root the root of the tree
	    */
	   public void inOrderTraversal(Node root) {
			if(root == null)
				return;
			
			// traverse left subtree
			inOrderTraversal(root.left);

			// print value of this node
			System.out.print(root.value + " ");

			// traverse right subtree
			inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /**
		* Prints the value of every node in postorder order
		* @param root the root of the tree
	    */
	   public void postOrderTraversal(Node root) {
			if(root == null)
				return;
			
			// traverse left subtree
			postOrderTraversal(root.left);

			// traverse right subtree
			postOrderTraversal(root.right);

			// print value of this node
			System.out.print(root.value + " ");
		   
	   }
	   
	   
	   
	   
	   /**
		* A method that checks if a node with the given value exists in the tree
		* @param root the root of the tree
		* @param key the value to look for
		* @return true if the key exists in the tree, and fals if it doesn't
	    */
		// "find" is a bad name for a function that returns a boolean, in my opinion, but it's what I'm stuck with
	   public boolean find(Node root, int key) {
			// I could do it iteratively, but doing it recursively because I'm very lazy
			if(root == null)
				return false;
			else if(root.value == key)
				return true;
			else
				return find(root.left, key) || find(root.right, key);
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
         //implement in here
	      
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
         //implement in here
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert(24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
