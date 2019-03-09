package test.file;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        read();
        read2();
        write();
    }

    public static void write(){

        File file = new File("write.txt");
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write("测试write");
            bw.flush();              //确认write完毕  如果有close就可以不需要flush
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void read(){

        File file = new File("test.txt");
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int tmp = fileReader.read();
            while (tmp!=-1){
                System.out.print((char)tmp);
                tmp = fileReader.read();
            }
            }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * BufferedReader是FileReader比较高级的用法
     * 是先把要读取的东西提前放到缓冲区
     * 这样子读取比较不会耗时
     */

    public static void read2(){

        File file = new File("test.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine())!= null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
