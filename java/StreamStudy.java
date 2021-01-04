import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

// ------------------------------------------ 菜鸟教程
// ---------------------------------------------------
class StreamForRunoob {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        filtered.stream().forEach(x -> System.out.print(x + "\n"));

        // ---------------------------------------- 使用 forEach 输出了10个随机数
        // ----------------------------------------//
        LineAndTitle.printTitle("使用 forEach 输出了10个随机数");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}

class StreamForJson {
    public static void main(String[] args) throws IOException {
        // デバッグ用のJSONファイルの呼び出し
        String json = Files
                .lines(Paths.get("./entry_jobchange_data.json"), Charset.forName("UTF-8"))
                .collect(Collectors.joining(System.getProperty("line.separator")));

        // System.out.print(json);
        // JSONObject json_test = JSONObject.fromObject(json);
    }
}

class StreamForSetTest {
    public static void main(String[] args) {
        HashSet<Long> idSet = new HashSet<>();
        idSet.add(1L);
        idSet.add(2L);
        idSet.add(1L);
        idSet.forEach(x -> System.out.print(x+"\n"));
    }
}

class subArray {
    public static void main(String[] args) {
        String[] src = new String[]{"1", "2", "3", "4", "5"};
        String newArray[] = Arrays.copyOfRange(src, 2, src.length);
        for (String i : newArray) {
            System.out.println(i);
        }
        System.out.println(String.join("",newArray));
    }
}


class subArray2 {
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

        // map 可以筛选数据，返回其他类型List。
        List<Float> heightList = list.stream().map(x -> x.getHeight()).collect(Collectors.toList());
        System.out.print(heightList);
        System.out.print("\n");

        // filter 可以过滤数据，返回同类型List。
        List<Student> subHeightList = list.stream().filter(x -> x.getHeight() < 180).collect(Collectors.toList());

        // forEach 可以遍历数据，不返回List。
        subHeightList.forEach(x -> System.out.print(x.getSex()));
        System.out.print("\n");

        // subHeightList.removeIf(x -> x.getHeight())
    }
}