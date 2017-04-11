package editor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.JFileChooser;


public class CopyMain2 extends JFrame implements ActionListener{
	JButton bt_open, bt_save,bt_copy;
	JTextField t_open, t_save;
	FileInputStream fis; //������ ������� �� �Է½�Ʈ��
	FileOutputStream fos; //������ ������� �� ��½�Ʈ��
	
	//���� Ž���⸦ ó���ϴ� ��ü
	JFileChooser chooser;


	
	public CopyMain2() {
		bt_open=new JButton("�������");
		bt_save=new JButton("������");
		
		
		t_open=new JTextField("C:/java_workspace2/project0323/res/white.gif",30);
		t_save=new JTextField("C:/java_workspace2/project0323/data",30);
		
		setLayout(new FlowLayout());
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);

		//��ư�� �����ʿ��� ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);

		//���� ������ �̸� �÷�����!!
		chooser=new JFileChooser();
		
		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //����:���μ����� ���̹Ƿ�, �����ϴ� ��Ʈ���� ���� ��ȸ�� �Ҿ����.->�����츮������ Ŭ��¡ �޼��� ���.
	}

	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource(); //�̺�Ʈ �ҽ��� ��ȯ�޴´�!! �׼��̺�Ʈ�� �̹���, ��ư �� ����Ǵ� ������ �����Ƿ� ������Ʈ ��ü�� ����

		if(obj==bt_open){
			System.out.println("����");
			open();
		}else if(obj==bt_save){
			System.out.println("����");
			copy();
		}
		
	}

	//���� ����!!
	public void open(){
		chooser.showOpenDialog(this);
		
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			t_open.setText(chooser.getSelectedFile().getPath());
			
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
		new CopyMain2();
	}

}
