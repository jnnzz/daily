/*
Name: Barral, Jacinth Cedric C.
Date: March 27, 2024
Description: Using Java, create a calculator that can perform arithmetic operations such as Addition, Subtraction, Multiplication, Division and Modulo.
                For an additional point for your project, you may include conversions from Decimal to Octal, Decimal to Hexadecimal and Decimal to Binary numbers.
                The Java program for the calculator should use the topics 
                already discussed such as Decision making and branching, loops and arrays.
* */

import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class CalculatorWithGUI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exitLoop = false;
        char choice;

        System.out.println("*******************************************");
        System.out.println("\t  Simple Calculator w/ Conversion");
        System.out.println("*******************************************\n");

        System.out.println("*******************************************");
        System.out.println("\t  NOTE: Only takes 2 input :(");
        System.out.println("*******************************************\n\n");
        do{
            System.out.println("Start Program (Y for yes, N for No) ");
            System.out.print("--------->:: ");
            choice = in.next().charAt(0);
            choice = Character.toUpperCase(choice);

            in.nextLine();
            System.out.println();

            if(choice !='Y' && choice != 'N'){
                System.out.println("Invalid Input, try again!\n");
            }
            else if(choice == 'Y'){
                System.out.println("Starting...");
                callMainWindow();
                exitLoop = true;
            }
            else{
                System.out.println("Exiting....");
                System.out.println("Thank You and Goodbye!");
                exitLoop = true;
            }
        }while(!exitLoop);

        in.close();

//         DEbug
//         callMainWindow();
    }

    static void callMainWindow(){
      new mainWindow();
//        operationWindow operWind = new operationWindow("Testing", 0);
//        new operationWindow("Division", 4);
//         new operationWindow("Testing");


    }
}

class mainWindow extends JFrame implements ActionListener {
    operationWindow operWind;
    JPanel mainPanelWrapper, headerPanel, bodyElementPanel, elementPanel;
    JPanel[] elementContainer;
    JLabel titleLabel;
    JLabel[] buttonTitles, buttonContainer;
    JButton[] mainButtons;
    // ************************ Button Lists ************************
    String[] mainMenu = {"Addition", "Subtraction", "Multiplication", "Division", "Modulo", "Conversion", "All Operations?", "Exit Program"};
    String[] menuLogo = {"+", "-", "*", "/", "%", "-->", "-all-", "0"};


    public mainWindow(){


        // ************************ Button Titles, Button Containers, and Buttons Intializer ************************
        buttonTitles = new JLabel[mainMenu.length];
        buttonContainer = new JLabel[mainMenu.length];
        mainButtons = new JButton[mainMenu.length];
        for(byte  i = 0; i< mainMenu.length; i++){

            /*----------------- Main Buttons -----------------*/

            mainButtons[i] = new JButton("<html><p style='color: #353839; font-size: 10px; padding-left: 6px;'>" + mainMenu[i] + "</p></html>");

            mainButtons[i].setHorizontalAlignment(JButton.LEFT);
            mainButtons[i].setFont(new Font("Calibri", Font.BOLD, 14));
            mainButtons[i].addActionListener(this);
            mainButtons[i].setFocusable(false);
            mainButtons[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//            mainButtons[i].setBorder(BorderFactory.createLineBorder(black, 1));

            mainButtons[i].setBackground(new Color(172, 221, 250));

            /*----------------- Button Titles -----------------*/

            buttonTitles[i] = new JLabel(mainMenu[i], JLabel.LEFT);


            buttonTitles[i].setText("<html><p style='color: #353839; white-space: nowrap;'>\n" +"(" +menuLogo[i]+ ")  "+ mainMenu[i]  +"</p></html>");
            buttonTitles[i].setFont(new Font("Calibri", Font.PLAIN, 16));
            buttonTitles[i].setBorder(BorderFactory.createEmptyBorder(3,5,3,5) );

//            buttonTitles[i].setBorder(BorderFactory.createLineBorder(black, 1));

            /*----------------- Button Containers -----------------*/
            buttonContainer[i] = new JLabel();

            buttonContainer[i].setHorizontalAlignment(JLabel.CENTER);
            buttonContainer[i].setLayout(new BorderLayout());
            buttonContainer[i].setBorder(BorderFactory.createEmptyBorder(3,5,3,5) );

            buttonContainer[i].add(mainButtons[i]);
        }
        // ************************ last Button to be color RED ************************
        mainButtons[mainMenu.length -1].setBackground(new Color(250, 172, 172));


        // ************************ Elements Container ************************
        elementContainer = new JPanel[2];
        for(byte  i = 0; i < 2; i++){
            elementContainer[i] = new JPanel();

            elementContainer[i].setOpaque(false);
            elementContainer[i].setLayout(new GridLayout(mainMenu.length, elementContainer.length));

        }
        // ************************ ADD items to Element container ************************
        for(byte j = 0; j < mainMenu.length; j++){
            elementContainer[0].add(buttonTitles[j]);
            elementContainer[1].add(buttonContainer[j]);
        }

        // ************************ Elements Panel Cont ************************

        elementPanel = new JPanel();

        elementPanel.setOpaque(true);
        elementPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        elementPanel.setLayout(new GridLayout(1,2,5,5));
        elementPanel.setBackground(new Color(238, 238, 238));

        elementPanel.add(elementContainer[0]);
        elementPanel.add(elementContainer[1]);


        // ************************ Title Label ************************
        titleLabel = new JLabel();

        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(255, 243, 176));
        titleLabel.setText("<html><div style='text-align: center;'><p style='color: #353839; font-size: 30px;'>Simple Calculator</p><p>Barral, Jacinth Cedric C.</p><p>BSIT - 1B</p></div></html>");

        titleLabel.setFont(new Font("Calibri", Font.BOLD, 17));


        // ************************ Header Panel ************************
        headerPanel = new JPanel();

        headerPanel.setOpaque(true);
        headerPanel.setPreferredSize(new Dimension(300, 150));
        headerPanel.setBackground(new Color(48, 48, 48));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        headerPanel.setLayout(new BorderLayout(10,10));

        headerPanel.add(titleLabel, BorderLayout.CENTER);


        // ************************ Body Element Panel  ************************
        bodyElementPanel = new JPanel();

        bodyElementPanel.setOpaque(true);
        bodyElementPanel.setPreferredSize(new Dimension(300, 150));
        bodyElementPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        bodyElementPanel.setBackground(new Color(48, 48, 48));

        bodyElementPanel.setLayout(new BorderLayout());
        bodyElementPanel.add(elementPanel, BorderLayout.CENTER);


        // ************************ Main Panel Wrapper ************************

        mainPanelWrapper = new JPanel();

        mainPanelWrapper.setOpaque(true);
        mainPanelWrapper.setLayout(new BorderLayout());

        mainPanelWrapper.add(headerPanel, BorderLayout.NORTH);
        mainPanelWrapper.add(bodyElementPanel, BorderLayout.CENTER);



        // ************************ Main Window ************************
        this.setTitle("Simple Calculator");
        this.setSize(new Dimension(400,500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(mainPanelWrapper, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton source = (JButton) e.getSource();
        buttonEventController(source);

    }

    public void buttonEventController(JButton source){
        for (int i = 0; i < mainMenu.length; i++) {
            if (source == mainButtons[i]) {
                switch (i) {
                    case 0:
                        System.out.println("Addition");
                        dispose();
                        operWind = new operationWindow("Addition", (i+1));
                        // Barral, Jacinth Cedric
                        break;
                    case 1:
                        System.out.println("Subtraction");
                        dispose();
                        operWind = new operationWindow("Subtraction", (i+1));
                        
                        break;
                    case 2:
                        System.out.println("Multiplication");
                        dispose();
                        operWind = new operationWindow("Multiplication", (i+1));
                        break;
                    case 3:
                        System.out.println("Division");
                        dispose();
                        operWind = new operationWindow("Division", (i+1));
                        
                        break;
                    case 4:
                        System.out.println("Modulo");
                        dispose();
                        operWind = new operationWindow("Modulo", (i+1));
                        
                        break;
                    case 5:
                        System.out.println("Conversion");
                        dispose();
                        operWind = new operationWindow("Conversion");
                        
                        break;
                    case 6:
                        System.out.println("All Operations");
                        dispose();
                        operWind = new operationWindow("All Operations", (i+1));
                        
                        break;
                    case 7:
                        System.out.println("Exiting Program");
                        dispose();
                        JOptionPane.showMessageDialog(null, "Thank you! and Goodbye!! :D", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                    default:
                        // Optional
                        break;
                }
                break;
            }
        }


    }
}

class operationWindow extends JFrame implements ActionListener{
    mainOperations operations = new mainOperations();
    JPanel mainPanelWrapper, headerPanel, bodyElementPanel;
    JLabel titleLabel, mainBodyLabel;
    JButton calculate, backButton;
    JLabel[] textFieldTitle;
    JTextField[] userInput;
    int eventIndex;
    double[] numberInput;

    // ************************ Variables for the Conversion Window ************************

    JLabel[] labelElements, labelElementsTitle;
    JTextField[] resultFields;
    JTextField numberToConvert;
    JLabel inputTitle, interactLabel, inputAndConvert;
    JButton convertButton, resetButton;
    String[] conversionMenu = {"Decimal to Binary",  "Decimal to Hex", "Decimal to Octal" };
    String[] conversionTitle = {"Binary",  "Hex", "Octal" };

    String[] binary, octal, hexaDecimal;
    String operTitle, userInSTR;
    int userInNum =0, index = 0;

    /*-------------Operations Window -------------*/

    operationWindow(String title, int event){
        // Indicator for what Operation to Use
        this.eventIndex = event;
        this.operTitle = title;

        
        textFieldTitle = new JLabel[2];
        userInput = new JTextField[2];

        for(byte i = 0; i < 2; i++){

            textFieldTitle[i] = new JLabel("<html><p style='color: #353839;'><b>Input Number " +(i+1)+":</b></p></html>");
            textFieldTitle[i].setFont(new Font("Calibri", Font.PLAIN, 15));
            textFieldTitle[i].setHorizontalAlignment(JLabel.CENTER);

            // *********************** UserInput for the Operations ***********************
            userInput[i] = new JTextField();

            userInput[i].setPreferredSize(new Dimension(150, 150));
            userInput[i].setOpaque(true);
            userInput[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(10, 10, 10, 10) ));
            Font currentFont = userInput[i].getFont();
            Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 5);
            userInput[i].setFont(newFont);
        }

        // *********************** Back To Menu button ***********************
        backButton = new JButton("<html><p style='color: #353839;'>Back to Menu</p></html>");

        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setFont(new Font("Calibri", Font.BOLD, 18));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(172, 221, 250));


        // *********************** Calculate Button***********************
        calculate = new JButton("<html><p style='color: #353839;'>Calculate</p></html>");

        calculate.setHorizontalAlignment(JButton.CENTER);
        calculate.setFont(new Font("Calibri", Font.BOLD, 18));
        calculate.addActionListener(this);
        calculate.setFocusable(false);
        calculate.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        calculate.setBackground(new Color(182, 250, 172));


        mainBodyLabel = new JLabel();

        mainBodyLabel.setOpaque(true);
        mainBodyLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainBodyLabel.setLayout(new GridLayout(3,2,5,5));
        mainBodyLabel.setBackground(new Color(240, 240, 240 ));

        // *********************** Adding items in MainBodyLabel ***********************
        mainBodyLabel.add(textFieldTitle[0]);
        mainBodyLabel.add(userInput[0]);
        mainBodyLabel.add(textFieldTitle[1]);
        mainBodyLabel.add(userInput[1]);
        mainBodyLabel.add(calculate);
        mainBodyLabel.add(backButton);


        // ************************ Title Label ************************
        titleLabel = new JLabel();

        titleLabel.setOpaque(true);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        titleLabel.setText("<html><div style='text-align: center;'><p style='color: #353839; word-wrap: break-word;'><b>" + operTitle.toUpperCase() + "</b>: Press the <b>Calculate</b> Button for the Results</p></div></html>");
        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
        titleLabel.setBackground(new Color(255, 243, 176));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // ************************ Header Panel ************************
        headerPanel = new JPanel();

        headerPanel.setOpaque(true);
        headerPanel.setPreferredSize(new Dimension(400,100));
        headerPanel.setBackground(new Color(48, 48, 48));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        headerPanel.setLayout(new BorderLayout(10,10));

        headerPanel.add(titleLabel, BorderLayout.CENTER);


        // ************************ Body Element Panel  ************************
        bodyElementPanel = new JPanel();

        bodyElementPanel.setOpaque(true);
        // bodyElementPanel.setPreferredSize(new Dimension(300, 150));
        bodyElementPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        bodyElementPanel.setBackground(new Color(48, 48, 48));
        bodyElementPanel.setLayout(new BorderLayout());

        bodyElementPanel.add(mainBodyLabel, BorderLayout.CENTER);




        // ************************ Main Panel Wrapper ************************
        mainPanelWrapper = new JPanel();

//        mainPanelWrapper.setOpaque(true);
//        mainPanelWrapper.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//        mainPanelWrapper.setBackground(new Color(48, 48, 48));
        mainPanelWrapper.setLayout(new BorderLayout());
        // mainPanelWrapper.setBorder(BorderFactory.createLineBorder(black,2));

        mainPanelWrapper.add(headerPanel, BorderLayout.NORTH);
        mainPanelWrapper.add(bodyElementPanel, BorderLayout.CENTER);





        // ************************ Main Window ************************
        this.setTitle(operTitle);
        this.setSize(new Dimension(350,300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.add(mainPanelWrapper, BorderLayout.CENTER);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
        


    }
    // ************************ Conversion Windwo ************************
    operationWindow(String title){

        // ************************ Label Elements ************************
        this.operTitle = title;
        labelElements = new JLabel[2];

        for(byte i=0; i < labelElements.length; i++){
            
            labelElements[i] = new JLabel();

//            labelElements[i].setOpaque(true);
            labelElements[i].setBackground(new Color(240, 240, 240 ));
        }
        labelElements[0].setPreferredSize(new Dimension(50,150));
        labelElements[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        labelElements[0].setLayout(new GridLayout(3,2,5,5));
        

        // ************************ Items in the Label Elements index 0 (Bottom) ************************

        labelElementsTitle = new JLabel[3];
        resultFields = new JTextField[3];

        for(byte i =0; i < labelElementsTitle.length; i++){

            labelElementsTitle[i] = new JLabel();

            labelElementsTitle[i].setOpaque(true);
            labelElementsTitle[i].setBackground(new Color(250, 232, 215));
            labelElementsTitle[i].setText(conversionMenu[i]);
            labelElementsTitle[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(10, 10, 10, 10) ));

            // ************************ Result Fields ************************

            resultFields[i] = new JTextField();

            resultFields[i].setOpaque(true);
            resultFields[i].setBackground(new Color(254, 255, 231 ));

            resultFields[i].setEditable(false);
            resultFields[i].setText(conversionTitle[i]);
            resultFields[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(10, 10, 10, 10) ));


            labelElements[0].add(labelElementsTitle[i]);
            labelElements[0].add(resultFields[i]);
        }


        // ************************ Items in the Label Elements index 1 (Top) ************************


        // labelElements[1].setPreferredSize(new Dimension(50,50));
        labelElements[1].setLayout(new BorderLayout(0,15));
        labelElements[1].setBorder(BorderFactory.createEmptyBorder(0, 10,10, 10));


        // ************************ Title ************************

        inputTitle = new JLabel();
        inputTitle.setPreferredSize(new Dimension(100, 50));
        inputTitle.setOpaque(true);
        inputTitle.setText("<html><p style='font-family: Calibri; font-size: 18px; text-align: center;'>Input Number to Convert<br><span style='font-size: 12px; color: #FF5733;'>Note: Can only convert up to 7 digits</span></p></html>");
        inputTitle.setHorizontalAlignment(JLabel.CENTER);
        

        // ************************ Label Container for USER INTERACTION ************************
        interactLabel = new JLabel();

        interactLabel.setPreferredSize(new Dimension(50,50));
        // interactLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        interactLabel.setLayout(new GridLayout(1,2,5,5));


        
        // ************************ Text Field for INPUT ************************
        numberToConvert = new JTextField();

        numberToConvert.setOpaque(true);
        numberToConvert.setBackground(white);
        numberToConvert.setText("Enter Number Here");

        Font currentFont = numberToConvert.getFont();
        // Create a new font with a larger size
        Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 5); // Increase font size by 5 points
        numberToConvert.setFont(newFont);
        numberToConvert.setCaretPosition(0);
        numberToConvert.setPreferredSize(new Dimension(100,50));
        numberToConvert.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(5,10,5,10) ));
        numberToConvert.setHorizontalAlignment(JTextField.LEFT);

        convertButton = new JButton("<html><p style='color: #353839;'>Convert</p></html>");

        convertButton.setHorizontalAlignment(JButton.CENTER);
        convertButton.setPreferredSize(new Dimension(100,50));
        convertButton.setFont(new Font("Calibri", Font.BOLD, 18));
        convertButton.addActionListener(this);
        convertButton.setFocusable(false);
        convertButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        convertButton.setBackground(new Color(182, 250, 172));

        inputAndConvert = new JLabel();

        inputAndConvert.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputAndConvert.setLayout(new BorderLayout(10,0));
        inputAndConvert.setOpaque(true);
        inputAndConvert.setBackground(new Color(238, 238, 238));

        inputAndConvert.add(convertButton, BorderLayout.EAST);
        inputAndConvert.add(numberToConvert, BorderLayout.CENTER);

        // ------------------------------------------------- Items inside Interact Label -------------------------------------------------

        // ************************ Back to Menu Button ************************
        // backButton settings
        backButton = new JButton("<html><p style='color: #353839;'>Back to Menu</p></html>");

        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setFont(new Font("Calibri", Font.BOLD, 18));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(172, 221, 250));

        // ************************ Convert Button ************************
        // convertButton settings
        resetButton = new JButton("<html><p style='color: #353839;'>Reset</p></html>");

        resetButton.setHorizontalAlignment(JButton.CENTER);
        resetButton.setFont(new Font("Calibri", Font.BOLD, 18));
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        resetButton.setBackground(new Color(250, 172, 172));

        // ************************ Adding Items into Interact Label ************************

        interactLabel.add(resetButton);
        interactLabel.add(backButton); 


        // ************************ LAYOUT FOR THE TWO LABELS ************************

        labelElements[1].add(inputTitle, BorderLayout.NORTH);
        labelElements[1].add(inputAndConvert, BorderLayout.CENTER);
        labelElements[1].add(interactLabel, BorderLayout.SOUTH);


        // ************************ Main Body Label in Body Element Panel ************************
        mainBodyLabel = new JLabel();

        mainBodyLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainBodyLabel.setLayout(new BorderLayout());
        mainBodyLabel.setOpaque(true);
        mainBodyLabel.setBackground(new Color(238, 238, 238));

        mainBodyLabel.add(labelElements[0], BorderLayout.SOUTH);
        mainBodyLabel.add(labelElements[1], BorderLayout.CENTER);
        // mainBodyLabel.add(labelElements[2], BorderLayout.SOUTH);


        // ************************ Title Label ************************

        titleLabel = new JLabel();

        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        titleLabel.setOpaque(true);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        titleLabel.setText("<html><div style='text-align: center;'><p style='color: #353839; word-wrap: break-word;'><b>" + operTitle.toUpperCase() + "</b>: Press the <b>Convert</b> Button for the Results</p></div></html>");
        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
        titleLabel.setBackground(new Color(255, 243, 176));
       
        
        
        // ************************ Header Panel ************************
        headerPanel = new JPanel();

        headerPanel.setOpaque(true);
        headerPanel.setPreferredSize(new Dimension(400,100));
        headerPanel.setBackground(new Color(48, 48, 48));

        headerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        headerPanel.setLayout(new BorderLayout(10,10));

        headerPanel.add(titleLabel, BorderLayout.CENTER);


        // ************************ Body Element Panel  ************************
        bodyElementPanel = new JPanel();

        bodyElementPanel.setOpaque(true);
        // bodyElementPanel.setPreferredSize(new Dimension(300, 150));
        bodyElementPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        bodyElementPanel.setBackground(new Color(48, 48, 48));
        bodyElementPanel.setLayout(new BorderLayout());

        bodyElementPanel.add(mainBodyLabel, BorderLayout.CENTER);


        // ************************ Main Panel Wrapper ************************
        mainPanelWrapper = new JPanel();

        mainPanelWrapper.setOpaque(true);
        mainPanelWrapper.setLayout(new BorderLayout());


        mainPanelWrapper.add(headerPanel, BorderLayout.NORTH);
        mainPanelWrapper.add(bodyElementPanel, BorderLayout.CENTER);


        // ************************ Main Window ************************
        this.setTitle(operTitle);
        this.setSize(new Dimension(400,500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.add(mainPanelWrapper, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton) e.getSource();
        eventController(source);
    }

    public void eventController(JButton source){
        // ************************ Checking for the Calculate Button ************************
        if(source == calculate){
            if(!userInput[0].getText().isEmpty() && !userInput[1].getText().isEmpty()){
                try{
                    operationEvent();

                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Invalid Input, try Again!", "Error", JOptionPane.ERROR_MESSAGE);
                    resetValue();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Numbers in the Specified Fields!", "Error", JOptionPane.ERROR_MESSAGE);
                resetValue();
            }
        }

        // ************************ Checking for the Conversion Button ************************
        else if(source == convertButton){
            if(!numberToConvert.getText().isEmpty()){
                try{
                    conversionEvent();
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Invalid Input, try Again!", "Error", JOptionPane.ERROR_MESSAGE);
                    resetValueConversion();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Numbers in the Specified Fields!", "Error", JOptionPane.ERROR_MESSAGE);
                resetValueConversion();
            }
        }
        // ************************ Checking for the Back to Menu Button ************************
        else if(source == backButton){
            dispose();
            callBackMenu();
        }
        else if(source == resetButton){
            resetValueConversion();
        }
    }
    // ************************ Operation Methods ************************
    public void operationEvent(){
        String resultString = "", titleMessage = "";
        numberInput = new double[2];
        double decimalPart;
        boolean divisionByZero = false;
        boolean hasDecimalPoint, hasRemainder;
        switch (eventIndex) {
            case 1:
                // Addition
//                JOptionPane.showMessageDialog(null, "Addition EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }

                hasDecimalPoint = (int) (numberInput[0] * 10.0) % 10 == 0 && (int) (numberInput[1] * 10.0) % 10 == 0;

                resultString = (hasDecimalPoint) ? "Result: " + (int)operations.sumOfNum(numberInput) : String.format("Result: %.2f", operations.sumOfNum(numberInput));

                titleMessage = operTitle;
                break;
            case 2:
                // Subtraction

                // JOptionPane.showMessageDialog(null, "Subtraction EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                hasDecimalPoint = (int) (numberInput[0] * 10.0) % 10 == 0 && (int) (numberInput[1] * 10.0) % 10 == 0;
                resultString = (hasDecimalPoint) ? "Result: " + (int) operations.diffOfNum(numberInput) : String.format("Result: %.2f", operations.diffOfNum(numberInput));

                titleMessage = operTitle;
                break;
            case 3:
                // Multiplication
                // JOptionPane.showMessageDialog(null, "Multiplication EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                hasDecimalPoint = (int) (numberInput[0] * 10.0) % 10 == 0 && (int) (numberInput[1] * 10.0) % 10 == 0;

                resultString = (hasDecimalPoint) ? "Result: " + (int)operations.prodOfNum(numberInput) : String.format("Result: %.2f", operations.prodOfNum(numberInput));

                titleMessage = operTitle;
                break;
            case 4:
                // Division
                // JOptionPane.showMessageDialog(null, "Division EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }

                if(numberInput[1] == 0){
                    divisionByZero = true;
                }
                else{
                    System.out.println("Result Quotient: "+operations.quotientOfNum(numberInput));
                    System.out.println("Result Quotient (int) : "+(int)operations.quotientOfNum(numberInput));
                    decimalPart = operations.quotientOfNum(numberInput) - (int) operations.quotientOfNum(numberInput);
                    System.out.println("After the Decimal Point Numbers: " + decimalPart);
                    System.out.printf("Number Input 1: %s\n", ((int)(numberInput[0] * 10.0) % 10 == 0) ? "No Decimal" : "Hav Decimal");
                    System.out.printf("Number Input 2: %s\n", ((int)(numberInput[1] * 10.0) % 10 == 0) ? "No Decimal" : "Hav Decimal");
                    System.out.printf("Decimal Part: %s\n", decimalPart == 0 ? true : false);

                    hasDecimalPoint = (int) (numberInput[0] * 10.0) % 10 == 0 && (int) (numberInput[1] * 10.0) % 10 == 0 && decimalPart == 0 ;
                    System.out.println("Has Decimal?: " + hasDecimalPoint + "\n\n");
                    resultString = (hasDecimalPoint) ? "Result: " + (int) operations.quotientOfNum(numberInput) : String.format("Result: %.2f", operations.quotientOfNum(numberInput)) ;

                    titleMessage = operTitle;
                }
                break;
            case 5:
                // Modulo
                // JOptionPane.showMessageDialog(null, "Modulo EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }

                if(numberInput[1] == 0){
                    divisionByZero = true;
                }
                else{
                    System.out.println("Result Modulo: "+operations.moduloOfNum(numberInput));
                    System.out.println("Result Modulo (int) : "+(int)operations.moduloOfNum(numberInput));
                    decimalPart = operations.moduloOfNum(numberInput) - (int) operations.moduloOfNum(numberInput);
                    System.out.println("After the Decimal Point Numbers: " + decimalPart);
                    System.out.printf("Number Input 1: %s\n", ((int)(numberInput[0] * 10.0) % 10 == 0) ? "No Decimal" : "Hav Decimal");
                    System.out.printf("Number Input 2: %s\n", ((int)(numberInput[1] * 10.0) % 10 == 0) ? "No Decimal" : "Hav Decimal");
                    System.out.printf("Decimal Part: %s\n", decimalPart == 0 ? true : false);


                    hasDecimalPoint = (int)(numberInput[0] * 10.0) % 10 == 0 && (int) (numberInput[1] * 10.0) % 10 == 0 && decimalPart == 0 ;
                    System.out.println(hasDecimalPoint);

                    resultString = (hasDecimalPoint) ?  "Result: " + (int) operations.moduloOfNum(numberInput): String.format("Result: %.2f", operations.moduloOfNum(numberInput)) ;

                    titleMessage = operTitle;
                }
                break;
            case 7:
                // JOptionPane.showMessageDialog(null, "All Operations EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                hasDecimalPoint = (int) (numberInput[0] * 10.0) % 10 == 0 && (int) (numberInput[1] * 10.0) % 10 == 0;
                resultString = "Results\n\n" +
                    "Addition: " + ((hasDecimalPoint) ?  (int) operations.sumOfNum(numberInput): String.format("%.2f", operations.sumOfNum(numberInput))) +
                    " \nSubtraction: " + ((hasDecimalPoint) ? (int) operations.diffOfNum(numberInput) : String.format("%.2f", operations.diffOfNum(numberInput))) +
                    "\nMultiplication: " + ((hasDecimalPoint) ? (int) operations.prodOfNum(numberInput) : String.format("%.2f", operations.prodOfNum(numberInput))) +
                    "\nDivision: " + ((numberInput[1] != 0) ? ((operations.quotientOfNum(numberInput) - (int) operations.quotientOfNum(numberInput) == 0) ? (int) operations.quotientOfNum(numberInput) : String.format("%.2f", operations.quotientOfNum(numberInput))) : "Error!") +
                    "\nModulo: " + ((numberInput[1] != 0) ? ((operations.moduloOfNum(numberInput) - (int) operations.moduloOfNum(numberInput) == 0) ? (int) operations.moduloOfNum(numberInput) : String.format("%.2f", operations.moduloOfNum(numberInput)) ) : "Error!");
                titleMessage = operTitle;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error");
                break;
        }
        if(divisionByZero){
            JOptionPane.showMessageDialog(null, "Dividing By Zero is Not Allowed!, Try Again", "Error", JOptionPane.ERROR_MESSAGE);
            resetValue();
        }
        else{
            JOptionPane.showMessageDialog(null, resultString, titleMessage, JOptionPane.INFORMATION_MESSAGE);
//            resetValue();

        }

    }
    // Barral, Jacinth Cedric
    // ************************ Conversion Methods ************************
    
    
    
    public void conversionEvent(){
        // Get String from JTextField numberToConvert
        userInSTR = numberToConvert.getText().trim();

        String userInSTRTemp;
        // Assign boolean value if userInSTR contains "-" negative sign
        boolean isNegative = userInSTR.startsWith("-");
        // InputBuffer Limit only to 7 Characters excluding "-"
        final int maxInputBuffer = 7;
        // Input length from the user
        int inputLength;

        if(isNegative) {
            // isNegative is true, then

            // Gets the Temp value of "NEGATIVE" STring and then removes the '-' sign
            userInSTRTemp = userInSTR.replaceFirst("-", "");
//            System.out.println(userInSTRTemp);

            // userInSTRTemp will then be a String without the NEGATIVE SIGN and can be parsed into INTEGER
            // The NOW Positive userInSTRTemp will be stored in userInNum
            userInNum = Integer.parseInt(userInSTRTemp);
            // get the Length of the String to use for checking
            inputLength = String.valueOf(userInNum).length();
            System.out.println(userInNum + " from negative \n");

        }
        else {
            // If isNegative is FALSE, then

            // The already positive userInSTR will be stored in userInNum
            userInNum = Integer.parseInt(userInSTR);

            // get the Length of the String to use for checking
            inputLength = String.valueOf(userInNum).length();
            System.out.println(userInNum + " positive\n");
        }

        if(inputLength > maxInputBuffer){
            JOptionPane.showMessageDialog(null, "The Number is too LARGE!", "Error", JOptionPane.ERROR_MESSAGE);
            resetValueConversion();
        }else{
            if(userInNum == 0){
                resultFields[0].setText("0");
                resultFields[1].setText("0");
                resultFields[2].setText("0");

            }else {

                index = operations.decToBin(userInNum);
                binary = new String[index];
                binary = conversDispNumb(operations.digits, index);
                resultFields[0].setText(isNegative ? "-" + arrayToString(binary) : arrayToString(binary));

                index = operations.decToHex(userInNum);
                hexaDecimal = new String[index];
                hexaDecimal = conversDispChar(operations.hexaDecimal, index);
                resultFields[1].setText(isNegative ? "-" + arrayToString(hexaDecimal) : arrayToString(hexaDecimal));

                index = operations.decToOctal(userInNum);
                octal = new String[index];
                octal = conversDispNumb(operations.digits, index);
                resultFields[2].setText(isNegative ? "-" + arrayToString(octal) : arrayToString(octal));
            }
        }
    }
    // ************************ String Array convert into a String ************************
    public String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = index -1; i >=0; i--) {
            result.append(array[i]);
        }
        return result.toString();
    }
    // ************************ Get data from int array, returns the data into a String array ************************
    public String[] conversDispNumb(int[] array, int index){
        String[] items = new String[index];
        for( int  i = index - 1; i >= 0; i--){
            items[i] = String.valueOf(array[i]);
        }
        return items;
        // Barral, Jacinth Cedric
    }
    // ************************ Get data from char array, returns the data into a String array ************************
    public String[] conversDispChar(char[] array, int index){
        String[] items = new String[index];
        for( int  i = index -1; i >= 0; i--){
            items[i] = String.valueOf(array[i]);
            // System.out.printf("%c", array[i]);
        }
        return items;
    }
    public void callBackMenu(){
        new mainWindow();
    }
    public void resetValue(){
        for(byte i = 0; i <2; i++){
            userInput[i].setText("");
        }
    }
    public void resetValueConversion(){
        numberToConvert.setText("");
        for(byte i = 0; i <3; i++){
            resultFields[i].setText("");
        }
    }
}
class mainOperations{
    final int ARRAY_SIZE = 22;

    int index;
    int[] digits;
    
    char[] hexaDecimal;

    double sumOfNum(double[] num){
        return num[0] + num[1];
    }
    double diffOfNum(double[] num){
        return num[0] - num[1];
    }
    double prodOfNum(double[] num){
        return num[0] * num[1];
    }

    double quotientOfNum(double[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] / num[1];
    }
    double moduloOfNum(double[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] % num[1];
    }

    int decToBin(int numData){
        digits  = new int[ARRAY_SIZE];
        index = 0;
        while (numData > 0) {
            digits[index] = numData % 2;
            numData /= 2;
            index++;
        }
        return index;

    }

    int decToOctal(int numData) {
        digits = new int[ARRAY_SIZE];
        index = 0;

        while(numData > 0) {
            digits[index] = numData % 8;
            numData /= 8;
            index++;
        }
        return index;
    }

    int decToHex(int numData){
        hexaDecimal = new char[ARRAY_SIZE];
        index =0;
        while(numData > 0){

            hexaDecimal[index] = (numData%16 == 10) ? 'A' : (numData%16 == 11) ? 'B' :
                    (numData%16 == 12) ? 'C' : (numData%16 == 13) ? 'D' :
                            (numData%16 == 14) ? 'E' : (numData%16 == 15) ? 'F' :
                                    (char) ((numData%16)+48);
            numData /= 16;
            index++;
        }
        return index;
    }
    // Barral, Jacinth Cedric

}

