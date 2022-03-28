package com.nds.gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.nds.dbutil.ConnectionManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPage() throws SQLException {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username")) {
					txtUsername.setText("");

				} else {
					txtUsername.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setFont(new Font("Arial", Font.BOLD, 14));
		txtUsername.setText("Username");
		txtUsername.setBounds(281, 173, 187, 47);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('*');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
				}
			}
		});
		txtPassword.setFont(new Font("Arial", Font.BOLD, 14));
		txtPassword.setText("Password");
		txtPassword.setBounds(281, 230, 186, 47);
		contentPane.add(txtPassword);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application?",
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginPage.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
		});
		lblX.setBounds(new Rectangle(554, 0, 20, 20));
		lblX.setBounds(580, 6, 14, 16);
		contentPane.add(lblX);

		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setBounds(304, -10, 290, 230);
		contentPane.add(lblNewLabel);

		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginMessage.setForeground(new Color(30, 144, 255));
		lblLoginMessage.setBounds(202, 292, 187, 16);
		contentPane.add(lblLoginMessage);

		JLabel lblNewLabel_1 = new JLabel("NEWSPAPER DELIVERY SYSTEM");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 6, 590, 80);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(258, 88, 376, 80);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Adobe Arabic", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(79, 173, 136, 31);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Adobe Arabic", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(79, 242, 136, 31);
		contentPane.add(lblNewLabel_4);

		Connection con = ConnectionManager.getConnection();
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String paswd = txtPassword.getText();
				try {
					PreparedStatement prd = con.prepareStatement("select * from login where UserName=? and paswd=?");
					prd.setString(1, username);
					prd.setString(2, paswd);
					ResultSet rs1 = prd.executeQuery();
					if (rs1.next()) {
						if (rs1.getString(1).equals(username) && rs1.getString(2).equals(paswd)) {
							new MainHomePage().setVisible(true);
							LoginPage.this.dispose();
						}
					} else {
						LoginPage frame = new LoginPage();
						 JOptionPane.showMessageDialog(frame,"Invalid LogIn.","Alert",JOptionPane.WARNING_MESSAGE); 
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(248, 330, 85, 21);
		contentPane.add(btnNewButton);

		setLocationRelativeTo(null);
	}
}