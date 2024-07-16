import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {
    private static JLabel idlabel;
    private static JTextField idText;
    private static JLabel departmentLabel;
    private static JPasswordField departmentText;
    private static 	JButton button;
    private static JLabel success;
    
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(100 , 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		idlabel = new JLabel("id");
		idlabel.setBounds(10,  20,  80,  25);
		panel.add(idlabel);
		idText = new JTextField();
		idText.setBounds(100, 20,165,25);
		panel.add(idText);
		departmentLabel = new JLabel("Department");
		departmentLabel.setBounds(10,50,80,25);
		panel.add(departmentLabel);
		departmentText = new JPasswordField();
		departmentText.setBounds(100, 50, 165, 25);
		panel.add(departmentText);
	    button = new JButton("submit");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new GUI());
		panel.add(button);
	    success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		frame.setVisible(true);
		
		
				

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = idText.getText();
		String department = departmentText.getText();
		System.out.println(id + " ," +department);
		if(id.equals("cse") && department.equals("proffessor")) 
		{
		  System.out.println("D block");
		
		}
		else if(id.equals("ece") && department.equals("a.proffessor"))
		{
		  System.out.println("E block");
		}
		else if(id.equals("mec") && department.equals("a.proffessor"))
		{
			System.out.println("E block");
		}
		else
		{
			System.out.println("common block");
		}
	}
}