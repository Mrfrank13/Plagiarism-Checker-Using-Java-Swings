import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.ChangedCharSetException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.io.*;

public class Plagiarism extends JFrame {
	File efile;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plagiarism frame = new Plagiarism();
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
	public Plagiarism() {
		setBackground(Color.ORANGE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPlagiarismChecker = new JLabel("PLAGIARISM CHECKER");
		lblPlagiarismChecker.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 16));
		lblPlagiarismChecker.setBounds(198, 11, 198, 23);
		contentPane.add(lblPlagiarismChecker);

		JLabel lblEnterThePath = new JLabel("Enter the path of the file to be checked");
		lblEnterThePath.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterThePath.setBounds(45, 70, 267, 14);
		contentPane.add(lblEnterThePath);

		textField = new JTextField();
		textField.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		textField.setBounds(310, 69, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Arial Black", Font.BOLD, 14));
		textArea.setBounds(95, 145, 404, 180);
		contentPane.add(textArea);
		textArea.setEditable(false);
		TextArea textArea2 = new TextArea();
		textArea2.setFont(new Font("Arial Black", Font.BOLD, 14));
		textArea2.setBounds(95, 145, 404, 180);
		contentPane.add(textArea2);
		textArea.setEditable(false);

		JButton btnNewButton = new JButton("Show More");
		JButton btnCheckPlagiriasm = new JButton("Check Plagiarism");
		btnCheckPlagiriasm.setBackground(new Color(255, 0, 0));
		btnCheckPlagiriasm.setForeground(Color.WHITE);
		btnCheckPlagiriasm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Plagirism obj = new Plagirism();

				obj.checkPath = textField.getText();
				efile = new File(obj.checkPath);
				if (obj.checkPath.isEmpty())
					JOptionPane.showMessageDialog(null, "The Path File is Empty, Enter the Proper Path File Name");
				else if (!efile.isFile()) {
					JOptionPane.showMessageDialog(null, "Wrong Path, Enter the Proper Path File Name");

				} else {
					try {

						obj.backend();
					} catch (Exception e) {
						e.printStackTrace();
					}
					textArea.setText(obj.aString);
//					for(int l=0;l<=obj.m;l++)
//						obj.Console[l]=null;
					btnNewButton.setText("Show More");
					btnCheckPlagiriasm.setText("Check Plagiarism");
					btnCheckPlagiriasm.setBackground(new Color(255, 0, 0));
					btnCheckPlagiriasm.setForeground(Color.WHITE);
					
				}

			}

		});
		btnCheckPlagiriasm.setBounds(219, 101, 146, 23);
		contentPane.add(btnCheckPlagiriasm);
		btnCheckPlagiriasm.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plagirism obj2 = new Plagirism();
				textArea.setText(obj2.moreString);
				btnCheckPlagiriasm.setText("Show Less");
				btnCheckPlagiriasm.setBackground(new Color(240,240,240));
				btnCheckPlagiriasm.setForeground(Color.BLACK);
						}
		});
		btnNewButton.setBounds(219, 353, 146, 23);
		contentPane.add(btnNewButton);

	}
}
