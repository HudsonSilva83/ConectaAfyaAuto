# language: pt

Funcionalidade: Documentos Admissionais

  Contexto:  ValidarDocumentosAdmissionais
  
    Dado que eu esteja logado e que ja tenha enviado os documentos para admissao, adicionado os Dados Bancarios e cadastrado os Beneficios e com exame aprovado
      | CPF   |           28612091004 |
      | Senha | @TesteAutomacaoAfya22 |
    Entao o app apresenta a tela para iniciar a validacao dos documentos Admissional
    Quando aciono o comando para comecar a verificar
    
  @teste 
  Cenario: Validar documentos Admissional (Dados Pessoais) 
    
    Entao o app apresenta a tela para confirmar os dados do RG
    
      | Identidade         |  12281029             |
      | Nascimento         |  01/01/1989           |
      | Estado Civil       |  Solteiro(a)          |
      | Sexo               |  Não-binário          |
      | Nacionalidade      |  Brasileira           |
      | Estado Natal       |  Minas Gerais         |
      | Cidade Natal       |  Belo Horizonte       |
      
      
    E verifico também a tela para confirmar os dados da Carteira de Trabalho   
    
      | Numero                |  7777777              |
      | Serie                 |  01                   |
      | Emissão               |  25/12/2000           |
      | PIS/PASESP            |  1111111111           |
      | Registro Profissional |  -                    |
      
    E verifico também a tela para confirmar os dados do titulo de eleitor   
    
      | Numero             |  111111111111         |
      | Emissão            |  12/03/1993           |
      | UF                 |  MG                   |
      | Zona               |  01                   |
      | Secao              |  02                   |  
      
     E verifico também a tela para confirmar os dados do Grau de instrução
          
       | Educação           | Ensino fundamental incompleto | 
      
     E verifico também a tela para confirmar os dados do Endereco
         
	      | Rua            |  Argelia                 |
	      | Complemento    |  Casa                    |
	      | Numero         |  355                     |
	      | Bairro         |  Boa Vista               |
	      | Cidade         |  BELO HORIZONTE          | 
     
    @teste 
    Cenario: Validar documentos Admissional (Dados do Cargo) 
    
	    Entao o app apresenta a tela para confirmar os dados do Cargo
	    
	      | Cargo              |  ANALISTA DE DADOS PL  |
	      | Area               |  -                     |
	      | Admissiao          |  -                     |
	      | Forma de pagamento |  -                     |
	      | Salario            |  R$ 5.000,00           |
	      | Salario hora       |  -                     |
	      | Jornada            |  -                     |
        | Opcao F            |  -                     | 
        | Horario            |  -                     |
        
        
	   Cenario: Validar documentos Admissional (Dados da empresa) 
    
	    Entao o app apresenta a tela para confirmar os dados da empresa
	    
	      | Empresa              |  Empresa              |
	      | Endereço             |  Rua tal, Bairro tal  |
	      | CEP                  |  31910510             |
	      | Emissão              |  string               |
	      | CNPJ                 |  11242354451          |
	      
  
     Cenario: Alterar Dados Pessoais
    
	    Entao aciono a opção para alterar os dados do RG
	    
	      | Identidade         |  12281029             |
	      | Nascimento         |  01/01/1989           |
	      | Estado Civil       |  Solteiro(a)          |
	      | Sexo               |  Não-binário          |
	      | Nacionalidade      |  Brasileira           |
	      | Estado Natal       |  Minas Gerais         |
	      | Cidade Natal       |  Belo Horizonte       |
	      
	      E altero também os dados da carteira de trabalho  
	      
		    | Numero                |  7777777              |
	      | Serie                 |  01                   |
	      | Emissão               |  25/12/2000           |
	      | PIS/PASESP            |  1111111111           |
	      | Registro Profissional |  -                    | 
	     
	      E altero também os dados do titulo de eleitor  
	    	    
	      | Numero             |  111111111111         |
	      | Emissão            |  12/03/1993           |
	      | UF                 |  MG                   |
	      | Zona               |  01                   |
	      | Secao              |  02                   |
	      
	     E altero também os dados do Grau de instrução
	         
	      | Educação           | Ensino fundamental incompleto |
	      
	   	      
    Cenario: Alterar Dados do Cargo
    
	    Entao o app apresenta a tela para confirmar os dados do Cargo
	    
	      | Cargo              |  ANALISTA D DADOS PL  |
	      | Area               |  -                    |
	      | Admissiao          |  -                    |
	      | Forma de pagamento |  Não-binário          |
	      | Salario            |  R$ 5.000,00          |
	      | Salario hora       |  -                    |
	      | Jornada            |  -                    |
        | Opcao F            |  -                    | 
        | Horario            |  -                    |   
        
    Cenario: Alterar Dados da empresa 
    
	    Entao o app apresenta a tela para confirmar os dados do Cargo
	    
	      | Empresa              |  ANALISTA D DADOS PL  |
	      | Endereço             |  -                    |
	      | CEP                  |  -                    |
	      | Emissão              |  Não-binário          |
	      | CNPJ                 |  R$ 5.000,00          |
     