package net.kiranatos.variant1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;

public class Start {
    public static void main(String[] args) throws URISyntaxException, IOException {
        
        MainApp.start(args);
        
        System.out.println("\nФайл baka.txt находится на одном уровне с папкой src и должен находится рядом при запуске jar-ника или же если его нет, то создастся независимо от jar-ника");
        File file1 = new File("baka.txt");
        System.out.println("Are we founded that file? - " + file1.exists() + " Let's write something in it!");
        PrintWriter printWriter = new PrintWriter(new FileWriter(file1));
        printWriter.println("TEST TEST");
        printWriter.close();        
        

        /* Пока не знаю, что с этим делать:
        File dir = new File(getClass().getClassLoader().getResource("myFolderName").getFile()); 
        File[] files = dir.listFiles();*/
        
        
        /* Работает в IDE в проекте с Maven-ом, но выбрасывает исключение при запуске jar-ника*/ /*
        System.out.println("Как найти файл в папке Мейвена //src//main//resources");
        URL resource = Start.class.getClassLoader().getResource("find.txt");
        System.out.println(resource.toURI());
        File f = new File(resource.toURI());
        System.out.println("Файл найден? - " + f.exists());*/
        
        /* Работает и в IDE в проекте с Maven-ом, и в собранном jar-нике*/
        InputStream resource = Start.class.getClassLoader().getResourceAsStream("find.txt");        
        //InputStream resource = Start.class.getClassLoader().getResourceAsStream("find/find.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
        String s="";
        while ( s != null ) {  
            s = reader.readLine(); 
            System.out.println(s);
        }

        
    }
}
