import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 class lanceTest extends JFrame implements ActionListener {
    JPanel upPanel, Frontview,downPanel,centerWHITE;

    lanceTest() {

        ImageIcon jollibee = new ImageIcon("soda.png");
        this.setIconImage(jollibee.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel();

        label.setText("REVIEW YOUR ORDER");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("ARIAL", Font.PLAIN, 30));

        JButton button = new JButton();
        button.setBounds(0,200,300,20);
        button.setIcon(jollibee);
        button.setText("EDIT ORDER");

        upPanel = new JPanel();
        upPanel.setBackground(Color.DARK_GRAY);
        upPanel.setBounds(0,0,650,90);
        upPanel.setLayout(new BorderLayout());

        Frontview = new JPanel();
        Frontview.setBackground(Color.RED);
        Frontview.setBounds(0, 90, 650, 750);
        Frontview.add(button);


        downPanel = new JPanel();
        downPanel.setBackground(new Color(99, 0, 0));
        downPanel.setBounds(0,595,625,100);

        centerWHITE = new JPanel();
        centerWHITE.setBackground(Color.WHITE);
        centerWHITE.setBounds(0, 170, 650, 500);



        this.setSize(625,700);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        upPanel.add(label);
        this.add(upPanel);
        this.add(downPanel);
        this.add(centerWHITE);
        this.add(Frontview);

    }

    public static void main(String[] args) {
        new lanceTest();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}