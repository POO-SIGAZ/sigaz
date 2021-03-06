package model.vo;

public class GradeVO {
	private StudentVO student;
	private ClassroomVO classroom;
	private int n1;
	private int n2;
	private int n3;
	private int nfinal;
	private double frequency;

	public StudentVO getStudent() {
		return this.student;
	}

	public void setStudent(StudentVO student) throws Exception {
		if (student == null)
			throw new Exception("Aluno inválido");
		else
			this.student = student;
	}

	public ClassroomVO getClassroom() {
		return this.classroom;
	}

	public void setClassroom(ClassroomVO classroom) throws Exception {
		if (classroom == null)
			throw new Exception("Turma inválida");
		else
			this.classroom = classroom;
	}

	public int getN1() {
		return this.n1;
	}

	public void setN1(int n1) throws Exception {
		if (n1 < 0 || n1 > 100)
			throw new Exception("Nota inválida, deve ser de 0 a 100");
		else
			this.n1 = n1;
	}

	public int getN2() {
		return this.n2;
	}

	public void setN2(int n2) throws Exception {
		if (n2 < 0 || n2 > 100)
			throw new Exception("Nota inválida, deve ser de 0 a 100");
		else
			this.n2 = n2;
	}

	public int getN3() {
		return this.n3;
	}

	public void setN3(int n3) throws Exception {
		if (n3 < 0 || n3 > 100)
			throw new Exception("Nota inválida, deve ser de 0 a 100");
		else
			this.n3 = n3;
	}

	public int getNFinal() {
		return this.nfinal;
	}

	public void setNFinal(int nfinal) throws Exception {
		if (nfinal < 0 || nfinal > 100)
			throw new Exception("Nota inválida, deve ser de 0 a 100");
		else
			this.nfinal = nfinal;
	}

	public double getFrequency() {
		return this.frequency;
	}

	public void setFrequency(double frequency) throws Exception {
		if (frequency < 0.0 || frequency > 1.0)
			throw new Exception("Valor inválido, deve ser entre 0% a 100%");
		else
			this.frequency = frequency;
	}

	public String toString() {
		return "Aluno: " + this.getStudent().getName() + "\nDisciplina: " + this.getClassroom().getSubject().getName()
				+ "\nN1: " + this.getN1() + "\nN2: " + this.getN2() + "\nN3: " + this.getN3() + "\nMédia Final: "
				+ this.getNFinal() + "\nFrequência: " + this.getFrequency() * 100 + "%";
	}
}
