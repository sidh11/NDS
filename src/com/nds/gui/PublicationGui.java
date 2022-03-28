package com.nds.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import com.nds.bean.Publication;
import com.nds.dao.impl.PublicationDaoImpl;
import com.nds.test.VerifyDeliveryperson;
import com.nds.test.VerifyPublication;

public class PublicationGui {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JTable table;
	private static DefaultTableModel model;
	static PublicationDaoImpl pp = new PublicationDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublicationGui window = new PublicationGui();
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
	public PublicationGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(64, 60, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(64, 114, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(64, 155, 99, 29);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("number of Stock");
		lblNewLabel_3.setBounds(64, 220, 92, 29);
		frame.getContentPane().add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(161, 57, 99, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(160, 111, 100, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(161, 159, 99, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(161, 224, 99, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyPublication verifyadd = new VerifyPublication();
				if (verifyadd.ValidateFields(textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "please enter the details");
				} else if (!verifyadd.validateid(textField.getText())) {
					JOptionPane.showMessageDialog(null, "id not valid");
				} else if (!verifyadd.validatename(textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "name not valid");
				} else if (!verifyadd.validateprice(textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "price not valid");
				} else if (!verifyadd.validateStock(textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "stock not valid");
				} else {
					int id = Integer.parseInt(textField.getText());
					String Pname = textField_1.getText();
					String price = textField_2.getText();
					int numOfStock = Integer.parseInt(textField_3.getText());
					Publication publication = new Publication();
					publication.setPub_id(id);
					publication.setPname(Pname);
					publication.setPrice(price);
					publication.setNumOfStock(numOfStock);
					pp.addPub(publication);
					JOptionPane.showMessageDialog(null, "Publication added successfully");
				}
			}
		});
		btnNewButton.setBounds(64, 331, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyPublication verifymod = new VerifyPublication();
				if (verifymod.ValidateFields(textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "please enter the details");
				} else if (!verifymod.validateid(textField.getText())) {
					JOptionPane.showMessageDialog(null, "id not valid");
				} else if (!verifymod.validatename(textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "name not valid");
				} else if (!verifymod.validateprice(textField_2.getText())) {
					JOptionPane.showMessageDialog(null, "price not valid");
				} else if (!verifymod.validateStock(textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "stock not valid");
				} else {

					int id = Integer.parseInt(textField.getText());
					String Pname = textField_1.getText();
					String price = textField_2.getText();
					int NumOfStock = Integer.parseInt(textField_3.getText());
					Publication publication = new Publication();
					publication.setPub_id(id);
					publication.setPname(Pname);
					publication.setPrice(price);
					publication.setNumOfStock(NumOfStock);
					pp.update(publication);
					JOptionPane.showMessageDialog(null, "Publication updated successfully");

				}
			}
		});
		btnNewButton_1.setBounds(195, 331, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyPublication verifydel = new VerifyPublication();
				if (

						verifydel.validateid(textField.getText())) {
					JOptionPane.showMessageDialog(null, "id not valid");
				} else {
					int pid = Integer.parseInt(textField.getText());
					Publication publication = new Publication();
					publication.getPub_id();
					pp.delPubById(pid);
					JOptionPane.showMessageDialog(null, "deleted success fully");
					viewTable();
					
				}
			}
		});
		btnNewButton_2.setBounds(429, 331, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTable();
			}

		});

		btnNewButton_3.setBounds(556, 331, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainHomePage().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(676, 331, 89, 23);
		frame.getContentPane().add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 60, 478, 248);
		frame.getContentPane().add(scrollPane);

		table = new JTable(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Price", "Number of Stock" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton_5 = new JButton("Add Stock");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyPublication verifyaddstock = new VerifyPublication();
				if (verifyaddstock.ValidateFields(textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "please enter the details");
				} else if (!verifyaddstock.validateid(textField.getText())) {
					JOptionPane.showMessageDialog(null, "id not valid");
				}else if (!verifyaddstock.validateStock(textField_3.getText())) {
					JOptionPane.showMessageDialog(null, "stock not valid");
				} else {
					int id = Integer.parseInt(textField.getText());
					int NumOfStock = Integer.parseInt(textField_3.getText());
					Publication publication = pp.findById(id);
					publication.setNumOfStock(Integer.parseInt(textField_3.getText()));
					pp.updateStock(id, NumOfStock);
					JOptionPane.showMessageDialog(null, "stock updated succes fully");
				}
			}
		});
		btnNewButton_5.setBounds(309, 331, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
	}

	protected void dispose() {
		// TODO Auto-generated method stub

	}

	public static void viewTable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<Publication> publications = pp.findAll();
		for (Publication publication : publications) {
			Object[] dataTable = { publication.getPub_id(), publication.getPname(), publication.getPrice(),
					publication.getNumOfStock() };
			model.addRow(dataTable);
		}
	}
}
