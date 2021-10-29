import static org.junit.Assert.*;

import org.junit.Test;

public class LCATests {

    @Test
    public void testLCA() {
		LCAjava G = new LCAjava(7);
		assertEquals("Empty Graph", -1, G.getLCA(G, 2, 3));
		
		G.addEdge(0, 1);
		
		G.addEdge(1, 2);
		G.addEdge(1, 3);
		G.addEdge(1, 5);
		
		G.addEdge(2, 4);
		
		G.addEdge(3, 4);
		G.addEdge(3, 5);
		
		G.addEdge(4, 5);
		
		assertEquals("LCA of (1, 2)", 0, G.getLCA(G, 1, 2));
		assertEquals("LCA of (2, 3)", 1, G.getLCA(G, 2, 3));
		assertEquals("LCA of (4, 3)", 1, G.getLCA(G, 4, 3));
		assertEquals("LCA of (4, 5)", 3, G.getLCA(G, 4, 5));
		assertEquals("Node does not exisit", -1, G.getLCA(G, 2, 6));
		

		LCAjava G2 = new LCAjava(7);
		G2.addEdge(0, 1);
		G2.addEdge(1, 3);
		G2.addEdge(3, 5);
		
		G2.addEdge(0, 2);
		G2.addEdge(2, 4);
		G2.addEdge(4, 6);
		
		assertEquals("LCA of (3, 4)", 0, G2.getLCA(G2, 5, 6));
		
		
		LCAjava G3 = new LCAjava(7);
		G3.addEdge(1, 3);
		G3.addEdge(0, 2);
		
		assertEquals("LCA does not exisit (3, 4)", -1, G3.getLCA(G3, 3, 4));
		
		G3.addEdge(0, 1);
		G3.addEdge(1, 4);
		assertEquals("LCA of (3, 4)", 1, G3.getLCA(G, 3, 4));

    }

    
}

