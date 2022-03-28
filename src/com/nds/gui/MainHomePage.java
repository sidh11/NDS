package com.nds.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainHomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHomePage frame = new MainHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Subscription");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionGui frame = new SubscriptionGui();
				new SubscriptionGui().setVisible(true);
				MainHomePage.this.dispose();
				
			}
		});
		btnNewButton.setBounds(129, 122, 122, 47);
		contentPane.add(btnNewButton);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerHomePage window = new CustomerHomePage();
				window.frmHomepageCustomerModule.setVisible(true);
				MainHomePage.this.dispose();
				
			}
		});
		btnCustomer.setBounds(312, 122, 113, 47);
		contentPane.add(btnCustomer);
		
		JButton btnBilling = new JButton("Billing");
		btnBilling.setBounds(129, 225, 122, 47);
		contentPane.add(btnBilling);
		
		JButton btnBilling_1 = new JButton("Accounts");
		btnBilling_1.setBounds(312, 225, 113, 47);
		contentPane.add(btnBilling_1);
		
		JLabel label = new JLabel("NEWSPAPER DELIVERY SYSTEM");
		label.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
		label.setBounds(10, 10, 590, 80);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("Delivery");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryGui window = new DeliveryGui();
				window.frame.setVisible(true);
				MainHomePage.this.dispose();
			}
		});
		btnNewButton_1.setBounds(129, 307, 122, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Publication");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicationGui window = new PublicationGui();
				window.frame.setVisible(true);
				MainHomePage.this.dispose();
			}
		});
		btnNewButton_2.setBounds(312, 307, 113, 47);
		contentPane.add(btnNewButton_2);
	}
}
