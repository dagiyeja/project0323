/*
 * �÷��� �����ӿ��� api��ü �� List�迭�� ���� ��ü�� Vector�� �н��غ���!!
 * 
 * ����)List �迭�� ��� �츮�� ���� ��Դ� �迭�� ���� ����.
 * 
 * 				�迭							List
 * ũ��:	�ݵ�� ���					���û���		
	���: �ڹٱ⺻�ڷ��� +��ü��		���� ��ü��
	
 * */

package collection;

import java.util.Vector;

import javax.swing.JButton;

public class VectorTest {

	public static void main(String[] args) {
		//�÷��� �����ӿ� ��ü�� Generic Type�� ����ϸ�,
		//��ü�� ���̴� ���� ������ Ÿ�ӿ� �������ش�!!
		//���� �ڷ����� �������� ������ ����ȯ�� �� �ʿ䰡 ����!
		
		Vector<String> v=new Vector<String>(); //�ڷ���: Ventor<String> ->String���� ����
		
		v.add("���"); //->Constant Pool�� �������
		v.add("����");
		v.add("�ٳ���");
		v.add("������");
		
		for(int i=0; i<v.size(); i++){
			String obj=v.get(i); //����ȯ�� �� �ʿ䰡 ���� ������ (String)v.get(i)�� ���� ������� ���� ����
			
		}
		
		//Object obj=(String)v.get(2); //fm ���
		//System.out.println(obj);
	}

}
