/*
 * �÷��� �����ӿ� �� �������� ��ü���� 
 * key-value ������ �����ϴ� Map�� �н��Ѵ�	
*/
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("eowyn38","�ѿ���");
		map.put("han4441","������");
		map.put("lohan","����������");
		
		Set<String> set=map.keySet(); //set���� ���� 
		Iterator<String> it=set.iterator();
		
		//��� ��ü ���
		while(it.hasNext()){
			String id=it.next(); //key������ ��ü Ž��
			String value=map.get(id);
			System.out.println(value);
		}
	}
}
