import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NparniCounter {
	public static void main(String[] args) throws IOException{
		String site = "nparni.ru";
		int currentPage=1;
		int count=0;
		boolean f=false;
		String[] strQuery= {"Погрузочные работы","Такелажные работы", "Перевозка оборудования", "Подъем грузов"};
		FileWriter out=null;
		Date date=null;
		WebElement pageCounter=null;
		//WebElement pageCounter=null;
		//WebElement el=null;
		//List<WebElement> site_list=null;
		//Iterator<WebElement> it=null;
		/*Random generator = new Random();
		System.setProperty("http.proxyHost", "202.64.115.226:8080");
		System.setProperty("http.proxyPort", "80");
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js;
        js=(JavascriptExecutor)driver;
		driver.get("http://yandex.ru/");*/
		/*String PROXY = "178.124.140.93:80";
		String PROXY2 = "50.22.206.179:8080";
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
		WebDriver driver = new FirefoxDriver(cap);
		driver.get("http://ip.spys.ru/");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proxy.setHttpProxy(PROXY2);
		cap.setCapability(CapabilityType.PROXY, proxy);
		System.out.println("обновление");
		driver.get("http://ip.spys.ru/");*/
		date = new Date();
		//File flt = new File("C:\\Users\\viacheslav\\HomeWorkspace\\NparniCounter\\np.txt");
		try {
			out = new FileWriter("C:/Users/viacheslav/HomeWorkspace/NparniCounter/np.txt", true);
			//out.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("файл не найден np.txt");
		}
		for (int i=0; i<strQuery.length; i++){
			f=false;
			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor js;
	        js=(JavascriptExecutor)driver;
			driver.get("http://yandex.ru/");
			WebElement ya_serch_input= driver.findElement(By.cssSelector("#text"));
			ya_serch_input.sendKeys(strQuery[i]);
			WebElement ya_serch_button= driver.findElement(By.cssSelector(".suggest2-form__button"));
			js.executeScript("arguments[0].click();", ya_serch_button);
			WebDriverWait wait = new WebDriverWait(driver, 7); 
			while (!f){
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("html.i-ua_js_yes body.b-page div.main div.main__center div.main__center-inner div.main__footer div.pager div.pager__content span.pager__group a.button")));
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				List<WebElement>  site_list = driver.findElements(By.xpath("(//a[@class='b-link serp-url__link'])"));
				Iterator<WebElement> it = site_list.iterator();
				while (it.hasNext()){
					WebElement el = (WebElement)it.next();
					if (el.getAttribute("innerHTML").contains(site)){
						System.out.println("Найден сайт "+site+" на странице "+currentPage);
						count++;
						if (count>=1){
							String url = driver.getCurrentUrl();
							f=true;
							CharSequence ch = date.toGMTString()+ " Найден результат: " + strQuery[i] + " на странице "+currentPage + "\n";
							out.append(ch);
							out.append("ссылка "+driver.getCurrentUrl()+"\n");						
							out.flush();
							currentPage=1;
							//driver.close; для закрытия окон браузера и полной ост программы по окончанию
						}
					}
				}
				if (!f){
					//т.к. кнопка на странице смещается
					if (currentPage==1){
						pageCounter = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[7]/div[3]/div/span/a["+6+"]"));
					}
					else{
						pageCounter = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[7]/div[3]/div/span[2]/a["+7+"]"));
					}
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					js.executeScript("arguments[0].click();", pageCounter);
					currentPage++;
				}
			}
		}
		
		
		out.close();
		//li.b-serp-item:nth-child(10) > h2:nth-child(2) > b:nth-child(1)
		//.b-pager__current
		
	}
}
