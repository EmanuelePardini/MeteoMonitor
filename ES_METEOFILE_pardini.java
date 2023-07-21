//MAIN CLASS MAINMENU
package com.mycompany.meteoapp;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class MainMenu {
    
public static void main(String[] args) {
    int scelta;
    Scanner tast=new Scanner(System.in);
    Meteo metodo=new Meteo();
System.out.println("Scrivere i file manualmente? (1/0)");
scelta=tast.nextInt();
if(scelta==1){
metodo.scrittura_utente("C:\\Users\\User\\Desktop\\dati_meteo_man.txt");
}
else{
metodo.scrittura_automatica("C:\\Users\\User\\Desktop\\dati_meteo_man.txt");
}
System.out.println("Rilettura:");
metodo.lettura("C:\\Users\\User\\Desktop\\Text_file.txt");
}}
//-----------------------------------------------------------------
//CLASS METEO

/**
 *
 * @author User
 */
public class Meteo {
    
    
    public static void scrittura_automatica(String percorso){
     Random rand=new Random();
    int temp;
    int i=0;
    int temp_med=0;
    int temp_min=99999999;
    int temp_max=0;
    String linea=null;
    for(i=8;i<21;i++){
    temp =rand.nextInt(12)+6;
linea =linea+"\n"+"Ore:"+i+" ; "+"Temp:"+temp;
temp_med=temp_med+temp;
if(temp>temp_max){
    temp_max=temp;
}
if(temp<temp_min){
    temp_min=temp;
}
    }
      linea =linea+"\n"+"Temperatura media:"+temp_med/12;
    linea =linea+"\n"+"Temperatura massima:"+temp_max;
    linea =linea+"\n"+"Temperatura minima:"+temp_min;
try{
FileWriter file = new FileWriter(new File(percorso));
BufferedWriter bw = new BufferedWriter(file);
bw.write(linea);
bw.flush();
bw.close();
}
catch(IOException ex){
ex.printStackTrace();
}
}
    
    
public static void scrittura_utente(String percorso){
    Scanner tast=new Scanner(System.in);
    int temp;
    int i=0;
    int temp_med=0;
    int temp_min=99999999;
    int temp_max=0;
    String linea=null;
    System.out.println("Inserire le temperature nella fascia oraria 8:00/20:00");
    for(i=8;i<21;i++){
   temp=tast.nextInt();
linea =linea+"\n"+"Ore:"+i+" ; "+"Temp:"+temp;
temp_med=temp_med+temp;
if(temp>temp_max){
    temp_max=temp;
}
if(temp<temp_min){
    temp_min=temp;
}
    }
    linea =linea+"\n"+"Temperatura media:"+temp_med/12;
    linea =linea+"\n"+"Temperatura massima:"+temp_max;
    linea =linea+"\n"+"Temperatura minima:"+temp_min;
try{
FileWriter file = new FileWriter(new File(percorso));
BufferedWriter bw = new BufferedWriter(file);
bw.write(linea);
bw.flush();
bw.close();
}
catch(IOException ex){
ex.printStackTrace();
}
}



public static void lettura(String percorso){
try{
BufferedReader br = new BufferedReader(new FileReader(percorso));
String linea = br.readLine();
System.out.println(linea);
linea=br.readLine();
br.close();
}
catch(IOException ex){
ex.printStackTrace();
}
}
}
