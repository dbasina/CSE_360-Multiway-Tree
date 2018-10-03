import java.util.*;
import java.util.ArrayList;



public class 	multiway_tree
{
			
			int 	tree_size=0;
			multiway_node			root;
			
			public void initiaze_tree(ArrayList<multiway_node> input_list, ArrayList<String> dependency_list)
			{
					// Expecting from main: array list of multiway node with name and duration variables initialized upon creation.
					//						the elements of dependency list must have  delimiter ","
					// We should also input a String array of dependencies of the input in the same order as the ArrayList of input_nodes. 
					
					
					// Find the index of root node and initialize it.  
					int		i=0;
					while (dependency_list.get(i)!= "NULL")
					{
						i++;
					}
					root = input_list.get(i);
					input_list.remove(i);
					
					
					// The second level of nodes must have only 1 dependency, which is the root node. Since all nodes must be connected
					for (int j=0;j<input_list.size();i++)
					{
						if (dependency_list.get(j)==root.name)
						{
							// add jth node as a connection to the root node
							root.connections.add(input_list.get(j));
							
							// add root as dependency to the jth node
							multiway_node	temp = input_list.get(j);
							temp.dependencies.add(root);
							
							// Delete jth nodes from both ArrayLists
							input_list.remove(j);
							dependency_list.remove(j);
						}
					}
					
					// Reset i=0
					i=0;
					// Use i and iterate over both lists and make connections between the rest of the nodes
					
					while(i<input_list.size())
					{
						// Get the list of dependencies for input_list.get(i)
						String element_dependencies=dependency_list.get(i);
						
						// convert the list of dependencies into a string array
						String dependency_array[] = element_dependencies.split(",");
						
						// iterate over this array and form connections in the dependency array lists and connections array lists.
						for (int k=0;k<dependency_array.length;k++)
						{
							for (int l=0;l<input_list.size();l++)
							{
								if(dependency_array[k] == input_list.get(l).name)
								{
									// Add the dependency to input_list.get(i)
									multiway_node temp1 = input_list.get(i);
									temp1.dependencies.add(input_list.get(l));
									
									// Add the connection input_list.get(i) to input_list.get(l_
									multiway_node temp2= input_list.get(l);
									temp2.connections.add(input_list.get(i));
									
								}
							}
						}	
						
						//increment i
						i++;
					}
					
					
			}
			
}
			
			
			
		
		
		
		