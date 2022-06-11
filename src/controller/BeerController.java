package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BeerController {
public static void op1(String res1,String res2) throws IOException {
	File path = new File(res1);
	File file = new File(res1,res2);
	if(path.exists() && path.isDirectory()){
		if(file.exists() && file.isFile()){
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader input = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(input);
			String linha = buffer.readLine();
			List<String> li = new ArrayList<String>();
			List<String> li2 = new ArrayList<String>();
			List<String> li3 = new ArrayList<String>();
			List<String> li4 = new ArrayList<String>();
			String[] tbd = linha.split(",");
			int h = 0;
			int j = 0;
			int k = 0;
			for(String i : tbd) {
				if(i.contains("id")) {
					if(tbd[h+1].contains("name") && tbd[h+1].contains("ingredient")==false) {
						li.add(tbd[h+1]);
					}
				}
				else if(i.contains("tagline")) {
					li2.add(i);
				}
				else if(i.contains("first_brewed")) {
					li3.add(i);
				}
				if(i.contains("descrip")) {
					j = h;
					StringBuffer stb = new StringBuffer();
					try {
					while(tbd[h].contains("image_url")==false){
						stb.append(","+tbd[h]);
						h=h+1;
					}
					String a1 = stb.toString();
					li4.add(a1);
					}catch(Exception e){
						}
					h = j;
				}
				h = h+1;
			}
			int d = 0;
			for(int i =0;i<=25; i++) {
				System.out.println(li.get(i)+" | "+li2.get(i)+ " | "+li3.get(i)+" | "+li4.get(i));
			}
			
		}else {
			throw new IOException("não é arquivo");
		}
}else {
		throw new IOException("não é diretorio");
	}
}
}