package model.vo;

public class SubjectVO {
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (code == null || !code.matches("^[A-Z]{3}\\d{4}$"))
			System.out.println("Código inválido!");
		else
			this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty())
			System.out.println("Nome inválido!");
		else
			this.name = name;
	}

	public String toString() {
		return "Código: " + code + "\nNome: " + name;
	}
}
