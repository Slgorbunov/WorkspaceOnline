import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.tree.*;

public class PetriTree
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new PetriTreeFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
class PetriTreeFrame extends JFrame
{
   public PetriTreeFrame()
   {
      setTitle("Сети петри.Создай своё дерево петри");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // construct tree
      String start = "RT:[1, 0, 0, 0, 1]";
      TreeNode root = makeParentTree(start);
      model = new DefaultTreeModel(root);
      tree = new JTree(model);
      tree.setEditable(true);

      // add scroll pane with tree

      JScrollPane scrollPane = new JScrollPane(tree);
      add(scrollPane, BorderLayout.CENTER);

      makeButtons();
   }

   public TreeNode makeParentTree(String start)
   {
      DefaultMutableTreeNode root = new DefaultMutableTreeNode(start);
      
      return root;
   }

   /**
    * Makes the buttons to add a sibling, add a child, and delete a node.
    */
   public void makeButtons()
   {
      JPanel panel = new JPanel();
      

      JButton addChildButton = new JButton("Add Child");
      addChildButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
                     .getLastSelectedPathComponent();
               String strINT = selectedNode.toString();
               System.out.println(strINT);
               int[] p = new int[5];
               int u=0;
               int strLength = strINT.length();
               for (int i=4;  i<=strLength; i+=3){
            	   
            	   p[u] = Integer.parseInt( String.valueOf(strINT.charAt(i)) );
            	   u++; 
               }
           		//t1
               	ArrayList<String> list = new ArrayList<String>();
           		int[] p1 = Arrays.copyOf(p,5);
           		int[] p2= Arrays.copyOf(p,5);
           		int[] p3 = Arrays.copyOf(p,5);
           		int[] p4 = Arrays.copyOf(p,5);
           		if (p1[0]>0){
           			p1[1]=p[1]+1;
           			p1[2]=p[2]+1;
           			p1[3]=p[3]+2;
           			String resultT1="T1:"+Arrays.toString(p1);
      				list.add(resultT1);
           		}
           		//t2
           		if ( (p[1]>0) && (p[2]>0) && (p[3]>0) ){
           			p2[2]=p[2]-1;
           			p2[3]=p[3]-1;
           			String resultT2="T2:"+Arrays.toString(p2);
      				list.add(resultT2);
           		}
           		//t3
           		if ((p[3]>1)){
           			p3[3]=p[3]-2;
           			p3[4]=p[4]+1;
           			String resultT3="T3:"+Arrays.toString(p3);
      				list.add(resultT3);
           		}
           		//t4
           		if ((p[4]>0)){
           			p4[2]=p[2]+1;
           			p4[3]=p[3]+1;
           			String resultT4="T4:"+Arrays.toString(p4);
      				list.add(resultT4);
           		}
           	
               if (selectedNode == null) return;
               
               for(String elList : list){
            	   DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(elList);
            	   model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
               
            	   // now display new node

	               TreeNode[] nodes = model.getPathToRoot(newNode);
	               TreePath path = new TreePath(nodes);
	               tree.scrollPathToVisible(path);
               }
            }
         });
      panel.add(addChildButton);
      
      JButton deleteButton = new JButton("Delete");
      deleteButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
                     .getLastSelectedPathComponent();

               if (selectedNode != null && selectedNode.getParent() != null) model
                     .removeNodeFromParent(selectedNode);
            }
         });
      panel.add(deleteButton);
      add(panel, BorderLayout.SOUTH);
   }

   private DefaultTreeModel model;
   private JTree tree;
   private static final int DEFAULT_WIDTH = 400;
   private static final int DEFAULT_HEIGHT = 200;
}