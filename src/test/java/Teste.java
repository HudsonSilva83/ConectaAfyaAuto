import br.com.conecta.afya.domain.DadosCargo;
import br.com.conecta.afya.domain.DadosEmpresa;
import br.com.conecta.afya.domain.DadosPessoais;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DadosPessoais dados = new DadosPessoais();
		DadosCargo dadosCargo = new DadosCargo();
		
		
		
		
//		dados.setIdentidade("12281029");
//		dados.setdataNascimento("01/01/1989");
//		dados.setEstadoCivil("SOLTEIRO");
//		dados.setSexo("NÃOBINARIO");
//		dados.setNacionalidade("Brasileira");
//		dados.setEstadoNatal("Minas Gerais");
//		dados.setCidadeNatal("Belo Horizonte");
//		System.out.println(dados.lista_rg());
	
		
		
//		dados.setCartTrabnumero("77777777");
//		dados.setCartTrabserie("01");
//		dados.setCartTrabemissao("25/12/2000");
//		dados.setCartTraPis("1111111");
//		dados.setCartTrabRegisProf("-");
//		
//		System.out.println(dados.lista_CarteiraTrabalho());
		
//		
//		dados.setTituEleNumero("111111");
//		dados.setTituEleEmissao("12/03/1993");
//		dados.setTituEleUF("MG");
//		dados.setTituEleZona("01");
//		dados.setTituEleSecao("02");
//		
//		dados.setGrauInstituicaoEdu("Ensino Fundamental");
//		
//		System.out.println(dados.getGrauInstituicaoEdu());
		
		
//		dadosCargo.setCargo("Cargo");
//		dadosCargo.setArea("-");
//		dadosCargo.setAdmissao("-");
//		dadosCargo.setFormaPagamento("-");
//		dadosCargo.setSalario("R$ 5.0000,00");
//		dadosCargo.setSalarioHora("-");
//		dadosCargo.setJornada("-");
//		dadosCargo.setOpcaoFGTS("-");
//		dadosCargo.setHorario("-");
//		
//		System.out.println(dadosCargo.lista_DadosCargo());
		
		
		
		
		
		DadosEmpresa dadosEmpresa = new DadosEmpresa();
		
		dadosEmpresa.setEmpresa("Empresa Teste");
        dadosEmpresa.setEndereco("Rua tal");
        dadosEmpresa.setCep("3910510");
        dadosEmpresa.setCnpj("11242354451");
        System.out.println(dadosEmpresa.lista_DadosEmpresa());
		
		
		}
	
	
	
}
