import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class LCATest {

	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("LCA of empty tree: ", null, tree.findLCA(1, 2));
	}
/*example to visualize
     4
   /   \
  2      6
 / \    / \
1   3  5   7
*/

	@Test
	public void testSimpleLCA(){
		LCA tree = new LCA();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		assertEquals("LCA of 2 and 6: ", 4, tree.findLCA(2, 6).data);
		assertEquals("LCA of 1 and 3: ", 2, tree.findLCA(1, 3).data);
		assertEquals("LCA of 5 and 7: ", 6, tree.findLCA(5, 7).data);
		assertEquals("LCA of 1 and 5: ", 4, tree.findLCA(1, 5).data);
	}

	@Test
	public void testForNonExistentNodes(){
		LCA tree = new LCA();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		assertEquals("LCA of non-existent nodes: ", null, tree.findLCA(8, 9));
	}

	@Test
	public void testTwoNodes(){
		LCA tree = new LCA();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		assertEquals("LCA of root and only one child: ", 4, tree.findLCA(4, 2).data);
	}

	@Test
	public void testSize15Nodes() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		tree.root.right.right.left = new Node(14);
		tree.root.right.right.right = new Node(15);

		assertEquals("LCA of 1 and 2", 1, tree.findLCA(1, 2).data);
		assertEquals("LCA of 2 and 3", 1, tree.findLCA(2, 3).data);
		assertEquals("LCA of 2 and 4", 2, tree.findLCA(2, 4).data);
		assertEquals("LCA of 4 and 5", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 6 and 7", 3, tree.findLCA(6, 7).data);
		assertEquals("LCA of 4 and 8", 4, tree.findLCA(4, 8).data);
		assertEquals("LCA of 8 and 9", 4, tree.findLCA(8, 9).data);
		assertEquals("LCA of 6 and 12", 6, tree.findLCA(6, 12).data);
		assertEquals("LCA of 14 and 15", 7, tree.findLCA(14, 15).data);
		assertEquals("LCA of 8 and 2", 2, tree.findLCA(8, 2).data);
		assertEquals("LCA of 9 and 11", 2, tree.findLCA(9, 11).data);
		assertEquals("LCA of 13 and 14", 3, tree.findLCA(13, 14).data);
		assertEquals("LCA of 15 and 1", 1, tree.findLCA(15, 1).data);
	}
}
