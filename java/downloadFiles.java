import java.io.File;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class downloadFiles {
    public static void main(String[] args) throws Exception {

        try {
            // 目前这里是写死的本地硬盘路径
            String path = "C:\\Users\\zhangxuping.ITEC\\Desktop\\test";

            // 文件名后缀
            String suffix = ".txt";
            suffix = suffix.toLowerCase();

            // 文件大小
            char[] fileCharSize = new char[1024];

            // 文件内容
            String s = new String(" I love Java");

            File targetFile = new File(fileCharSize.length + "byte" + suffix);

            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));
            bufferedWriter.write(s, 0, s.length());
            bufferedWriter.close();

            FileInputStream inputStream = new FileInputStream(targetFile);

            // 写入文件缓存大小
            byte[] bs = new byte[1024];
            FileOutputStream os = new FileOutputStream(path + File.separator + "test_test" + suffix);

            // 开始读取
            int len = 0;
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

            os.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class createFile {
    public static void main(String[] args) {
        String prePath = "C:/Users/zhangxuping.ITEC/Desktop/test/";
        // String suffix = ".txt";
        String suffix = ".xlsx";
        // byte[] contentInBytes = new byte[1024 * 1024 * 11];
        byte[] contentInBytes = new byte[1024 * 123];
        // String fileName = (contentInBytes.length) / (1024 * 1024) + "MB" + "File";
        String fileName = "@@@@";
        File file = new File(prePath + fileName + suffix);
        String content = "This is the text content";

        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            // byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class fileWriterExample {
    public static void main(String[] args) throws IOException {
        try {
            File testFile = new File("D:\\testFiles\\fileWriterExample.txt");
            // if testFile no exist ,then create one.
            if (!testFile.exists()) {
                testFile.createNewFile();
            }
            FileWriter testFileWriter = new FileWriter(testFile);
            BufferedWriter testBufferedWriter = new BufferedWriter(testFileWriter);
            testBufferedWriter.write("testFileWriter.");
            testBufferedWriter.close();

            System.out.print("done");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

class fileOutPutStreamExample {
    public static void main(String[] args) throws IOException {
        try {
            File testFile = new File("D:\\testFiles\\fileOutPutStream.txt");
            if (!testFile.exists()) {
                testFile.createNewFile();
            }
            FileOutputStream testFileOutputStream = new FileOutputStream(testFile);
            String content = "testFileOutputStream.";
            testFileOutputStream.write(content.getBytes());
            testFileOutputStream.flush();
            testFileOutputStream.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
