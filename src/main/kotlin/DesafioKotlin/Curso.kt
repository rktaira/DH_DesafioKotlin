package DesafioKotlin

class Curso(
    val nome: String,
    val codigo: Int,
    var profTitular: ProfessorTitular,
    var profAdjunto: ProfessorAdjunto,
    val alunosMax: Int
) {
    var listaAlunos: MutableList<Aluno> = mutableListOf()

    //Sobrescrevendo equals para comparar o código de curso.
    override fun equals(other: Any?): Boolean {
        return (other is Curso && other.codigo == this.codigo)
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if (listaAlunos.contains(umAluno) == true) {
            println("Erro: Aluno já está matriculado neste curso.")
            return false
        } else if (listaAlunos.size >= alunosMax) {
            println("Erro: Número máximo de alunos já foi atingido.")
            return false
        } else {
            listaAlunos.add(umAluno)
            println("Aluno incluído com sucesso!")
            return true
        }
    }

    fun excluirAluno(umAluno: Aluno): Boolean {
        if (listaAlunos.contains(umAluno) == false) {
            println("Erro: Aluno não está matriculado neste curso.")
            return false
        } else {
            listaAlunos.remove(umAluno)
            println("Aluno excluído com sucesso!")
            return true
        }
    }
}


//Parte E, 1) Adicionar os parâmetros profTitular, profAdjunto, maxAlunos e listaAlunos.