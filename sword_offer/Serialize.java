//package loadoffer;
//
//import com.sun.source.tree.Tree;
//
//public class Serialize {
//    int index = -1;
//
//    String Serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        if (root == null) {
//            //递归出口，若为空节点，则输入'#',并返回
//            sb.append("#,");
//            return sb.toString();
//        }
//        sb.append(root.val + ",");//若为非空节点，则输入“值,”
//        sb.append(Serialize(root.left));//递归左
//        sb.append(Serialize(root.right));
//        return sb.toString();
//    }
//
//    TreeNode Deserialize(String str) {
//        index++;
//        int len=str.length();
//        if (index>=len){
//            return null;
//        }
//        String []str1=str.split(",");
//        TreeNode node=null;
//        if (!str1[index].equals("#")){
//            node=new TreeNode(Integer.valueOf(str1[index]));
//            node.left=Deserialize(str);
//            node.right=Deserialize(str);
//        }
//        return node;
//    }
//
//}
