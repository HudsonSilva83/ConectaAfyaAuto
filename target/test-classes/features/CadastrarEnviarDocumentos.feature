# language: pt

@UC01-testeFuncionalidade
Funcionalidade: Enviar Documentos de Admissao
Como usuario 
Eu quero me cadastrar na Plataforma do Aplicativo Conecta Afya e enviar meus Documentos para finalizar meu processo de Admissao.

@UC01-testeCenario
Cenario: Cadastrar e Enviar Documentos de admissao com sucesso

Dado que fiz meu cadastro na plataforma do Conecta Afya
Quando iniciar o envio dos documentos
E preencher os dados do documento eSocial
E preencher os dados do documento de Identidade
E preencher os dados do documento de Carteira de Trabalho
E preencher os dados de Endereco
E preencher os dados do Estado Civil
E preencher os dados do PIS
E preencher os dados do Titulo Eleitor
E preencher os dados do CertifiCado de Reservista
E preencher os dados do Diploma Escolaridade
E preencher os dados de Dependentes
E acionar para finalizar o envio dos Documentos 
Quando aceitar o termo e finalizar
Entao os documentos sao enviados com sucesso.