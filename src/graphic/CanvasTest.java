/*
 * �׸� �׷��� �������� �����Ǵ� ��ü�� 
 * Canvas �� �׸��� �׷�����!!
 * �� ĵ������ �׷��� �ϳ�?
 * ĵ������ �����̳�ó�� �ƹ��͵� ���� ����..
 *�� ��ȭ���� ǥ���� ��ü�̹Ƿ�..
 * */
package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can; //�� �� ��ȭ��
	Toolkit kit; //javaSE���� �̹����� �������� ��Ŷ ��ü�� �̿��ؾ� �Ѵ�(Sun �簡)
	Image img; //�߻�Ŭ������ new����
	
	public CanvasTest() {
		kit=Toolkit.getDefaultToolkit(); //�ν��Ͻ� ���
		img=kit.getImage("C:/html_workspace/images/mario.png"); //�������ô� �����츸 ��
		
		//Canvas�� �ڽ�. �������� ���⼭ �������̵� ����!
		//���� �͸� Ŭ����
		can=new Canvas(){
			//paint �޼���� ��ǻ� ������ �Ұ��ϸ�
			//� �׸��� �׸����� �����ϴ� ��ü�� 
			//Graphics ��ü�̴�!!
			public void paint(Graphics g) {
				//g.drawLine(0, 0, 300, 400);
				//g.drawOval(300, 300, 100, 100);
				//g.drawRect(100, 200, 300, 300);
				g.drawImage(img, 0, 0	,100, 100, this); //->this:Canvas
			}
			
		};
		//this->CanvasTest
		can.setBackground(Color.yellow);
		add(can);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasTest();

	}

}
