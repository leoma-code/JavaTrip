package com.leo.javabasic.fileandio.d01StaticProperty;

import java.io.File;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class FileStaticPropertyDemo {

    public static void main(String[] args) {

        String pathSeparator = File.pathSeparator;
        System.out.println("pathSeparator - " + pathSeparator);

        String separator = File.separator;
        System.out.println("separator - " + separator);

        File file = new File("/Users/leo/Desktop");
        System.out.println(file.getPath());
        System.out.println(file);

    }
}
