public class Codec {

  // Serialize a tree to a string
  public String serialize(TreeNode root) {
    if (root == null) return "X";
    String left = serialize(root.left);
    String right = serialize(root.right);
    return root.val + "," + left + "," + right;
  }

  // Deserialize a string back to a tree
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));

    return deserializeHelper(queue);
  }

  private TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.remove();
    if (val.equals("X")) return null;
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deserializeHelper(queue);
    node.right = deserializeHelper(queue);
    return node;
  }

}
