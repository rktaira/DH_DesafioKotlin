package DesafioKotlin

class DigitalHouseManager(
    var alunos: MutableList<Aluno> = mutableListOf(),
    var professores: MutableList<Professor> = mutableListOf(),
    var cursos: MutableList<Curso> = mutableListOf(),
    var matriculas: MutableList<Matricula> = mutableListOf(),
) {

    fun registrarCurso(nome: String, codigo: Int, maxAlunos: Int) {
        val curso = Curso(nome, codigo, maxAlunos)
        cursos.add(curso)
        println(
            """=====================================
            |Curso registrado com sucesso!
            |Identificação: $codigo - $nome
            |Limite de Alunos: $maxAlunos
            |=====================================
        """.trimMargin()
        )
    }


    fun excluirCurso(codigoCurso: Int) {
        //Primeiro "if" verifica se existe o código na lista
        if (cursos.map { it.codigo }.contains(codigoCurso)) {
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    println(
                        """
                        Curso removido: ${i.codigo} - ${i.nome}
                    """.trimIndent()
                    )
                    cursos.remove(i)
                }
            }
        } else {
            println("Erro: Código digitado não foi encontrado na lista de cursos")
        }
    }


    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professor = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        professores.add(professor)
    }


    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professor = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        professores.add(professor)
    }


    fun excluirProfessor(codigoProfessor: Int) {
        if (professores.map { it.codigo }.contains(codigoProfessor)) {
            for (i in professores) {
                if (i.codigo == codigoProfessor) {
                    println(
                        """
                        Professor removido: ${i.codigo} - ${i.nome} ${i.sobrenome} 
                    """.trimIndent()
                    )
                    professores.remove(i)
                }
            }
        } else {
            println("Erro: Código digitado não foi encontrado na lista de professores.")
        }
    }


    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome, sobrenome, codigoAluno)
        alunos.add(aluno)
    }


    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        //Primeiro if verifica se o código de aluno existe na lista.
        //Segundo if verifica se o código de curso existe na lista.
        if (alunos.map { it.codigo }.contains(codigoAluno) == false) {
            println("Erro: Código de aluno não foi encontrado")
        } else if (cursos.map { it.codigo }.contains(codigoCurso) == false) {
            println("Erro: Código de curso não foi encontrado")

            //Parte do código que procura o curso "i" e adiciona o aluno "j"
        } else {
            for (i in cursos) for (j in alunos) {
                if (i.codigo == codigoCurso &&
                    j.codigo == codigoAluno) {
                    i.adicionarUmAluno(j)
                }
                //Adiciona matrícula na lista
                val matricula = Matricula(j, i)
                matriculas.add(matricula)
            }
        }
    }


    fun alocarProfessor(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        //Primeiro if verifica se o código de curso existe na lista.
        //Segundo if verifica se o código de prof titular existe na lista.
        //Terceiro if verifica se o código de prof adjunto existe na lista.
        if (cursos.map { it.codigo }.contains(codigoCurso) == false) {
            println("Erro: Código de curso não foi encontrado")
        } else if (professores.map { it.codigo }.contains(codigoProfessorTitular) == false) {
            println("Erro: Código de Professor Titular não foi encontrado")
        } else if (professores.map { it.codigo }.contains(codigoProfessorAdjunto) == false) {

            //Parte do código que procura o curso "i" e adiciona os profs "j" e "k"
        } else {
            for (i in cursos) for (j in professores) for (k in professores){
                if (i.codigo == codigoCurso &&
                    j is ProfessorTitular && j.codigo == codigoProfessorTitular &&
                    k is ProfessorAdjunto && k.codigo == codigoProfessorAdjunto) {
                    i.profTitular = j
                    i.profAdjunto = k
                }
            }
        }
    }

}