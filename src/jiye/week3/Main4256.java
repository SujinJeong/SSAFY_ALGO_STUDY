import java.util.*;
import java.io.*;

class Node{
	int data;
	Node left;
	Node right;
}
class Tree{
	public Node root;

	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public Node makeNode(Node left, int data, Node right) {
		Node node=new Node();
		node.data=data;
		node.left=left;
		node.right=right;
		return node;
	}
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	public void preorder(Node node) {
		if(node != null) {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}

class Main4256 {//트리
    static int[] pre;
    static int[] in;
    static int[] post;
    static Tree tree;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++)
        {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            pre = new int[N];
            in = new int[N];
            post = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
            {
                pre[i]= Integer.parseInt(st.nextToken());//전위
            }

            
            int index = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
            {
                in[i] = Integer.parseInt(st.nextToken());
                if(in[i]==pre[0])
                    index = i;//4
            }
     
            tree = new Tree();
            Node n1 = tree.makeNode(null,pre[0],null);
            tree.setRoot(n1);

            int[] left = new int[index];
            int[] right = new int[N-1-index];
            for(int i=0;i<index;i++)
                left[i] = in[i];
            for(int i=index+1;i<N;i++)
                right[i-index-1] = in[i];

            
            func(n1,0,index,N);
        }
    }
   static int root;


public static void func(Node node,int rot, int index, int size)
{
    if(root==N-1)
        return;

    int index2=0;
    int size2=size-1-index;
    if(index==0 && size2==0)
    {
        return;
    }

    node.left = tree.makeNode(null,pre[root+1],null);//그다음루트
    int[] tleft = new int[index];
    int[] tright = new int[size2];

    for(int i=0;i<index;i++)
    {
        tleft[i] = in[i];//노드 왼쪽
        if(tleft[i]==pre[root+1])
            index2=i;//루트 인덱스
    }
    for(int i=index+1;i<size;i++)
        tright[i-index-1] = in[i];//노드 오른쪽
    
 
    root+=1;
    
    System.out.println(Arrays.toString(tleft));
    System.out.println(Arrays.toString(tright));
    System.out.println(root+" "+index2+" "+index+" l");
    func(node.left,root,index2,index);//left를 또돌
    
    if(root==N-1)
        return;
    if(size2==0)
        return;
    
    node.right = tree.makeNode(null,pre[root+1],null);
    for(int i=0;i<size2;i++)
    {
        if(tright[i]==pre[root+1])
            index2=i;//root 갱신
    }

    in = tright;
    // tleft = new int[index2];
    // tright = new int[size2-1-index2];

    // for(int i=0;i<index2;i++)
    // {
    //     tleft[i] = in[i];//노드 왼쪽
    // }
    // for(int i=index2+1;i<size2;i++)
    //     tright[i-index2-1] = in[i];//노드 오른쪽

    root+=1;
    System.out.println(Arrays.toString(tleft));
    System.out.println(Arrays.toString(tright));
    System.out.println(root+" "+index2+" "+size2+" r");
    func(node.right,root,index2,size2);
}

}
