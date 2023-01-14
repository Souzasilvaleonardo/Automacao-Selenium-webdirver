# language: pt

@login
Funcionalidade: Login
  Eu como usuário do sistema
  Quero fazer login
  Para fazer uma compra no site

  Contexto: Acessar aplicação
    Dado que estou na tela de login

  @login-sucesso
  Cenário: Login com sucesso
    Quando preencho login "leonardo.ss@qazando.com" e senha "1234567"
    E clico em login
    Então sou logado na aplicação


  @login-campos-vazios
  Esquema do Cenário: Validar mensagem: <mensagem>, no login inválido
    Quando preencho login "<user>" e senha "<password>"
    E clico em login
    Então vejo mensagem "<mensagem>" de campo não preenchido

    Exemplos:
      | user            | password | mensagem         |
      |                 | 1234567  | E-mail inválido. |
      | email@email.com |          | Senha inválida.  |
      |                 |          | E-mail inválido. |






