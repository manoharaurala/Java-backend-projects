import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("G:\\JAVA Backend Course\\MyCode\\iostreams\\src\\tmp\\file.txt");
        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.canWrite());

        System.out.println(file.isDirectory());
        FileReader fileReader=new FileReader(file);
        FileWriter fileWriternew=new FileWriter(file);



    }
}
