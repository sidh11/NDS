package com.nds.gui;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.nds.bean.Subscription;
import com.nds.dao.impl.SubscriptionDaoImpl;
import com.nds.test.SubscriptionValidate;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SubscriptionGui extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTable table;
	private static DefaultTableModel model;
	SubscriptionDaoImpl sd = new SubscriptionDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubscriptionGui frame = new SubscriptionGui();
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
	public SubscriptionGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Subscription ID:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(54, 65, 112, 45);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(54, 117, 95, 45);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Publicaion ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(54, 168, 131, 45);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionValidate sv = new SubscriptionValidate();
				if (sv.ValSubfields(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText())) {
					JOptionPane.showMessageDialog(null, "enter something");
				} else if (!sv.Validatesub(tf1.getText())) {
					JOptionPane.showMessageDialog(null, "invalid id");
				} else if (!sv.Validatecus(tf2.getText())) {
					JOptionPane.showMessageDialog(null, "invalid customer");
				} else if (!sv.Validatepub(tf3.getText())) {
					JOptionPane.showMessageDialog(null, "invalid publication");
				} else if (!sv.Validatdesc(tf4.getText())) {
					JOptionPane.showMessageDialog(null, "invalid descrption");
				} else {
					int subs_id = Integer.parseInt(tf1.getText());
					Subscription subscription = sd.findById(subs_id);
					subscription.setCus_id(Integer.parseInt(tf2.getText()));
					subscription.setPub_id(Integer.parseInt(tf3.getText()));
					subscription.setdesc(tf4.getText());
					sd.UpdateSubscription(subscription);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(510, 117, 124, 45);
		contentPane.add(btnNewButton);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionValidate sv = new SubscriptionValidate();
				if (sv.ValSubfields(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText())) {
					JOptionPane.showMessageDialog(null, "enter something");
				} else if (!sv.Validatesub(tf1.getText())) {
					JOptionPane.showMessageDialog(null, "invalid id");
				} else if (!sv.Validatecus(tf2.getText())) {
					JOptionPane.showMessageDialog(null, "invalid customer");
				} else if (!sv.Validatepub(tf3.getText())) {
					JOptionPane.showMessageDialog(null, "invalid publication");
				} else if (!sv.Validatdesc(tf4.getText())) {
					JOptionPane.showMessageDialog(null, "invalid descrption");
				} else {

					SubscriptionDaoImpl sd = new SubscriptionDaoImpl();
					String Sub_id = tf1.getText();
					String Cust_id = tf2.getText();
					String Pub_id = tf3.getText();
					String desc = tf4.getText();

					Subscription sub = new Subscription(Integer.parseInt(Sub_id), Integer.parseInt(Cust_id),
							Integer.parseInt(Pub_id), desc);
					sd.AddSubscription(sub);
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsert.setBounds(510, 65, 124, 46);
		contentPane.add(btnInsert);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscriptionValidate sv = new SubscriptionValidate();
				if (sv.ValSubfields(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText())) {
					JOptionPane.showMessageDialog(null, "enter something");
				} else if (!sv.Validatesub(tf1.getText())) {
					JOptionPane.showMessageDialog(null, "invalid id");
				} else {
					SubscriptionDaoImpl sd = new SubscriptionDaoImpl();
					String Sub_id = tf1.getText();
					sd.DeleteSubscription(Integer.parseInt(Sub_id));
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(510, 168, 124, 45);
		contentPane.add(btnDelete);

		tf1 = new JTextField();
		tf1.setBounds(266, 76, 136, 29);
		contentPane.add(tf1);
		tf1.setColumns(10);

		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(266, 127, 136, 30);
		contentPane.add(tf2);

		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(266, 178, 136, 30);
		contentPane.add(tf3);

		JLabel lblNewLabel_3 = new JLabel("SUBSCRIPTION");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_3.setBounds(234, 10, 186, 45);
		contentPane.add(lblNewLabel_3);

		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.PLAIN, 16));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainHomePage frame = new MainHomePage();
				frame.setVisible(true);
				SubscriptionGui.this.dispose();
			}
		});
		back.setBounds(508, 223, 126, 45);
		contentPane.add(back);

		JLabel lblNewLabel_4 = new JLabel("Discription:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(54, 223, 95, 29);
		contentPane.add(lblNewLabel_4);

		tf4 = new JTextField();
		tf4.setBounds(266, 230, 136, 35);
		contentPane.add(tf4);
		tf4.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(192, 278, 551, 261);
		contentPane.add(scrollPane);

		table = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "Subscription_ID", "Publication_ID", "Customer_ID", "Description" }));
		scrollPane.setViewportView(table);

		JButton btnview = new JButton("View");
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				List<Subscription> subcriptions = sd.findAll();
				for (Subscription subscription : subcriptions) {
					Object[] dataTable = { subscription.getSub_id(), subscription.getCus_id(), subscription.getPub_id(),
							subscription.getdesc() };
					model.addRow(dataTable);
					;
				}

			}
		});
		btnview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnview.setBounds(38, 292, 101, 35);
		contentPane.add(btnview);
	}
}