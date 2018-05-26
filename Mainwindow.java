import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.geometry.Orientation;


public class Mainwindow extends JFrame{
	
	public Mainwindow() {
		
		super();
		
		Dimension dim = new Dimension(1200,800);
		
		JFrame window = new JFrame("SimpleMerge"); //window��� frame ����
		window.setVisible(true);
		window.setBounds(120,120,1200,800);
		window.setPreferredSize(dim);
		
		JPanel view = new JPanel(); 			//�θ� �г�

        view.setLayout(new GridLayout(2,3));
		
		FileDialog load = new FileDialog(this,"���� ����",FileDialog.LOAD);
		FileDialog save = new FileDialog(this, "���� ����", FileDialog.SAVE);
		
			
		JButton loadBtn1 = new JButton("LOAD");
		JButton editBtn1 = new JButton("EDIT");
		JButton saveBtn1 = new JButton("SAVE");
		
		JButton loadBtn2 = new JButton("LOAD");
		JButton editBtn2 = new JButton("EDIT");
		JButton saveBtn2 = new JButton("SAVE");
		
		JButton compareBtn = new JButton("COMPARE");
		
		JButton mergeBtn1 = new JButton("<<<LEFTMERGE");
		JButton mergeBtn2 = new JButton("RIGHTMERGE>>>");	

		JPanel panel1 = new JPanel(); 				// panel1�� frame�� �߰� left ������ load, edit, save �ϴ� ��ư ����
		panel1.setLayout(new FlowLayout());
		panel1.add(loadBtn1);
		panel1.add(editBtn1);
		panel1.add(saveBtn1);
		
		JPanel panel2 = new JPanel();				 // panel2�� frame�� �߰�. �� ������ compare �ϴ� ��ư ����
		panel2.add(compareBtn);
		
		JPanel panel3 = new JPanel();			// panel3�� frame�� �߰� right ������ load, edit, save �ϴ� ��ư ����
		panel3.setLayout(new FlowLayout());
		panel3.add(loadBtn2);
		panel3.add(editBtn2);
		panel3.add(saveBtn2);
		
		JTextArea leftcode = new JTextArea();			// panel4�� frame�� �߰� left ������ text
		leftcode.append("LEFT FILE CODE \n");
		leftcode.setCaretPosition(leftcode.getText().length());
		leftcode.setLineWrap(true);
		leftcode.setWrapStyleWord(true);
		JScrollPane panel4 = new JScrollPane(leftcode);		
				
		JPanel panel5 = new JPanel();				// panel5�� frame�� �߰�. �� ������ merge �ϴ� ��ư ����
		panel5.add(mergeBtn1);
		panel5.add(mergeBtn2);
		
		JTextArea rightcode = new JTextArea();			// panel6�� frame�� �߰� right ������ text
		rightcode.append("RIGHT FILE CODE \n");
		rightcode.setCaretPosition(rightcode.getText().length());
		rightcode.setLineWrap(true);
		rightcode.setWrapStyleWord(true);
		JScrollPane panel6 = new JScrollPane(rightcode);
		
		
		
		
		loadBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� load�ϴ� Ŭ������ ��ü ����
				
				load.setVisible(true);
				System.out.println("�������� : " + load.getDirectory());
				System.out.println("�������� : " + load.getFile());
				

				// 'txt ���ϸ� �о�ͼ�' panel4��  textarea �� ���!
				
				/*
				 try {
					    //dfName�� ������ ã�ư��� ���ۿ� ����
					    BufferedReader reader = new BufferedReader(new FileReader(lfName));
					    
					    //TextArea �ʱ�ȭ
					    txtMemo.setText("");
					    String line;
					    
					    //reader�� �ִ� ������ readLine���� �������� �о��
					    //TextArea�� �������� ����ϰ�
					    //�ڷᰡ ������ ����
					    while((line = reader.readLine()) != null) {     // �о�� ������ ���� ��������
					     leftcode.append(line + "\n");       // leftcode�� �߰�
					    }
					    reader.close();
					    
					    //���� ������ ���ϸ��� ���������ٿ� ǥ��
					    setTitle(dialog.getFile() + " - �޸���" );
				
				
				*/
				
				
			}
		});
		
		
		editBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//���� edit�� �� �ְ�
				
				String lefttxt = leftcode.getText();
				
				update(lefttxt);
								
			}
			
			private void update(String code) {
				
			}
		});
		
		
		saveBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//���� save �� �� �ְ�
				save.setDirectory(".");  // .�� ���� �� ������ ��ġ�ϴ� ����
				save.setVisible(true);
				
				/*
				//�����θ� �⺻���� ���
				   save.setDirectory(".");
				   save.setVisible(true);
				   
				   //��Ҹ� ������ ��������
				   // �̰ɻ��� ��Ҹ� �ص� �����̵�
				   if(dialog.getFile() == null) return;
				   
				   //�������� â�� ������ ��ο� ���ϳ����� dfName�� ����
				   String dfName = dialog.getDirectory() + dialog.getFile();  // ��θ� ���ϸ�
				   // System.out.println(dfName);
				   
				   
				   try {
				    //FileWriter�� ��θ�, ���ϸ��� �������
				    BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
				    //���۶����� ��ü�� ���� TextArea�� ������ ����
				    writer.write(txtMemo.getText());
				    writer.close();
				    
				    setTitle(dialog.getFile() + " - �޸���" );
				   } catch (Exception e2) {
				    JOptionPane.showMessageDialog(this, "���� ����");
				   }
				
				*/
				
				
				
			}
		});
		
		
		loadBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� load�ϴ� Ŭ������ ��ü ����
				
				load.setVisible(true);
				System.out.println("�������� : " + load.getDirectory());
				System.out.println("�������� : " + load.getFile());
				
				
				// txt ���ϸ� �о�ͼ� panel6��  textarea �� ���!
				
				
				
			}
		});
		
		
		editBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//���� edit�� �� �ְ�
				
				String lefttxt = leftcode.getText();
				
				update(lefttxt);
								
			}
			
			private void update(String code) {
				
			}
		});
		
		
		saveBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//���� save �� �� �ְ�
				
				save.setVisible(true);
			}
		});
		
		view.add(panel1);
		view.add(panel2);
		view.add(panel3);
		view.add(panel4);
		view.add(panel5);
		view.add(panel6);
		
		window.add(view);
		window.setVisible(true);

	}
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
