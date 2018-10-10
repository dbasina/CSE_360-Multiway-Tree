import java.util.*;
import java.util.ArrayList;



public class 	multiway_tree
{
			
			// Data for a multiway_tree.
			// Root: 			Dummy node. Every tree has dummy node to make 
			//					it easy to handle input data with multiple starting nodes.
			// input_list_main: After initializing the data, input_list_main contains all the data nodes.
			// errors		  : This is an ArrayList used in the cycle_check algorithm
			// output_path    : ArrayList of strings that contain the output path data.
			// path			  : ArrayList that is used in compute_paths implementation. Does not have important data.
			
			 
			// Data:
			multiway_node  root= new multiway_node("root",0);	
			ArrayList<multiway_node> input_list_main = new ArrayList<multiway_node>();
			ArrayList<String> errors = new ArrayList<String>();
			ArrayList<String> output_path = new ArrayList<String>();
			ArrayList<String> path = new ArrayList<String>();
			int sum =0;	
			
			
				
			public void initialize_tree(ArrayList<String> input_list_string, ArrayList<String> dependency_list_main, ArrayList<String> duration_list)
			{
					// Initialize nodes from the arraylist of node names into actual nodes
					// Store these nodes in an arraylist of multiway nodes. 
					
					for (int i=0;i<input_list_string.size();i++)
					{
						multiway_node new_node = new multiway_node();
						new_node.name = input_list_string.get(i);
						input_list_main.add(new_node);
					}
					
					// initialize the string_dependencies array of each node. 
					for(int t=0;t<input_list_main.size();t++)
					{
						String temp[] = dependency_list_main.get(t).split(",");
						for (int u=0;u<temp.length;u++)
						{
							input_list_main.get(t).string_dependencies.add(temp[u]);
						}
					}
					
					// Initialize the durations of the nodes. 
					
					for (int i=0;i<duration_list.size();i++)
					{
						input_list_main.get(i).duration=Integer.parseInt(duration_list.get(i));
					}
					
					int i=0;
					
					// Go to each node in input_list_main
					
					while (i<input_list_main.size())
					{
						// Access the node's string_dependencies ArrayList
						multiway_node temp = input_list_main.get(i);
						ArrayList<String> temp_string_dependencies = temp.string_dependencies;
						
						// check each dep_string in string_dependencies with the names in input_list_main.
						for (int j=0;j<temp_string_dependencies.size();j++)
						{
							String dep_string = temp_string_dependencies.get(j);
							// If dep_string = "NULL" then we are currently looking at root node. 
							if (dep_string.equals("NULL"))
							{
								root.connections.add(temp);
								temp.dependencies.add(root);
							}
							
							// If not, then we iterate over the names of nodes in input_list_main
							else
							{
								for (int k=0; k<input_list_main.size();k++)
								{
									String node_name = input_list_main.get(k).name;
									// If match, add temp to connection of input_list_main.get(k)
									// and add input_list_main.get(k) to the dependency of temp.
									if (node_name.equals(dep_string))
									{
										temp.dependencies.add(input_list_main.get(k));
										input_list_main.get(k).connections.add(temp);
									}
								}
							}
						
						}
						i++;
					 }	
			}
					
			public void print_tree(multiway_node node)
			{
				// This method is to understand how the recursion algorithm access elements in the tree.
				if(node.connections.size()==0)
				{
					System.out.println(node.name);
					return;
				}
				
				else
				{
					System.out.println(node.name);
					int i=0;
					while(i<node.connections.size())
					{
						
						print_tree(node.connections.get(i));
						i++;
					}
				}
			}
			
			public void compute_paths(multiway_node node)
			{
					
				// The calling function needs to input an empty ArrayList path which is used in the storing each node while 
				// computing paths. This ArrayList does not output any important information. It is just a helper parameter. 
				// The method uses ArrayList path for storing the path string at the end of each recursion
							 
				if(node.connections.size()==0)
				{
					path.add(node.name);
					sum = sum + (node.duration);
					String temp ="";

					for (int i=1;i<path.size();i++)
					{
						temp = temp+path.get(i)+":";					
					}
					temp = temp+ Integer.toString(sum);
					output_path.add(temp);
								
					path.remove(node.name);
					sum = sum-(node.duration);
					
					return;
				}
				
				else
				{
					int i=0;
					while(i<node.connections.size())
					{
						path.add(node.name);
						sum = sum + (node.duration);
						
						compute_paths(node.connections.get(i));
								
						path.remove(node.name);
						sum = sum - (node.duration);
						i++;
					}
				}
			}
		
			public void sort_paths()
			{
				// Call this method on the output_path ArrayList that was used as a parameter for compute_paths method
				// Bubble sort algorithm for sorting the outputs.
				int n = output_path.size(); 
       			 for (int i=0; i< n-1; i++)
       			 {
       			 	for (int j=0; j < n-i-1; j++)
       			 	{
       			 		if (path_time(output_path.get(j)) < path_time(output_path.get(j+1))) 
               				 { 
                  				  Collections.swap(output_path, j, j+1);
                			} 
       			 	} 
               		 
       			 }
            		
					
			}
			
			
			public int path_time(String path)
			{
				// Helper Function used to extract the duration from the end of a path string.
				String[] temp = path.split(":");
				int len = temp.length;
				return Integer.parseInt(temp[len-1]);
			}
			
			public void cycle_check(multiway_node node)
			{
			
				if(node.connections.size()==0)
				{
					node.status = true;
					return;
				}
				
				if(node.status==true)
				{
					String error_message ="Cycle detected: Aborting...";
					errors.add(error_message);
					return;
				}
				
				else
				{
					
					int i=0;
					while(i<node.connections.size())
					{
						node.status=true;
						cycle_check(node.connections.get(i));
						node.status = false;
						i++;
					}
				}
			}
			
			public ArrayList<String> output()
			{
				// Return the paths in sorted descending order as an ArrayList<String>
				
				this.cycle_check(this.root);
				if (this.errors.size()==0)
				{
					this.compute_paths(this.root);
					this.sort_paths();
				}
				
				else
				{
					System.out.println("Cycle Error Detected: Abort Program");
				}
				return this.output_path;
			}
}
			
			
			
		
		
		
		