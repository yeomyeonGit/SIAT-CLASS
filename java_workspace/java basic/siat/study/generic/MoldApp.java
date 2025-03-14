package siat.study.generic;

import lombok.val;

public class MoldApp<T> {    // 외부에서 객체를 생성할 때 타입을 지정해야 함

    private T value ;   // 외부에서 타입을 임의로 설정할 수 있는 것이 바로 Generic - T: 타입의 제너릭
    

    // 메서드를 호출하면서 매개변수를 넣으면 value에 값이 할당되는 코드: set
    public void setValue(T value) {
        this.value = value ;
    }
    

    // 메서드를 호출하면 set에서 설정한 value 값을 반환하는 코드: get
    public T getValue() {
        return value ;
    }


    
}
