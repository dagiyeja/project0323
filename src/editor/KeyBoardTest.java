package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {

	public static void main(String[] args) {
		//System 클래스 final: 상속받지 않겠다. 그대로 쓰면됨 .인스턴스 만들지 X
		// InputStream -스트림 중 최상위 객체
		/*
		 * keyboard 는 개발자가 원할때 생성할 수 있는 스트림이 아니라,
		 * 이미 시스템에서 컴퓨터 켤 때, 미리 얻어놓기 때문에
		 * 개발자는 이미 존재하는 스트림을 얻어와 사용만 하면 된다!!
		 * 자바에서는 os로부터 스트림을 이미 얻어와서 System 클래스의 멤버변수인 in변수에 받아놓았다..
		 * 
		 * 자바는 하드웨어를 직접 제어하지 않고 
		 * 또한 하드웨어 자체는 현 시스템을 운영하는 OS가 제어하므로, 하드웨어에 대한
		 * 입력 스트림은 자바가 아닌 OS 이미 제어해놓고 있다.
		 * 따라서 자바 언어를 이용하여 키보드, 스캐너,, 등등의 입력하드웨어의 값을
		 * 얻기 위해서는 각 하드웨어에 알맞은 스트림 클래스가 지원되는 것이 아니라,
		 * 오직 표준 입력스트림인 InputStream을 쓰면 된다.
		 * */
		InputStream is=System.in; //윈도우에 의존적. 자바가 직접 제어하지 않음. 얻어오기만 하면 됨. 표준입력도구에 한해서
		
		int data;
		//원하는 블럭 설정 후 shift+alt+z 누르면 예외처리 쉽게 할 수 있음
		try {
			//read() 메서드는 사용자의 입력이 있을 때까지 블럭 상태에 빠진다!!
			//블럭상태란 대기상태를 말한다!!
			//read() 메서드는 무한루프 돌려도 안전하다. 입력 받고 다시 대기상태.
			while(true){
				data=is.read(); //1byte 읽기
				System.out.print((char)data); //char 형인 경우->문자데이터만 나오고, 줄바꿈과 엔터키에 대해서는 눈에 보이지 않으므로 찍히지 않음
				//out->모니터에 출력
				//표준 입출력 스트림: 개발자가 원할 때 올리는 것이 아님. 이미 존재함.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
