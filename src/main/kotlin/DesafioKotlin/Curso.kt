package DesafioKotlin

class Curso(
    var nome: String,
    var codigo: Int
) {
    //Sobrescrevendo equals para comparar o código de aluno.
    override fun equals(other: Any?): Boolean {
        return(other is Curso && other.codigo == this.codigo)
    }
}