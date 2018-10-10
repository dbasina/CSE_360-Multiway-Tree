import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class UserInterface extends JFrame
{
	JTextArea	txtAreaActivityList 	= new JTextArea("Activity Name \t\t"  + "Predecessor\t\t"   + "Duration\t\t");
	JLabel		lblActivityName			= new JLabel("Activity Name",JLabel.LEFT);
	JTextField 	txtActivityName			= new JTextField(6);
	
	JLabel 		lblPredecessor			= new JLabel("Predecessor",JLabel.LEFT);
	JTextField  txtPredecessor			= new JTextField(6);
	
	JLabel		lblDuration				= new JLabel("Duration",JLabel.LEFT);
	JTextField  txtDuration				= new JTextField(6);
	
	JButton		btnAdd					= new JButton("Add");
	JButton		btnCompute				= new JButton("Compute");
	JButton		btnHelp					= new JButton("Help");
	JButton		btnAbout				= new JButton("About");
	
	/*LinkedList that holds Operation Object*/
	private LinkedList<Operation> activityList	= new LinkedList<Operation>();
	
	public UserInterface()
	{
		JPanel flow1Panel 			= new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel flow2Panel			= new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel gridPanel			= new JPanel(new GridLayout(3,1));
		
		txtAreaActivityList.setEditable(false);
		flow1Panel.add(lblActivityName);
		flow1Panel.add(txtActivityName);
		
		flow1Panel.add(lblPredecessor);
		flow1Panel.add(txtPredecessor);
		
		flow1Panel.add(lblDuration);
		flow1Panel.add(txtDuration);
		flow2Panel.add(btnAdd);
		
		flow2Panel.add(btnCompute);
		flow2Panel.add(btnHelp);
		flow2Panel.add(btnAbout);
		
		gridPanel.add(flow1Panel);
		gridPanel.add(flow2Panel);
		
		add(txtAreaActivityList, BorderLayout.CENTER);
		add(gridPanel,BorderLayout.SOUTH);
		
		btnAdd.addActionListener(event->addActivity()); 						/*Adding action to Add Button*/
		btnAbout.addActionListener(event->addAboutNotice());					/*Adding action to About Button*/
		btnHelp.addActionListener(event->addHelpNotice());						/*Adding action to Help Button*/
		btnCompute.addActionListener(event->addDisplayComputationResult());		/*Adding action to Compute Button*/
	}
	
	private void addDisplayComputationResult()
	{
		//Graph g = new Graph();
		txtAreaActivityList.setText("");
		for(Operation op : activityList)
		{
			txtAreaActivityList.append(op +"\n");
		}
	}
	
	/*'Help' Button Action */
	private void addHelpNotice()
	{
		try 
		{
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "
							+ "https://www.cdn.devyashis.me/dev/null/help.pdf");
		}
		catch (Exception evt) 
		{
			JOptionPane.showMessageDialog(null, "Error occured while retrieving the file!");
		}
	}
	
	/*'About' Button Action */
	private void addAboutNotice()
	{
		String msg_about = "<html><body><div width='600px' align='center'>Program Name: Path Detector <br/> Description:The Path Detector is a software program to analyze a network diagram and determine all paths in the network <br/><br/> ===Contributers=== <br/>Faruk Karagoz<br/> Alison Mayer<br/> Divesh Dinoli <br/> Yash <br/><br/> ARIZONA STATE UNIVERSITY <br/> Computer Science</body></html>";
		JOptionPane.showMessageDialog(null, msg_about);	
	}
	
	/*'Add' Button Action Performed: add user input to  data structure called LinkedList */
	private void addActivity()
	{
		boolean isActivityNameUnique = true;
		boolean hasPathOneRoot = true;
		
		if(txtActivityName.getText().isEmpty() || 
				   txtPredecessor.getText().isEmpty()  ||
				   txtDuration.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "All Fields must be filled");
		}
		else
		{
			for(Operation op : activityList)
			{
				if(op.getActivityName().compareTo(txtActivityName.getText()) == 0)
				{
					isActivityNameUnique = false;
				}
				if(op.getPredecessor().compareToIgnoreCase(txtPredecessor.getText())==0)
				{
					hasPathOneRoot = false;
				}
			}
		
			if(isActivityNameUnique == false)
			{
				JOptionPane.showMessageDialog(null, "Error: This Avtivity is already in Database!");
			}
			/* Commenting out to try out the gui.
			if(hasPathOneRoot == false)
			{
				JOptionPane.showMessageDialog(null, "Error: Network must contain only one root");
			}
			*/	
			else
			{
				activityList.add(new Operation
				(txtActivityName.getText(),txtPredecessor.getText(),txtDuration.getText()));
				addDisplayComputationResult();
			}
		}
	}
	
	public static void initializeGUI()
	{
		UserInterface frame = new UserInterface();
		frame.setTitle("Path Detector");
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
}
