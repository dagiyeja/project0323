package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PhotoGallery extends JFrame implements ActionListener{
	JLabel url;
	Canvas can;
	JPanel p_south;
	JButton bt_back, bt_next;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	String[] path={
			"C:/html_workspace/images/p1.jpg",
			"C:/html_workspace/images/p2.jpg",
			"C:/html_workspace/images/p3.jpg",
			"C:/html_workspace/images/p4.jpg",
			"C:/html_workspace/images/p5.jpg",
			"C:/html_workspace/images/p6.jpg",
			"C:/html_workspace/images/p7.jpg",
			"C:/html_workspace/images/p8.jpg",
			"C:/html_workspace/images/p9.jpg",
	};
	
	int count=0; //�迭�� index ->�Ŀ� ���� ���� ���� �����Ҷ� �����ϱ� ������ ����
	
	public PhotoGallery() {
		
		//���ʿ� ù��° �̹��� ������
		url=new JLabel(path[count]);
		img=kit.getImage(path[count]); 
		
		//Canvas�� �ڽ�. �������� ���⼭ �������̵� ����!
		//���� �͸� Ŭ����
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0	,600, 600, this); //->this:Canvas�� �̹����� �Ȱ�����
				System.out.println("paint ȣ��!!");
			}
		};
	
		can.setBackground(Color.GRAY);
		p_south=new JPanel();
		bt_back=new JButton("��������");
		bt_next=new JButton("��������");
		
		add(url,BorderLayout.NORTH);
		add(can,BorderLayout.CENTER);
		p_south.add(bt_back);
		p_south.add(bt_next);
		add(p_south,BorderLayout.SOUTH);
		
		//��ư���� ����!!
		bt_back.addActionListener(this);
		bt_next.addActionListener(this);
		
		
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		//���â�� ���� ��
		//JOptionPane.showMessageDialog(this, "�� ������?");
		
		//ActionEvent�� Ŭ���Ӹ� �ƴ϶�, ���� ������ �ƿ츣�� �̺�Ʈ ��ü�̴�. 
		//���� ��ư�� ActionEvent�� ����Ű�� �� �ƴϴ�.
		//e.getSource()ȣ���ϸ�, � ������Ʈ�� �̺�Ʈ�� �����״��� ������ �� �����Ƿ�
		//Object������ ��ȯ���ش�!!
		Object obj=e.getSource(); //�̺�Ʈ�� ����Ų ������Ʈ(���⼭�� ��ư�� ����Ŵ)
		
		JButton btn=(JButton)obj;
		
		if(btn == bt_back){ //�ּҰ��� �����̶��..
			//JOptionPane.showMessageDialog(this,"����"); //parent ���� this(���� Ŭ�������� ������ JFrame) 
			prev();
		}else if(btn==bt_next){
			//JOptionPane.showMessageDialog(this,"����");
			next();
		}
	}
	
	//���� ���� �����ֱ�!!
	public void prev(){
		count++;
		img=kit.getImage(path[count]); 
		
		can.repaint();
		//���� ������ ������!
		url.setText(path[count]);
	}
	
	//���� ���� �����ֱ�!!
	public void next(){
		//�̹����� ��� ����!! + ���� ���� ����
		count++;
		img=kit.getImage(path[count]); 
		
		//�����ڴ� paint�޼��带 ȣ���� �� ���� ->�ý����� �ٽ� �׸� ������ �Ǵ��ؾ� �ϱ� ������.
		//paint�� ���� ȣ��ǳ�??
		//user�� �ش� ������Ʈ�� ������ ���Ҷ� ������ ȣ��ȴ�!!
		//���� ��ư�� ������ �Ǹ�, ĵ������ ������ ���� ���� ���� ������ paint�޼���� ȣ����� �ʴ´�..
		//�ذ�å)ĵ������ paint�޼��带 ���� ȣ���ؾ� ������, ȣ��Ұ��̹Ƿ�
		//���� ȣ�� �ؾ� �Ѵ�..
		//�ý������� paint�� ȣ���� �޶�� ��û�ؾ��Ѵ�. repaint() --> update() --> paint()
		//update�޼���� ���� ȭ���� �������
		//paint() �޼��尡 �׸��� �ٽ� �׸���..
		//���� �̹��� �뷮�� ū ��쿣 �츮 ����
		//�����Ÿ��� ȿ���� ���� ���̴�!!
		can.repaint();
		//���� ������ ������!
		url.setText(path[count]);
		
	}
	
	
	
	public static void main(String[] args) {
		new PhotoGallery();
	}
}
	
