package tableTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class editKidsTableFrame extends JFrame {
	/*Initializes items*/
	Connection connection= null;
	private JPanel contentPane;
	private final JLabel first_label = new JLabel("Address Id:");
	private final JLabel second_label = new JLabel("First Name:");
	private final JLabel third_label = new JLabel("Last Name:");
	private final JLabel fourth_label = new JLabel("Gender:");
	private final JLabel lblNewLabel = new JLabel("Age:");
	private final JLabel lblVerdict = new JLabel("Verdict:");
	private final JTextField second_textfield = new JTextField();
	private final JTextField third_textfield = new JTextField();
	private final JTextField fourth_textfield = new JTextField();
	private final JButton btnInsert = new JButton("Insert");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnRefresh = new JButton("Refresh");
	private final JButton btnDelete = new JButton("Delete");
	private final JTextField first_textfield = new JTextField();
	private final JLabel lblKidId = new JLabel("Kid Id:");
	private final JLabel lblEditKidsTable = new JLabel("Edit Kids Table");
	private final JComboBox fifth_combobox = new JComboBox();
	private final JComboBox sixth_combobox = new JComboBox();
	private final JComboBox seventh_combobox = new JComboBox();

	

	/**
	 * Create the frame.
	 */
	
	/*Defines items characteristics and settings*/
	public editKidsTableFrame() {
		first_textfield.setBounds(89, 74, 130, 26);
		first_textfield.setColumns(10);
		connection = postgresConnection.dbConnector();
		jblnit();
		fourth_textfield.setBounds(89, 159, 130, 26);
		fourth_textfield.setColumns(10);
		third_textfield.setBounds(89, 131, 130, 26);
		third_textfield.setColumns(10);
		second_textfield.setBounds(89, 103, 130, 26);
		second_textfield.setColumns(10);
		jblnit();
	}
	private void jblnit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		first_label.setBounds(6, 108, 71, 16);
		
		contentPane.add(first_label);
		second_label.setBounds(6, 136, 78, 16);
		
		contentPane.add(second_label);
		third_label.setBounds(6, 164, 78, 16);
		
		contentPane.add(third_label);
		fourth_label.setBounds(29, 192, 61, 16);
		
		contentPane.add(fourth_label);
		lblNewLabel.setBounds(49, 225, 28, 16);
		
		contentPane.add(lblNewLabel);
		lblVerdict.setBounds(29, 253, 48, 16);
		
		contentPane.add(lblVerdict);
		
		contentPane.add(second_textfield);
		
		contentPane.add(third_textfield);
		
		contentPane.add(fourth_textfield);
		
		
		/*Item Listeners waiting to run based on user interaction*/
		if (btnInsert.getActionListeners().length<1){
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					try {
						do_btnInsert_actionPerformed(ae);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		btnInsert.setBounds(77, 302, 117, 29);
		
		contentPane.add(btnInsert);
		if (btnCancel.getActionListeners().length<1){
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnCancel_actionPerformed(e);
				}
			});
		}
		btnCancel.setBounds(77, 382, 117, 29);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(251, 74, 677, 297);
		
		contentPane.add(scrollPane);
		
		/* Mouse Listener for table waiting for user interaction*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		if (btnRefresh.getActionListeners().length<1) {
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnRefresh_actionPerformed(e);
				}
			});
		}
		btnRefresh.setBounds(452, 33, 117, 29);
		
		contentPane.add(btnRefresh);
		if (btnDelete.getActionListeners().length<1){
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnDelete_actionPerformed(e);
				}
			});
		}
		btnDelete.setBounds(77, 342, 117, 29);
		
		contentPane.add(btnDelete);
	
		
		contentPane.add(first_textfield);
		first_textfield.disable();
		lblKidId.setBounds(36, 79, 48, 16);
		
		contentPane.add(lblKidId);
		lblEditKidsTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblEditKidsTable.setBounds(6, 6, 320, 55);
		
		contentPane.add(lblEditKidsTable);
		fifth_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		fifth_combobox.setBounds(89, 187, 130, 28);
		
		contentPane.add(fifth_combobox);
		sixth_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"}));
		sixth_combobox.setBounds(89, 220, 130, 28);
		
		contentPane.add(sixth_combobox);
		seventh_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Naughty", "Nice"}));
		seventh_combobox.setBounds(89, 248, 130, 28);
		
		contentPane.add(seventh_combobox);
	}
	
	/*Action Method for Cancel button: Telling frame to close*/
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	
	/*Action method for the Insert Button: Inserting info to database table based on user input*/
	protected void do_btnInsert_actionPerformed(ActionEvent e) throws SQLException {
		try {
			String insertQuery = "insert into kids (address_id, first_name, last_name, gender, age, verdict) values (?,?,?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setLong(1, Integer.parseInt(second_textfield.getText()));
			pst.setString(2, third_textfield.getText());
			pst.setString(3, fourth_textfield.getText());
			pst.setString(4, (String) fifth_combobox.getSelectedItem());
			pst.setLong(5, Integer.parseInt(sixth_combobox.getSelectedItem().toString()));
			pst.setString(6, (String) seventh_combobox.getSelectedItem());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Kid Successfully Inserted");
			
			pst.close();
			btnRefresh.doClick();
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	
	/*Refresh button action method that refreshes address table*/
	protected void do_btnRefresh_actionPerformed(ActionEvent e) {
		try {
			String refreshQuery = "Select * from kids order by last_name";
			PreparedStatement pst = connection.prepareStatement(refreshQuery);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		try {
			String deleteQuery = "delete from kids where kid_id = " + Integer.parseInt(first_textfield.getText()) + ";";
			PreparedStatement pst = connection.prepareStatement(deleteQuery);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Kid Successfully Deleted");
			
			pst.close();
			btnRefresh.doClick();
			second_textfield.setText("");
			third_textfield.setText("");
			fourth_textfield.setText("");
			fifth_combobox.setSelectedItem("");
			sixth_combobox.setSelectedItem("");
			seventh_combobox.setSelectedItem("");
			first_textfield.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * executes query based on users selected record in table
	 * from that query it takes the results and populates the appropriate text fields accordingly
	 * */
	protected void do_table_mouseClicked(MouseEvent e) {
		try {
			int row = table.getSelectedRow();
			String kid_id = (table.getModel().getValueAt(row, 0)).toString();
			
			
			String Query = "select * from kids where kid_id ='"+ kid_id +"'";
			
			PreparedStatement pst = connection.prepareStatement(Query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				first_textfield.setText(rs.getString("kid_id"));
				second_textfield.setText(rs.getString("address_id"));
				third_textfield.setText(rs.getString("first_name"));
				fourth_textfield.setText(rs.getString("last_name"));
				fifth_combobox.setSelectedItem(rs.getObject(5));
				sixth_combobox.setSelectedItem(rs.getObject(6).toString());
				seventh_combobox.setSelectedItem(rs.getObject(7));
			}
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
