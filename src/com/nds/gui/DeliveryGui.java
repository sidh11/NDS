package com.nds.gui;

import com.nds.bean.Delivery;
import com.nds.dao.impl.*;
import com.nds.test.VerifyDeliveryperson;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DeliveryGui {

	static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static DeliveryDaoImpl dd = new DeliveryDaoImpl();
	private static DefaultTableModel model;
	private static JTable table;

	/**
	 * 
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					DeliveryGui window = new DeliveryGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeliveryGui() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 866, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerifyDeliveryperson verifyadd = new VerifyDeliveryperson();
				if (verifyadd.ValidateFields(textField_1.getText(), textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "please add the details");
//				} else if (!verifyadd.ValidateId(textField.getText())) {
//					JOptionPane.showMessageDialog(null, "Id not valid");
				} else if (!verifyadd.ValidateName(textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "Name not valid");
				} else if (!verifyadd.ValidateNumber(textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "Number not valid");
				} else {
					 int id = Integer.parseInt(textField.getText());
					String Dpname = textField_1.getText();
					int DpContactNo = Integer.parseInt(textField_2.getText());
					com.nds.bean.Delivery delivery = new com.nds.bean.Delivery();
					delivery.setDpid(id);
					delivery.setDpname(Dpname);
					delivery.setDpContactNo(DpContactNo);
					dd.addDP(delivery);
					JOptionPane.showMessageDialog(null, "Added success fully");

				}
			}
		});
		btnNewButton.setBounds(43, 343, 89, 23);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(220, 59, 111, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Delivery Person Id");
		lblNewLabel.setBounds(44, 61, 151, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Delivery Person Name");
		lblNewLabel_1.setBounds(43, 132, 111, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(220, 126, 111, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(220, 194, 111, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Delivery Person Contact");
		lblNewLabel_2.setBounds(43, 200, 125, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewTable();
			}
		});

		btnNewButton_1.setBounds(192, 343, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VerifyDeliveryperson verifyDelivery = new VerifyDeliveryperson();
			
				if (!verifyDelivery.ValidateId(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Id not valid");
				} else {
					int dpid = Integer.parseInt(textField.getText());
					com.nds.bean.Delivery delivery = new com.nds.bean.Delivery();
					delivery.getDpid();
					dd.delDPById(dpid);
					JOptionPane.showMessageDialog(null, "deleted success fully");
					viewTable();
					
				}

			}

		});
		btnNewButton_2.setBounds(386, 343, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				VerifyDeliveryperson verifyupdate = new VerifyDeliveryperson();
				if (verifyupdate.ValidateFields(textField.getText(), textField_1.getText(), textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "please add the details");
				} else if (!verifyupdate.ValidateId(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Id not valid");
				} else if (!verifyupdate.ValidateName(textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "Name not valid");
				} else if (!verifyupdate.ValidateNumber(textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "Number not valid");
				}

				else {

					int dpid = Integer.parseInt(textField.getText());
					Delivery delivery = dd.findById(dpid);
					delivery.setDpname(textField_1.getText());
					delivery.setDpContactNo(Integer.parseInt(textField_2.getText()));
					dd.update(delivery);
					viewTable();
					JOptionPane.showMessageDialog(null, "Data updated succesfully");
				}
			}

		});

		btnNewButton_3.setBounds(546, 343, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 52, 480, 282);
		frame.getContentPane().add(scrollPane);

		table = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Number" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new MainHomePage().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(713, 343, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}

//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				viewTable();
//			}
//		});
//	}

	public static void viewTable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<Delivery> deliveries = dd.findAll();

		for (Delivery delivery : deliveries) {
			Object[] dataTable = { delivery.getDpid(), delivery.getDpname(), delivery.getDpContactNo() };
			model.addRow(dataTable);
		}
	}

}
