package com.nds.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.nds.bean.Customer;
import com.nds.dao.impl.CustomerDaoImpl;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.nds.gui.VerifyCustomerDetails;
//import com.nds.dao.impl.CustomerDaoImpl;

public class AddCustomer {

	private JFrame frmAddNewCustomer;
	private JTextField textFieldfn;
	private JTextField textFieldln;
	private JTextField textFieldadd;
	private JTextField textFieldcn;
	private CustomerDaoImpl cm;
	private JTextField textFieldid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer window = new AddCustomer();
					window.frmAddNewCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAddNewCustomer = new JFrame();
		frmAddNewCustomer.setTitle("Add New Customer Details");
		frmAddNewCustomer.setBounds(100, 100, 450, 300);
		frmAddNewCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNewCustomer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setBounds(60, 61, 90, 14);
		frmAddNewCustomer.getContentPane().add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(60, 99, 90, 14);
		frmAddNewCustomer.getContentPane().add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(60, 133, 90, 14);
		frmAddNewCustomer.getContentPane().add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact no. :");
		lblContactNo.setBounds(60, 171, 90, 14);
		frmAddNewCustomer.getContentPane().add(lblContactNo);
		
		textFieldfn = new JTextField();
		textFieldfn.setBounds(213, 61, 86, 20);
		frmAddNewCustomer.getContentPane().add(textFieldfn);
		textFieldfn.setColumns(10);
		
		textFieldln = new JTextField();
		textFieldln.setBounds(213, 99, 86, 20);
		frmAddNewCustomer.getContentPane().add(textFieldln);
		textFieldln.setColumns(10);
		
		textFieldadd = new JTextField();
		textFieldadd.setBounds(213, 137, 86, 20);
		frmAddNewCustomer.getContentPane().add(textFieldadd);
		textFieldadd.setColumns(10);
		
		textFieldcn = new JTextField();
		textFieldcn.setBounds(213, 168, 86, 20);
		frmAddNewCustomer.getContentPane().add(textFieldcn);
		textFieldcn.setColumns(10);
	
		JLabel lblNewLabel_1 = new JLabel("Id :");
		lblNewLabel_1.setBounds(60, 24, 46, 14);
		frmAddNewCustomer.getContentPane().add(lblNewLabel_1);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(213, 21, 86, 20);
		frmAddNewCustomer.getContentPane().add(textFieldid);
		textFieldid.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldfn.getText().trim().equals("") || textFieldln.getText().trim().equals("")
						|| textFieldadd.getText().trim().equals("") || textFieldcn.getText().trim().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please Fill up the Details!");
					return;
				}
				else {
				
					int id = Integer.parseInt(textFieldid.getText());
				String fn = textFieldfn.getText().trim();
				String ln = textFieldln.getText().trim();
				String add = textFieldadd.getText().trim();
				String cn = textFieldcn.getText();
				
				if(!VerifyCustomerDetails.verifyfirstName(fn)) {
					JOptionPane.showMessageDialog(null, "First name should be between 3-15 characters!");
					return;
				}
				if(!VerifyCustomerDetails.verifylastName(ln)) {
					JOptionPane.showMessageDialog(null, "Last name should be between 3-15 characters!");
					return;
				}
				if(!VerifyCustomerDetails.verifyAddress(add)) {
					JOptionPane.showMessageDialog(null, "Address should be between 10-150 characters!");
					return;
				}
				if(!VerifyCustomerDetails.verifyContactno(cn)) {
					JOptionPane.showMessageDialog(null, "Contact number should be of length 10!");
					return;
				}
				Customer cd = new Customer(id,fn, ln, add, cn);
				cd.setCusid(id);
				cd.setFirstName(fn);
				cd.setLastName(ln);
				cd.setAddress(add);
				cd.setContactno(cn);
				int count = cm.AddCustomer(cd);
				if (count > 0) {
					JOptionPane.showMessageDialog(null, "Customer Details added successfully!");
					frmAddNewCustomer.dispose();
				}
				}
			}
		});
		btnNewButton.setBounds(85, 192, 101, 23);
		frmAddNewCustomer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddNewCustomer.dispose();
				CustomerHomePage.main(null);
			}
		});
		btnNewButton_1.setBounds(243, 192, 89, 23);
		frmAddNewCustomer.getContentPane().add(btnNewButton_1);
	}
}
