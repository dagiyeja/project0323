/*
 * 1.��Ʈ���� ���⼺�� ���� �з�
 * -�Է�, ���
 * 
 * 2.��Ʈ���� ������ ó������� ���� �з�
 * 	(1)����Ʈ ��� ��Ʈ�� ->�ٺ����� �κ�
 * 		-����½� 1byte�� ó�� 
 * 		
 * 	(2)���� ��� ��Ʈ��
 * 		-����½� 2byte�� ��� ������ �� �ִ� ��Ʈ��
 * 		����!! 2byte�� �аų�, ���°� �ƴϴ�!!
 * 		���ڱ�ݽ�Ʈ���� ����Ģ
 * 		�Է½�Ʈ�� - ~~Reader ����
 * 		��½�Ʈ�� - ~~~Writer ����
 * 
 * (3)���� ��Ʈ��
 * */

package editor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		/*System.in -ǥ�� �Է� System.out -ǥ�� ���*/
		
		//��Ʈ�� ���!!
		InputStream is=System.in; 
		InputStreamReader reader=null;
		reader=new InputStreamReader(is); //->����Ʈ ����� �⺻ �ѿ� ���� ��� ��Ʈ�� ������. �ٱ��ʲ� ���
		 
		int data;
		try {
			//while(true){
			data=reader.read(); //1byte
			System.out.print((char)data); //ln�� �ٹٲ� ǥ���� �ȵɻ�. ln���� ���� 
			//}
			} catch (IOException e) {
			
			e.printStackTrace();
		} 

	}

}
