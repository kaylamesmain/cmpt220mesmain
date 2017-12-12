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
import javax.swing.JTextArea;

public class editInventoryTableFrame extends JFrame {

	Connection connection= null;
	private JPanel contentPane;
	private final JLabel first_label = new JLabel("Factory Id:");
	private final JLabel second_label = new JLabel("Item Name:");
	private final JLabel third_label = new JLabel("Item Description:");
	private final JLabel fourth_label = new JLabel("Item Weight (lbs):");
	private final JTextField second_textfield = new JTextField();
	private final JTextField third_textfield = new JTextField();
	private final JButton btnInsert = new JButton("Insert");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnRefresh = new JButton("Refresh");
	private final JButton btnDelete = new JButton("Delete");
	private final JTextField first_textfield = new JTextField();
	private final JLabel lblKidId = new JLabel("Item Id:");
	private final JLabel lblEditKidsTable = new JLabel("Edit Inventory Table");
	private final JTextField fifth_textfield = new JTextField();
	private final JTextArea fourth_textarea = new JTextArea();
	private final JScrollPane scrollPane_1 = new JScrollPane();

	

	/**
	 * Create the frame.
	 */
	public editInventoryTableFrame() {
		fifth_textfield.setBounds(132, 238, 130, 26);
		fifth_textfield.setColumns(10);
		first_textfield.setBounds(132, 74, 130, 26);
		first_textfield.setColumns(10);
		connection = postgresConnection.dbConnector();
		jblnit();
		third_textfield.setBounds(132, 131, 130, 26);
		third_textfield.setColumns(10);
		second_textfield.setBounds(132, 103, 130, 26);
		second_textfield.setColumns(10);
		jblnit();
	}
	private void jblnit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		first_label.setBounds(46, 108, 71, 16);
		
		contentPane.add(first_label);
		second_label.setBounds(39, 136, 78, 16);
		
		contentPane.add(second_label);
		third_label.setBounds(6, 164, 111, 16);
		
		contentPane.add(third_label);
		fourth_label.setBounds(6, 243, 117, 16);
		
		contentPane.add(fourth_label);
		
		contentPane.add(second_textfield);
		
		contentPane.add(third_textfield);
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
		btnInsert.setBounds(116, 277, 117, 29);
		
		contentPane.add(btnInsert);
		if (btnCancel.getActionListeners().length<1){
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnCancel_actionPerformed(e);
				}
			});
		}
		btnCancel.setBounds(116, 357, 117, 29);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(305, 74, 744, 243);
		
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
		btnDelete.setBounds(116, 317, 117, 29);
		
		contentPane.add(btnDelete);
	
		
		contentPane.add(first_textfield);
		first_textfield.disable();
		lblKidId.setBounds(58, 80, 48, 16);
		
		contentPane.add(lblKidId);
		lblEditKidsTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblEditKidsTable.setBounds(6, 6, 320, 55);
		
		contentPane.add(lblEditKidsTable);
		
		contentPane.add(fifth_textfield);
		scrollPane_1.setBounds(132, 164, 130, 72);
		
		contentPane.add(scrollPane_1);
		scrollPane_1.setRowHeaderView(fourth_textarea);
		fourth_textarea.setLineWrap(true);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnInsert_actionPerformed(ActionEvent e) throws SQLException {
		try {
			String insertQuery = "insert into inventory (factory_id, item_name, item_description, item_weight_lbs) values (?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setLong(1, Integer.parseInt(second_textfield.getText()));
			pst.setString(2, third_textfield.getText());
			pst.setString(3, fourth_textarea.getText());
			pst.setLong(4, Integer.parseInt(fifth_textfield.getText()));
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Item Successfully Inserted");
			
			pst.close();
			btnRefresh.doClick();
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnRefresh_actionPerformed(ActionEvent e) {
		try {
			String refreshQuery = "Select * from inventory order by item_name";
			PreparedStatement pst = connection.prepareStatement(refreshQuery);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		try {
			String deleteQuery = "delete from inventory where item_id = " + Integer.parseInt(first_textfield.getText()) + ";";
			PreparedStatement pst = connection.prepareStatement(deleteQuery);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Item Successfully Deleted");
			
			pst.close();
			btnRefresh.doClick();
			first_textfield.setText("");
			second_textfield.setText("");
			third_textfield.setText("");
			fourth_textarea.setText("");
			fifth_textfield.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		try {
			int row = table.getSelectedRow();
			String item_id = (table.getModel().getValueAt(row, 0)).toString();
			
			
			String Query = "select * from inventory where item_id ='"+ item_id +"'";
			
			PreparedStatement pst = connection.prepareStatement(Query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				first_textfield.setText(rs.getString("item_id"));
				second_textfield.setText(rs.getString("factory_id"));
				third_textfield.setText(rs.getString("item_name"));
				fourth_textarea.setText(rs.getString("item_description"));
				fifth_textfield.setText(rs.getString("item_weight_lbs"));
				
			}
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
