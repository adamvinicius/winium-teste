package com.metodos;



import java.util.Calendar;

//import com.Selenium.CamposSelenium;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
//import java.util.Set;
//import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import org.openqa.selenium.Alert;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.xalan.xsltc.runtime.BasisLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

public class MetodosSelenium  {
        public static Date data = new Date();
        public static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        public int id_execucao_robo;
        
        public Set<String> testes;
        public String possui_erro = "";
        
        
        public void setErro(boolean _erro){
            erro = _erro;
        }
        public String getIP() throws UnknownHostException{
            InetAddress ia = null;
            
            ia = InetAddress.getLocalHost();
            String ip = ia.getHostAddress();
            return  ip;
                   
        }
            
                    
            
            
        
        public String addMes(String _data, int qtd) throws ParseException {
            
            Date data_ano = (Date)formatador.parse(_data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(data_ano);
            cal.add(Calendar.MONTH, qtd);
            
            
            
            return formatador.format(cal.getTime());
	}
        
        public String addDia(String _data, int qtd) throws ParseException {
            
            Date data_ano = (Date)formatador.parse(_data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(data_ano);
            cal.add(Calendar.DAY_OF_MONTH, qtd);
            
            
            return formatador.format(cal.getTime());
	}
        
        public void setIdExecucaoRobo(int _id_execucao_robo){
            id_execucao_robo = _id_execucao_robo;
        }
        
        public int getIdExecucaoRobo(){
            return id_execucao_robo;
        }
        
        public String addAno(String _data, int qtd) throws ParseException {
            
            Date data_ano = (Date)formatador.parse(_data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(data_ano);
            cal.add(Calendar.YEAR, qtd);
            
            
            return formatador.format(cal.getTime());
	}
        
        public void Sair(WebDriver driver){
            click(driver, "//div[@id='barra_informativa']/span[4]/a");
        }
        
	private String baseUrl;
	private int posicao = 0;
	private int tamanho;
	private StringBuffer verificationErrors = new StringBuffer();
	private int id_log = 0;
	//private CamposSelenium campos_selenium;
                public boolean erro = false;
                private String scriptAtual;
                private String versaoSistema;
                private String log_erro;
                private int print_erro = 0;
                public boolean erro_execucao = false;
	// private boolean acceptNextAlert = true;
        
        private static String data_atual = formatador.format(data);       
        
        public void setBaseUrl(String _baseUrl){
            baseUrl = _baseUrl;
        }
                
        public int getPrintErro(){
            return print_erro;
        }
                
        public void setVersaoSistema(WebDriver driver){
                erro = false;
            
                   versaoSistema = getText(driver, "nota_rodape");
                  

        }
        
        public String getDataAtual(){
            return data_atual;
        }
        
        public void executaPrint(WebDriver driver, String caminho){
            
            
            if(print_erro == 0){
                
            
            
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(scrFile, new File(caminho+"/Selenium"+scrFile.getName()));
                } catch (IOException ex) {
                    Logger.getLogger(MetodosSelenium.class.getName()).log(Level.SEVERE, null, ex);
                }

             



             
                

                

                
            }

            
        }

        public String getVersaoSistema(){
            return versaoSistema;
        }

        public void setLogErro(String _log_erro){
                log_erro = _log_erro;
        }

        public String getLogErro(){
                return log_erro;
        }
        
        public void setTestes(Set<String> _testes){
            testes = _testes;
        }

        public void setTesteAtual(String _scriptAtual){
                    scriptAtual = _scriptAtual;
                   
                    possui_erro = "";
                    
                    erro = false;
                    
                    
                    if(!testes.isEmpty()){
                        
                        if(testes.contains(_scriptAtual)){
                            erro = false;
                        }else{
                            erro = true;
                            possui_erro = "nao";
                        }
                    }
                    
                    
                   
                    
                    
        }
        public String getTesteAtual(){
                    return scriptAtual;
        }
	public void setTamanho(int _tamanho) {
		tamanho = _tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getIdLog() {
		return id_log;
	}

	public void setIdLog(int _id_log) {
		id_log = _id_log;
	}

	public void closeAlert(WebDriver driver) {
                                if(isAlertPresent(driver))
                                {
                                        Alert alert = driver.switchTo().alert();
                                        String alertText = alert.getText();
                                        setLogErro(alertText);
                                        erro = true;
                                        alert.accept();
                                }
	}
        
        public void closeAlertSemErro(WebDriver driver) {
            if(erro != true){
                
           
                                if(isAlertPresent(driver))
                                {
                                        Alert alert = driver.switchTo().alert();
                                        
                                        alert.accept();
                                }
                                else{
                                    String alertText = "alert n�o encontrado!!, funcao closeAlertSemErro";
                                    setLogErro(alertText);
                                    erro = true;
                                }
            }
        }

	public String retornaFormatacaoNumero(String numero) {
		return String.format("%.2f", Double.parseDouble(numero)).replace(",",
				".");
	}

	public boolean in_array(String valor, String[] vetor) {
		boolean retorno = false;

		for (String x : vetor) {
			if (x.equals(valor))
				retorno = true;
		}

		return retorno;
	}

	public boolean in_array(int valor, int[] vetor) {
		boolean retorno = false;

		for (int x : vetor) {
			if (x == valor)
				retorno = true;
		}

		return retorno;
	}

	public void setUp(String _baseUrl, WebDriver driver) throws Exception {
		// driver = new FirefoxDriver();
		baseUrl = _baseUrl;
		alteraTempo(driver, 0);

	}

	public String getBaseUrl() {
		return baseUrl;
	}

	

	public void tearDown(WebDriver driver) throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			System.out.println(verificationErrorString);
                        erro = true;
                       // fail(verificationErrorString);
		} else {
			System.out.println("Teste Realizado");

		}
	}

	public void setPosicao(int _posicao) {
		posicao = _posicao;
	}

	public int getPosicao() {
		return posicao;
	}

	public void login(WebDriver driver, String login, String senha,
			String modulo) throws Exception {
		type(driver, "F_usuario", login);
		type(driver, "F_senha", senha);
		// driver.findElement(By.name("F_usuario")).sendKeys("conam");
		// driver.findElement(By.id("F_senha")).sendKeys("t");
		new Select(driver.findElement(By.id("F_sistema")))
				.selectByVisibleText(modulo);
		click(driver, "//input[@value='Entrar']");

	}

	public void maximiza(WebDriver driver) {
            
		driver.get(baseUrl + "/");
            
		driver.manage().window().maximize();

	}

	public void alteraTempo(WebDriver driver, int segundos) {
		driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
	}

	public void type(WebDriver driver, String campo, String valor)
        {
           
            if(erro == false)
            {
		try {
			//valor = StringEscapeUtils.unescapeJava(valor);
			valor = valor.replace("\t", "");
			//valor = StringEscapeUtils.unescapeJava(valor);
		} catch (Exception e) {

		}
		int s;
		for (s = 0; s < 10; s++) {
                        System.out.println("entrou no for: "+s);
			if (isElementPresent(driver, By.id(campo))) {
				if (!getValue(driver, campo).equals(valor)) {
                                    
                                    try {
                                        driver.findElement(By.id(campo)).clear();
					driver.findElement(By.id(campo)).sendKeys(valor);
                                    } catch (Exception e) {
                                        
                                        setLogErro("O campo "+campo+" nao é digitavel!");
                                        erro = true;
                                    }
                                        
					
				}
				break;
			}else if (isElementPresent(driver, By.className(campo))){
                            try {
                                    driver.findElement(By.className(campo)).clear();
                                    driver.findElement(By.className(campo)).sendKeys(valor);
                                } catch (Exception e) {

                                    setLogErro("O campo "+campo+" nao � digitavel!");
                                    erro = true;
                                }
                            break;
                        } else if (isElementPresent(driver, By.name(campo))) {
				if (!getValue(driver, campo).equals(valor)) {
                                    
                                    try {
                                        driver.findElement(By.name(campo)).clear();
					driver.findElement(By.name(campo)).sendKeys(valor);
                                    } catch (Exception e) {
                                        
                                        setLogErro("O campo "+campo+" nao � digitavel!");
                                        erro = true;
                                    }
                                    
					
				}
				break;
			} else if (isElementPresent(driver, By.xpath(campo))) {
				if (!getValue(driver, campo).equals(valor)) {
                                    try {
                                        driver.findElement(By.xpath(campo)).clear();
					driver.findElement(By.xpath(campo)).sendKeys(valor);
                                    } catch (Exception e) {
                                        
                                        setLogErro("O campo "+campo+" nao � digitavel!");
                                        erro = true;
                                    }
                                    
					
				}
				break;
			} else if (isElementPresent(driver, By.cssSelector(campo))) {
				if (!getValue(driver, campo).equals(valor)) {
                                    
                                    try {
                                        driver.findElement(By.cssSelector(campo)).clear();
					driver.findElement(By.cssSelector(campo)).sendKeys(valor);
                                    } catch (Exception e) {
                                        
                                        setLogErro("O campo "+campo+" nao � digitavel!");
                                        erro = true;
                                    }
                                    
					
				}
				break;
			}
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		if (s >= 10) {
			                 setLogErro("Campo type: "+campo+" Inexistente");
			 
                                                
                         erro = true;
                                                
			 
			//driver.findElement(By.id(campo)).clear();
			//driver.findElement(By.id(campo)).sendKeys(valor);
		}
            }
	}
        
        public void typeUpload(WebDriver driver, String campo, String caminho) throws Exception 
        {
            
            click(driver, campo);
            StringSelection path = new StringSelection("../../../../.."+caminho);//the code needed to be pasted in the second dialog box 
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

            Thread.sleep(2000);//Sleep time to detect the window dialog box

            //Pasting the path in the File name field
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            //To click the Open button so as to upload file
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        
	public void typeArquivo(WebDriver driver, String campo, String valor)
			throws Exception {
		int s;
		for (s = 0; s < 10; s++) {
			if (isElementPresent(driver, By.id(campo))) {

				driver.findElement(By.id(campo)).sendKeys(valor);
				break;
			} else if (isElementPresent(driver, By.name(campo))) {

				driver.findElement(By.name(campo)).sendKeys(valor);
				break;
			}   else if (isElementPresent(driver, By.name(campo))) {
				
					driver.findElement(By.name(campo)).sendKeys(valor);
				break;
                        }
                        
                        else if (isElementPresent(driver, By.xpath(campo))) {

				driver.findElement(By.xpath(campo)).sendKeys(valor);
				break;
			} else if (isElementPresent(driver, By.cssSelector(campo))) {

				driver.findElement(By.cssSelector(campo)).sendKeys(valor);
				break;
			}
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void select(WebDriver driver, String campo, String valor) {
            if(erro == false)
            {
		if (isElementPresent(driver, By.id(campo))) {
			new Select(driver.findElement(By.id(campo)))
					.selectByVisibleText(valor);
		} else if (isElementPresent(driver, By.xpath(campo))) {
			new Select(driver.findElement(By.xpath(campo)))
					.selectByVisibleText(valor);
		}
                else erro = true;
                
            }
	}

	public void comparaSelect(WebDriver driver, String campo, String[] valores) {
            if(erro == false)
            {        
                String[] vetor = getText(driver, campo).split("\n");
                if(erro == false)
                {    
                    for (int i = 0; i < vetor.length; i++) {
                            String achou = "nao";
                            for (int x = 0; x < valores.length; x++) {
                                    if (vetor[i].equals(valores[x])) {
                                            achou = "sim";
                                            break;
                                    }
                            }
                            if (achou.equals("nao"))
                                    System.out
                                                    .println("O valor da tela no campo " + campo + ": "
                                                                    + vetor[i]
                                                                    + " Nao foi encontrado nos dados informados");
                            else
                                    achou = "sim";
                    }

                    for (int i = 0; i < valores.length; i++) {
                            String achou = "nao";
                            for (int x = 0; x < vetor.length; x++) {
                                    if (valores[i].equals(vetor[x])) {
                                            achou = "sim";
                                            break;
                                    }
                            }
                            if (achou.equals("nao"))
                                    System.out.println("O valor: " + valores[i]
                                                    + " nao foi encontrado no campo: " + campo);
                            else
                                    achou = "sim";
                    }
                }
            }
	}

	public void comparaText(WebDriver driver, String campo, String valor) {
		if (!getText(driver, campo).trim().equals(valor))
                                {
                                        if(erro == false)
			System.out.println("Campo: " + campo + ", Valor Esperado: " + valor
					+ " Valor encontrado: " + getText(driver, campo));
                                }
	}

	public void comparaValue(WebDriver driver, String campo, String valor) {
		if (!getValue(driver, campo).equals(valor))
                                        if(erro == false)
			System.out.println("Campo: " + campo + ", Valor Esperado: " + valor
					+ " Valor encontrado: " + getValue(driver, campo));

	}

	public void comparaExclusao(WebDriver driver) {
		String campo = "resultado_busca";
		if (!getText(driver, campo).equals("Resultado: 0 registro(s) em 0 p�gina(s)."))
                                        if(erro == false)
			System.out.print("Valor Esperado: Resultado: 0 registro(s) em 0 p�gina(s). Valor encontrado: "
							+ getText(driver, campo));
	}

	public String getText(WebDriver driver, String campo) {
                    String msg_erro;
                    if(erro == false)
                    {
                        int a = 2;
                        if (isElementPresent(driver, By.xpath(campo)))
                                return driver.findElement(By.xpath(campo)).getText();
                        else if (isElementPresent(driver, By.id(campo)))
                                return driver.findElement(By.id(campo)).getText();
                        else if (isElementPresent(driver, By.className(campo)))
                                return driver.findElement(By.className(campo)).getText();
                        else if (isElementPresent(driver, By.name(campo)))
                                return driver.findElement(By.name(campo)).getText();
                        else {
                                if (isElementPresent(driver, By.xpath("//div[@id='msg_erros']/a"))) {
                                        if (isElementPresent(driver,By.xpath("//div[@id='msg_erros']/a"))) {
                                                
                                                msg_erro = "Erros encontrados: "+ driver.findElement(By.xpath("//div[@id='msg_erros']/a")).getText();
                                                
                                                while (isElementPresent(driver,By.xpath("//div[@id='msg_erros']/a[" + a + "]"))) {
                                                        if(!msg_erro.equals(""))
                                                            msg_erro += " - ";
                                                        msg_erro += driver.findElement(By.xpath("//div[@id='msg_erros']/a["+ a + "]")).getText();

                                                        a++;
                                                }
                                                //System.exit(1);
                                                erro = true;
                                        }
                                }
                                else{
                                    setLogErro("Campo text: " + campo + " Inexistente");
                                
                                    //System.exit(1);
                                    erro = true;
                                }
                        }
                        return campo;
                    }
                    else return "";
	}

	public String getValue(WebDriver driver, String campo) {
                    if(erro == false)
                    {
                        if (isElementPresent(driver, By.id(campo)))
                                return driver.findElement(By.id(campo)).getAttribute("value");
                        else if (isElementPresent(driver, By.name(campo)))
                                return driver.findElement(By.name(campo)).getAttribute("value");
                        
                        else if (isElementPresent(driver, By.xpath(campo)))
                                return driver.findElement(By.xpath(campo)).getAttribute("value");

                        else if (isElementPresent(driver, By.className(campo)))
                                return driver.findElement(By.className(campo))
                                                .getAttribute("value");
                        
                        else {
                                setLogErro("Campo value: " + campo + " Inexistente");
                                
                                //System.exit(1);
                                erro = true;
                        }
                        return campo;
                    }
                    else return "";
	}

	public void click(WebDriver driver, String campo) {
                    if(erro == false)
                    {
                        int s;
                        for (s = 0; s < 10; s++) {
                                if (isElementPresent(driver, By.xpath(campo))) {
                                    try{
                                        driver.findElement(By.xpath(campo)).click();
                                    } catch (Exception e) {
                                       try {
                                                WebElement element = driver.findElement(By.xpath(campo));
                                                Actions action = new Actions(driver);
                                                action.moveToElement(element).click().perform();

                                            } catch (Exception er) {
                                                try {
                                                
                                                    JavascriptExecutor js =(JavascriptExecutor)driver;
                                                    js.executeScript("window.scrollTo(0,"+driver.findElement(By.xpath(campo)).getLocation().x+")");
                                                    driver.findElement(By.xpath(campo)).click();
                                                } catch (Exception err) {
                                               
                                                    setLogErro("botao/link: javascript " + campo + " n�o � clicavel");

                                                    erro = true;
                                                }
                                            
                                           }
                                           
                                    }
                                       
                                     
                                        
                                        break;
                                } else if (isElementPresent(driver, By.id(campo))) {
                                            try {
                                                driver.findElement(By.id(campo)).click();
                                    } catch (Exception e) {
                                        try {
                                                WebElement element = driver.findElement(By.id(campo));
                                                Actions action = new Actions(driver);
                                                action.moveToElement(element).click().perform();

                                            } catch (Exception er) {
                                                try {
                                                
                                                JavascriptExecutor js =(JavascriptExecutor)driver;
                                                js.executeScript("window.scrollTo(0,"+driver.findElement(By.id(campo)).getLocation().x+")");
                                                driver.findElement(By.id(campo)).click();
                                                } catch (Exception err) {
                                                    setLogErro("botao/link: id javascript " + campo + " n�o � clicavel");

                                                    erro = true;

                                                }
                                                
                                                
                                            }
                                                
                                            
                                            
                                                                        
                                        

                                       
                                    }
                                            
                                        
                                            
                                        break;
                                } else if (isElementPresent(driver, By.name(campo))) {
                                    try{
                                        driver.findElement(By.name(campo)).click();
                                     } catch (Exception e) {
                                                                          
                                        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+driver.findElement(By.name(campo)).getLocation().y+")");

                                        driver.findElement(By.name(campo)).click();
                                       
                                    }
                                    
                                    break;
                                /*} else if (isElementPresent(driver, By.cssSelector(campo))) {
                                        driver.findElement(By.cssSelector(campo)).click();
                                        break;
                                */} else if (isElementPresent(driver, By.linkText(campo))) {
                                        try{
                                                                                
                                            driver.findElement(By.linkText(campo)).click();
                                        } catch (Exception e) {
                                                                          
                                            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+driver.findElement(By.linkText(campo)).getLocation().y+")");

                                            driver.findElement(By.linkText(campo)).click();
                                       
                                         }
                                        break;
                                }
                                try {
                                        Thread.sleep(1000);

                                } catch (Exception e) {
                                        System.out.println(e);
                                }

                        }
                        if (s >= 10) {
                                setLogErro("botao/link: " + campo + "Inexistente");
                                
                                erro = true;
                                //System.exit(1);
                        }
                    }
	}

	public void clicaPopUp(WebDriver driver, String campo, String janela) {
                    
                    if(erro == false)
                    {
                        click(driver, campo);
                        if(erro == false)
                        {
                            String janela_principal = driver.getWindowHandle();

                            for (String winHandle : driver.getWindowHandles()) {
                                    if (!janela_principal.equals(winHandle)) {
                                            // System.out.println("'"+winHandle+"'");

                                            driver.switchTo().window(winHandle);

                                    }
                            }
                        }
                    }
	}

	public void clicaPopUp(WebDriver driver, String campo) {
                    if(erro == false)
                    {
                        click(driver, campo);
                        if(erro == false)
                        {
                            String janela_principal = driver.getWindowHandle();

                            for (String winHandle : driver.getWindowHandles()) {
                                    if (!janela_principal.equals(winHandle)) {
                                            // System.out.println("'"+winHandle+"'");

                                            driver.switchTo().window(winHandle);

                                    }
                            }
                        }
                    }
	}

	public void lupa(WebDriver driver, String dados) {
                        if(erro == false)
                        {

                            click(driver, "//input[@type='image']");
                            
                            click(driver, dados);
                            if(erro == true)
                            {
                                driver.close();

                            }
                            driver.switchTo().window("");

                        }
	}

	public void FechaPopUp(WebDriver driver) {
		driver.switchTo().window("");

	}

	public void confirma(WebDriver driver) {
            if(erro == false)
            {
		if (isElementPresent(driver,
				By.xpath("//img[@onclick='efetivar_parcelamento( \"Ok\" )']")))
			click(driver, "//img[@onclick='efetivar_parcelamento( \"Ok\" )']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='confirmar()']")))
			click(driver, "//img[@onclick='confirmar()']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='submeter_formulario()']")))
			click(driver, "//img[@onclick='submeter_formulario()']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='faux_frm_pessoa_fisica.concluir()']")))
			click(driver, "//img[@onclick='faux_frm_pessoa_fisica.concluir()']");

		else if (isElementPresent(
				driver,
				By.xpath("//img[@onclick='faux_frm_pessoa_juridica.concluir()']")))
			click(driver,
					"//img[@onclick='faux_frm_pessoa_juridica.concluir()']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='faux_frmMotivo.concluir()']")))
			click(driver, "//img[@onclick='faux_frmMotivo.concluir()']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='efetivar_cancelamento()']")))
			click(driver, "//img[@onclick='efetivar_cancelamento()']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='submeter_itens()']")))
			click(driver, "//img[@onclick='submeter_itens()']");

		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='remover()']")))
			click(driver, "//img[@onclick='remover()']");
		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='faux_frmUfMunicipio.concluir()']")))
			click(driver, "//img[@onclick='faux_frmUfMunicipio.concluir()']");
		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='confirmar_alteracao();']")))
			click(driver, "//img[@onclick='confirmar_alteracao();']");
		else if (isElementPresent(driver,
				By.xpath("//img[@onclick='re_submeter_formulario()']")))
			click(driver, "//img[@onclick='re_submeter_formulario()']");

		else {
                                                setLogErro("Elemento de confirma��o Inexistente");
			
			//System.exit(1);
                                                erro = true;
		}
                              /*
                                for (int second = 0;; second++) {
                                        if (second >= 60)
                                        {
                                            setLogErro("Erro ao confirmar!!");

                                            erro = true;
                                            break;
                                            //fail("Nao foi encontrado mesmo");
                                        }
                                        try {
                                                if (driver.findElement(By.id("msg_sucesso")).isDisplayed())
                                                        break;
                                        } catch (Exception e) {
                                        }
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                }*/
                                
                                
		if (!isElementPresent(driver, "msg_sucesso")) {
                                               // closeAlert(driver);
                                                String msg_erro = "";
                                                int a = 2;
                                               if (isElementPresent(driver,By.xpath("//div[@id='msg_erros']/a"))) {
                                                
                                                    msg_erro = "Erros encontrados: "+ driver.findElement(By.xpath("//div[@id='msg_erros']/a")).getText();

                                                    while (isElementPresent(driver,By.xpath("//div[@id='msg_erros']/a[" + a + "]"))) {
                                                            if(!msg_erro.equals(""))
                                                                msg_erro += " - ";
                                                            msg_erro += driver.findElement(By.xpath("//div[@id='msg_erros']/a["+ a + "]")).getText();

                                                            a++;
                                                    }
                                                    //System.exit(1);
                                                    setLogErro(msg_erro);
                                                    erro = true;
                                                }
                                               else
                                               {
                                                    setLogErro("Erro ao confirmar!!");
                            
                                                    erro = true;
                                               }
		}
                    
            }
	}

	public void aguarda_elemento(WebDriver driver, String campo)
			throws InterruptedException {
            if(erro == false)
            {
		for (int second = 0;; second++) {
			if (second >= 60)
                        {
                            setLogErro("Campo "+campo+" Nao foi encontrado!");
                            
                            erro = true;
                            break;
                            //fail("Nao foi encontrado mesmo");
                        }
                        try {
				if (driver.findElement(By.name(campo)).isDisplayed())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);

		}
            }
	}
/*
	public void ExibeComparaElementos(WebDriver driver) {
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		List<WebElement> selects = driver.findElements(By.tagName("select"));
		List<WebElement> textareas = driver
				.findElements(By.tagName("textarea"));

		List<CamposSelenium> selenium = new ArrayList<CamposSelenium>();
		List<CamposSelenium> selenium2 = new ArrayList<CamposSelenium>();

		for (WebElement input : inputs) {
			if (input.isDisplayed() && input.isEnabled()) {

				campos_selenium = new CamposSelenium(
						"umMetodo.comparaValue(driver,\""
								+ input.getAttribute("id") + "\",json.getString(\"\"));", input
								.getLocation().getX(), input.getLocation()
								.getY(), "input", input.getAttribute("id"));
				selenium.add(campos_selenium);
			}
		}

		for (WebElement select : selects) {
			if (select.isDisplayed() && select.isEnabled()) {
				campos_selenium = new CamposSelenium(
						"umMetodo.comparaValue(driver,\""
								+ select.getAttribute("id") + "\",json.getString(\"\"));",
						select.getLocation().getX(), select.getLocation()
								.getY(), "select", select.getAttribute("id"));
				selenium.add(campos_selenium);
			}
		}

		for (WebElement textarea : textareas) {
			if (textarea.isDisplayed() && textarea.isEnabled()) {
				campos_selenium = new CamposSelenium(
						"umMetodo.comparaValue(driver,\""
								+ textarea.getAttribute("name") + "\",json.getString(\"\"));",
						textarea.getLocation().getX(), textarea.getLocation()
								.getY(), "textarea",
						textarea.getAttribute("name"));
				selenium.add(campos_selenium);
			}
		}
		CamposSelenium menor_posicao = new CamposSelenium();
		while (selenium.size() > 1) {
			for (int x = 0; x < selenium.size(); x++) {

				if (x == 0) {
					menor_posicao = selenium.get(x);
				} else {
					if (menor_posicao.getPosicao_y() > selenium.get(x)
							.getPosicao_y()) {
						menor_posicao = selenium.get(x);
					} else if (menor_posicao.getPosicao_y() == selenium.get(x)
							.getPosicao_y()
							&& menor_posicao.getPosicao_x() > selenium.get(x)
									.getPosicao_x()) {
						menor_posicao = selenium.get(x);
					}
				}
			}

			System.out.println(menor_posicao.getCampo());
			selenium.remove(menor_posicao);

		}

		System.out.println(selenium.get(0).getCampo());
		selenium.remove(selenium.get(0));

	}

	public void ExibeElementos(WebDriver driver) throws Exception {

		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		List<WebElement> selects = driver.findElements(By.tagName("select"));
		List<WebElement> textareas = driver
				.findElements(By.tagName("textarea"));

		List<WebElement> imgs = driver.findElements(By.tagName("img"));
		List<WebElement> imgs1 = new ArrayList<WebElement>();

		for (WebElement img : imgs) {
			String[] vetor = img.getAttribute("src").split("/");
			if (vetor[vetor.length - 1].equals("lupa.gif")) {
				imgs1.add(img);

				// System.out.println(img.getAttribute("src"));
			}
		}

		List<CamposSelenium> selenium = new ArrayList<CamposSelenium>();
		List<CamposSelenium> selenium2 = new ArrayList<CamposSelenium>();

		for (WebElement input : inputs) {
			if (input.isDisplayed() && input.isEnabled()) {

				try {
					type(driver, input.getAttribute("id"), "");
					campos_selenium = new CamposSelenium(
							"umMetodo.type(driver,\""
									+ input.getAttribute("id") + "\",json.getString(\"\"));",
							input.getLocation().getX(), input.getLocation()
									.getY(), "input", input.getAttribute("id"));

					selenium.add(campos_selenium);
				} catch (Exception e) {

				}

			}
		}

		for (WebElement select : selects) {
			if (select.isDisplayed() && select.isEnabled()) {
				campos_selenium = new CamposSelenium(
						"umMetodo.select(driver,\"" + select.getAttribute("id")
								+ "\",json.getString(\"\"));", select.getLocation().getX(),
						select.getLocation().getY(), "select",
						select.getAttribute("id"));
				selenium.add(campos_selenium);
			}
		}

		for (WebElement textarea : textareas) {
			if (textarea.isDisplayed() && textarea.isEnabled()) {
				campos_selenium = new CamposSelenium("umMetodo.type(driver,\""
						+ textarea.getAttribute("name") + "\",json.getString(\"\"));", textarea
						.getLocation().getX(), textarea.getLocation().getY(),
						"textarea", textarea.getAttribute("name"));
				selenium.add(campos_selenium);
			}
		}

		List<String> lupas = new ArrayList<String>();

		for (WebElement img : imgs1) {

			campos_selenium = new CamposSelenium("", img.getLocation().getX(),
					img.getLocation().getY(), "lupa", img.getAttribute("id"));

			selenium.add(campos_selenium);

		}

		CamposSelenium menor_posicao = new CamposSelenium();
		while (selenium.size() > 1) {
			for (int x = 0; x < selenium.size(); x++) {

				if (x == 0) {
					menor_posicao = selenium.get(x);
				} else {
					if (menor_posicao.getPosicao_y() > selenium.get(x)
							.getPosicao_y()) {
						menor_posicao = selenium.get(x);
					} else if (menor_posicao.getPosicao_y() == selenium.get(x)
							.getPosicao_y()
							&& menor_posicao.getPosicao_x() > selenium.get(x)
									.getPosicao_x()) {
						menor_posicao = selenium.get(x);
					}
				}
			}

			if (menor_posicao.getTipo().equals("lupa")) {
				int cont = 1;
				for (String lupa : lupas) {
					if (menor_posicao.getCampo_sem_formatacao().equals(lupa))
						cont++;
				}
				lupas.add(menor_posicao.getCampo_sem_formatacao());

				String texto;
				if (cont > 1)
					texto = "\numMetodo.clicaPopUp(driver,\"(//img[@id='"
							+ menor_posicao.getCampo_sem_formatacao() + "'])["
							+ cont + "]\");";

				else
					texto = "\numMetodo.clicaPopUp(driver,\""
							+ menor_posicao.getCampo_sem_formatacao() + "\");";
				menor_posicao.setCampo(texto);

				System.out.println(menor_posicao.getCampo());

				String janela_principal = driver.getWindowHandle();
				// System.out.println(menor_posicao.getCampo_sem_formatacao());
				click(driver, menor_posicao.getCampo_sem_formatacao());

				for (String winHandle : driver.getWindowHandles()) {

					if (!janela_principal.equals(winHandle)) {
						// System.out.println("'"+winHandle+"'");

						driver.switchTo().window(winHandle);
						// type(driver,"frm_mcc_tipo_falecido_descricao",
						// "AAA");
						List<WebElement> inputsPopUp = driver.findElements(By
								.tagName("input"));

						WebElement inputPopUp1;
						if (inputsPopUp.size() == 0) {
							inputPopUp1 = driver.findElement(By
									.tagName("input"));
							// System.out.println("\tumMetodo.type(driver,\""+inputPopUp1.getAttribute("id")+"\",json.getString(\"\"));");
						}

						inputsPopUp = driver.findElements(By.tagName("input"));
						for (WebElement inputPopUp : inputsPopUp) {

							if (inputPopUp.isDisplayed()
									&& inputPopUp.isEnabled()) {
								if (!inputPopUp.getAttribute("id").equals(""))
									System.out
											.println("\tumMetodo.type(driver,\""
													+ inputPopUp
															.getAttribute("id")
													+ "\",json.getString(\"\"));");
							}
						}

					}

				}
				System.out.println("umMetodo.lupa(driver,json.getString(\"\"));\n");
				imgs = driver.findElements(By.tagName("img"));
				for (WebElement img1 : imgs) {
					String[] vetor = img1.getAttribute("src").split("/");

					if (vetor[vetor.length - 1].equals("fechar.gif")) {
						img1.click();
						break;
					}
				}

				driver.switchTo().window("");

			} else
				System.out.println(menor_posicao.getCampo());
			selenium.remove(menor_posicao);

		}

		System.out.println(selenium.get(0).getCampo());
		selenium.remove(selenium.get(0));

	}*/

	public void aguarda_value(WebDriver driver, String campo)
			throws InterruptedException {
            if(erro == false)
            {
		click(driver, campo);
                              //  closeAlert(driver);
		for (int second = 0;; second++) {
			if (second >= 40)
                        {
                                setLogErro("Campo " + campo + " N�o foi preenchido");
		
                                erro = true;
                                break;
                                //fail("Campo " + campo + " N�o foi preenchido");
                        }
			if (!driver.findElement(By.id(campo)).getAttribute("value")
					.equals("")) {
				break;
			}

			Thread.sleep(500);
		}
                        
            }
	}

	public boolean isElementPresent(WebDriver driver, String campo) {
                        
		if (isElementPresent(driver, By.xpath(campo)))
			return true;
		else if (isElementPresent(driver, By.id(campo)))
			return true;
		else if (isElementPresent(driver, By.name(campo)))
			return true;
		else if (isElementPresent(driver, By.linkText(campo)))
			return true;
		else
			return false;
	}

	public boolean isElementPresent(WebDriver driver, By by) {
           
		try {
			driver.findElement(by);
                     
			return true;
		} catch (NoSuchElementException e) {
                     
			return false;
		}
	}

	
	 private boolean isAlertPresent(WebDriver driver) { 
                    try {
                        driver.switchTo().alert(); 
                        return true; 
                    } catch (Exception e){ 
                            return false; 
                        } 
                    }
	 /* 
	 private String closeAlertAndGetItsText(WebDriver driver) { try { Alert
	 * alert = driver.switchTo().alert(); String alertText = alert.getText(); if
	 * (acceptNextAlert) { alert.accept(); } else { alert.dismiss(); } return
	 * alertText; } finally { acceptNextAlert = true; } }
	 */

	
}
