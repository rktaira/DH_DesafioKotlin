package DesafioKotlin

data class Aluno(
    val nome: String,
    val sobrenome: String,
    val codigo: Int
) {
    //Sobrescrevendo equals para comparar o código de aluno.
    override fun equals(other: Any?): Boolean {
        return (other is Aluno && other.codigo == this.codigo)
    }
}