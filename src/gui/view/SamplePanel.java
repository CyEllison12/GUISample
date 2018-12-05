package gui.view;

import javax.swing.*;
import gui.controller.GUIController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SamplePanel extends JPanel
{
	private GUIController appController;
	private JLabel textLabel;
	private JButton colorButton;
	private JButton testButton;
	private SpringLayout appLayout;
	
	public SamplePanel(GUIController appController)
	{
		super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		this.textLabel = new JLabel("THIS IS A COLOR APP!");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.add(textLabel);
		this.colorButton = new JButton("CLICK HERE TO CHANGE COLOR");


		this.add(colorButton);
		this.setLayout(appLayout);


	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.SOUTH, colorButton, -146, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, textLabel, 26, SpringLayout.SOUTH, colorButton);
		appLayout.putConstraint(SpringLayout.WEST, colorButton, 77, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, textLabel, -117, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		colorButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent mouseClick)
					{
						changeBackgroundColor();
					}
				});
		

	}
	
	private void changeBackgroundColor()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
		textLabel.setText("Red: " + red + " Green: " + green + " Blue: " + blue);
	}

}
