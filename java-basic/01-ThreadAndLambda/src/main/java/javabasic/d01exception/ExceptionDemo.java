package javabasic.d01exception;

import java.io.FileNotFoundException;
import java.util.Objects;

/**
 * Created by Leo on 2019/12/16.
 * Description :
 */
public class ExceptionDemo {

    public static void main(String[] args) {

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            Date date = sdf.parse("1991-02-10");
//            System.out.println("parse date: " + date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        int[] arr = null;
//        int e = getElementAtIndex(arr, 3);
//        System.out.println("Element At Index is " + e);

        try {
            readFile("/Users/Steven/Desktop");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int a = getA();
        System.out.println("a : " + a);


    }

    private static int getA() {
        int a = 10;
        try {
            return a;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            a = 100;
            return  a;
        }
    }



    public static void readFile(String fileName) throws FileNotFoundException {
        Objects.requireNonNull(fileName);

        if (!fileName.equals("/Users/Steven/Desktop")) {
            throw new FileNotFoundException("文件路径不对");
        }

    }















    private static int getElementAtIndex(int[] arr, int index) {
        // 1
        Objects.requireNonNull(arr, "Objects 数组不能为空");
        // 2
        if (Objects.isNull(arr)) throw new NullPointerException("Objects 数组为Null");
        // 3
        if (arr == null) throw new NullPointerException("数组为Null");

        if (arr.length - 1 < index || index < 0) throw new ArrayIndexOutOfBoundsException("数组越界");

        int e = arr[index];
        return e;
    }

}
