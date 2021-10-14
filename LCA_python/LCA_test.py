import unittest
import LCA

class TestLCA(unittest.TestCase):

    def setUp(self):
        self.root = LCA.Node(4)
        self.root.left = LCA.Node(2)
        self.root.right = LCA.Node(6)
        self.root.left.left = LCA.Node(1)
        self.root.left.right = LCA.Node(3)
        self.root.right.left = LCA.Node(5)
        self.root.right.right = LCA.Node(7)

    def test_findLCA(self):

        self.assertEqual(LCA.findLCA(self.root, 4, 5), 4, "LCA(4, 5) should be 4")
        self.assertEqual(LCA.findLCA(self.root, 1, 2), 2, "LCA(1, 2) should be 2")
        self.assertEqual(LCA.findLCA(self.root, 3, 2), 2, "LCA(3, 4) should be 2")
        self.assertEqual(LCA.findLCA(self.root, 5, 7), 6, "LCA(5, 7) should be 6")

        self.assertEqual(LCA.findLCA(self.root, 4, 8), None, "LCA(4, 5) should be None")
        self.assertEqual(LCA.findLCA(self.root, 8, 4), None, "LCA(8, 4) should be None")

if __name__ == '__main__':
    unittest.main()
