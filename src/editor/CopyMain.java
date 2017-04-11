package editor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CopyMain extends JFrame implements ActionListener{
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	FileInputStream fis; //������ ������� �� �Է½�Ʈ��
	FileOutputStream fos; //������ ������� �� ��½�Ʈ��
	
	//���� Ž���⸦ ó���ϴ� ��ü
	JFileChooser chooser;


	
	public CopyMain() {
		bt_open=new JButton("�������");
		bt_save=new JButton("������");
		bt_copy=new JButton("�������");
		
		t_open=new JTextField(30);
		t_save=new JTextField(30);
		
		setLayout(new FlowLayout());
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);

		//��ư�� �����ʿ��� ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		//���� ������ �̸� �÷�����!!
		//����Ʈ ���丮�� �����ϸ� ���ϴ�..
		chooser=new JFileChooser("C:/java_workspace2/project0323");
		
		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //����:���μ����� ���̹Ƿ�, �����ϴ� ��Ʈ���� ���� ��ȸ�� �Ҿ����.->�����츮������ Ŭ��¡ �޼��� ���.
	}

	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource(); //�̺�Ʈ �ҽ��� ��ȯ�޴´�!! �׼��̺�Ʈ�� �̹���, ��ư �� ����Ǵ� ������ �����Ƿ� ������Ʈ ��ü�� ����

		if(obj==bt_open){
			
			open(); //ctrlŰ ������ �ش� �޼��� ������ �̵�
		}else if(obj==bt_save){
			int state=chooser.showSaveDialog(this);
			System.out.println(state);  //������ 0, ��Ҵ� 1����->�ϱ��ؼ� ���� �ͺ��� ��� ���� ���� ����.
			//����� �ΰ����� �������� �ο����ش�
			//��? ����ܾ �̿��ϴϱ�..
			if(state==JFileChooser.APPROVE_OPTION){
				//���� ��θ� �ؽ�Ʈ �ʵ忡 ���!!
				File file=chooser.getSelectedFile(); //���� ó�� ���� ��ü���� ������ ��! ���⼭�� File . ->File�̶�� Ŭ���� �޾ƿ�
				
				//����Ŭ������ ������ ������ �޼��带 �̿��Ͽ� ��� ��ȯ
				String path=file.getAbsolutePath();
				
				t_save.setText(path);
			}
			
		}else if(obj==bt_copy){
			
			copy();
		}
	}

	//���� ����!!
	public void open(){
		chooser.showOpenDialog(this);
		
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION) {
			//������ ������ ���Ͽ� ���� ���� Ŭ����
			//�ν��Ͻ� ���!!
			File file=chooser.getSelectedFile();
			
			//����� �ν��Ͻ��� �̿��Ͽ� ������ ���
			String path=file.getAbsolutePath();
			
			//���� ��� �ؽ�Ʈ �ʵ忡 ����ϱ�
			t_open.setText(path);
			
		}
	
	}

	//�����ϱ�!! ->�����ϱ� ���(���⿡�� ������ ������ �����Ͽ� �ؽ�Ʈ�ʵ忡 ���̰� ��ư�� ������ ���� ���̾�α� ��������)
	public void copy(){
		//���� ���Ͽ� ��Ʈ�� �����Ͽ�, �����͸� ���̸�����
		//������ �����͸� ���� ���Ͽ� ��������!!
		String oriPath=t_open.getText();
		String destPath=t_save.getText();

		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(destPath);

			int data=-1; //-1�� �ƹ��͵� ���� ���� ���� ,�ʱⰪ ���൵ ������� ������ read���� �ʱ�ȭ�ϹǷ�
			while(true){
				data=fis.read(); //���� �������� ���α׷����� 1byte �о����! 
				if(data==-1)break;
				fos.write(data); //�����Ͱ� -1�̹Ƿ� ���� ���� ���� ��Ȳ���� ���͵� ����
			
			}
			JOptionPane.showMessageDialog(this, "����Ϸ�");

			//��Ʈ���� ����
		

		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�.");
			
			//try�� �ȿ��� ���� ��� ������ ->�����ϱ� ���� finally���
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO�۾��� ���� �߻��߳׿�");
		}finally{
			try{
				//��ü�� �޸𸮿� �ö�Դٸ�..
				if(fis!=null){
					fis.close();
				}if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
			
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CopyMain();
	}

}
