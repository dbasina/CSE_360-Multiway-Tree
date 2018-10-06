import java.util.*;
import java.util.ArrayList;

class test
{
	public static void main(String args[])
	{
		multiway_tree tree = new multiway_tree();
		
		ArrayList<multiway_node> node_list = new ArrayList<multiway_node>();
		multiway_node node1 = new multiway_node("node1",2);
		multiway_node node2 = new multiway_node("node2",2);	
		multiway_node node3 = new multiway_node("node3",2);
		multiway_node node4 = new multiway_node("node4",2);
		multiway_node node5 = new multiway_node("node5",2);	
		multiway_node node6 = new multiway_node("node6",6);
		multiway_node node7 = new multiway_node("node7",6);
		
		for (int i=1;i<8;i++)
		{
			String ch= Integer.toString(i);
			String node_name= "node"+ch;
			multiway_node temp= new multiway_node(node_name,2);
			node_list.add(temp);
		}
		
		// Print names of nodes
		/*
		for (int j=0;j<7;j++)
		{
			System.out.println(node_list.get(j).name);
		}*/
		
		ArrayList<String> node_dependencies = new ArrayList<String>();
		node_dependencies.add("NULL");
		node_dependencies.add("node1");
		node_dependencies.add("node1");
		node_dependencies.add("node2");
		node_dependencies.add("node2,node3");
		node_dependencies.add("node3");
		node_dependencies.add("node4,node5,node6");
		
		Collections.shuffle(node_list);
		Collections.shuffle(node_dependencies);
		
		System.out.println(" The nodes and their dependencies before initialize_tree");
		for (int i=0;i<node_list.size();i++)
		{
			System.out.println("Node: "+node_list.get(i).name+"\tDependencies: "+node_dependencies.get(i));
		}
		System.out.println("\n\n");
		
		
		tree.initialize_tree(node_list,node_dependencies);	
		
		
		//PRINT CHECK
		System.out.println(" The nodes and their dependencies after initialize_tree printed by accessing each dependency from their nodes");
		System.out.println("Root: "+tree.root.name);
		for (int k=0;k<node_list.size();k++)
		{
			System.out.print("node: "+node_list.get(k).name+"\tDependencies: ");
			for (int l=0;l<node_list.get(k).dependencies.size();l++)
			{
				System.out.print(node_list.get(k).dependencies.get(l).name+",");
			}
			System.out.println("");
			
		}
		
		
		
	}
}