package TryHard9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MyApp2 extends JFrame{
	JPanel pnChua, pnTop, pnTT, pnSP, pnThaoTac, pnTable;
	JLabel lbTen, lbDiaChi, lbSDT, lbBill;
	JTextField tfTen, tfDiaChi, tfSDT;
	JCheckBox cbBanhTrang, cbTraSua, cbKhoaiTay, cbMacho;
	JButton btnDatHang, btnThoat, btnXoa, btnThanhToan;
	DefaultTableModel model;
	JTable table;
	JScrollPane scollPane;
	private String sanPhamDaChon = "";
	private double tongGia =0;
	private int stt =1;
	public MyApp2() {
		setTitle("Mua Hang Online");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pnChua = new JPanel();
		pnChua.setLayout(new BorderLayout());
//Top
		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		//Thong tin
		pnTT = new JPanel();
		pnTT.setLayout(new GridLayout(3, 2));
		lbTen = new JLabel("Ho va Ten");
		lbDiaChi = new JLabel("Dia chi");
		lbSDT = new JLabel("So dien thoai");
		tfTen = new JTextField();
		tfDiaChi = new JTextField();
		tfSDT = new JTextField();
		pnTT.add(lbTen);pnTT.add(tfTen);
		pnTT.add(lbDiaChi);pnTT.add(tfDiaChi);
		pnTT.add(lbSDT);pnTT.add(tfSDT);
		pnTT.setBorder(BorderFactory.createTitledBorder("Thong Tin Khach Hang"));
		pnTop.add(pnTT, BorderLayout.NORTH);
		//San Pham
		pnSP = new JPanel();
		pnSP.setLayout(new GridLayout(2, 2));
		cbBanhTrang = new JCheckBox("Banh Trang Tron(15000)");
		cbKhoaiTay = new JCheckBox("Khoai Tay Chien(5000)");
		cbMacho = new JCheckBox("Tra Sua Thach Macho(20000)");
		cbTraSua = new JCheckBox("Tra Sua Chan Chau(20000)");
		
		cbBanhTrang.addActionListener(new XuLiCheckBox());
		cbKhoaiTay.addActionListener(new XuLiCheckBox());
		cbMacho.addActionListener(new XuLiCheckBox());
		cbTraSua.addActionListener(new XuLiCheckBox());
		
		pnSP.add(cbBanhTrang);
		pnSP.add(cbTraSua);
		pnSP.add(cbKhoaiTay);
		pnSP.add(cbMacho);
		pnSP.setBorder(BorderFactory.createTitledBorder("Chon San Pham"));
		pnTop.add(pnSP, BorderLayout.CENTER);
		//Thao tac
		pnThaoTac = new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		btnDatHang = new JButton("DatHang");
		btnThanhToan = new JButton("Thanh Toan");
		btnThoat = new JButton("Thoat");
		btnXoa = new JButton("XoaSP");
		
		btnDatHang.addActionListener(new XuLiButton());
		btnThanhToan.addActionListener(new XuLiButton());
		btnThoat.addActionListener(new XuLiButton());
		btnXoa.addActionListener(new XuLiButton());
		
		pnThaoTac.add(btnDatHang);
		pnThaoTac.add(btnThoat);
		pnThaoTac.add(btnXoa);
		pnThaoTac.add(btnThanhToan);
		pnThaoTac.setBorder(BorderFactory.createTitledBorder("Thao Tac Dat Hang"));
		pnTop.add(pnThaoTac, BorderLayout.SOUTH);
		pnChua.add(pnTop, BorderLayout.NORTH);
//Table
		pnTable = new JPanel();
		String[] hearderTable = {"STT", "Ten san pham", "Don gia"};
		model = new DefaultTableModel(hearderTable, 0);
		table = new JTable(model);
		scollPane = new JScrollPane(table);
		scollPane.setPreferredSize(new Dimension(400, 200));
		pnTable.add(scollPane);
		pnChua.add(pnTable, BorderLayout.CENTER);
// Thanh toan
		lbBill = new JLabel("0.0");
		lbBill.setHorizontalAlignment(SwingConstants.LEFT);
		lbBill.setBorder(BorderFactory.createTitledBorder("Tong so tien can thanh toan"));
		pnChua.add(lbBill, BorderLayout.SOUTH);
		getContentPane().add(pnChua);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public class XuLiCheckBox implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox user = (JCheckBox) e.getSource();
			if(user==cbBanhTrang) {
				sanPhamDaChon+=cbBanhTrang.getText()+"-";
			}
			else if(user==cbTraSua) {
				sanPhamDaChon+=cbTraSua.getText()+"-";
			}
			else if(user==cbKhoaiTay) {
				sanPhamDaChon+=cbKhoaiTay.getText()+"-";
			}
			else if(user==cbMacho) {
				sanPhamDaChon+=cbMacho.getText()+"-";
			}
			
		}
	}
	public class XuLiButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton user = (JButton) e.getSource();
			if(user==btnDatHang) {
				String[] list = sanPhamDaChon.split("-");
				for (String str : list) {
					String tenSP = str.substring(0, str.indexOf("("));
					double gia = Double.parseDouble(str.substring(str.indexOf("(")+1, str.indexOf(")")));
					tongGia+=gia;
					String[] row = {stt++ +"", tenSP, gia+""};
					model.addRow(row);
				}
				cbBanhTrang.setSelected(false);
				cbKhoaiTay.setSelected(false);
				cbMacho.setSelected(false);
				cbTraSua.setSelected(false);
			}else if(user==btnThoat){
				int option = JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Xac Nhan", JOptionPane.YES_NO_OPTION);
				if (option==0) {
					System.exit(0);
				}else {
					stt=1;
					tongGia=0;
					sanPhamDaChon="";
					lbBill.setText(tongGia+"");
					model.setRowCount(0);
				}
			}else if(user==btnXoa) {
				double giaDaXoa = Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2));
				tongGia-=giaDaXoa;
				model.removeRow(table.getSelectedRow());
			}else if(user==btnThanhToan) {
				lbBill.setText(tfTen.getText()+" "+tfDiaChi.getText()+" "+tfSDT.getText()+" "+ "Tong thanh tien: "+tongGia+"");
			}
		}
		
				
	}
	public static void main(String[] args) {
		new MyApp2();
	}
}
