package com.nds.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;

import com.nds.dao.impl.CustomerDaoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CustomerHomePage {

	JFrame frmHomepageCustomerModule; 
	private CustomerDaoImpl cm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerHomePage window = new CustomerHomePage();
					window.frmHomepageCustomerModule.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomepageCustomerModule = new JFrame();
		frmHomepageCustomerModule.setTitle("HomePage Customer Module");
		frmHomepageCustomerModule.setBounds(100, 100, 450, 300);
		frmHomepageCustomerModule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomepageCustomerModule.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHomepageCustomerModule.dispose();
				AddCustomer adv = new AddCustomer();
			}
		});
		btnNewButton.setBounds(44, 21, 154, 23);
		frmHomepageCustomerModule.getContentPane().add(btnNewButton);
		
		JButton btnViewListOf = new JButton("View List of Customers");
		btnViewListOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame listw = new JFrame();
				listw.setVisible(true);
				cm.ViewCustomer();
				
			}
		});
		btnViewListOf.setBounds(44, 55, 154, 23);
		frmHomepageCustomerModule.getContentPane().add(btnViewListOf);
		
		JButton btnEditCustomerDetails = new JButton("Edit Customer Details");
		btnEditCustomerDetails.setBounds(44, 91, 154, 23);
		frmHomepageCustomerModule.getContentPane().add(btnEditCustomerDetails);
		
		JButton btnDeleteCustomerDetails = new JButton("Delete Customer Details");
		btnDeleteCustomerDetails.setBounds(44, 125, 154, 23);
		frmHomepageCustomerModule.getContentPane().add(btnDeleteCustomerDetails);
	}
}
