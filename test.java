import java.util.*;
import java.util.ArrayList;

class test
{
	public static void main(String args[])
	{
		multiway_tree tree = new multiway_tree();
		
		
		ArrayList<String> node_list_string = new ArrayList<String>();
		ArrayList<String> duration_list = new ArrayList<String>();
		// Creating data to input.
		for (int i=1;i<8;i++)
		{
			String ch= Integer.toString(i);
			String node_name= "node"+ch;
			node_list_string.add(node_name);
			duration_list.add(ch);
		}		
		
		
		// Regular node dependencies 
		ArrayList<String> node_dependencies = new ArrayList<String>();
		node_dependencies.add("NULL");
		node_dependencies.add("node1");
		node_dependencies.add("node1");
		node_dependencies.add("node2");
		node_dependencies.add("node2,node3");
		node_dependencies.add("node3");
		node_dependencies.add("node4,node5,node6");
		
		
		/*
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
		Collections.shuffle(node_list_string);
		Collections.shuffle(node_dependencies);	
		
		// Print the raw data that was initialized. 
		System.out.println("\nRaw Data of Nodes");
		for (int i=0;i<node_list_string.size();i++)
		{
			System.out.println("Node: "+node_list_string.get(i)+"\tDependencies: "+node_dependencies.get(i)+"\tDuration: "+duration_list.get(i));
		}
		System.out.println("\n\n");
		
		
		// Initialize parameters that are needed to run certain tree functions. 
		int sum=0;
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> path_output = new ArrayList<String>();
		ArrayList<String> errors = new ArrayList<String>();
		
		// Test Statements		
		tree.initialize_tree(node_list_string,node_dependencies,duration_list);	
		tree.cycle_check(tree.root,errors);
		if (errors.size()==0)
		{
			//tree.print_tree(tree.root);
			tree.compute_paths(tree.root,path,sum,path_output);
			tree.sort_paths(path_output);
			System.out.println("\nPaths:");
			for (int k=0;k<path_output.size();k++)
			{
				System.out.println(path_output.get(k));
			
			}
		
		}
		
		else
		{
			System.out.println("Cycle Error Detected: Abort Program");
		}
		
			
	}
}