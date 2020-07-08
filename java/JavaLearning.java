import java.lang.ProcessBuilder.Redirect.Type;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.GregorianCalendar;
import java.lang.annotation.Annotation;

public class JavaLearning {

}

class JavaTesting1 {
    public static void main(String[] args) {
        System.out.println("testClass_1!");
    }

    // javac 编译java文件、
    // 运行 java程序。 --> java javaTesting_1
}

class JavaTesting2 {
    public static void main(String[] args) {
        System.out.println("testClass_2!");
    }
}

// 枚举类型，在一个类中，定义一个事先定义好的值列表。
class FreshJuice {
    enum FreshJuiceSize {
        SMALL, MEDIUM, LARGE // 变量？字符串？字符串常量？
    }

    FreshJuiceSize size;
}

class FreshJuiceTest {
    public static void main(String[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        System.out.print(juice.size);
    }
}

// 内置数据类型的包装类和Math类提供的数学方法。
class MathTest {
    public static void main(String[] args) {
        System.out.print(Math.max(1, 2));
        Integer a = 123;
        System.out.print(a.max(1, 3) + "\n");
        System.out.print(Integer.max(1, 4) + "\n");
        System.out.print(Math.random() * 100 + "\n");
        System.out.print(a.doubleValue() + "\n");
        System.out.print(a.intValue() + "\n");
        int b = 234;
        System.out.print(Integer.max(a.intValue(), b) + "\n");
    }
}

class StringTest {

    public static void main(String[] args) {
        String a = "hello world!";
        String b = new String("hello world!");
        System.out.print(a == b);
        System.out.print("\n");
        int c = 1;
        long d = 1;
        System.out.print(c == d);
        System.out.print("\n");
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2 + "\n");
        System.out.println(s1.equals(s2) + "\n");
    }
}

class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("123");
        a.append("123");
    }

    @Deprecated
    public void printStringBuffer() {
        StringBuffer a = new StringBuffer("123");
        a.append("123");
        System.out.println(a);
    }
}

class annotationTest {

    public static void main(String[] args) {
        StringBufferTest a = new StringBufferTest();
        a.printStringBuffer();

    }
}

@Target(value = { ElementType.METHOD, ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@interface Hello {
    String value();
}

class annotationTest2 {
    @Hello("123")
    public static void main(String[] args) {
        try {
            // この方法だけで案のテーションを取得するか？
            Class cls = annotationTest2.class;
            Method method = cls.getMethod("main", String[].class);
            Hello hello = method.getAnnotation(Hello.class);

            System.out.println(hello.toString());
            System.out.println(hello.hashCode());
            System.out.println(hello.annotationType());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
