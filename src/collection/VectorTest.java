/*
 * 컬렉션 프레임웍의 api객체 중 List계열의 하위 객체인 Vector를 학습해보자!!
 * 
 * 참고)List 계열은 사실 우리가 흔히 써왔던 배열과 거의 같다.
 * 
 * 				배열							List
 * 크기:	반드시 명시					선택사항		
	대상: 자바기본자료형 +객체형		오직 객체형
	
 * */

package collection;

import java.util.Vector;

import javax.swing.JButton;

public class VectorTest {

	public static void main(String[] args) {
		//컬렉션 프레임웍 객체에 Generic Type을 명시하면,
		//객체가 섞이는 것을 컴파일 타임에 방지해준다!!
		//전용 자료형이 정해지기 때문에 형변환을 할 필요가 없다!
		
		Vector<String> v=new Vector<String>(); //자료형: Ventor<String> ->String전용 벡터
		
		v.add("사과"); //->Constant Pool에 만들어짐
		v.add("딸기");
		v.add("바나나");
		v.add("오렌지");
		
		for(int i=0; i<v.size(); i++){
			String obj=v.get(i); //형변환을 할 필요가 없기 때문에 (String)v.get(i)와 같은 방식으로 쓰지 않음
			
		}
		
		//Object obj=(String)v.get(2); //fm 방식
		//System.out.println(obj);
	}

}
