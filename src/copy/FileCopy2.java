/*
���� ó���� ����
-������ ������ ����(�� �������� �ý��� ��� �������� ��)

�Ϲ������� ���α׷��� ���� ����� �� ���� ��Ȳ�� ������ 
"����"��� ��

sun������ ������ ���� �з���. ->Ŭ������ ����

1.���α׷��Ӱ� ��ó�� �� ���� �Ұ��׷��� ����
	Error 
2.���α׷��Ӱ� ��ó�� �� �ִ� ����(����)
	�ڹ��� ���� ������ �ٷ� "����"�̴�
	sun������ �� ���ܸ� ��Ȳ�� ���� ü������ Ŭ������ �����ϰ� �ִ�.

�� ���� ��ü���� �ٽ� ũ�� 2���� �������� �з�
(1)������ Ÿ�ӿ� ����ó���� �����ϴ� ���
	checked Exception

(2)������ Ÿ�ӿ� ����ó���� �������� �ʴ� ���
	Unchecked Exception =Runtime Exception

*/
package copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileCopy2{
	FileInputStream fis; //���� ��������� �Է� ��Ʈ��
	FileOutputStream fos; //���� ��������� ��� ��Ʈ��
	
	public FileCopy2(){
		//�Ʒ��� �ڵ�� ����, ������ �߻��� �� �ִ� ���ɼ��� �ٺ��ϴ�..
		//����, �����ڰ� ������ �� �ۼ��������� �ұ��ϰ�, Ư����
		//������ġ�� �����ϱ⸦ �����Ѵ�!!
		try{
			fis=new FileInputStream("C:/Java_workspace2/project0323/res/white.gif");
				//System.out.println("������ ��Ʈ�� �����߾��");
			fos=new FileOutputStream("C:/Java_workspace2/project0323/data/white.gif");
				//��Ʈ���� �� ������ �����, �������� ��ο�, ���ϸ� ����
			int data;
			while(true){ 
				data=fis.read(); //1byte �� ����!!
				//FileCopy2.java:44: error: unreported exception IOException; must be caught or declared to be thrown
				//����� �� ���ܰ� �߻��� �� �ִ�.. catch �� �ϳ� ���߰�����!!
				fos.write(data); //1byte �� ����!! //�а� �� ������ ��Ʈ���� �ѹ����� �����Ǿ�� �Ѵ� // �׷��������� �޸��� ������ �߻�!!
				//�о���� �����͸� ������!!
				if(data==-1)break;
				System.out.println(data);
			}
			
		}catch(FileNotFoundException e){//������ �߻��ϸ� ����ΰ� �̿������� ���Եȴ�!!
			//catch ���� �����ϰ� �Ǹ�, ���α׷��� ������ ���� ���� �ʴ´�!!
			//����ڿ��� �ȳ��ϴ� �뵵�� catch���� ����ϰ� �ȴ�..
			System.out.println("������ ã�� �� �����ϴ�");
			//catch ���� ���ٴ� ���������� �ȴ�..
			//����ó���� ������ ���Դϱ�? ������������ ����!!(�ڡ�)
		
		}catch(IOException e){
			System.out.println("������ ���� �� �����ϴ�");
		}finally{
			//finally �� �����ϸ�, 
			//try���� �����ϵ�, catch ���� �����ϵ�
			//����ΰ� ������ �� ������ ��ġ�� �Ǿ��ִ�..
			//�׷��Ƿ�, ������ ���� �ڵ�� ���� �����..
			//finally �ڵ��� ������
			/*
			�ַ� database ������ ��Ʈ�� ��� ��
			�������θ� ������ ������ �ڿ��� �ݰų�,
			������ �Ϸ��� try���̵��� catch ���̵��� �������
			������ ���İ��� �� �ڵ念���� �α� �����̴�..
			*/
			try{
				if(fis!=null){fis.close();}
				//fis �� ������������� ,close �ȵǰ�
				//fis �� ��Ʈ���� ��������ڴ� - ��Ʈ�� ��������!! //���ܻ��� �ٽ� �߻�!!	
			
			}catch(IOException e){
				
			}//fis.close() ����
			try{	

				if(fos!=null){fos.close();};//fos �� ��Ʈ���� ���������..

			}catch(IOException e){
			
			}

		}

	}
	
	public static void main(String[] args){
		new FileCopy2();
	}

}