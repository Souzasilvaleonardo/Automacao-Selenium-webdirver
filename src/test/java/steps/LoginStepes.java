package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.LoginPage;
import runner.RunCucumber;


public class LoginStepes extends RunCucumber {

    LoginPage LoginPage = new LoginPage();

    @Dado("^que estou na tela de login$")
    public void que_estou_na_tela_de_login() {
        System.out.println(System.getProperty("browser"));

        initDriver();
        LoginPage.acessarAplicacao();
        LoginPage.acessarTelaLogin();
    }

    @Quando("^preencho login \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void preencho_login_e_senha(String email, String senha) {
        LoginPage.preencheEmail(email);
        LoginPage.preencherSenha(senha);
    }

    @Quando("^clico em login$")
    public void clico_em_login() {

        LoginPage.clicarLogin();
    }

    @Então("^sou logado na aplicação$")
    public void sou_logado_na_aplicação() {

        LoginPage.verificaLoginSucesso();
    }

    @Então("^vejo mensagem \"([^\"]*)\" de campo não preenchido$")
    public void vejo_mensagem_de_campo_não_preenchido(String message) {

        LoginPage.verificaCampoVazio(message);
    }

    @Quando("^acesso a tela de cadastro do usuário$")
    public void acesso_a_tela_de_cadastro_do_usuário() {
        LoginPage.acessarTelaCdastro();

    }

    @Dado("^que estou loga na aplicação com user \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void que_estou_loga_na_aplicação_com_user_e_senha(String email, String senha) {
        initDriver();
        LoginPage.acessarAplicacao();
        LoginPage.acessarTelaLogin();
        LoginPage.preencheEmail(email);
        LoginPage.preencherSenha(senha);
        LoginPage.clicarLogin();
        LoginPage.verificaLoginSucesso();
    }

}
