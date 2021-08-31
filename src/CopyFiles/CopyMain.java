package CopyFiles;

import java.io.*;

/**
 * 多文件复制实战
 * 路径需要改
 */
public class CopyMain {
    public static void main(String[] args) {

        String dir = "C:\\Users\\xurui\\Pictures";
        File file = new File(dir + "\\Saved Pictures");
        for (File listFile : file.listFiles()) {
            String fileName = listFile.getName();
            copy(listFile.getAbsolutePath(), dir + "\\test1\\" + fileName);
        }


    }

    public static void copy(String from, String to) {
        try {
            File file = new File(new File(to).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));

            int size;
            byte[] bytes = new byte[1024];
            while ((size = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, size);
            }
            bos.flush();
            bis.close();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
