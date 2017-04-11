/*
 * �÷��� �����ӿ��� ���� 2���� ��
 * �������� ��ü���� ������ Set ������ �˾ƺ���
 * */
package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		
		//Set �ڽĵ��� TreeSet�� ����غ���
		TreeSet<String> set=new TreeSet<String>();
		
		set.add("���");
		set.add("����");
		set.add("������");
		
		//�÷��� �����ӿ��� ��ü �� �������� ��ü�� 
		//����ϴ� ����, �뷮�� ó�� �� �ݺ����� ���� ����� �� ���ٴ� ����� �ε�����.
		//�ذ�å)�������°��� -->�����ְ� ������
		//		   Enumertation,  Iterator
		
		//�ݺ������� for, while ���� �ִ�
		//for���� ���۰� ������ ��ġ�� �˰� ������ �����ϴ� 1~256
		//while���� �Ұ�ȣ ���� true�� ���� ����
		/*
		 * while(true){
		 * 		i++;
		 * 		if(i>=256){
		 * 			break;
		 * 		}
		 * } 
		 * ->�� ��쿣 ���� ����
		 * */
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()){
			String e1=it.next(); //���� ��ҿ� ����!!
			System.out.println(e1);
		}
		
		Iterator<String> it2=set.iterator();
		while(it.hasNext()){
			String e2=it2.next(); //���� ��ҿ� ����!!
			System.out.println(e2);
		}
	}

}
