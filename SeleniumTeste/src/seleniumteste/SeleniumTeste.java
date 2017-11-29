/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumteste;

import com.metodos.MetodosSelenium;
import java.awt.Desktop;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;


/**
 *
 * @author adamvinicius@gmail.com
 */
public class SeleniumTeste {
        private static WebDriver driver;
        private static MetodosSelenium umMetodo;
        private static MercadoLivre umMercadoLivre;
        private static List<String> listaMercadoLivre;
        
        static WiniumDriver driver1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        umMetodo = new MetodosSelenium();
        umMercadoLivre = new MercadoLivre();
       
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        
        driver = new ChromeDriver();
        
        String url = "https://www.mercadolivre.com.br";
             
        
        try {

            
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath("C:\\Windows\\System32\\notepad.exe");
            
            try {
              driver1 = new WiniumDriver(new URL("http://localhost:9999"), options);
              
            } catch (Exception e) {
                e.printStackTrace();;
            }
           
          //  driver1.findElementByClassName("Edit").sendKeys("Marcos, o Famoso borra Linguiça, mais conhecido como cabeça de fimose!!");
            
            umMetodo.type(driver1, "Edit", "Marcos, o Famoso borra Linguiça, mais conhecido como cabeça de fimose!!");
            System.out.println(umMetodo.getText(driver1, "Edit"));


//driver1.close();            
            
            
           umMetodo.setBaseUrl(url);
	   umMetodo.maximiza(driver);
          
          //1 - Realizar uma pesquisa no site do mercado livre e imprimir SOMENTE título e valor dos CINCO primeiros resultados.
         
           umMercadoLivre.realizaPesquisa(driver, umMetodo, "Star Wars");
           umMercadoLivre.setDadosMercadoLivre(driver, umMetodo, 5);
           listaMercadoLivre = umMercadoLivre.retornaListaMercadolivre();
         
            for (int i = 0; i < listaMercadoLivre.size(); i++) {
                System.out.println(listaMercadoLivre.get(i));
            }
           
          //2 - Realizar uma pesquisa no site do mercado livre que contenha paginação, tirar um print do penúltimo anuncio da segunda página. 
          
           umMercadoLivre.realizaPesquisa(driver, umMetodo, "Star Wars");
           umMercadoLivre.tiraPrintPenultimoProduto(driver, umMetodo);
      
           
           driver.close();
           
        } catch (Exception e) {
            System.err.print(e);
            umMetodo.setErro(true);
            umMetodo.setLogErro("Não foi possível inicar o driver!!");
            
        }
        
        
        
        
    }
    
}
