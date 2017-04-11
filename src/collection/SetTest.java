/*
 * 컬렉션 프레임웍의 유형 2가지 중
 * 순서없는 객체들의 집합인 Set 유형을 알아보자
 * */
package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		
		//Set 자식들중 TreeSet을 사용해본다
		TreeSet<String> set=new TreeSet<String>();
		
		set.add("사과");
		set.add("딸기");
		set.add("오렌지");
		
		//컬렉션 프레임웍의 객체 중 순서없는 객체를 
		//사용하다 보면, 대량의 처리 시 반복문을 직접 사용할 수 없다는 어려움에 부딪힌다.
		//해결책)순서없는것을 -->순서있게 만들자
		//		   Enumertation,  Iterator
		
		//반복문에는 for, while 문이 있다
		//for문은 시작과 끝값을 수치로 알고 있을때 유용하다 1~256
		//while문은 소괄호 안이 true인 동안 동작
		/*
		 * while(true){
		 * 		i++;
		 * 		if(i>=256){
		 * 			break;
		 * 		}
		 * } 
		 * ->이 경우엔 좋지 않음
		 * */
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()){
			String e1=it.next(); //다음 요소에 접근!!
			System.out.println(e1);
		}
		
		Iterator<String> it2=set.iterator();
		while(it.hasNext()){
			String e2=it2.next(); //다음 요소에 접근!!
			System.out.println(e2);
		}
	}

}
