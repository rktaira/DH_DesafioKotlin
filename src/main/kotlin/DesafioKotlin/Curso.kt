package DesafioKotlin

class Curso(
    val nome: String,
    val codigo: Int
) {
    //Sobrescrevendo equals para comparar o código de aluno.
    override fun equals(other: Any?): Boolean {
        return(other is Curso && other.codigo == this.codigo)
    }
}