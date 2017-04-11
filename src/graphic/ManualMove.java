/*버튼을 누르면 공이 움직임*/
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
	int x,y; //0으로 초기화
	
	public ManualMove() {
		bt=new JButton("공 움직이기");
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
					
					//프레임을 접근하는 방법
					repaint(); //여기서 this는 panel이 아닌 내부익명을 지칭하므로 그냥 뺐다.
					test();
				}

		});
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void test(){
		System.out.println("test 호출");
		
	}
	
	public static void main(String[] args) {
		new ManualMove();
		
	}

}
