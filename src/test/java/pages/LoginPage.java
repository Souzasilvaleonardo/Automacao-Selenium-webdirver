package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.RunCucumber;

public class LoginPage extends RunCucumber {

    //elementos
    private String URL = ("http://automationpratice.com.br/");
    private By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private By campoEmail = By.id("1user");
    private By campoSenha = By.id("password");
    private By botaoFazerLogin = By.id("btnLogin");
    private By loginSuceso = By.id("swal2-title");
    private By verificarCampoVazio = By.className("invalid_input");
    private By botatAcessarCadastro = By.id("createAccount");


    //ações / funções / metódos
    public void acessarAplicacao() {

        getDriver().get(URL);
    }

    public void acessarTelaLogin() {

        getDriver().findElement(botaoAcessarLogin).click();
    }

    public void preencheEmail(String email) {
        getDriver().findElement(campoEmail).sendKeys(email);
//        WebElement campoEmail = getDriver().findElement(By.id("user"));
//        campoEmail.sendKeys(email);
    }

    public void preencherSenha(String senha) {
        getDriver().findElement(campoSenha).sendKeys(senha);
//        WebElement campoSenha = getDriver().findElement(By.id("password"));
//        campoSenha.sendKeys(senha);
    }

    public void clicarLogin() {
        getDriver().findElement(botaoFazerLogin).click();

    }

    public void verificaLoginSucesso() {
        String TextoLoginSucesso = getDriver().findElement(loginSuceso).getText();
        Assert.assertEquals("Os textos não são iguais!!!!", "Login realizado", TextoLoginSucesso);
    }

    public void verificaCampoVazio(String message) {
        String textError = getDriver().findElement(verificarCampoVazio).getText();
        Assert.assertEquals(message, textError);
    }

    public void acessarTelaCdastro() {

        getDriver().findElement(botatAcessarCadastro).click();
    }
}
