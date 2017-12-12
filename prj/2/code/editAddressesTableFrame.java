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

public class editAddressesTableFrame extends JFrame {

	Connection connection= null;
	private JPanel contentPane;
	private final JLabel first_label = new JLabel("Street Address:");
	private final JLabel second_label = new JLabel("City:");
	private final JLabel third_label = new JLabel("Region:");
	private final JLabel fourth_label = new JLabel("Postal Code:");
	private final JLabel lblNewLabel = new JLabel("Country:");
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
	private final JLabel lblKidId = new JLabel("Address Id:");
	private final JLabel lblEditKidsTable = new JLabel("Edit Address' Table");
	private final JTextField fifth_textfield = new JTextField();
	private final JTextField sixth_textfield = new JTextField();

	

	/**
	 * Create the frame.
	 */
	public editAddressesTableFrame() {
		sixth_textfield.setBounds(89, 220, 130, 26);
		sixth_textfield.setColumns(10);
		fifth_textfield.setBounds(89, 187, 130, 26);
		fifth_textfield.setColumns(10);
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
		setBounds(100, 100, 944, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		first_label.setBounds(6, 108, 71, 16);
		
		contentPane.add(first_label);
		second_label.setBounds(49, 136, 35, 16);
		
		contentPane.add(second_label);
		third_label.setBounds(29, 164, 55, 16);
		
		contentPane.add(third_label);
		fourth_label.setBounds(0, 192, 90, 16);
		
		contentPane.add(fourth_label);
		lblNewLabel.setBounds(22, 225, 55, 16);
		
		contentPane.add(lblNewLabel);
		
		contentPane.add(second_textfield);
		
		contentPane.add(third_textfield);
		
		contentPane.add(fourth_textfield);
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
		btnInsert.setBounds(72, 268, 117, 29);
		
		contentPane.add(btnInsert);
		if (btnCancel.getActionListeners().length<1){
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnCancel_actionPerformed(e);
				}
			});
		}
		btnCancel.setBounds(72, 346, 117, 29);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(251, 74, 667, 243);
		
		contentPane.add(scrollPane);
		
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
		btnRefresh.setBounds(350, 33, 117, 29);
		
		contentPane.add(btnRefresh);
		if (btnDelete.getActionListeners().length<1){
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnDelete_actionPerformed(e);
				}
			});
		}
		btnDelete.setBounds(72, 306, 117, 29);
		
		contentPane.add(btnDelete);
	
		
		contentPane.add(first_textfield);
		first_textfield.disable();
		lblKidId.setBounds(6, 79, 78, 16);
		
		contentPane.add(lblKidId);
		lblEditKidsTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblEditKidsTable.setBounds(6, 6, 320, 55);
		
		contentPane.add(lblEditKidsTable);
		
		contentPane.add(fifth_textfield);
		
		contentPane.add(sixth_textfield);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnInsert_actionPerformed(ActionEvent e) throws SQLException {
		try {
			String insertQuery = "insert into addresses (street_address, city, region, postal_code, country) values (?,?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, second_textfield.getText());
			pst.setString(2, third_textfield.getText());
			pst.setString(3, fourth_textfield.getText());
			pst.setString(4, fifth_textfield.getText());
			pst.setString(5, sixth_textfield.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Address Successfully Inserted");
			
			pst.close();
			btnRefresh.doClick();
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnRefresh_actionPerformed(ActionEvent e) {
		try {
			String refreshQuery = "Select * from addresses order by country";
			PreparedStatement pst = connection.prepareStatement(refreshQuery);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		try {
			String deleteQuery = "delete from addresses where address_id = " + Integer.parseInt(first_textfield.getText()) + ";";
			PreparedStatement pst = connection.prepareStatement(deleteQuery);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Address Successfully Deleted");
			
			pst.close();
			btnRefresh.doClick();
			first_textfield.setText("");
			second_textfield.setText("");
			third_textfield.setText("");
			fourth_textfield.setText("");
			fifth_textfield.setText("");
			sixth_textfield.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		try {
			int row = table.getSelectedRow();
			String address_id = (table.getModel().getValueAt(row, 0)).toString();
			
			
			String Query = "select * from addresses where address_id ='"+ address_id +"'";
			
			PreparedStatement pst = connection.prepareStatement(Query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				first_textfield.setText(rs.getString("address_id"));
				second_textfield.setText(rs.getString("street_address"));
				third_textfield.setText(rs.getString("city"));
				fourth_textfield.setText(rs.getString("region"));
				fifth_textfield.setText(rs.getString("postal_code"));
				sixth_textfield.setText(rs.getString("country"));
			}
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
