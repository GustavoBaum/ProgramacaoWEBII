package Func;

public class Funcionarios {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	private int cargaHoraria;
	private String turno;
	private String setor;
	
	public Funcionarios(String nome, String cpf, String dataNascimento, String email, int cargaHoraria, String turno, String setor) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEmail(email);
		setCargaHoraria(cargaHoraria);
		setTurno(turno);
		setSetor(setor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		String cepéfe = cpf;
		
		if (cepéfe.length() == 11) {
			this.cpf = cepéfe.substring(0, 3) + "." +
			cepéfe.substring(3, 6) + "." +
			cepéfe.substring(6, 9) + "-" +
			cepéfe.substring(9, 11);
		} else {
			this.cpf = cpf;
		}
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		String data = dataNascimento;
		if (data.length() == 8) {
			this.dataNascimento = data.substring(0, 2) + "/" +
			data.substring(2, 4) + "/" +
			data.substring(6, 8);
		} else {
			this.dataNascimento = dataNascimento;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
}
