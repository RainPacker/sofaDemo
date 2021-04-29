/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.clone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

/**
 * @author rain
 * @version : Clone.java, v 0.1 2020年12月25日 上午10:23 rain Exp $
 */
public class Clone {

    public static void main(String[] args) throws Exception {

        LocalDateTime localDateTime= LocalDateTime.now();

        ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("./object.txt"));

        oos.writeObject(localDateTime);
        oos.close();
        File f =new File("object.txt");
        System.out.println(f.getAbsolutePath());

        ObjectInputStream ois =new ObjectInputStream(new FileInputStream("./object.txt"));
        LocalDateTime ld = (LocalDateTime) ois.readObject();
        System.out.println(ld== localDateTime);
        ois.close();

        f.delete();

    }
}
