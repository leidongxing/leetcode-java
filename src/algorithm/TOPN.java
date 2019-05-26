package algorithm;

import java.io.*;
import java.util.Random;

public class TOPN {
    private static final int MAX_SIZE = 100000000;
    private static final String PATH="C:\\Users\\leido\\Desktop\\random.xml";
    private static final String CHARSET="UTF-8";

    public static void  write() throws IOException {
        File f = new File(PATH);
        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        Random r = new Random();;
        for(int i=0;i<MAX_SIZE;i++){
            int x = r.nextInt(MAX_SIZE);
            bos.write(String.valueOf(x).getBytes(CHARSET));
            bos.write("\r\n".getBytes(CHARSET));
            bos.flush();
        }
        bos.close();
        fos.close();
    }


    public static void  read()throws IOException{
        File f = new File(PATH);
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream bis=new BufferedInputStream(fis);
        for(int i=0;i<1000;i++){
            while(bis.read()!=-1)
            {
                System.out.println(bis.read());
            }
        }
        bis.close();
        fis.close();
    }



    public static void main(String[] args) throws Exception {
        TOPN.read();
    }
}
