public class CodecMain {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        //          1
        //            \
        //             2
        //             /
        //            3
        Codec c = new Codec();
        String slz = c.serialize(root);
        System.out.println(slz);
        TreeNode temp = c.deserialize(slz);
        System.out.println(c.serialize(temp));
        
    }
}