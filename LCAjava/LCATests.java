import static org.junit.Assert.*;

import org.junit.Test;

public class LCATests {

    @Test
    public void testLCA() {
    		
    	LCAjava tree = new LCAjava();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		assertEquals("Does not exisit: LCA of (0, 5)", -1, tree.findLCA(0, 5));
		assertEquals("LCA of (4, 5)", 2, tree.findLCA(4, 5));
		assertEquals("LCA of (4, 6)", 1, tree.findLCA(4, 6));
		assertEquals("LCA of (3, 4)", 1, tree.findLCA(3, 4));
		assertEquals("LCA of (2, 4)", 2, tree.findLCA(2, 4));
		assertEquals("LCA of (2, 3)", 1, tree.findLCA(2, 3));
    		

    }

    
}

