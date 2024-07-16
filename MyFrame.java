import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;

public class MyFrame extends JFrame {
  
  MyFrame(){
      this.setTitle("Calculator");
      this.setSize(400,420);
      this.setVisible(true);
      this.setResizable(false);

      ImageIcon image = new ImageIcon("calcc.png");
      this.setIconImage(image.getImage());
      this.getContentPane().setBackground(Color.CYAN);
  }
  
}
