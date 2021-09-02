package DesafioKotlin

class Professor(
    var nome: String,
    var sobrenome: String,
    var tempoDeCasa: Int,
    var codigo: Int
) {
    //Sobrescrevendo equals para comparar o código de aluno.
    override fun equals(other: Any?): Boolean {
        return (other is Professor && other.codigo == this.codigo)
    }
}