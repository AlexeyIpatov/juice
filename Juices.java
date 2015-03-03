import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Juices {
    List<String> jucies;
    List<String> jucies1;
    List<String> all_fruits;
    Set<String> fruits;
    Map<String,Integer> juice_and_count_of_fruits;
    List<String> sorted_jucies;

    public static void main(String[] args) throws IOException {
        new Juices().run();
    }

    Juices() {
        jucies = new ArrayList<String>();
        jucies1 = new ArrayList<String>();
        all_fruits = new ArrayList<String>();
        fruits = new LinkedHashSet<String>();
        juice_and_count_of_fruits = new TreeMap<String,Integer>();
        sorted_jucies = new ArrayList<String>();
    }

    void run() throws IOException {
        read();
    }

    String remove_replays (String string) throws IOException {
        String str = "";
        List<String> list_strings = new LinkedList<String>();
        StringTokenizer st = new StringTokenizer(string, " ");
        while(st.hasMoreTokens()){
            String buf = st.nextToken();
            if (!list_strings.contains(buf))
                list_strings.add(buf);
        }
        for (int i = 0;i<list_strings.size();i++){
            if(i==list_strings.size()-1){
                str+=list_strings.get(i).toString();
            }
            else{
            str+=list_strings.get(i).toString()+" ";}
        }
        return str;
    }

    void read() throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C://Users//Pro//Desktop//juice//input.txt")));
        StringTokenizer stringTokenizer1;
        String temp1;
        while(true) {
            temp1 = bufferedReader.readLine();
            if(temp1 == null) break;
            stringTokenizer1 = new StringTokenizer(temp1, ";");
            while(stringTokenizer1.hasMoreTokens()) {
                jucies.add(stringTokenizer1.nextToken());
            }
        }

        for(int p = 0; p < jucies.size(); p++) {
            jucies1.add(p, remove_replays(jucies.get(p).toString()));
        }

        for (int i=0;i<jucies1.size();i++) {
            int count_of_fruits_juice = 0;
            StringTokenizer stringTokenizer2 = new StringTokenizer(jucies1.get(i)," ");
            while(stringTokenizer2.hasMoreTokens()) {
                all_fruits.add(stringTokenizer2.nextToken());
                count_of_fruits_juice++;
            }
            juice_and_count_of_fruits.put(jucies1.get(i), count_of_fruits_juice);
        }

        fruits.addAll(all_fruits);
        Collections.sort(all_fruits);
        writeAnswer1(all_fruits, "juice2");
        writeAnswer(fruits,"juice1");
        Set<Map.Entry<String,Integer>> entrySet=juice_and_count_of_fruits.entrySet();

        for (int j = 1 ; j < juice_and_count_of_fruits.size() + 1 ; j++) {
            Object desiredObject = j;//что хотим найти
            for (Map.Entry<String, Integer> pair : entrySet) {
                if (desiredObject.equals(pair.getValue())) {
                    sorted_jucies.add(pair.getKey());
                }
            }
        }

        String[] array_sorted_jucies = sorted_jucies.toArray(new String[sorted_jucies.size()]);
        for(int y=0;y<array_sorted_jucies.length;y++) {
            System.out.println(array_sorted_jucies[y]);
        }
        String str="";
        int a=0,b=0;
        for (int k=0;k<array_sorted_jucies.length;k++) {
            for (int l = 0; l < array_sorted_jucies.length; l++) {
                if (array_sorted_jucies[l].length() != 0) {
                    System.out.println(array_sorted_jucies[l] + "=|||=" + array_sorted_jucies[k]);
                    str = array_sorted_jucies[l];
                    array_sorted_jucies[l] = array_sorted_jucies[l].replaceAll(array_sorted_jucies[k], "");

                    if (array_sorted_jucies[l].compareTo(str) == 0) {
                        b++;
                    }
                    //System.out.println(array_sorted_jucies[l]);
                }
            }
            if(b>0){
                a++;
            }
        }
        System.out.println(a);

    }

    public List getFruits(){
        return this.all_fruits;
    }

    void writeAnswer(Set answer,String path) throws IOException{
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("C://Users//Pro//Desktop//juice//"+path+".txt")));
        printWriter.println(answer);
        printWriter.close();
    }

    void writeAnswer1(List answer,String path) throws IOException{
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("C://Users//Pro//Desktop//juice//"+path+".txt")));
        printWriter.println(answer);
        printWriter.close();
    }
/*
    void writeTask2(ArrayList<MyPair> arrayList) throws IOException{
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("bytes2.out")));
        Iterator<MyPair> iterator = arrayList.iterator();
        MyPair temp;
        while(iterator.hasNext()){
            temp = iterator.next();
            printWriter.println(temp.getName() + " - " + temp.getCountOfMembers());
        }
        printWriter.close();
    }*/
}
