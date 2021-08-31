
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.*;

public class Study {
    public static void main(String[] args) {

    }

    /**
     * list迭代器测试
     */
    public static void ListIterator() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if ("c".equals(str) || "d".equals(str)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    /**
     * map迭代器 遍历测试
     */
    public static void maptestList() {
        Map<String, String> maplist = new HashMap<>();
        maplist.put("1", "a");
        maplist.put("2", "b");
        maplist.put("3", "c");
        maplist.put("4", "d");
        maplist.put("5", "e");
        Set<Map.Entry<String, String>> mapentry = maplist.entrySet();
        Iterator<Map.Entry<String, String>> iterator = mapentry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> ne = iterator.next();
            String key = ne.getKey();
            String value = ne.getValue();
            System.out.println("数据为" + key + ":" + value);
        }
    }

    /**
     * 输入流测试
     * dir = "C:\\Users\\rhxu3\\Desktop";
     * name = "a.txt";
     * try {
     * InputstreamTest("C:\\Users\\rhxu3\\Desktop","a.txt");
     * }catch (Exception e){
     * e.printStackTrace();
     * }
     */
    public static void InputstreamTest(String dir, String name) throws IOException {
        File file = new File(dir, name);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, length));
        }
        fileInputStream.close();
    }

    /**
     * 输出流测试
     * try {
     * OutputstreamTest("C:\\Users\\rhxu3\\Desktop","a.txt");
     * }catch (Exception e){
     * e.printStackTrace();
     * }
     */
    public static void OutputstreamTest(String dir, String name) throws IOException {
        //拷贝的文件路径和文件名
        File file = new File(dir, name);
        FileInputStream fileInputStream = new FileInputStream(file);
        String target = "b.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(dir + File.separator + target);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, length);

        }
        fileInputStream.close();
        fileOutputStream.close();

    }

    /**
     * Buffer缓冲 输入流输出流实战
     * 路径需要改 文件需要建
     */
    public static void BufferIntPut() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\rhxu3\\Desktop\\a.txt");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\rhxu3\\Desktop\\c.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int length;
            byte[] bytes = new byte[1024];
            while ((length = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * try-with-resource处理I/O异常
     */
    public static void TryWithResource() {
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\rhxu3\\Desktop\\a.txt"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\rhxu3\\Desktop\\c.txt"));
        ) {
            int size;
            byte[] bytes = new byte[1024];
            while ((size = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * LocalDate
     */
    public static void LocalDateTest() {
        LocalDate today = LocalDate.now();
//        System.out.println("今天日期"+today);
//        System.out.println("年份"+today.getYear());
//        System.out.println("月份"+today.getMonth());
//        System.out.println("月份（数字）"+today.getMonthValue());
//        System.out.println("日"+today.getDayOfMonth());
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd+HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println(format);
    }

}
