package Func;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface TrabalhoServer {
	@WebMethod void adicionarFuncionarioNaEmpresa(String nome, String cpf, String dataNascimento, String email, int cargaHoraria, String turno, String setor);
	@WebMethod void deletarFuncionarioNaEmpresa(int pos);
	@WebMethod void updateFuncionarioNaEmpresa(int pos, String campo, String up);
	@WebMethod String readFuncionario(int pos);
	@WebMethod String readAllFuncionarios();
}
