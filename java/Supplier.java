package jp.mynavi.api.controller;

import static org.mockito.ArgumentMatchers.startsWith;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

class Car {
    // Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}

class test {
    public static void main(String[] args) throws java.lang.Exception {
        List<String> testList = Arrays.asList("java","python","php","javascript","c++");
		
	    for(String a : testList){
            boolean takeIf = a.startsWith("j");
	        (takeIf) -> System.out::println(takeIf);
	    }
    }

    // public static void testMethod(List lNames,Predicate condition){
    // for(String lName : lNames){
    // condition.test(lname);
    // }
    // }
}