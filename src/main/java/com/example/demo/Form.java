package com.example.demo;

import java.io.*;

public class Form {
    private int val1;
    private int val2;

    public int getVal1() {

        return val1;
    }

    public void setVal1(int val1) {

        this.val1 = val1;
    }

    public int getVal2() {

        return val2;
    }

    public void setVal2(int val2) {

        this.val2 = val2;
    }

    public int getSum(){
        return val1 + val2;
    }

    public void saveDataTxt(){
        try {
            File file = new File("./files/dataForm.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(Integer.toString(getVal1()));
            bw.write(",");
            bw.write(Integer.toString(getVal2()));
            bw.write(",");
            bw.write(Integer.toString(getSum()));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDataTxt() {
        String line = "";
        StringBuilder file = new StringBuilder();
        String[] arrOfLine;

        try {
                FileReader ler = new FileReader("./files/dataForm.txt");
                BufferedReader reader = new BufferedReader(ler);
                while ((line = reader.readLine()) != null) {
                    file.append("<tr>");
                    arrOfLine = line.split(",",5);

                    for (String num : arrOfLine) {
                        file.append("<td>").append(num).append("</td>");
                    }

                    file.append("</tr>");
                }
                reader.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
        file.append("</table>");
        System.out.println(file);
            return file.toString();
    }

    public String getAverageFromTxt() {
        String line = "";
        float avg = 0;
        int lineCount = 0;
        String[] arrOfLine;

        try {
            FileReader ler = new FileReader("./files/dataForm.txt");
            BufferedReader reader = new BufferedReader(ler);
            while ((line = reader.readLine()) != null) {
                arrOfLine = line.split(",",5);

                for (int indexArrayFromFile = 0; indexArrayFromFile < arrOfLine.length-1; indexArrayFromFile++) {
                    avg += Float.valueOf(arrOfLine[indexArrayFromFile]);
                }
                lineCount ++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        avg = avg/(lineCount*2);

        return Float.toString(avg);
    }

}
