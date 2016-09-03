// Joshua Davis

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TaxWindow extends JFrame
{
     private JPanel panel;         				 
     private Container contentPane; 			 
     private JLabel stateTaxLabel,				 
	  					  countyTaxLabel,
						  priceLabel,
						  totalTaxLabel,
						  totalCostOfTaxLabel,       			
						  totalCostLabel;
						         			
     private JTextField stateTaxText,          
	    	           countyTaxText,
						  priceText,
						  totalTaxText,
						  totalCostOfTaxText, 				    
						  totalCostText;       			
     private JButton calcButton;    		    
     private final int WINDOW_WIDTH = 350,   
                       WINDOW_HEIGHT = 350;   

   

     public TaxWindow()
     {
          
          super("Sales Tax");
			
         // set sixe of GUI
          setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

          // define close operation
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          //create and name Labels
          stateTaxLabel = new JLabel("State sales tax as a decimal");
			 stateTaxLabel.setLocation(100, 7);
			 countyTaxLabel = new JLabel("County sales tax as a decimal");
			 priceLabel = new JLabel("Price of item in dollars");
			 totalTaxLabel = new JLabel("Total sales tax as a decimal");
			 totalCostOfTaxLabel = new JLabel("Total cost of tax in dollars");
			 totalCostLabel = new JLabel("Total cost of item in dollars");
			 
			 // define Text box length
			 stateTaxText = new JTextField(20);
			 countyTaxText = new JTextField(20);
			 priceText = new JTextField(20);
			 totalTaxText = new JTextField(20);
			 totalCostOfTaxText = new JTextField(20);
			 totalCostText = new JTextField(20);
			 
			 // create calculation button
          calcButton = new JButton("Calculate");

          // create action listener
          calcButton.addActionListener(new CalcButtonListener());

          // create panel and fill it with Labels and Texts and button
          panel = new JPanel();
          panel.add(stateTaxLabel);
			 panel.add(stateTaxText);
			 panel.add(countyTaxLabel);
			 panel.add(countyTaxText);
			 panel.add(priceLabel);
			 panel.add(priceText);
			 panel.add(totalTaxLabel);
			 panel.add(totalTaxText);
			 panel.add(totalCostOfTaxLabel);
			 panel.add(totalCostOfTaxText);
          panel.add(totalCostLabel);
			 panel.add(totalCostText);
          
	       panel.add(calcButton);

          // get content pane address
          contentPane = getContentPane();

          // fill content pane with panel
          contentPane.add(panel);

         // display the GUI
          setVisible(true);
		
   }	 
   	// code to execute on calc button click
     private class CalcButtonListener implements ActionListener
     {
          public void actionPerformed(ActionEvent e)
          {
               String input;
               final double stateTax = .04,
									 countyTax = .02;
					double price=0, totalTax, totalTaxCost, totalCost;
						 
				   input = priceText.getText();
					
					try{
					price = Double.parseDouble(input);}
					
					catch(NumberFormatException exception){
					System.out.print(" input was not only numbers"+
											 "/ no letters or special characters allowed");}
					
					// processing
					totalTax = stateTax + countyTax; 
					totalCost = price + totalTax * price;
					totalTaxCost = totalTax * price;
					
					// display vars
					input = totalCost + " ";
					totalCostText.setText(input);
					
					input = totalTaxCost + " ";
					totalCostOfTaxText.setText(input);
					
					input = stateTax + " ";
					stateTaxText.setText(input);
					
					input = countyTax + " ";
					countyTaxText.setText(input); 
					
					input = totalTax + " ";
					totalTaxText.setText(input);              
                       
          }              
     } 
}
