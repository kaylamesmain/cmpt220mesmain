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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class editStaffTableFrame extends JFrame {

	Connection connection= null;
	private JPanel contentPane;
	private final JLabel first_label = new JLabel("Department Id:");
	private final JLabel second_label = new JLabel("First Name:");
	private final JLabel third_label = new JLabel("Last Name:");
	private final JLabel fourth_label = new JLabel("Age:");
	private final JLabel lblNewLabel = new JLabel("Hire Date:");
	private final JLabel lblVerdict = new JLabel("Hourly Rate:");
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
	private final JLabel lblKidId = new JLabel("Elf Id:");
	private final JLabel lblEditKidsTable = new JLabel("Edit Staff Table");
	private final JTextField sixth_textfield = new JTextField();
	private final JTextField seventh_textfield = new JTextField();
	private final JTextField fifth_textfield = new JTextField();

	

	/**
	 * Create the frame.
	 */
	public editStaffTableFrame() {
		fifth_textfield.setBounds(89, 187, 130, 26);
		fifth_textfield.setColumns(10);
		seventh_textfield.setBounds(89, 248, 130, 26);
		seventh_textfield.setColumns(10);
		sixth_textfield.setBounds(89, 220, 130, 26);
		sixth_textfield.setColumns(10);
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
		setBounds(100, 100, 864, 450);
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
		lblNewLabel.setBounds(6, 225, 71, 16);
		
		contentPane.add(lblNewLabel);
		lblVerdict.setBounds(6, 253, 71, 16);
		
		contentPane.add(lblVerdict);
		
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
		btnInsert.setBounds(79, 285, 117, 29);
		
		contentPane.add(btnInsert);
		if (btnCancel.getActionListeners().length<1){
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnCancel_actionPerformed(e);
				}
			});
		}
		btnCancel.setBounds(79, 364, 117, 29);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(251, 74, 587, 243);
		
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
		btnRefresh.setBounds(452, 33, 117, 29);
		
		contentPane.add(btnRefresh);
		if (btnDelete.getActionListeners().length<1){
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnDelete_actionPerformed(e);
				}
			});
		}
		btnDelete.setBounds(79, 324, 117, 29);
		
		contentPane.add(btnDelete);
	
		
		contentPane.add(first_textfield);
		first_textfield.disable();
		lblKidId.setBounds(36, 79, 48, 16);
		
		contentPane.add(lblKidId);
		lblEditKidsTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblEditKidsTable.setBounds(6, 6, 320, 55);
		
		contentPane.add(lblEditKidsTable);
		
		contentPane.add(sixth_textfield);
		sixth_textfield.disable();
		
		contentPane.add(seventh_textfield);
		
		contentPane.add(fifth_textfield);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnInsert_actionPerformed(ActionEvent e) throws SQLException {
		try {
			Calendar currenttime = Calendar.getInstance();
		    Date sqldate = new Date((currenttime.getTime()).getTime());
		    
			String insertQuery = "insert into staff (department_id, first_name, last_name, age, hire_date, hourly_rate) values (?,?,?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setLong(1, Integer.parseInt(second_textfield.getText()));
			pst.setString(2, third_textfield.getText());
			pst.setString(3, fourth_textfield.getText());
			pst.setLong(4, Integer.parseInt(fifth_textfield.getText()));
			pst.setDate(5, sqldate);
			pst.setDouble(6, Double.parseDouble(seventh_textfield.getText()));
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Elf Successfully Inserted");
			
			pst.close();
			btnRefresh.doClick();
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnRefresh_actionPerformed(ActionEvent e) {
		try {
			String refreshQuery = "Select * from staff order by last_name";
			PreparedStatement pst = connection.prepareStatement(refreshQuery);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		try {
			String deleteQuery = "delete from staff where elf_id = " + Integer.parseInt(first_textfield.getText()) + ";";
			PreparedStatement pst = connection.prepareStatement(deleteQuery);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Elf Successfully Deleted");
			
			pst.close();
			btnRefresh.doClick();
			second_textfield.setText("");
			third_textfield.setText("");
			fourth_textfield.setText("");
			fifth_textfield.setText("");
			sixth_textfield.setText("");
			seventh_textfield.setText("");
			first_textfield.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		try {
			int row = table.getSelectedRow();
			String elf_id = (table.getModel().getValueAt(row, 0)).toString();
			
			
			String Query = "select * from staff where elf_id ='"+ elf_id +"'";
			
			PreparedStatement pst = connection.prepareStatement(Query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				first_textfield.setText(rs.getString("elf_id"));
				second_textfield.setText(rs.getString("department_id"));
				third_textfield.setText(rs.getString("first_name"));
				fourth_textfield.setText(rs.getString("last_name"));
				fifth_textfield.setText(rs.getString("age"));
				sixth_textfield.setText(rs.getString("hire_date"));
				seventh_textfield.setText(rs.getString("hourly_rate"));
			}
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
