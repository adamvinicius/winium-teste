/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumteste;

import com.metodos.MetodosSelenium;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Adam Vinicius
 */
public class MercadoLivre {
    private final List<String> dadosMercadoLivre = new ArrayList<>();
    
    public void setDadosMercadoLivre(WebDriver driver, MetodosSelenium umMetodo, int qtLinhas){
        String titulo = "";
        String preco = "";
        for (int i = 1; i <= qtLinhas; i++) {
           
            if(umMetodo.isElementPresent(driver, "//main/div/div/div/section/ol/li[\"+i+\"]/div/div[2]/div/h2/a/span")){

                titulo = umMetodo.getText(driver, "//main/div/div/div/section/ol/li["+i+"]/div/div[2]/div/h2/a/span"); 
                preco = umMetodo.getText(driver, "//main/div/div/div/section/ol/li["+i+"]/div/div[2]/div/div[1]/div/span[2]");
            
                dadosMercadoLivre.add(titulo + ": R$ "+preco);
            }
          
        }
        
    }
    
    public void tiraPrintPenultimoProduto(WebDriver driver, MetodosSelenium umMetodo){
       
        int i = 1;
        umMetodo.click(driver, "//main/div/div/div/section/div[2]/ul/li[3]/a");
        while (umMetodo.isElementPresent(driver, "//main/div/div/div/section/ol/li["+i+"]/div/div[2]/div/h2/a/span")){
            i++;
        }
        umMetodo.click(driver, "//main/div/div/div/section/ol/li["+(i-2)+"]/div/div[1]/div/div/a/img");
        umMetodo.executaPrint(driver, "C:/Temp");
        System.out.println("Print tirado, se encontra em: C:/Temp");
        
    }
    
    
    
    public void realizaPesquisa(WebDriver driver, MetodosSelenium umMetodo, String vl_pesquisa){
        umMetodo.type(driver, "as_word", vl_pesquisa);
           
        umMetodo.click(driver, "//button[@type='submit']");
    }
    
    
    
    public List<String> retornaListaMercadolivre(){
        return dadosMercadoLivre;
    }
}
