package FinalSwing;

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

public class BanHangOnline2 extends JFrame{
	JPanel pnChua, pnTop, pnTT, pnSP, pnThaoTac;
	JLabel lbTen, lbDiaChi, lbSDT, lbBill;
	JTextField tfTen, tfDiaChi, tfSDT;
	JCheckBox cbBanhTrang, cbTraSua, cbKhoaiTay, cbMacho;
	JButton btnDatHang, btnXoa, btnThanhToan, btnThoat;
	DefaultTableModel model;
	JTable table;
	JScrollPane scrollPane;
	private String sanPhamDaChon="";
	private double tongGia=0;
	private int stt=1;
	public BanHangOnline2() {
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
		lbTen = new JLabel("Ho va ten");
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
		//san pham
		pnSP = new JPanel();
		pnSP.setLayout(new GridLayout(2,2));
		cbBanhTrang = new JCheckBox("Banh Trang Tron(15000)");
		cbKhoaiTay = new JCheckBox("Khoai Tay Chien(5000)");
		cbMacho = new JCheckBox("Tra Sua Thach Macho(20000)");
		cbTraSua = new JCheckBox("Tra Sua Tran Chau(20000)");
		
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
		pnThaoTac.setBorder(BorderFactory.createTitledBorder("Thao Tac Dat Hang"));
		btnDatHang = new JButton("DatHang");
		btnThanhToan = new JButton("Thanh Toan");
		btnThoat = new JButton("Thoat");
		btnXoa = new JButton("Xoa");
		
		btnDatHang.addActionListener(new XuLiButton());
		btnThanhToan.addActionListener(new XuLiButton());
		btnThoat.addActionListener(new XuLiButton());
		btnXoa.addActionListener(new XuLiButton());
		
		
		pnThaoTac.add(btnDatHang);
		pnThaoTac.add(btnThoat);
		pnThaoTac.add(btnXoa);
		pnThaoTac.add(btnThanhToan);
		pnTop.add(pnThaoTac, BorderLayout.SOUTH);
		pnChua.add(pnTop, BorderLayout.NORTH);
	//table
		String[] col = {"STT", "Ten San Pham", "Don Gia"};
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		pnChua.add(scrollPane, BorderLayout.CENTER);
	//Thanh toan
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
			else if(user==cbKhoaiTay) {
				sanPhamDaChon+=cbKhoaiTay.getText()+"-";
			}
			else if(user==cbMacho) {
				sanPhamDaChon+=cbMacho.getText()+"-";
			}
			else if(user==cbTraSua) {
				sanPhamDaChon+=cbTraSua.getText()+"-";
			}
		}
	}
	public class XuLiButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton user = (JButton) e.getSource();
			if(table.getRowCount()==0) {
				stt=1;
			}
			if(user==btnDatHang) {
				String[] listSP = sanPhamDaChon.split("-");
				for (String str : listSP) {
					int indexdau = str.indexOf("(");
					String tenSP = str.substring(0, indexdau);
					double giaSP = Double.parseDouble(str.substring(indexdau+1, str.indexOf(")")));
					tongGia+=giaSP;
					String[] row = {stt++ +"",tenSP, giaSP+""};
					model.addRow(row);
				}
				cbBanhTrang.setSelected(false);
				cbKhoaiTay.setSelected(false);
				cbMacho.setSelected(false);
				cbTraSua.setSelected(false);
				sanPhamDaChon ="";
			}else if(user==btnThanhToan) {
				tfTen.setEnabled(false);
				tfSDT.setEnabled(false);
				tfDiaChi.setEnabled(false);
				
				cbBanhTrang.setEnabled(false);
				cbKhoaiTay.setEnabled(false);
				cbMacho.setEnabled(false);
				cbTraSua.setEnabled(false);
				lbBill.setText(tfTen.getText()+" "+tfDiaChi.getText()+" "+tfSDT.getText()+" Tong Thanh Tien: "+tongGia+"");
			}else if(user==btnXoa) {
				double giaDaXoa = Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2));
				tongGia-=giaDaXoa;
				model.removeRow(table.getSelectedRow());
			}else if(user==btnThoat) {
				int option = JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Xac Nhan", JOptionPane.YES_NO_OPTION);
				if(option==0) {
					System.exit(0);
					
				}else {
					tongGia=0;
					tfTen.setEnabled(true);
					tfSDT.setEnabled(true);
					tfDiaChi.setEnabled(true);
					tfTen.setText("");
					tfDiaChi.setText("");
					tfSDT.setText("");
					cbBanhTrang.setEnabled(true);
					cbKhoaiTay.setEnabled(true);
					cbMacho.setEnabled(true);
					cbTraSua.setEnabled(true);
					model.setRowCount(0);
					lbBill.setText(tongGia+"");
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new BanHangOnline2();
	}
}
