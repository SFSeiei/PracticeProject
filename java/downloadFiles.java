import java.io.File;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class downloadFiles {
    public static void main(String[] args) throws Exception {

        // try {
        // // 目前这里是写死的本地硬盘路径
        // String path = "C:\\Users\\zhangxuping.ITEC\\Desktop\\test";

        // // 文件名后缀
        // String suffix = ".txt";
        // suffix = suffix.toLowerCase();

        // // 文件大小
        // byte[] fileSize = new byte[1024];
        // // char[] fileCharSize = new char[1024];
        // String s = new String(" I love Java");

        // char bchar[] = s.toCharArray();
        // System.out.println(fileSize.length + "byte" + suffix);

        // File targetFile = new File(fileCharSize.length + "byte" + suffix);

        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(targetFile));
        // bufferedWriter.write(fileCharSize, 0, bchar.length);

        // // FileInputStream inputStream = new FileInputStream(targetFile);

        // bufferedWriter.close();

        // // if (!targetFile.getParentFile().exists()) {
        // // // 注意，判断父级路径是否存在
        // // targetFile.getParentFile().mkdirs();
        // // }
        // // 写入文件缓存大小
        // // byte[] bs = new byte[1024];
        // // FileOutputStream os = new FileOutputStream(targetFile.getPath() +
        // File.separator + "test_test"+suffix);
        // // // 开始读取
        // // int len = 0;
        // // while ((len = inputStream.read(bs)) != -1) {
        // // os.write(bs, 0, len);
        // // }
        // // os.close();
        // // inputStream.close();

        // } catch (IOException e) {
        // e.printStackTrace();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        String prePath = "C:/Users/zhangxuping.ITEC/Desktop/test/";
        String suffix = ".txt";
        byte[] contentInBytes = new byte[1024 * 1024 * 10];
        String fileName = (contentInBytes.length) / (1024 * 1024) + "MB" + "File";
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