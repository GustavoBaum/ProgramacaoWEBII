package Func;

import java.util.ArrayList;

import javax.jws.WebService;

@WebService(endpointInterface = "Func.TrabalhoServer")
public class TrabalhoServerImpl implements TrabalhoServer {

	private ArrayList<Funcionarios> lista = new ArrayList<Funcionarios>();
	private Empresa e = new Empresa(lista);


	@Override
	public void adicionarFuncionarioNaEmpresa(String nome, String cpf, String dataNascimento, String email, int cargaHoraria, String turno, String setor) {
		Funcionarios novo = new Funcionarios(nome, cpf, dataNascimento, email, cargaHoraria, turno, setor);
		lista.add(novo);
	}

	@Override
	public void deletarFuncionarioNaEmpresa(int pos) {
		e.delete(pos);
	}

	@Override
	public void updateFuncionarioNaEmpresa(int pos, String campo, String up) {
		e.update(pos, campo, up);
	}

	@Override
	public String readFuncionario(int pos) {
		return e.read(pos);
	}

	@Override
	public String readAllFuncionarios() {
		return e.readAll();
	}
}
