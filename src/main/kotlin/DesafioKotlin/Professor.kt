package DesafioKotlin

open class Professor(
    val nome: String,
    val sobrenome: String,
    var tempoDeCasa: Int,
    val codigo: Int
) {
    //Sobrescrevendo equals para comparar o código de professor.
    override fun equals(other: Any?): Boolean {
        return (other is Professor && other.codigo == this.codigo)
    }
}

//Parte D. Alterações: abrir classe professor para as classes ProfessorTitular e ProfessorAdjunto herdarem.