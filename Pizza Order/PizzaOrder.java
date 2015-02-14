/*
 * Jeremy Lewis
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PizzaOrder
{

	private JFrame frame;
	private JLabel pictureLabel;
	private JCheckBox pepperoni;
	private JCheckBox mushrooms;
	private JCheckBox olives;
	private JRadioButton thin;
	private JRadioButton stuffed;
	private JRadioButton pan;
	
	private JComboBox payment;
	private JButton order;
	private JButton cancle;

	private double total = 10;

	private void makeComponents()
	{
		frame = new JFrame("Papa Bob's");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5, 1));
		pictureLabel = new JLabel(new ImageIcon("images/cutecat.jpg"));
		pepperoni = new JCheckBox("Pepperoni");
		mushrooms = new JCheckBox("Mushrooms");
		olives = new JCheckBox("Olives");
		thin = new JRadioButton("Thin");
		stuffed = new JRadioButton("Stuffed");
		pan = new JRadioButton("Pan");
		}

	private JPanel makeButtonPanel()
	{
	    JPanel panel = new JPanel();
	    order = new JButton("Order");
        cancle = new JButton("Cancle");
        panel.add(order);
        panel.add(cancle);
      return panel;
	}

	private JPanel makePaymentPanel()
	{
	    JPanel panel = new JPanel();
	    payment = new JComboBox();
        payment.addItem("Check");
        payment.addItem("Cash");
        payment.addItem("Credit Card");
        panel.add(payment);
		return panel;
	}

	private JPanel makeCrustPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Crust"));
		panel.setLayout(new GridLayout(3, 1));
		panel.add(thin);
		panel.add(stuffed);
		panel.add(pan);
		ButtonGroup bg = new ButtonGroup();
		bg.add(thin);
		bg.add(stuffed);
		bg.add(pan);
		CrustListener crustListener = new CrustListener();
		thin.addActionListener(crustListener);
		stuffed.addActionListener(crustListener);
		pan.addActionListener(crustListener);		
		return panel;
	}

	private JPanel makeToppingsPanel()
	{
		JPanel panel = new JPanel();
		// panel.setLayout(new GridLayout(3,1));
		panel.add(pepperoni);
		panel.add(mushrooms);
		panel.add(olives);
		ToppingsListener toppingsListener = new ToppingsListener();
		pepperoni.addActionListener(toppingsListener);
		mushrooms.addActionListener(toppingsListener);
		olives.addActionListener(toppingsListener);
		return panel;
	}

	private void makeLayout()
	{
		frame.add(pictureLabel);
		frame.add(makeToppingsPanel());
		frame.add(makeCrustPanel());
		frame.add(makePaymentPanel());
		frame.add(makeButtonPanel());
		
		frame.pack();
	}

	private void setVisible()
	{
		frame.setVisible(true);
	}

	public class ToppingsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if (pepperoni.isSelected())
			{
				total += 0.5;
			}
			if (mushrooms.isSelected())
			{
				total += 0.5;
			}
			if (olives.isSelected())
			{
				total += 0.5;
			}
			System.out.println("Price: " + total);
		}

	}



	public class CrustListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == thin)
			{
				total += 1;
			} else if (e.getSource() == pan)
			{
				total += 1;
			}
			System.out.println("Price: " + total);
		}

	}

	public static void main(String[] args)
	{
		PizzaOrder pizza = new PizzaOrder();
		pizza.makeComponents();
		pizza.makeLayout();
		pizza.setVisible();
	}

}
