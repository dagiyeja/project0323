/*��ư�� ������ ���� ������*/
package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManualMove extends JFrame{
	JPanel p;
	JButton bt;
	int x,y; //0���� �ʱ�ȭ
	
	public ManualMove() {
		bt=new JButton("�� �����̱�");
		p=new JPanel(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		p.setBackground(Color.YELLOW);
		
		add(bt,BorderLayout.NORTH);
		add(p);
		
		bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					x+=10;
					y+=10;
					
					//�������� �����ϴ� ���
					repaint(); //���⼭ this�� panel�� �ƴ� �����͸��� ��Ī�ϹǷ� �׳� ����.
					test();
				}

		});
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void test(){
		System.out.println("test ȣ��");
		
	}
	
	public static void main(String[] args) {
		new ManualMove();
		
	}

}
