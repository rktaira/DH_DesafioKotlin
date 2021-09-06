package DesafioKotlin

fun main(){


    
    val teste = DigitalHouseManager()
    for (i in teste.cursos) {
        println(i.nome)
    }
    teste.registrarCurso("Curso 1", 123, 10)

    for (i in teste.cursos) {
        println(i.nome)
    }
    teste.registrarCurso("Curso 2", 124, 10)

    for (i in teste.cursos) {
        println(i.codigo)
    }

    teste.excluirCurso(125)

    for (i in teste.cursos) {
        println(i.nome)
    }

    teste.registrarProfessorAdjunto("João", "Silva", 11,8)
    for (i in teste.professores) {
        println(i.nome)
    }

    teste.registrarAluno("John", "Michael", 1)
    teste.registrarAluno("Marie", "Stevens", 2)
    teste.registrarAluno("Mario", "Mario", 3)

    println(teste.cursos.map{it.listaAlunos.map{it.nome}})


    teste.matricularAluno(1, 123)
    println(teste.cursos.map{it.listaAlunos.map{it.nome}})
    teste.matricularAluno(2, 125)
    println(teste.cursos.map{it.listaAlunos.map{it.nome}})
    teste.matricularAluno(2, 123)
    println(teste.cursos.map{it.listaAlunos.map{it.nome}})
}