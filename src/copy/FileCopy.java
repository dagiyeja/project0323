/*
특정 디렉토리안의 파일을 원하는 위치로 복사해본다!!

스트림이란? (Stream)
-흐름을 뜻한다..
현실에서의 스트림은 그 대상이 물이지만, 
전산에서의 스트림의 대상은 데이터이다!
결국 데이터가 흐르는 모습을 가리켜 스트림이라 한다.

2.종류
(1)방향에 따른 구분
입력:실행중인 프로그램으로 데이터가 들어가는 스트림 ex)입력도구-키보드, 바코드스캐너..
출력:실행중인 프로그램에서 데이터가 나오는 스트림 ex)프린터, 모니터..
-----------------------------------------------------------------------
자바코드를 작성후 컴파일했을때, 문법에 문제가 없다고 하여 그 프로그램은 언제나 정상 수행을 보장해주진 않는다..
예)파일의 경로를 잘못 적은 경우(문법상의 문제가 아닌 데이터의 문제)
컴파일러가 감지하지 못함-컴파일은 제대로 되었으나, 실행시 에러발생해서 비정상 종료
예)방금전까지는 파일이 존재해서 제대로 프로그램이 수행되었는데, 누군가가 파일을 지워버린 경우
(프로그램으로 감당할 수 없는 외부요인..)->실행 시 에러발생해서 비정상 종료
*/
package copy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

class FileCopy extends JFrame{ 
	FileInputStream fis;
	String ori="C:/java_workspace2/project0323/res/white.gif";

	public FileCopy(){
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		try{ //이 코드는 무조건 실행부에 의해 시도됨.
			//sun에서는 try문에서 에러가 발생한 경우
			//프로그램을 비정상 종료 시키지 않기 위해
			//실행부가 catch문으로 진입하게 하여
			//정상수행을 할 수 있는 기회를 준다..
			fis=new FileInputStream(ori);

			//만일 이 try문 안에서 파일을 찾을 수 없는 에러가
			//발생할 경우, sun에서는 FileNotFoundException 객체를
			//메모리에 올리고, 이 인스턴스를 개발자에게 전달해준다!
			//왜?? 그래야 개발자가 에러 정보를 이용하여 사용자에게 알맞은 메세지를 보여줄 수 있다.
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this,"파일을 찾을 수 없습니다.");
		}


	}

	public static void main(String[] args){
		new FileCopy();
	}
}
	

