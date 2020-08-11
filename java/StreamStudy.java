import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Student {
    int no;
    String name;
    String sex;
    float height;

    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public float getHeight() {
        return height;
    }

    public int getNo() {
        return no;
    }

    public String getSex() {
        return sex;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

public class StreamStudy {
    public static void main(String[] args) {
        Student stuA = new Student(1, "A先生", "M", 184);
        Student stuB = new Student(2, "B女生", "G", 163);
        Student stuC = new Student(3, "C先生", "M", 175);
        Student stuD = new Student(4, "D女生", "G", 158);
        Student stuE = new Student(5, "E先生", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);
        // -------------------------------- Iterator 方式
        // (外部迭代方式)---------------------------------------
        // Iterator<Student> stuIterator = list.iterator();
        // while (stuIterator.hasNext()) {
        // Student stu = stuIterator.next();
        // if (stu.getSex().equals("G")) {
        // System.out.println(stu.getName());
        // }
        // }
        // -------------------------------- Stream 方式
        // （聚合操作方式）---------------------------------------
        list.stream().filter(student -> student.getSex().equals("G"))
                .forEach(student -> System.out.println(student.getName()));

        list.stream().forEach(student -> {
            if (student.getName().contains("A")) {
                student.setName("张".concat(student.getName().substring(1)));
            } else if (student.getName().contains("B")) {
                student.setName("王".concat(student.getName().substring(1)));
            } else if (student.getName().contains("C")) {
                student.setName("李".concat(student.getName().substring(1)));
            } else if (student.getName().contains("D")) {
                student.setName("赵".concat(student.getName().substring(1)));
            } else if (student.getName().contains("E")) {
                student.setName("孙".concat(student.getName().substring(1)));
            }
        });

        list.stream().forEach(student -> System.out.println(student.getName()));
    }
}

class concat0BeforeStr {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7,8";
        List<String> sListBefore = Arrays.asList(str.split(","));
        List<String> sListAfter = new ArrayList<>();
        sListBefore.stream().forEach(x -> {
            sListAfter.add("0".concat(x));
        });
        str = String.join(",", sListAfter);
        System.out.println(str);
    }
}
