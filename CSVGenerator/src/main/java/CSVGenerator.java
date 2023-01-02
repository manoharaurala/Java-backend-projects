import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVGenerator {
    public static void main(String[] args) throws IOException {
        List<String[]> csvdata=createCSV();
       try( CSVWriter csvWriter=new CSVWriter(new FileWriter("G:\\JAVA Backend Course\\MyCode\\visitor-app\\csv\\upload.scv"))) {
           csvWriter.writeAll(csvdata);
        }
    }

    private static List<String[]> createCSV() {
        String[] header={"name","email","phone","flat","address","roleId"};
        String[] row1={"annaya","annya@gmail.com","8838193013","1","10000","3"};
        String[] row2={"piddi","piddi@gmail.com","535346356","2","10001","2"};
        List<String[]> list=new ArrayList<>();
        list.add(header);
        list.add(row1);
        list.add(row2);

        return list;
    }
}
