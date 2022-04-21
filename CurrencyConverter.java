import java.net.*;
import java.io.*;
import org.json.JSONObject;
import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String... args) {

		String API_KEY = "830e0a87e7b9a7c78fa72176";
		
		Scanner myScan = new Scanner(System.in);
		System.out.println("Welcome to Currency Converter");
		System.out.println("Select from the below choice");
		System.out.println("1: INR to USD");		
		System.out.println("2: USD to INR");
		int myChoice = myScan.nextInt();	
		
		// inr to usd
		switch (myChoice) {
			case 1:
				String absUrl1 = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/INR"; 
				String data1 = getUrlContent(absUrl1);
				JSONObject obj1 = new JSONObject(data1);
				JSONObject obj2 = obj1.getJSONObject("conversion_rates");
				float inr1 = obj2.getFloat("INR");
				float usd1 = obj2.getFloat("USD");
				System.out.println("Enter the amount");
				int myINR = myScan.nextInt();
				System.out.println("INR");
				System.out.println(inr1 * myINR);
				System.out.println("USD");
				System.out.println(usd1 * myINR);
				break;
			case 2:
				String absUrl2 = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD"; 
				String data2 = getUrlContent(absUrl2);
				JSONObject obj3 = new JSONObject(data2);
				JSONObject obj4 = obj3.getJSONObject("conversion_rates");
				float inr2 = obj4.getFloat("INR");
				float usd2 = obj4.getFloat("USD");
				System.out.println("Enter the amount");
				int myUSD = myScan.nextInt();
				System.out.println("USD");
				System.out.println(usd2 * myUSD);
				System.out.println("INR");
				System.out.println(inr2 * myUSD);
		}
	}


	private static String getUrlContent(String theUrl) {
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL(theUrl);
			URLConnection urlConnection = url.openConnection();
			//Created UrlConection object reffered to url
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}
}