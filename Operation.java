public class Operation
{
	String activity_name;
	String predecessor;
	String duration;
	
	public Operation()
	{
		activity_name 	= "";
		predecessor 	= "";
		duration 		= "";
	}
	
	public Operation(String activity_name, String predecessor, String duration)
	{
		this.activity_name		= activity_name;
		this.predecessor		= predecessor;
		this.duration			= duration;
	}
	
	public String getActivityName()
	{
		return this.activity_name;
	}
	
	public String getPredecessor()
	{
		return this.predecessor;
	}
	
	public String getDuration()
	{
		return this.duration;
	}
	
	public void setActivityName(String activity_name)
	{
		this.activity_name = activity_name;
	}
	
	public void setPredecessor(String predecessor)
	{
		this.predecessor = predecessor;
	}
	public void setDuration(String duration)
	{
		this.duration = duration;
	}
	
	public String toString()
	{
		return "Activity Name:  "+activity_name + "\tPredecessor:  "+ predecessor + "\tDuration  " + duration ;
	}
}
