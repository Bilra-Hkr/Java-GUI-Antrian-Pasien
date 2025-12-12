package AntrianGUI;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.util.Date;
import java.text.SimpleDateFormat;

class Pasien {
	int noAntrian;
	String nama;
	String keluhan;
	
	public Pasien(int noAntrian, String nama, String keluhan) {
		this.noAntrian = noAntrian;
		this.nama = nama;
		this.keluhan = keluhan;	
	}
	
	@Override
	public String toString() {
		return String.format("%-3d %-20s %-20s", noAntrian, nama, keluhan);
	}
	
}
public class AntrianGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private LinkedList<Pasien> antrianPasien;
	private int noAntrian = 1;
	private JLabel lblJumlahAntrian;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private JTextArea Df_pasien;
	private JTextArea Lg_aktivitas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AntrianGUI frame = new AntrianGUI();
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
	public AntrianGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 701);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236,240,241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		antrianPasien = new LinkedList<>();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Header = new JPanel();
		Header.setBackground(new Color(41,128,185));
		Header.setBounds(33, 6, 915, 97);
		contentPane.add(Header);
		Header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistem Antrian Pasien");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel.setBounds(302, 22, 323, 37);
		Header.add(lblNewLabel);
		
		JLabel lblPuskesmas = new JLabel("Puskesmas Talawi");
		lblPuskesmas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuskesmas.setForeground(Color.WHITE);
		lblPuskesmas.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPuskesmas.setBounds(302, 50, 323, 37);
		Header.add(lblPuskesmas);
		
		JPanel Footer = new JPanel();
		Footer.setBackground(Color.GRAY);
		Footer.setBounds(33, 589, 915, 70);
		contentPane.add(Footer);
		Footer.setLayout(null);
		
		lblJumlahAntrian = new JLabel("Jumlah Antrian Pasien :");
		lblJumlahAntrian.setForeground(Color.WHITE);
		lblJumlahAntrian.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblJumlahAntrian.setBounds(22, 10, 138, 37);
		Footer.add(lblJumlahAntrian);
		
		JPanel Log_aktivitas = new JPanel();
		Log_aktivitas.setBackground(Color.WHITE);
		Log_aktivitas.setBounds(652, 114, 296, 465);
		contentPane.add(Log_aktivitas);
		Log_aktivitas.setLayout(null);
		
		JLabel lblPuskesmas_1_1_1 = new JLabel("Log Aktivitas");
		lblPuskesmas_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuskesmas_1_1_1.setForeground(new Color(41, 128, 185));
		lblPuskesmas_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPuskesmas_1_1_1.setBounds(0, 0, 296, 37);
		Log_aktivitas.add(lblPuskesmas_1_1_1);
		////////
		Lg_aktivitas = new JTextArea();
		Lg_aktivitas.setEditable(false);
		Lg_aktivitas.setFont(new Font("Consolas", Font.PLAIN, 12));
		Lg_aktivitas.setMargin(new Insets(5, 5, 5, 5));
		Lg_aktivitas.setBounds(10, 47, 268, 408);
		JScrollPane scrollPane_1 = new JScrollPane(Df_pasien);
		scrollPane_1.setBounds(10,47,268,408);
		Log_aktivitas.add(Lg_aktivitas);
		
		JPanel Input = new JPanel();
		Input.setBackground(Color.WHITE);
		Input.setBounds(33, 114, 311, 155);
		contentPane.add(Input);
		Input.setLayout(null);
		
		JLabel lblPuskesmas_1 = new JLabel("Input Data Pasien");
		lblPuskesmas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuskesmas_1.setForeground(new Color(41, 128, 185));
		lblPuskesmas_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPuskesmas_1.setBounds(0, 0, 311, 37);
		Input.add(lblPuskesmas_1);
		
		JLabel lblNamaPasien = new JLabel("Nama Pasien : ");
		lblNamaPasien.setForeground(Color.BLACK);
		lblNamaPasien.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNamaPasien.setBounds(20, 47, 138, 37);
		Input.add(lblNamaPasien);
		
		JLabel lblKeluhan = new JLabel("Keluhan :");
		lblKeluhan.setForeground(Color.BLACK);
		lblKeluhan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblKeluhan.setBounds(20, 86, 138, 37);
		Input.add(lblKeluhan);
		
		textField = new JTextField();
		textField.setBounds(128, 57, 158, 19);
		Input.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 94, 158, 19);
		Input.add(textField_1);
		
		JPanel Daftar_pasien = new JPanel();
		Daftar_pasien.setBackground(Color.WHITE);
		Daftar_pasien.setBounds(354, 114, 288, 465);
		contentPane.add(Daftar_pasien);
		Daftar_pasien.setLayout(null);
		
		JLabel lblPuskesmas_1_1 = new JLabel("Daftar Pasien");
		lblPuskesmas_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuskesmas_1_1.setForeground(new Color(41, 128, 185));
		lblPuskesmas_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPuskesmas_1_1.setBounds(0, 0, 288, 37);
		Daftar_pasien.add(lblPuskesmas_1_1);
		///
		Df_pasien = new JTextArea();
		Df_pasien.setBounds(10, 47, 268, 408);
		Df_pasien.setEditable(false);
		Df_pasien.setFont(new Font("Consolas", Font.PLAIN, 12));
		Df_pasien.setMargin(new Insets(5, 5, 5, 5));
		JScrollPane scrollPane = new JScrollPane(Df_pasien);
		scrollPane.setBounds(10,47,268,408);
		Daftar_pasien.add(scrollPane);
		
		JPanel Tombol = new JPanel();
		Tombol.setBounds(33, 279, 311, 145);
		contentPane.add(Tombol);
		Tombol.setLayout(null);
		
		JButton btnNewButton = new JButton("Tambah Pasien");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tambahPasien();
			}
		});
		btnNewButton.setBackground(new Color(39, 174, 96));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(10, 10, 128, 53);
		Tombol.add(btnNewButton);
		
		JButton btnCariPasien = new JButton("Cari Pasien");
		btnCariPasien.setBackground(new Color(230, 126, 34));
		btnCariPasien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cariPasien();
			}
		});
		btnCariPasien.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCariPasien.setBounds(10, 73, 128, 53);
		Tombol.add(btnCariPasien);
		
		JButton btnLayaniPasien = new JButton("Layani Pasien");
		btnLayaniPasien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layaniPasien();
			}
		});
		btnLayaniPasien.setBackground(new Color(41, 128, 185));
		btnLayaniPasien.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnLayaniPasien.setBounds(173, 10, 128, 53);
		Tombol.add(btnLayaniPasien);
		
		JButton btnResetAntrian = new JButton("Reset Antrian");
		btnResetAntrian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAntrian();
			}
		});
		btnResetAntrian.setBackground(new Color(231, 76, 60));
		btnResetAntrian.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnResetAntrian.setBounds(173, 73, 128, 53);
		Tombol.add(btnResetAntrian);
		
		JPanel Pencarian = new JPanel();
		Pencarian.setBackground(Color.WHITE);
		Pencarian.setBounds(33, 434, 311, 145);
		contentPane.add(Pencarian);
		Pencarian.setLayout(null);
		
		JLabel lblPuskesmas_1_2 = new JLabel("Pencarian Pasien");
		lblPuskesmas_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuskesmas_1_2.setForeground(new Color(41, 128, 185));
		lblPuskesmas_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblPuskesmas_1_2.setBounds(0, 0, 311, 37);
		Pencarian.add(lblPuskesmas_1_2);
		
		JLabel lblNamaAtauNomor = new JLabel("Nama atau nomor antrian pasien :");
		lblNamaAtauNomor.setForeground(Color.BLACK);
		lblNamaAtauNomor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNamaAtauNomor.setBounds(10, 47, 271, 37);
		Pencarian.add(lblNamaAtauNomor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 80, 271, 19);
		Pencarian.add(textField_2);
	}
	
	private void tambahPasien() {
		String nama = textField.getText().trim();
		String keluhan = textField_1.getText().trim();
		
		if (nama.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Masukan name pasien!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
			textField.requestFocus();
			return;
		}
		if (keluhan.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Masukan keluhan pasien!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
			textField.requestFocus();
			return;
		}
		
		antrianPasien.add(new Pasien(noAntrian++, nama, keluhan));
		Lg_aktivitas.append(String.format("Pasien berhasil ditambahkan \n" + getCurrentTime() + " " + nama + " " + keluhan + "\n"));
		textField.setText("");
		textField_1.setText("");
		textField.requestFocus(); 
		
		updateDaftarPasien();
		updateStatusLabel();
	}
	
	private String getCurrentTime() {
		return dateFormat.format(new Date());
	}
	
	private void updateDaftarPasien() {
		Df_pasien.setText("");
		if (antrianPasien.isEmpty()) {
			Df_pasien.setText("Tidak ada pasien dalam antrian");
		} else {
			Df_pasien.append(String.format("%-3s %-20s %-20s\n", "No", "Nama", "Keluhan"));
			Df_pasien.append("=======================================\n");
			for (Pasien p : antrianPasien) {
				Df_pasien.append(p.toString() + "\n");
			}
		}
	}
	
	private void updateStatusLabel() {
		lblJumlahAntrian.setText("Jumlah Antrian Pasien : " + antrianPasien.size());
	}
	
	
	private void cariPasien() {
		String keyword = textField_2.getText().trim();
		
		if (keyword.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Masukan name atau nomor Antrian pasien!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
			textField_2.requestFocus();
			return;
		}
		boolean ditemukan = false;
		for (Pasien p : antrianPasien) {
			if (p.nama.toLowerCase().contains(keyword.toLowerCase()) || String.valueOf(p.noAntrian).equals(keyword)) {
				Lg_aktivitas.append(String.format("Ditemukan pasien : " + "No antrian : " + p.noAntrian + " " + p.nama + " " + p.keluhan));
				ditemukan = true;
			}
		}
		if (!ditemukan) {
			Lg_aktivitas.append(String.format("Tidak ditemukan pasien"));
			JOptionPane.showMessageDialog(this, "Pasien tidak ditemukan", "informasi!", JOptionPane.INFORMATION_MESSAGE);
		}
		textField_2.setText("");
	}
	
	private void layaniPasien() {
		if (!antrianPasien.isEmpty()) {
			Pasien p = antrianPasien.removeFirst();
			Lg_aktivitas.append(String.format("Pasien sedang dilayani\n", getCurrentTime(), p.nama));
			updateDaftarPasien();
			updateStatusLabel();
			if (antrianPasien.isEmpty()) {
				noAntrian = 1;
				Lg_aktivitas.append(String.format("Semua pasien telah dilayani\n", getCurrentTime(), p.nama));
			}
		} else {
			Lg_aktivitas.append(String.format("Antrian Kosong, tidak ada pasien yang dilayani", getCurrentTime()));
		}
	}
	
	private void resetAntrian() {
		int option = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin mereset antrian?", 
				"Konfirmasi Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (option == JOptionPane.YES_OPTION) {
			antrianPasien.clear();
			noAntrian = 1;
			Lg_aktivitas.append(String.format("Semua antrian telah direset\n" + getCurrentTime()));
			updateDaftarPasien();
			updateStatusLabel();
		}
	}
}
