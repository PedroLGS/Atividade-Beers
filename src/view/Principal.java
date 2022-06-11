package view;

import controller.BeerController;

public class Principal {

	public static void main(String[] args) {
		String path = "C:\\TEMP";
		String file = "beer.json";
		try {
		BeerController.op1(path,file);
		}catch(Exception e) {

	}
}
}