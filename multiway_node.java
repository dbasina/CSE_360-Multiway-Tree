import java.util.*;
import java.util.ArrayList;

public class multiway_node
{
		
		boolean					status;
		int						length_dependencies;
		int						duration;
		ArrayList<String>		string_dependencies;
		ArrayList<multiway_node>			dependencies;
		ArrayList<multiway_node>			connections;	
		String					name="";
	
	
	public multiway_node(String input_name,int input_duration)
	{
			
				
			status 		= false;
			duration	= input_duration;
			name		= input_name;
		    dependencies = new ArrayList<multiway_node> ();
		    connections	=  new ArrayList<multiway_node>();
		    length_dependencies	= dependencies.size();
		    string_dependencies = new ArrayList<String>();
		    	
	}
	public multiway_node()
	{
			status 		= false;
			duration	= 0;
			name		= "";
			string_dependencies = new ArrayList<String>();
		    dependencies = new ArrayList<multiway_node> ();
		    connections	=  new ArrayList<multiway_node>();
		    length_dependencies	= dependencies.size();
	}
	
	
	
}
	
	
	