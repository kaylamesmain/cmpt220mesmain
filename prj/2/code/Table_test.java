package tableTest;
import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ComponentAdapter;
import java.awt.Choice;

public class Table_test extends JFrame {

	/* Initialize all the design objects inside the JFrame*/
	private JPanel contentPane;
	private final JButton btnRefresh = new JButton("Refresh");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final Label label = new Label("   Christmas Santa 2.0");
	private final Panel panel = new Panel();
	private final Label quickquery_label = new Label("Quick Query's");
	private final JComboBox tables_comboBox = new JComboBox();
	private final JLabel lblTable = new JLabel("Table");
	private final JComboBox sortby_comboBox = new JComboBox();
	private final JLabel lblNewLabel = new JLabel("Sort By");
	private final JButton btnKidInfo = new JButton("Kid Info");
	private final JButton btnGiftsPerKid = new JButton("Gifts Per Kid");
	private final JButton btnHeadElvesInfo = new JButton("Head Elves Info");
	private final JButton btnInventory = new JButton("Inventory");
	private final JButton btnNoLetterKids = new JButton("No Letter Kids");
	private final JButton btnNaughtyniceOccurences = new JButton("Naughty/Nice Occurences");
	private final JButton btnNiceList = new JButton("Nice List");
	private final JButton btnNaughtyList = new JButton("Naughty List");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnEdit = new JMenu("Edit");
	private final JMenu mnInsert = new JMenu("Tables");
	private final JMenuItem mntmKids = new JMenuItem("Kids");
	private final JMenuItem mntmAddressTable = new JMenuItem("Address'");
	private final JMenuItem mntmStaff = new JMenuItem("Staff");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmFactories = new JMenuItem("Factories");
	private final JMenuItem mntmInventory = new JMenuItem("Inventory");
	private final JMenuItem mntmReindeer = new JMenuItem("Reindeer");
	private final JMenuItem mntmDepartments = new JMenuItem("Departments");
	private final JMenuItem mntmWrappingSchemes = new JMenuItem("Wrapping Schemes");

	/*Initialed a variable labeled mainQuery as a new majorQuery Object*/
	private final majorQuery mainQuery = new majorQuery();
	Connection connection= null;
	String query = "";
	
	
	
	
	
	/**
	 * Launch the application. Creates and Opens new Home Frame
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table_test frame = new Table_test();
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
	public Table_test() {
		
		/*                          Establish Database Connection                       */
		connection = postgresConnection.dbConnector();
		
		
		
		/*                          Establish GUI Items Settings                        */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		label.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane.setBounds(215, 181, 649, 339);
		scrollPane.setViewportView(table);
		
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		label.setBackground(Color.RED);
		label.setBounds(0, 0, 900, 90);
		btnRefresh.setBounds(481, 141, 117, 29);
		
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 90, 178, 488);
		
		quickquery_label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		quickquery_label.setForeground(Color.RED);
		
		tables_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kids Table", "Letters Table", "Addresses Table", "Kid Logs Table", "Gifts Table", "Wrapping Schemes Table", "Staff Table", "Departments Table", "Head Elves Table", "Delivered Table", "Inventory Table", "Reindeer Table", "Factories Table"}));
		tables_comboBox.setBounds(222, 141, 178, 28);
		
		lblTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTable.setBounds(225, 113, 61, 16);
		
		sortby_comboBox.setModel(new DefaultComboBoxModel(new String[] {"kid_id", "address_id", "first_name", "last_name", "gender", "age", "verdict"}));
		sortby_comboBox.setBounds(666, 142, 162, 27);
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(672, 107, 84, 29);
		
		
		
		
		/*                                Menu Items Listeners                           */
		/* Listens linked to action items like buttons or drop downs waiting for user interaction*/
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmExit_actionPerformed(e);
			}
		});
		
		if (mntmKids.getActionListeners().length<1){
			mntmKids.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmKids_actionPerformed(e);
				}
			});
		}
		
		if (mntmAddressTable.getActionListeners().length<1){
			mntmAddressTable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmAddressTable_actionPerformed(e);
				}
			});
		}
		
		if (mntmStaff.getActionListeners().length<1){
			mntmStaff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmDelivered_actionPerformed(e);
				}
			});
		}
		
		if (mntmFactories.getActionListeners().length<1){
			mntmFactories.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmFactories_actionPerformed(e);
				}
			});
		}
		
		if (mntmDepartments.getActionListeners().length<1){
			mntmDepartments.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmDepartments_actionPerformed(e);
				}
			});
		}
		
		if (mntmReindeer.getActionListeners().length<1){
			mntmReindeer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmReindeer_actionPerformed(e);
				}
			});
		}
		
		if (mntmWrappingSchemes.getActionListeners().length<1){
			mntmWrappingSchemes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmWrappingSchemes_actionPerformed(e);
				}
			});
		}
		
		/*                          Establish Button Listeners                            */
		if (btnRefresh.getActionListeners().length<1){
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnLoadTable_actionPerformed(e);
				}
			});
		}
		
		if (mntmInventory.getActionListeners().length<1){
			mntmInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_mntmInventory_actionPerformed(e);
				}
			});
		}
		
		if (btnKidInfo.getActionListeners().length<1){
			btnKidInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnKidInfo_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnNiceList.getActionListeners().length<1){
			btnNiceList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnNiceList_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnNaughtyList.getActionListeners().length<1){
			btnNaughtyList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnNaughtyList_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnGiftsPerKid.getActionListeners().length<1){
			btnGiftsPerKid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnGiftsPerKid_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnHeadElvesInfo.getActionListeners().length<1){
			btnHeadElvesInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnHeadElvesInfo_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnInventory.getActionListeners().length<1){
			btnInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnInventory_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnNoLetterKids.getActionListeners().length<1){
			btnNoLetterKids.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnNoLetterKids_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		if (btnNaughtyniceOccurences.getActionListeners().length<1){
			btnNaughtyniceOccurences.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						do_btnNaughtyniceOccurences_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		
		/*                          Establish Combo Boxes Listeners                     */
		if (tables_comboBox.getActionListeners().length<1){
			tables_comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_tables_comboBox_actionPerformed(e);
				}
			});
		}
		
		if (sortby_comboBox.getActionListeners().length<1){
			sortby_comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_sortby_comboBox_actionPerformed(e);
				}
			});
		}
		
		
		//After item setting are configures items are added to appropriate location of JFrame
		jblnit();
	}
	
	private void jblnit() {
		/*                          Add All Items to Frame                                 */
		menuBar.add(mnFile);
		mnFile.add(mntmExit);
		menuBar.add(mnEdit);
		mnEdit.add(mnInsert);
		mnInsert.add(mntmAddressTable);
		mnInsert.add(mntmDepartments);
		mnInsert.add(mntmFactories);
		mnInsert.add(mntmInventory);
		mnInsert.add(mntmKids);
		mnInsert.add(mntmReindeer);
		mnInsert.add(mntmStaff);
		
		
		mnInsert.add(mntmWrappingSchemes);
		contentPane.add(btnRefresh);
		contentPane.add(scrollPane);
		contentPane.add(label);
		contentPane.add(panel);
		panel.add(quickquery_label);
		panel.add(btnNiceList);
		panel.add(btnNaughtyList);
		panel.add(btnKidInfo);
		panel.add(btnGiftsPerKid);
		panel.add(btnHeadElvesInfo);
		panel.add(btnInventory);
		panel.add(btnNoLetterKids);
		panel.add(btnNaughtyniceOccurences);
		contentPane.add(tables_comboBox);
		contentPane.add(lblTable);
		contentPane.add(sortby_comboBox);
		contentPane.add(lblNewLabel);
	}
	
	// Refresh Button Action Method
	protected void do_btnLoadTable_actionPerformed(ActionEvent i) {
		try {
			query= mainQuery.getMajorQuery();
			System.out.println(query);
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/* Table combo box action method that changes main query variables to desired choice*/
	protected void do_tables_comboBox_actionPerformed(ActionEvent e) {
		
		int selected = tables_comboBox.getSelectedIndex();
		switch (selected) {
		 
        case 0: mainQuery.setTable("kids");
        			mainQuery.setColumns(new String[] {"kid_id", "address_id", "first_name", "last_name", "gender", "age", "verdict"});
        			mainQuery.setSort(" Order by kid_id");
        			 break;
        			 
        case 1:  mainQuery.setTable("letters");
        			 mainQuery.setColumns(new String[] {"kid_id", "letter_id", "date_delivered", "date_received", "wishes"});
        			 mainQuery.setSort(" Order by kid_id");
        			 break;
        			 
        case 2:  mainQuery.setTable("addresses");
        			mainQuery.setColumns(new String[] {"address_id", "street_address", "city", "region", "postal_code", "country"});
         	    	mainQuery.setSort(" Order by address_id");

        			 break;
        			 
        case 3:  mainQuery.setTable("kid_logs");
        			mainQuery.setColumns(new String[] {"log_id", "kid_id", "changed_to", "changed_on"});
        			 mainQuery.setSort(" Order by log_id");
        			 break;
        			 
        case 4:  mainQuery.setTable("gifts");
        			 mainQuery.setColumns(new String[] {"gift_id", "kid_id", "item_id", "elf_id","wrapping_id", "date_packaged", "eta"});
        			 mainQuery.setSort(" Order by gift_id");
        			 break;
        			 
        case 5:  mainQuery.setTable("wrapping_schemes");
		 		 mainQuery.setColumns(new String[] {"wrapping_id", "wrapping_color", "wrapping_pattern", "ribbon_color", "box_size"});
        			 mainQuery.setSort(" Order by wrapping_id");
        			 break;
		         
        			 
        case 6:  mainQuery.setTable("staff");
        			 mainQuery.setColumns(new String[] {"elf_id", "department_id", "first_name", "last_name", "age","hire_date","hourly_rate"});
        			 mainQuery.setSort(" Order by elf_id");
        			 
        			 break;
        			 
        case 7:  mainQuery.setTable("departments");
		 		 mainQuery.setColumns(new String[] {"department_id", "department_name"});
        			 mainQuery.setSort(" Order by department_id");
        			 break;
        			 
        case 8:  mainQuery.setTable("head_elves");
        			 mainQuery.setColumns(new String[] {"elf_id", "title", "promotion_date"});
        			 mainQuery.setSort(" Order by elf_id");
        			 break;
        			 
        case 9: mainQuery.setTable("delivered");
        			mainQuery.setColumns(new String[] {"gift_id", "lead_reindeer", "time_delivered"});
        			mainQuery.setSort(" Order by gift_id");
        			 break;
        			 
        case 10: mainQuery.setTable("inventory");
		 		 mainQuery.setColumns(new String[] {"item_id", "factory_id", "item_name", "item_description", "item_weight_lbs"});
        			 mainQuery.setSort(" Order by item_id");
        			 break;
        			 
        case 11: mainQuery.setTable("reindeer");
		 		 mainQuery.setColumns(new String[] {"reindeer_id", "reindeer_name", "special_skills"});
        			 mainQuery.setSort(" Order by reindeer_id");
        			 break;
        			 
        case 12: mainQuery.setTable("factories");
		 		 mainQuery.setColumns(new String[] {"factory_id", "factory_name", "specialty"});
        			 mainQuery.setSort(" Order by factory_id");
                 break;
                 
    }
		sortby_comboBox.setModel(new DefaultComboBoxModel(mainQuery.getColumns()));
			
			btnRefresh.doClick();
	}
	
	/* changes sort variable inside main query to match user selection*/
	protected void do_sortby_comboBox_actionPerformed(ActionEvent e) {
		
		int selected = sortby_comboBox.getSelectedIndex();
		mainQuery.setSort(" Order by " + sortby_comboBox.getSelectedItem().toString());
		btnRefresh.doClick();
	}
	
	
	
	/* Quick queries that call on views establised in pg admin*/
	
	protected void do_btnKidInfo_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from kids_wishes;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
	
	protected void do_btnGiftsPerKid_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from gifts_per_kid;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	protected void do_btnHeadElvesInfo_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from head_elves_info;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	protected void do_btnInventory_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from item_gifted_amount;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	protected void do_btnNoLetterKids_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from not_sent_letters;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	protected void do_btnNaughtyniceOccurences_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from verdict_occurences;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	protected void do_btnNiceList_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from nice_list;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	protected void do_btnNaughtyList_actionPerformed(ActionEvent e) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("Select * from naughty_list;");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	
	/*Action methods for menu items*/
	
	protected void do_mntmKids_actionPerformed(ActionEvent e) {
		editKidsTableFrame frame = new editKidsTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmAddressTable_actionPerformed(ActionEvent e) {
		editAddressesTableFrame frame = new editAddressesTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmDelivered_actionPerformed(ActionEvent e) {
		editStaffTableFrame frame = new editStaffTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmExit_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_mntmFactories_actionPerformed(ActionEvent e) {
		editFactoriesTableFrame frame = new editFactoriesTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmInventory_actionPerformed(ActionEvent e) {
		editInventoryTableFrame frame = new editInventoryTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmReindeer_actionPerformed(ActionEvent e) {
		editReindeerTableFrame frame = new editReindeerTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmDepartments_actionPerformed(ActionEvent e) {
		editDepartmentsTableFrame frame = new editDepartmentsTableFrame();
		frame.setVisible(true);
	}
	protected void do_mntmWrappingSchemes_actionPerformed(ActionEvent e) {
		editWrappingSchemesTableFrame frame = new editWrappingSchemesTableFrame();
		frame.setVisible(true);
	}
}

