package net.zerotodev.api.designPatterns;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class IteratorPattern {
    @Test @DisplayName("Iterator Pattern Example")
    void main(){
        MyArrayList list = new MyArrayList(new Object[]{1,3,5,7,9});
        list.forEach(System.out::println);
    }
    class MyArrayList{
        Object[] elements = new Object[5];

        public MyArrayList(Object[] elements) {
            this.elements = elements;
        }
        public void forEach(Consumer<Object> action){
            for(int i = 0; i <elements.length; i++){
                action.accept(elements[i]);
            }
        }
    }
}
