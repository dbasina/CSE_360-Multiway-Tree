import java.util.*;
import java.util.ArrayList;

public class multiway_node
{
		
		boolean					status;
		int						length_dependencies;
		int						duration;
		ArrayList<multiway_node>			dependencies;
		ArrayList<multiway_node>			connections;	
		String					name="";
	
	
	
	public multiway_node(String input_name,int input_duration,ArrayList<multiway_node> input_dependencies)
	{
			
				
			status 		= false;
			duration	= input_duration;
			name		= input_name;
		    dependencies = new ArrayList<multiway_node> ();
		    connections	=  new ArrayList<multiway_node>();
		    length_dependencies	= dependencies.size();
		    	
	}
}
	
	
	