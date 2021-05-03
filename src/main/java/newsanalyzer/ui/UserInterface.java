package newsanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Scanner;

import newsanalyzer.ctrl.Controller;
import newsanalyzer.ctrl.NewsResponseException;
import newsapi.enums.Category;
import newsapi.enums.Country;
import newsreader.downloader.Downloader;
import newsreader.downloader.ParallelDownloader;
import newsreader.downloader.SequentialDownloader;


// Github REPO: https://github.com/GabrielHuebner/NewsAnalyzer.git
public class UserInterface 
{

	private Controller ctrl = new Controller();
	private Downloader parDown = new ParallelDownloader();
	private Downloader seqDown = new SequentialDownloader();

	public void getDataFromCtrl1(){
		System.out.println("Choice Austria");

		try {
			ctrl.process(Country.at, Category.health);
		}
		catch (MalformedURLException e) {
			System.out.println("Die URL  ist leider falsch");
		}
		catch (NewsResponseException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Problem");
		}
	}

	public void getDataFromCtrl2(){
		System.out.println("Choice Germany");

		try {
			ctrl.process(Country.de, Category.health);
		} catch (MalformedURLException e) {
			System.out.println("Die URL  ist leider falsch");
		}
		catch (NewsResponseException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Problem");
		}
	}

	public void getDataFromCtrl3(){
		System.out.println("Choice Slovakia");

		try {
			ctrl.process(Country.sk, Category.health);
		} catch (MalformedURLException e) {
			System.out.println("Die URL  ist leider falsch");
		}
		catch (NewsResponseException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Problem");
		}
	}

	public void downloadLastSearch(){
		System.out.println("Downloading Files");

		try {
			ctrl.downloadURL(parDown);
			ctrl.downloadURL(seqDown);
		} catch (MalformedURLException e) {
			System.out.println("Die URL  ist leider falsch");
		}
		catch (NewsResponseException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Problem " + e.getMessage());
		}
	}
	
	public void getDataForCustomInput() {
		System.out.println("Please enter a Category of your choice for the Country Austria (z.B.: health) :");
		Scanner scan = new Scanner(System.in);
		String uInput = scan.next();

		switch(uInput){
			case "business":
				try {
					ctrl.process(Country.at, Category.business);
				} catch (MalformedURLException e) {
					System.out.println("Die URL  ist leider falsch");
				}
				catch (NewsResponseException e){
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println("IO Problem");
				}
				break;
			case "entertainment":
				try {
					ctrl.process(Country.at, Category.entertainment);
				} catch (MalformedURLException e) {
					System.out.println("Die URL  ist leider falsch");
				}
				catch (NewsResponseException e){
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println("IO Problem");
				}
				break;
			case "health":
				try {
					ctrl.process(Country.at, Category.health);
				} catch (MalformedURLException e) {
					System.out.println("Die URL  ist leider falsch");
				}
				catch (NewsResponseException e){
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println("IO Problem");
				}
				break;
			case "science":
				try {
					ctrl.process(Country.at, Category.science);
				} catch (MalformedURLException e) {
					System.out.println("Die URL  ist leider falsch");
				}
				catch (NewsResponseException e){
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println("IO Problem");
				}
				break;
			case "sports":
				try {
					ctrl.process(Country.at, Category.sports);
				} catch (MalformedURLException e) {
					System.out.println("Die URL  ist leider falsch");
				}
				catch (NewsResponseException e){
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println("IO Problem");
				}
				break;
			case "technology":
				try {
					ctrl.process(Country.at, Category.technology);
				} catch (MalformedURLException e) {
					System.out.println("Die URL  ist leider falsch");
				}
				catch (NewsResponseException e){
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println("IO Problem");
				}
				break;
			default:
				System.out.println("Please enter one of the following choices: business, entertainment, health, science, sports, technology");
		}
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interfacx");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Choice Austria", this::getDataFromCtrl1);
		menu.insert("b", "Choice Germany", this::getDataFromCtrl2);
		menu.insert("c", "Choice Slovakia", this::getDataFromCtrl3);
		menu.insert("d", "Choice User Input (Country):",this::getDataForCustomInput);
		menu.insert("e","Choice Download Last Search",this::downloadLastSearch);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Program finished");
	}


    protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
        } catch (IOException ignored) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 	{
		Double number = null;
        while (number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
				System.out.println("Please enter a valid number:");
				continue;
			}
            if (number < lowerlimit) {
				System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
				System.out.println("Please enter a lower number:");
                number = null;
			}
		}
		return number;
	}
}
