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

public class editWrappingSchemesTableFrame extends JFrame {

	Connection connection= null;
	private JPanel contentPane;
	private final JLabel first_label = new JLabel("Wrapping Color:");
	private final JLabel second_label = new JLabel("Wrapping Pattern:");
	private final JLabel third_label = new JLabel("Ribbon Color:");
	private final JLabel fourth_label = new JLabel("Box Size:");
	private final JButton btnInsert = new JButton("Insert");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnRefresh = new JButton("Refresh");
	private final JButton btnDelete = new JButton("Delete");
	private final JTextField first_textfield = new JTextField();
	private final JLabel lblKidId = new JLabel("Wrapping Id:");
	private final JLabel lblEditKidsTable = new JLabel("Edit Wrapping Schemes Table");
	private final JComboBox second_combobox = new JComboBox();
	private final JComboBox third_combobox = new JComboBox();
	private final JComboBox fourth_combobox = new JComboBox();
	private final JComboBox fifth_combobox = new JComboBox();

	

	/**
	 * Create the frame.
	 */
	public editWrappingSchemesTableFrame() {
		first_textfield.setBounds(141, 74, 130, 26);
		first_textfield.setColumns(10);
		connection = postgresConnection.dbConnector();
		jblnit();
		jblnit();
	}
	private void jblnit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		first_label.setBounds(26, 108, 107, 16);
		
		contentPane.add(first_label);
		second_label.setBounds(16, 139, 117, 16);
		
		contentPane.add(second_label);
		third_label.setBounds(43, 164, 86, 16);
		
		contentPane.add(third_label);
		fourth_label.setBounds(72, 197, 61, 16);
		
		contentPane.add(fourth_label);
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
		btnInsert.setBounds(102, 245, 117, 29);
		
		contentPane.add(btnInsert);
		if (btnCancel.getActionListeners().length<1){
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnCancel_actionPerformed(e);
				}
			});
		}
		btnCancel.setBounds(102, 327, 117, 29);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(306, 74, 592, 282);
		
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
		btnDelete.setBounds(102, 285, 117, 29);
		
		contentPane.add(btnDelete);
	
		
		contentPane.add(first_textfield);
		first_textfield.disable();
		lblKidId.setBounds(49, 80, 84, 16);
		
		contentPane.add(lblKidId);
		lblEditKidsTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblEditKidsTable.setBounds(6, 6, 398, 55);
		
		contentPane.add(lblEditKidsTable);
		second_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Black", "Blue", "Brown", "Green", "Indigo", "Orange", "Pink", "Purple", "Red", "Violet", "White", "Yellow"}));
		second_combobox.setBounds(141, 101, 130, 28);
		
		contentPane.add(second_combobox);
		third_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Candy Canes", "Christmas Trees", "Elves", "Gingerbread Men", "Jingle Bells", "Ornaments", "Reindeer", "Santa", "Snowflakes", "Snowglobes", "Snowmen", "Stars", "Stockings", "Stripes"}));
		third_combobox.setBounds(141, 134, 130, 28);
		
		contentPane.add(third_combobox);
		fourth_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Black", "Blue", "Brown", "Green", "Indigo", "Orange", "Pink", "Purple", "Red", "Violet", "White", "Yellow"}));
		fourth_combobox.setBounds(141, 162, 130, 28);
		
		contentPane.add(fourth_combobox);
		fifth_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Small", "Medium", "Large", "X-Large"}));
		fifth_combobox.setBounds(141, 192, 130, 28);
		
		contentPane.add(fifth_combobox);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnInsert_actionPerformed(ActionEvent e) throws SQLException {
		try {
			String insertQuery = "insert into wrapping_schemes (wrapping_color, wrapping_pattern, ribbon_color, box_size) values (?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, (String) second_combobox.getSelectedItem());
			pst.setString(2, (String) third_combobox.getSelectedItem());
			pst.setString(3, (String) fourth_combobox.getSelectedItem());
			pst.setString(4, (String) fifth_combobox.getSelectedItem());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Scheme Successfully Inserted");
			
			pst.close();
			btnRefresh.doClick();
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnRefresh_actionPerformed(ActionEvent e) {
		try {
			String refreshQuery = "Select * from wrapping_schemes order by wrapping_id";
			PreparedStatement pst = connection.prepareStatement(refreshQuery);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		try {
			String deleteQuery = "delete from wrapping_schemes where wrapping_id = " + Integer.parseInt(first_textfield.getText()) + ";";
			PreparedStatement pst = connection.prepareStatement(deleteQuery);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Scheme Successfully Deleted");
			
			pst.close();
			btnRefresh.doClick();
			second_combobox.setSelectedItem("");
			third_combobox.setSelectedItem("");
			fourth_combobox.setSelectedItem("");
			fifth_combobox.setSelectedItem("");
			first_textfield.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		try {
			int row = table.getSelectedRow();
			String wrapping_id = (table.getModel().getValueAt(row, 0)).toString();
			
			
			String Query = "select * from wrapping_schemes where wrapping_id ='"+ wrapping_id +"'";
			
			PreparedStatement pst = connection.prepareStatement(Query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				first_textfield.setText(rs.getString("wrapping_id"));
				second_combobox.setSelectedItem(rs.getObject(2));
				third_combobox.setSelectedItem(rs.getObject(3));
				fourth_combobox.setSelectedItem(rs.getObject(4));
				fifth_combobox.setSelectedItem(rs.getObject(5));
			}
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
