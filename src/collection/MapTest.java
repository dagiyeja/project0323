/*
 * 컬렉션 프레임웍 중 순서없는 객체들을 
 * key-value 쌍으로 관리하는 Map을 학습한다	
*/
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("eowyn38","한예지");
		map.put("han4441","한지연");
		map.put("lohan","반지의제왕");
		
		Set<String> set=map.keySet(); //set으로 변신 
		Iterator<String> it=set.iterator();
		
		//모든 객체 출력
		while(it.hasNext()){
			String id=it.next(); //key값으로 객체 탐색
			String value=map.get(id);
			System.out.println(value);
		}
	}
}
