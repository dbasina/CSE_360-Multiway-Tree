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
				
		// Create the dependencies and add them to the ArrayList. 
		ArrayList<String> node_dependencies = new ArrayList<String>();
		node_dependencies.add("NULL");
		node_dependencies.add("node1");
		node_dependencies.add("node1");
		node_dependencies.add("node2");
		node_dependencies.add("node2,node3");
		node_dependencies.add("node3");
		node_dependencies.add("node4,node5,node6");
		
		// Shuffle Test and print statements
		//Collections.shuffle(node_list);
		//Collections.shuffle(node_dependencies);
		
		// Print the raw data that was initialized. 
		System.out.println("\nRaw Data of Nodes");
		for (int i=0;i<node_list_string.size();i++)
		{
			System.out.println("Node: "+node_list_string.get(i)+"\tDependencies: "+node_dependencies.get(i)+"\tDuration: "+duration_list.get(i));
		}
		System.out.println("\n\n");
		
		
		
		tree.initialize_tree(node_list_string,node_dependencies,duration_list);	
		
		
		//tree.print_tree(tree.root);
		
		
		// Setup for computing the paths. 
		int sum=0;
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> path_output = new ArrayList<String>();
		System.out.println("\nTree Paths and their time");
		
		tree.print_paths(tree.root,path,sum,path_output);
		
		System.out.println("\n\nPrinting path using the path_output ArrayList");
		for (int k=0;k<path_output.size();k++)
		{
			System.out.println(path_output.get(k));
		}
			
	}
	
	public int path_duration(String path_entry)
	{
		String[] temp = path_entry.split(":");
		int len = temp.length;
		return Integer.parseInt(temp[len-1]);
	}
}