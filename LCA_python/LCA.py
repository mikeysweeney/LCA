#example to visualize 
#           4
#         /   \
#        2      6
#       / \    / \
#      1   3  5   7
import networkx as nx

class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

    def find(self, x):
        if self.key == x:
            return True
        elif x < self.key and self.left:
            return self.left.find(x)
        elif x > self.key and self.right:
            return self.right.find(x)
        return False
