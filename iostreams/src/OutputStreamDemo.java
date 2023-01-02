import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        try{
            String filepath="G:\\JAVA Backend Course\\MyCode\\iostreams\\src\\tmp\\test.txt";
            outputStream=new FileOutputStream(filepath);
            String data="Hello शशिकांत ";
            outputStream.write(data.getBytes());
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }
        finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.print("Done");
    }
}
