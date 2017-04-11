/*
 * 그림 그려질 목적으로 지원되는 객체인 
 * Canvas 에 그림을 그려보자!!
 * 왜 캔버스에 그려야 하나?
 * 캔버스는 컨테이너처럼 아무것도 없기 때문..
 *빈 도화지를 표현한 객체이므로..
 * */
package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can; //텅 빈 도화지
	Toolkit kit; //javaSE에서 이미지를 얻으려면 툴킷 객체를 이용해야 한다(Sun 사가)
	Image img; //추상클래스라서 new못함
	
	public CanvasTest() {
		kit=Toolkit.getDefaultToolkit(); //인스턴스 얻기
		img=kit.getImage("C:/html_workspace/images/mario.png"); //역슬래시는 윈도우만 씀
		
		//Canvas의 자식. 귀찮으면 여기서 오버라이드 하자!
		//내부 익명 클래스
		can=new Canvas(){
			//paint 메서드는 사실상 행위에 불과하며
			//어떤 그림을 그릴지를 결정하는 객체는 
			//Graphics 객체이다!!
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
