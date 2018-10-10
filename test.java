import java.util.*;
import java.util.ArrayList;

class test
{
	public static void main(String args[])
	{
		multiway_tree tree = new multiway_tree();
		ArrayList<String> node_list_string = new ArrayList<String>();
		ArrayList<String> duration_list = new ArrayList<String>();
		ArrayList<String> node_dependencies = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		// Add data to node_list_string and duration_list.
		for (int i=1;i<8;i++)
		{
			String ch= Integer.toString(i);
			String node_name= "node"+ch;
			node_list_string.add(node_name);
			duration_list.add(ch);
		}		
		
		// Add data to node_dependencies.
		// Regular simulation dependencies 
		
		node_dependencies.add("NULL");
		node_dependencies.add("NULL");
		node_dependencies.add("node1,node2");
		node_dependencies.add("node2");
		node_dependencies.add("node2,node3");
		node_dependencies.add("node3");
		node_dependencies.add("node4,node5,node6");
				
		/*
		// Add data to node_dependencies.
		// Cycle simulation dependencies.
		ArrayList<String> node_dependencies = new ArrayList<String>();
		node_dependencies.add("NULL");
		node_dependencies.add("node1");
		node_dependencies.add("node1,node7");
		node_dependencies.add("node2");
		node_dependencies.add("node2,node3");
		node_dependencies.add("node3");
		node_dependencies.add("node4,node5,node6");
		*/
		
		// Shuffle raw data
		//Collections.shuffle(node_list_string);
		//Collections.shuffle(node_dependencies);	
			
		// Print the raw data that is being input. 
		System.out.println("\nRaw Data of Nodes");
		for (int i=0;i<node_list_string.size();i++)
		{
			System.out.println("Node: "+node_list_string.get(i)+"\tDependencies: "+node_dependencies.get(i)+"\tDuration: "+duration_list.get(i));
		}
		System.out.println("\n");
		
		// Test Algorithm		
		tree.initialize_tree(node_list_string,node_dependencies,duration_list);	
		output= tree.output();
		
		// Print output.
		System.out.println("\nPaths:");
		for (int k=0;k<output.size();k++)
		{
			System.out.println(output.get(k));
			
		}		
	}
}