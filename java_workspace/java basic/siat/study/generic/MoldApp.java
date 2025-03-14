package siat.study.generic;

import lombok.val;

public class MoldApp<T> {    // 외부에서 객체를 생성할 때 타입을 지정해야 함

    private T value ;
    public void setValue(T value) {
        this.value = value ;

    }
    public T getValue() {
        return value ;
        
    }
    
}
