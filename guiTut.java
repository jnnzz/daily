import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import javax.swing.ImageIcon;


public class guiTut {
  public static void main(String[] args){

//LABELS
      JLabel label = new JLabel();
      label.setText("hi welcome to this calculator");
      // label.setIcon(image);
      label.setHorizontalTextPosition(JLabel.CENTER);
      label.setVerticalTextPosition(JLabel.CENTER);
      label.setForeground(Color.MAGENTA);
      label.setFont(new Font("MV Boli", Font.PLAIN,50));
      // label.setIconTextGap(-25);
      label.setBackground(Color.BLACK);
      label.setOpaque(true);
      // label.setBorder(border);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setVerticalAlignment(JLabel.TOP);

//JFRAME   
      JFrame frame = new JFrame();
      frame.setTitle("Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,500);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.add(label);
      // frame.pack();

//IMAGE
      ImageIcon image = new ImageIcon("calcc.png");
      frame.setIconImage(image.getImage());
      // frame.getContentPane().setBackground(Color.CYAN);


      // MyFrame MyFrame = new MyFrame();

  }
}


