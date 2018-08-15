import java.util.*;
public class HuffmanDecoder {
    static void main(String args[]) {
        List<String> codes = new ArrayList<>();
        codes.add("a    100100");
        codes.add("\n   111111");
        codes.add("b    100101");
        codes.add("c    110001");
        codes.add("d    100000");
        String encodes = "111110000001100100111111100101110001111110";   
    }

    static String decode(List<String> codes, String encoded) {
        Node root = new Node();
        for(int i = 0;i < codes.size();i++) {
            String[] array = codes.get(i).split("\t");
            buildTrie(array[1],array[0],root);
        }
        int start = 0;
        StringBuilder sb = new StringBuilder();
        Node cur = root;
        while (start < encoded.length()) {
            if (cur.left == null && cur.right == null) {
                sb.append(cur.c);
                cur = root;
            }
            char c = encoded.charAt(start);
            if (c == '1') {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
            start++;
        }
        return sb.toString();
    }
    
    
    private static void buildTrie(String code, String l,Node root) {
        for(char c: code.toCharArray()) {
            if(c == '1'){
                if(root.right == null) root.right = new Node();
                root = root.right;
            }else {
                if(root.left == null) root.left = new Node();
                root = root.left;
            }
        }
        root.c = l;
    }

    static class Node {
        Node left, right;
        String c;
    }


}