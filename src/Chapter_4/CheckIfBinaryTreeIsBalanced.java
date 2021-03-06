package Chapter_4;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/15/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */

public class CheckIfBinaryTreeIsBalanced {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode("Sowmya", 7);
        tree.addNode("Vinitha", 2);
        tree.addNode("Silvia", 24);
        tree.addNode("Sai",30);
        System.out.println(tree.root);
        tree.inOrderTraversal(tree.root);
        tree.preOrderTraversal(tree.root);
        tree.postOrderTraversal(tree.root);
        System.out.println(tree.findNode(30));
    }

}

class BinaryTree {

    BinaryTreeNode root;

    public void addNode(String name,int key){

        BinaryTreeNode newNode = new BinaryTreeNode(name, key);
        BinaryTreeNode currentNode = root;
        BinaryTreeNode parentNode;

        while(true){
            parentNode = currentNode;
            if(key < currentNode.birthday){
                currentNode = currentNode.leftChild;
                if(currentNode == null){
                    parentNode.leftChild = newNode;
                    return;
                }
            }
            else{
                currentNode = currentNode.rightChild;
                if(currentNode == null){
                    parentNode.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public void inOrderTraversal(BinaryTreeNode node){
        if(node!=null){
            inOrderTraversal(node.leftChild);
            System.out.println(node.toString()+" ");
            inOrderTraversal(node.rightChild);
        }
    }

    public void preOrderTraversal(BinaryTreeNode node){
        if(node!=null){
            System.out.println(node.toString()+" ");
            preOrderTraversal(node.leftChild);
            preOrderTraversal(node.rightChild);
        }
    }

    public void postOrderTraversal(BinaryTreeNode node){
        if(node!=null){
            postOrderTraversal(node.leftChild);
            postOrderTraversal(node.rightChild);
            System.out.println(node.toString()+" ");
        }
    }

    public BinaryTreeNode findNode(int key){
        BinaryTreeNode currentNode = root;
        while(currentNode!=null){
            if(currentNode.birthday == key)
                return currentNode;
            if(key < currentNode.birthday){
                currentNode = currentNode.leftChild;
            }
            else{
                currentNode = currentNode.rightChild;
            }
        }
        return null;
    }
    public int getHeightTree(BinaryTreeNode node){
        if(root == null){
            return 0;
        }
        return Math.max(getHeightTree(node.leftChild), getHeightTree(node.rightChild)) + 1;
    }

    public boolean isBinaryTreeBalancedStupidWay(BinaryTreeNode root){
        if(root == null){
            return true;
        }
        if((getHeightTree(root.leftChild)-getHeightTree(root.rightChild)) > 1){
            return false;
        }
        return isBinaryTreeBalancedStupidWay(root.leftChild) && isBinaryTreeBalancedStupidWay(root.rightChild);
    }

//    public boolean isBinaryTreeBalanced(BinaryTreeNode root){
//
//    }
}

class BinaryTreeNode{
    String name;
    int birthday;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    BinaryTreeNode(String name, int key){
        this.birthday = key;
        this.name = name;
    }

    public String toString(){
        return name + " has her birthday on: " + birthday;
    }
}


