import java.util.*;
import java.util.ArrayList;



public class 	multiway_tree
{
			
			int 	tree_size=0;
			multiway_node			root;
			
			public void initialize_tree(ArrayList<multiway_node> input_list, ArrayList<String> dependency_list)
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
					
					// Assign root node. 
					root = input_list.get(i);
		
					 /*
					//PRINT CHECK
					for (int k=0;k<dependency_list.size();k++)
					{
						System.out.println("node: "+input_list.get(k).name+ "\tDependencies: "+dependency_list.get(k));
					}
					*/
					 
					// Assumption: Second level from top only has 1 dependency, root. 		
					for (int j=0;j<dependency_list.size();j++)
					{
						
						if (dependency_list.get(j).equals(root.name))
						{
							// add jth node as a connection to the root node
							root.connections.add(input_list.get(j));							
						
							// add root as dependency to the jth node
							input_list.get(j).dependencies.add(root);
	
						}
					}
				
					// Reset i=0
					i=0;
					// Use i and iterate over both lists and make connections between the rest of the nodes
					
					while(i<input_list.size())
					{
						if (!(dependency_list.get(i).equals("NULL")) && !(dependency_list.get(i).equals(root.name)))
						{
							// Get the list of dependencies for input_list.get(i)
							String element_dependencies=dependency_list.get(i);
						    
							// convert the list of dependencies into a string array
							String dependency_array[] = element_dependencies.split(",");
						
							// iterate over this array and form connections in the dependency array lists and connections array lists.
							for (int k=0;k<dependency_array.length;k++)
							{
								//PRINT CHECK
						    	System.out.print(dependency_array[k]);
						    
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
						}
						//increment i
						i++;
					}
					
					
			}
			
}
			
			
			
		
		
		
		