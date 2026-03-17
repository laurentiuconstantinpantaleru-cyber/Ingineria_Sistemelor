package lab3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
   try {
       String continut = new String(Files.readAllBytes(Paths.get( "in.txt")));
       List<String> linii = new ArrayList<>(Arrays.asList(continut.split("\\n")));

       StringBuilder sb = new StringBuilder();
       for(String linie: linii){
           sb.append(linie).append("\n\n");
       }
       System.out.println(sb);
       for(String linie: linii){
           sb.append(linie.replace(".",".\n")).append("\n");
       }
       System.out.println(sb);
       System.out.println(sb);
       Files.write(Paths.get("out.txt"), sb.toString().getBytes());
   }
   catch (IOException e) {
       e.printStackTrace();
   }
    }
}




