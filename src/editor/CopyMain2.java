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
	FileInputStream fis; //파일을 대상으로 한 입력스트림
	FileOutputStream fos; //파일을 대상으로 한 출력스트림
	
	//파일 탐색기를 처리하는 객체
	JFileChooser chooser;


	
	public CopyMain2() {
		bt_open=new JButton("원본경로");
		bt_save=new JButton("저장경로");
		
		
		t_open=new JTextField("C:/java_workspace2/project0323/res/white.gif",30);
		t_save=new JTextField("C:/java_workspace2/project0323/data",30);
		
		setLayout(new FlowLayout());
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);

		//버튼과 리스너와의 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);

		//파일 추저를 미리 올려놓자!!
		chooser=new JFileChooser();
		
		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //단점:프로세스를 죽이므로, 존재하는 스트림을 닫을 기회를 잃어버림.->윈도우리스너의 클로징 메서드 사용.
	}

	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource(); //이벤트 소스를 반환받는다!! 액션이벤트는 이미지, 버튼 등 범용되는 범위가 넓으므로 오브젝트 객체로 생성

		if(obj==bt_open){
			System.out.println("열기");
			open();
		}else if(obj==bt_save){
			System.out.println("복사");
			copy();
		}
		
	}

	//파일 열기!!
	public void open(){
		chooser.showOpenDialog(this);
		
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			t_open.setText(chooser.getSelectedFile().getPath());
			
		}
	
	}

	//복사하기!! ->저장하기 기능(열기에서 선택한 파일을 복사하여 텍스트필드에 붙이고 버튼을 누르면 저장 다이얼로그 열리도록)
	public void copy(){
		//원본 파일에 스트림 생성하여, 데이터를 들이마시자
		//들어오는 데이터를 목적 파일에 내려쓰자!!
		String oriPath=t_open.getText();
		String destPath=t_save.getText();

		try{
			fis=new FileInputStream(oriPath);
			fos=new FileOutputStream(destPath);

			int data=-1; //-1은 아무것도 읽지 않은 상태 ,초기값 안줘도 상관없다 어차피 read에서 초기화하므로
			while(true){
				data=fis.read(); //현재 실행중인 프로그램으로 1byte 읽어들임! 
				if(data==-1)break;
				fos.write(data); //데이터가 -1이므로 읽을 것이 없는 상황에서 쓸것도 없다
			
			}
			JOptionPane.showMessageDialog(this, "복사완료");

			//스트림을 닫자
		

		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");
			
			//try문 안에서 닫을 경우 문제점 ->보완하기 위해 finally사용
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO작업중 에러 발생했네요");
		}finally{
			try{
				//객체가 메모리에 올라왔다면..
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
