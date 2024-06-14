package tryhard4;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame{
	JPanel cards, pnDefault, pnQLMonHoc, pnQuanLiDiem;
	
	JLabel lbDefault;
	JMenuBar mnBar;
	JMenu mnFile, mnQuanLiSinhVien;
	JMenuItem mniExit, mniQuanLiMonHoc, mniQuanliDiem;
	//quan li mon hoc
	JPanel pnTop,pnMH,pnThaoTac , pnTable;
	JLabel lbMSSV, lbTen,lbMMH, lbTMH;
	JTextField tfMSSV, tfTen,tfMMH, tfTMH;
	JButton btnThem, btnXoa;
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollPane;
	//quan li diem
	JPanel pnTop1,pnMH1,pnThaoTac1 , pnTable1;
	JLabel lbMSSV1, lbTen1,lbMMH1, lbTMH1;
	JTextField tfMSSV1, tfTen1, tfTMH1;
	JComboBox<String> list;
	JButton btnThem1, btnTimSV;
	DefaultTableModel model1;
	JTable table1;
	JScrollPane scrollPane1;
		
	
	public MyFrame() {
		setTitle("DKMonHoc");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700,500);
//Menu
		mnBar = new JMenuBar();
		setJMenuBar(mnBar);
		mnFile = new JMenu("File");
		mniExit = new JMenuItem("Exit");
		mnFile.add(mniExit);
		mnQuanLiSinhVien = new JMenu("QuanLiSinhVien");
		mniQuanliDiem = new JMenuItem("QuanLiDiem");
		mniQuanLiMonHoc = new JMenuItem("QuanLiMonHoc");
		mniQuanLiMonHoc.addActionListener(new XuLiMenu());
		mniQuanliDiem.addActionListener(new XuLiMenu());
		mnQuanLiSinhVien.add(mniQuanLiMonHoc);
		mnQuanLiSinhVien.add(mniQuanliDiem);
		mnBar.add(mnFile);
		mnBar.add(mnQuanLiSinhVien);
//panel default
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		pnDefault = new JPanel();
		pnDefault.setLayout(new FlowLayout());
		lbDefault = new JLabel("Quan Ly Sinh Vien Khoa CNTT");
		lbDefault.setHorizontalAlignment(SwingConstants.CENTER);
		pnDefault.add(lbDefault);
		cards.add("default" ,pnDefault);
// Quan Li Mon hoc
		pnQLMonHoc = new JPanel();
		pnQLMonHoc.setLayout(new BorderLayout());
		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		pnMH = new JPanel();
		pnMH.setLayout(new GridLayout(4,4));
		lbMSSV = new JLabel("Ma so sinh vien");lbMSSV.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTen = new JLabel("Ho va ten sinh vien");lbTen.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMMH = new JLabel("Ma mon hoc");lbMMH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTMH = new JLabel("Ten mon hoc");	lbTMH.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfMSSV = new JTextField();
		tfTen = new JTextField();
		tfMMH = new JTextField();
		tfTMH = new JTextField();
		
		pnMH.add(lbMSSV);pnMH.add(tfMSSV);
		pnMH.add(lbTen);pnMH.add(tfTen);
		pnMH.add(lbMMH);pnMH.add(tfMMH);
		pnMH.add(lbTMH);pnMH.add(tfTMH);
		pnMH.setBorder(BorderFactory.createTitledBorder("Them Mon Hoc"));
		//thao tac
		pnThaoTac = new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		btnThem = new JButton("ThemMH");
		btnXoa = new JButton("XoaMH");
		pnThaoTac.add(btnThem);
		pnThaoTac.add(btnXoa);
		pnThaoTac.setBorder(BorderFactory.createTitledBorder("Thao Tac"));
		pnTop.add(pnMH, BorderLayout.NORTH);
		pnTop.add(pnThaoTac, BorderLayout.CENTER);
		//table
		pnTable = new JPanel();
		String[] hearderTable1 = {"So TT", "Ma so sinh vien", "Ten sinh Vien", "Ma mon hoc", "Ten mon hoc"};
		model = new DefaultTableModel(hearderTable1, 0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(680, 250));
		pnTable.add(scrollPane);
		pnTable.setBorder(BorderFactory.createTitledBorder("Ket Qua Mon Hoc"));
		pnQLMonHoc.add(pnTop, BorderLayout.NORTH);
		pnQLMonHoc.add(pnTable, BorderLayout.CENTER);
		
		cards.add("QuanLiMonHoc",pnQLMonHoc);
// Quan Li diem
		
		pnQuanLiDiem = new JPanel();
		pnQuanLiDiem.setLayout(new BorderLayout());
		//mon hoc
		pnTop1 = new JPanel();
		pnTop1.setLayout(new BorderLayout());
		pnMH1 = new JPanel();
		pnMH1.setLayout(new GridLayout(4,4));
		lbMSSV1 = new JLabel("Ma so sinh vien");lbMSSV1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTen1 = new JLabel("Ho va ten sinh vien");lbTen1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMMH1 = new JLabel("Ma mon hoc");lbMMH1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTMH1 = new JLabel("Ten mon hoc");	lbTMH1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfMSSV1 = new JTextField();
		tfTen1 = new JTextField();
		list = new JComboBox<String>();
		tfTMH1 = new JTextField();
		
		pnMH1.add(lbMSSV1);pnMH1.add(tfMSSV1);
		pnMH1.add(lbTen1);pnMH1.add(tfTen1);
		pnMH1.add(lbMMH1);pnMH1.add(list);
		pnMH1.add(lbTMH1);pnMH1.add(tfTMH1);
		pnMH1.setBorder(BorderFactory.createTitledBorder("Them Mon Hoc"));
		pnTop1.add(pnMH1, BorderLayout.NORTH);
		//thao tac
		pnThaoTac1 = new JPanel();
		pnThaoTac1.setLayout(new FlowLayout());
		btnThem1 = new JButton("ThemDiem");
		btnTimSV = new JButton("TimSinhVien");
		pnThaoTac1.add(btnThem1);
		pnThaoTac1.add(btnTimSV);
		pnThaoTac1.setBorder(BorderFactory.createTitledBorder("Thao Tac"));
		pnTop1.add(pnMH1, BorderLayout.NORTH);
		pnTop1.add(pnThaoTac1, BorderLayout.CENTER);
		pnQuanLiDiem.add(pnTop1, BorderLayout.NORTH);
		// table
		pnTable1 = new JPanel();
		String[] hearderTable2 = {"So TT", "Ma so sinh vien",  "Ma mon hoc", "Diem"};
		model1 = new DefaultTableModel(hearderTable2, 0);
		table1 = new JTable(model1);
		scrollPane1 = new JScrollPane(table1);
		scrollPane1.setPreferredSize(new Dimension(680, 250));
		pnTable1.add(scrollPane1);
		pnQuanLiDiem.add(pnTop1, BorderLayout.NORTH);
		pnQuanLiDiem.add(pnTable1, BorderLayout.CENTER);
		pnTable1.setBorder(BorderFactory.createTitledBorder("Ket Qua Mon Hoc"));
		cards.add("QuanLiDiem", pnQuanLiDiem);
		getContentPane().add(cards, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public class XuLiMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem user = (JMenuItem) e.getSource();
			CardLayout card = (CardLayout) cards.getLayout();
			if(user==mniQuanLiMonHoc) {
				card.show(cards, mniQuanLiMonHoc.getText());
			}else if(user == mniQuanliDiem) {
				card.show(cards, mniQuanliDiem.getText());
			}
			
		}
		
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
