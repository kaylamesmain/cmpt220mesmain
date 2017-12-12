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
import javax.swing.ScrollPaneConstants;

public class editReindeerTableFrame extends JFrame {

	Connection connection= null;
	private JPanel contentPane;
	private final JLabel first_label = new JLabel("Reindeer Name:");
	private final JLabel second_label = new JLabel("Special Skills:");
	private final JTextField second_textfield = new JTextField();
	private final JButton btnInsert = new JButton("Insert");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnRefresh = new JButton("Refresh");
	private final JButton btnDelete = new JButton("Delete");
	private final JTextField first_textfield = new JTextField();
	private final JLabel lblKidId = new JLabel("Reindeer Id:");
	private final JLabel lblEditKidsTable = new JLabel("Edit Reindeer Table");
	private final JTextArea third_textarea = new JTextArea();
	private final JScrollPane scrollPane_1 = new JScrollPane();

	

	/**
	 * Create the frame.
	 */
	public editReindeerTableFrame() {
		first_textfield.setBounds(109, 74, 130, 26);
		first_textfield.setColumns(10);
		connection = postgresConnection.dbConnector();
		jblnit();
		second_textfield.setBounds(109, 103, 130, 26);
		second_textfield.setColumns(10);
		jblnit();
	}
	private void jblnit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		first_label.setBounds(6, 108, 98, 16);
		
		contentPane.add(first_label);
		second_label.setBounds(6, 136, 91, 16);
		
		contentPane.add(second_label);
		
		contentPane.add(second_textfield);
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
		btnInsert.setBounds(81, 256, 117, 29);
		
		contentPane.add(btnInsert);
		if (btnCancel.getActionListeners().length<1){
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnCancel_actionPerformed(e);
				}
			});
		}
		btnCancel.setBounds(81, 337, 117, 29);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(251, 74, 481, 243);
		
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
		btnDelete.setBounds(81, 296, 117, 29);
		
		contentPane.add(btnDelete);
	
		
		contentPane.add(first_textfield);
		first_textfield.disable();
		lblKidId.setBounds(23, 80, 81, 16);
		
		contentPane.add(lblKidId);
		lblEditKidsTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblEditKidsTable.setBounds(6, 6, 320, 55);
		
		contentPane.add(lblEditKidsTable);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(109, 136, 130, 109);
		
		contentPane.add(scrollPane_1);
		third_textarea.setLineWrap(true);
		scrollPane_1.setViewportView(third_textarea);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnInsert_actionPerformed(ActionEvent e) throws SQLException {
		try {
			String insertQuery = "insert into reindeer (reindeer_name, special_skills) values (?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, second_textfield.getText());
			pst.setString(2, third_textarea.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Reindeer Successfully Inserted");
			
			pst.close();
			btnRefresh.doClick();
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnRefresh_actionPerformed(ActionEvent e) {
		try {
			String refreshQuery = "Select * from reindeer order by reindeer_name";
			PreparedStatement pst = connection.prepareStatement(refreshQuery);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception h) {
			h.printStackTrace();
		}
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		try {
			String deleteQuery = "delete from reindeer where reindeer_id = " + Integer.parseInt(first_textfield.getText()) + ";";
			PreparedStatement pst = connection.prepareStatement(deleteQuery);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Reindeer Successfully Deleted");
			
			pst.close();
			btnRefresh.doClick();
			first_textfield.setText("");
			second_textfield.setText("");
			third_textarea.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		try {
			int row = table.getSelectedRow();
			String reindeer_id = (table.getModel().getValueAt(row, 0)).toString();
			
			
			String Query = "select * from reindeer where reindeer_id ='"+ reindeer_id +"'";
			
			PreparedStatement pst = connection.prepareStatement(Query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				first_textfield.setText(rs.getString("reindeer_id"));
				second_textfield.setText(rs.getString("reindeer_name"));
				third_textarea.setText(rs.getString("special_skills"));
			}
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
