# language: pt

Funcionalidade: Agendar Exame Admissional

  Contexto:  AgendarExameAdmissional
  
    Dado que eu esteja logado e que ja tenha enviado os documentos para admissao, adicionado os Dados Bancarios e cadastrado os Beneficios
      | CPF   |           28612091004 |
      | Senha | @TesteAutomacaoAfya22 |
    Entao o app apresenta a tela para confirmar o agendamento do exame
    
   
  Cenario: Cadastrar Exame Admissional 
    Quando aciono o comando para confirmar o agendamento
    Entao o app apresenta a tela para confirmar o agendamento
    
      | Data do exame      |  dd.mm.aa             |
      | Nome da Clinica    |  Clinica Automacao    |
      | Hora               |  hh:mm                |
      | Endereco           |  Rua da Automacao 999 |
      | Instrucoes         |  Leve um documento com foto para o local do exame |
      
     Quando aciono o comando para aceitar a disponibilidade nesta data
     Entao o app apresenta o exame agendado com o texto "Exame agendado"
     E aciono o comando para ir para a home para confirmar o agendamento
     E confirme o agendamento com os dados abaixo
      | Data do exame      |  dd.mm.aa             |
      | Nome da Clinica    |  Clinica Automacao    |
      | Endereco           |  Rua da Automacao 999 |
     
     Quando anexo o exame e confirmo 
     Entao o app apresenta a tela do exame enviado "exame foi enviado"
     E aciono o comando para retomar a tela home do app
     E apresenta a informacao que o exame esta sendo analisado "Analisando o comprovante de exame, em breve iremos te atualizar"
     E apos a analise e aprovacao o app apresenta a tela com a informacao "Exame admissional Realizado com sucesso"
     
     