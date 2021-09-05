package DesafioKotlin

class Curso(
    val nome: String,
    val codigo: Int,
    var profTitular: ProfessorTitular,
    var profAdjunto: ProfessorAdjunto,
    val alunosMax: Int
) {
    var listaAlunos: List<Aluno> = listOf()

    //Sobrescrevendo equals para comparar o código de curso.
    override fun equals(other: Any?): Boolean {
        return(other is Curso && other.codigo == this.codigo)
    }

    
}

//Parte E, 1) Adicionar os parâmetros profTitular, profAdjunto, maxAlunos e listaAlunos.