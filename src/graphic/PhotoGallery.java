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
	
	int count=0; //배열의 index ->후에 먼저 나올 사진 설정할때 수정하기 쉽도록 설정
	
	public PhotoGallery() {
		
		//최초에 첫번째 이미지 보여줌
		url=new JLabel(path[count]);
		img=kit.getImage(path[count]); 
		
		//Canvas의 자식. 귀찮으면 여기서 오버라이드 하자!
		//내부 익명 클래스
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0	,600, 600, this); //->this:Canvas가 이미지를 안고있음
				System.out.println("paint 호출!!");
			}
		};
	
		can.setBackground(Color.GRAY);
		p_south=new JPanel();
		bt_back=new JButton("이전사진");
		bt_next=new JButton("다음사진");
		
		add(url,BorderLayout.NORTH);
		add(can,BorderLayout.CENTER);
		p_south.add(bt_back);
		p_south.add(bt_next);
		add(p_south,BorderLayout.SOUTH);
		
		//버튼마다 연결!!
		bt_back.addActionListener(this);
		bt_next.addActionListener(this);
		
		
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		//경고창을 띄우는 법
		//JOptionPane.showMessageDialog(this, "나 눌렀어?");
		
		//ActionEvent는 클릭뿐만 아니라, 여러 행위를 아우르는 이벤트 객체이다. 
		//따라서 버튼만 ActionEvent를 일으키는 게 아니다.
		//e.getSource()호출하면, 어떤 컴포넌트가 이벤트를 일으켰는지 예측할 수 없으므로
		//Object형으로 반환해준다!!
		Object obj=e.getSource(); //이벤트를 일으킨 컴포넌트(여기서는 버튼을 가리킴)
		
		JButton btn=(JButton)obj;
		
		if(btn == bt_back){ //주소값이 왼쪽이라면..
			//JOptionPane.showMessageDialog(this,"이전"); //parent 값에 this(지금 클래스에서 생성한 JFrame) 
			prev();
		}else if(btn==bt_next){
			//JOptionPane.showMessageDialog(this,"다음");
			next();
		}
	}
	
	//이전 사진 보여주기!!
	public void prev(){
		count++;
		img=kit.getImage(path[count]); 
		
		can.repaint();
		//라벨의 변경을 가하자!
		url.setText(path[count]);
	}
	
	//다음 사진 보여주기!!
	public void next(){
		//이미지의 경로 변경!! + 라벨의 값도 변경
		count++;
		img=kit.getImage(path[count]); 
		
		//개발자는 paint메서드를 호출할 수 없다 ->시스템이 다시 그릴 시점을 판단해야 하기 때문에.
		//paint는 언제 호출되나??
		//user가 해당 컴포넌트의 변경을 가할때 스스로 호출된다!!
		//따라서 버튼을 누르게 되면, 캔버스의 변경을 가한 적이 없기 때문에 paint메서드는 호출되지 않는다..
		//해결책)캔버스의 paint메서드를 강제 호출해야 하지만, 호출불가이므로
		//간접 호출 해야 한다..
		//시스템한테 paint를 호출해 달라고 요청해야한다. repaint() --> update() --> paint()
		//update메서드는 기존 화면을 싹지운다
		//paint() 메서드가 그림을 다시 그린다..
		//따라서 이미지 용량이 큰 경우엔 우리 눈엔
		//깜빡거리는 효과가 나는 것이다!!
		can.repaint();
		//라벨의 변경을 가하자!
		url.setText(path[count]);
		
	}
	
	
	
	public static void main(String[] args) {
		new PhotoGallery();
	}
}
	
