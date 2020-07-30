import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//-------------------------------------------the basic of serialize-------------------------------------------------
public class serializeTest {
    public static void main(String[] args) throws Exception {
        // 1.
        // serializeUser();
        // deSerializeUser();

        // 2.
        User user1 = new User();
        user1.setAge(25);
        user1.setName("梅罗");

        User user2 = CloneUtil.clone(user1);
        user2.setAge(26);
        User user3 = CloneUtil.clone(user1);
        user3.setAge(27);
        System.out.print(user1.getName() + "今年的年龄：" + user1.getAge() + "\n");
        System.out.print(user1.getName() + "明年的年龄：" + user2.getAge() + "\n");
        System.out.print(user1.getName() + "后年的年龄：" + user3.getAge() + "\n");
    }

    private static void serializeUser() throws Exception {
        User user = new User();
        user.setAge(24);
        user.setName("pdd");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://serializeTest/serializeText.txt"));
        oos.writeObject(user);
        oos.close();
        System.out.print("SerializeUser successfully!" + "\n");
    }

    private static void deSerializeUser() throws Exception {
        File file = new File("D://serializeTest/serializeText.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User) ois.readObject();
        ois.close();
        System.out.print("DeSerializeUser successfully!" + "\n");
        System.out.print("age :" + newUser.getAge() + "\n");
        System.out.print("name :" + newUser.getName() + "\n");
    }
}

// 1.Implements Serializable interface.
class User implements Serializable {
    // serialize id
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;

    // Static variable can't be serialized.
    // private static int age;

    // Transient variable will be initialized in de-serialization.
    // private transient int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

// 2.Implements Externalizable
// class User implements Externalizable {
// private int age;
// private String name;

// public void setAge(int age) {
// this.age = age;
// }

// public int getAge() {
// return this.age;
// }

// public void setName(String name) {
// this.name = name;
// }

// public String getName() {
// return this.name;
// }

// // A No-arguments constructor must be required.
// public User() {
// }

// @Override
// public void writeExternal(ObjectOutput oop) throws IOException {
// oop.writeObject(name);
// oop.writeInt(age);
// }

// @Override
// public void readExternal(ObjectInput oip) throws IOException,
// ClassNotFoundException {
// name = (String) oip.readObject();
// age = oip.readInt();
// }
// }

// -------------------------------------------a deep clone example-------------------------------------------------
class CloneUtil {
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            // write byteStream
            ByteArrayOutputStream baop = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baop);
            oos.writeObject(obj);
            oos.close();

            // distribute memory and copy obj to cloneObj
            ByteArrayInputStream baip = new ByteArrayInputStream(baop.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(baip);

            // copy obj to cloneObj
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return cloneObj;
    }
}