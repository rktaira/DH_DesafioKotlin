package DesafioKotlin

class Curso(
    val nome: String,
    val codigo: Int,
    val alunosMax: Int,
    var profTitular: ProfessorTitular? = null,
    var profAdjunto: ProfessorAdjunto? = null,
    var listaAlunos: MutableList<Aluno> = mutableListOf()
) {

    override fun equals(other: Any?): Boolean {
        return (other is Curso && other.codigo == this.codigo)
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        //Primeiro if verifica se o aluno já está matriculado
        //Segundo if verifica se há vagas
        if (listaAlunos.contains(umAluno) == true) {
            println("--Erro: Aluno já está matriculado neste curso.--")
            return false
        } else if (listaAlunos.size >= alunosMax) {
            println("--Erro: Número máximo de alunos já foi atingido, não há vagas.--")
            return false
        } else {
            listaAlunos.add(umAluno)
            println("--${umAluno.nome} ${umAluno.sobrenome} foi matriculado(a) no curso $codigo-$nome.--")
            return true
        }
    }

    fun excluirAluno(umAluno: Aluno): Boolean {
        if (listaAlunos.contains(umAluno) == false) {
            println("Erro: Aluno não está matriculado neste curso.")
            return false
        } else {
            listaAlunos.remove(umAluno)
            println("Aluno ${umAluno.codigo}-${umAluno.nome} ${umAluno.sobrenome} excluído com sucesso" +
                    "do curso $codigo-$nome!")
            return true
        }
    }

}


//Parte E, 1) Adicionar os parâmetros profTitular, profAdjunto, maxAlunos e listaAlunos.