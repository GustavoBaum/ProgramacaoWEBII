package Func;

import java.util.ArrayList;

public class Empresa {

	private ArrayList<Funcionarios> listaFuncionarios = new ArrayList<Funcionarios>();

	public Empresa(ArrayList<Funcionarios> listaF) {
		setListaFuncionarios(listaF);
	}

	public ArrayList<Funcionarios> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(ArrayList<Funcionarios> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	
	public void addFuncionario(Funcionarios funcionario, String nome, String cpf, String dataNascimento, String email, int cargaHoraria, String turno, String setor) {
		funcionario = new Funcionarios(nome, cpf, dataNascimento, email, cargaHoraria, turno, setor);
		listaFuncionarios.add(funcionario);
	}

	public void delete(int pos) {
		listaFuncionarios.remove(pos);
	}

	public void update(int pos, String campo, String up) {

		campo.toLowerCase();
		int pos2 = pos-1;
		
		switch (campo) {

		case "nome":
			listaFuncionarios.get(pos2).setNome(up);
			break;
		case "cpf":
			listaFuncionarios.get(pos2).setCpf(up);
			break;
		case "data de nascimento":
			listaFuncionarios.get(pos2).setDataNascimento(up);
			break;
		case "email":
			listaFuncionarios.get(pos2).setEmail(up);
			break;
		case "carga horaria":
			int upInt = Integer.parseInt(up);
			listaFuncionarios.get(pos2).setCargaHoraria(upInt);
			break;
		case "turno":
			listaFuncionarios.get(pos2).setTurno(up);
			break;
		case "setor":
			listaFuncionarios.get(pos2).setSetor(up);
			break;

		default:
			throw new RuntimeException();

		}
	}

	public String read(int pos) {
		return toStringFuncionario(listaFuncionarios.get(pos));
	}

	public String readAll() {
		String v2 = "";
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			v2 += "Funcionário " + (i+1) + " : " + toStringFuncionario(listaFuncionarios.get(i))  + "\n";
		}
		return v2;
	}

	public String toStringFuncionario(Funcionarios funcionarios) {

		String vl = "";

		vl = ("Nome: " + funcionarios.getNome() + " - ") +
	    ("CPF: " + funcionarios.getCpf() + " - ") +
		("Data de Nascimento: " + funcionarios.getDataNascimento() + " - ") +
        ("E-mail: " + funcionarios.getEmail() + " - ") +
		("Carga Horaria: " + funcionarios.getCargaHoraria() + " - ") +
		("Turno: " + funcionarios.getTurno() + " - ") +
		("Setor: " + funcionarios.getSetor() + ".");

		return vl;
	}
	
}