//DAG
import java.util.ArrayList;
class Node {
		int data;
		Node leftside, rightside;
		ArrayList<Node> lcancestors;

		Node(int value) {
			data = value;
			leftside = rightside = null;
			lcancestors = null;
		}
	}

public class LCA {
	Node root;
	boolean cycle = false;

	Node findLCA(int n1, int n2) {
		return findLCA(root, n1, n2);
	}

	Node findLCA(Node node, int n1, int n2) {
		if (node == null)
			return null;
		else if (node.data == n1 || node.data == n2)
			return node;
		Node leftside = findLCA(node.leftside, n1, n2);
		Node rightside = findLCA(node.rightside, n1, n2);
		if (leftside != null && rightside != null)
			return node;
		else if (leftside != null)
			return leftside;
		else
			return rightside;
	}

	public void addlcancestorsToNode(Node nodeA, Node nodeB) {
		for (int i = 0; i < nodeA.lcancestors.size(); i++) {
			if (nodeA.lcancestors.get(i) == nodeB)
				cycle = true;
			if (!nodeB.lcancestors.contains(nodeA.lcancestors.get(i)))
				nodeB.lcancestors.add(nodeA.lcancestors.get(i));
		}
	}

	public void addlcancestorsToNodeAtPosition(int position, Node nodeA, Node nodeB) {
		for (int i = 0; i < nodeA.lcancestors.size(); i++)
			if (!nodeB.lcancestors.contains(nodeA.lcancestors.get(i)))
				nodeB.lcancestors.add(position, nodeA.lcancestors.get(i));
	}

	public void addToGraph(Node nodeA) {
		nodeA.lcancestors = new ArrayList<Node>();
		nodeA.lcancestors.add(nodeA);
	}

	Node findLCADAG(Node nodeA, Node nodeB) {
		return findLCADAG(root, nodeA, nodeB);
	}

	Node findLCADAG(Node root, Node nodeA, Node nodeB) {
		if (nodeA != null && nodeB != null && !cycle)
			if (nodeA.lcancestors != null && nodeB.lcancestors != null) {
				for (int i = 0; i < nodeB.lcancestors.size(); i++)
					for (int j = 0; j < nodeA.lcancestors.size(); j++)
						if (nodeB.lcancestors.get(i) == nodeA.lcancestors.get(j))
							return nodeB.lcancestors.get(i);
			} else return root;
		return null;
	}
}
