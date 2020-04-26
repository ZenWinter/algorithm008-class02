/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    private void helper(Node root, List<Integer> res) {
        if (root != null) {
            for (Node t : root.children) {
                helper(t, res);
            }
            res.add(root.val);
        }
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 递归
        // helper(root, res);

        // 非递归
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.offerFirst(curr.val);
            for (Node t : curr.children) {
                stack.push(t);
            }
        }
        return res;
    }
}