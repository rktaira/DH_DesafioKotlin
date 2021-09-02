package DesafioKotlin

class Professor(
    val nome: String,
    val sobrenome: String,
    var tempoDeCasa: Int,
    val codigo: Int
) {
    //Sobrescrevendo equals para comparar o código de aluno.
    override fun equals(other: Any?): Boolean {
        return (other is Professor && other.codigo == this.codigo)
    }
}