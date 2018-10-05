import java.util.*;
import java.util.ArrayList;



public class 	multiway_tree
{
			
			int 	tree_size=0;
			multiway_node			root;
			
			public void initialize_tree(ArrayList<multiway_node> input_list_main, ArrayList<String> dependency_list_main)
			{
					// Expecting from main: array list of multiway node with name and duration variables initialized upon creation.
					//						the elements of dependency list must have  delimiter ","
					// We should also input a String array of dependencies of the input in the same order as the ArrayList of input_nodes. 
					
					// Copy the data into temporary Arraylists that can be manipulated.
					ArrayList<multiway_node> input_list = new ArrayList<multiway_node>();
					ArrayList<String> dependency_list = new ArrayList<String>();
					String temp_string="";
					multiway_node temp_node = new multiway_node();
					for (int j=0;j<input_list_main.size();j++)
					{
						temp_node = input_list_main.get(j);
						temp_string= dependency_list_main.get(j);
						input_list.add(temp_node);
						dependency_list.add(temp_string);
					}
					
					// Find the index of root node and initialize it.  
					int		i=0;
					while (dependency_list.get(i)!= "NULL")
					{
						i++;
					}
					
					// Assign root node. 
					root = input_list.get(i);
					// Reset i
					i=0;		 
					dependency_list.remove(i);
					i++;
					
					
					
					// Assumption: Second level from top only has 1 dependency, root.
					// Find level 2 elements and assign root as their predecessor 		
					//for (int j=0;j<dependency_list.size();j++)
					//{
						
						//if (dependency_list.get(j).equals(root.name))
						//{
							// add jth node as a connection to the root node
							//root.connections.add(input_list.get(j));							
						
							// add root as dependency to the jth node
							//input_list.get(j).dependencies.add(root);
							
							// Remove the connected elements' dependencies from the dependency_lists and increment i. Weird logic. Write and check!
							//dependency_list.remove(j);
							//i++;
	
						//}
					//}
					
					
					// Use i to iterate over the nodes that are not connected. And use j to iterate from the start of what is remaining in the dependency list
					// therefore, i's index is pointing to the nodes that are not connected. J's index starts at 0. 
					int j=0;
					while(i<input_list.size())
					{
							// Get the list of dependencies for the ith node at input_list.get(i)
							
							String node_dependencies=dependency_list.get(j);
						    
							// convert the list of dependencies into a string array
							String dependency_array[] = node_dependencies.split(",");
						
							// iterate over this array and form connections in the dependency array lists and connections array lists.
							for (int k=0;k<dependency_array.length;k++)
							{
								//PRINT CHECK
						    	//System.out.print(dependency_array[k]);
						    
								for (int l=0;l<input_list.size();l++)
								{
									if(dependency_array[k].equals(input_list.get(l).name))
									{
										// Add the dependency at input_list.get(l) to input_list.get(i)
										input_list.get(i).dependencies.add(input_list.get(l));
									
										// Add the connection input_list.get(i) to input_list.get(l)
										input_list.get(l).connections.add(input_list.get(i));
									
									}
								}
							}	
						
						
						i++;
						j++;
						
					}
					
					
			}
			
}
			
			
			
		
		
		
		