/*
 * 1.스트림의 방향성에 따른 분류
 * -입력, 출력
 * 
 * 2.스트림의 데이터 처리방법에 따른 분류
 * 	(1)바이트 기반 스트림 ->근본적인 부분
 * 		-입출력시 1byte씩 처리 
 * 		
 * 	(2)문자 기반 스트림
 * 		-입출력시 2byte씩 묶어서 이해할 수 있는 스트림
 * 		주의!! 2byte씩 읽거나, 쓰는게 아니다!!
 * 		문자기반스트림의 명명규칙
 * 		입력스트림 - ~~Reader 끝남
 * 		출력스트림 - ~~~Writer 끝남
 * 
 * (3)버퍼 스트림
 * */

package editor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		/*System.in -표준 입력 System.out -표준 출력*/
		
		//스트림 얻기!!
		InputStream is=System.in; 
		InputStreamReader reader=null;
		reader=new InputStreamReader(is); //->바이트 기반이 기본 겉에 문자 기반 스트림 덧씌움. 바깥쪽꺼 사용
		 
		int data;
		try {
			//while(true){
			data=reader.read(); //1byte
			System.out.print((char)data); //ln이 줄바꿈 표현만 안될뿐. ln빼면 나옴 
			//}
			} catch (IOException e) {
			
			e.printStackTrace();
		} 

	}

}
