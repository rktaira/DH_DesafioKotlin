package DesafioKotlin

class DigitalHouseManager(
    var alunos: MutableList<Aluno> = mutableListOf(),
    var professores: MutableList<Professor> = mutableListOf(),
    var cursos: MutableList<Curso> = mutableListOf(),
    var matriculas: MutableList<Matricula> = mutableListOf(),
) {

    fun registrarCurso(nome: String, codigo: Int, maxAlunos: Int) {
        //if para verificar se já existe um curso com este código:
        if (cursos.map { it.codigo }.contains(codigo)) {
            for (i in cursos) {
                if (i.codigo == codigo) {
                    println(
                        """——————————————————————————————————————————————
                           |Erro: Já existe um Curso com este código!
                           |Tentativa de inclusão: $codigo-$nome
                           |Registro já existente: ${i.codigo}-${i.nome}
                           |——————————————————————————————————————————————""".trimMargin()
                    )
                }
            }
        } else {
            //código que instancia um objeto do tipo curso e o adiciona à lista:
            val curso = Curso(nome, codigo, maxAlunos)
            cursos.add(curso)
            println(
                """——————————————————————————————————————————————
                   |Curso registrado com sucesso!
                   |Identificação: $codigo-$nome
                   |Limite de Alunos: $maxAlunos
                   |——————————————————————————————————————————————""".trimMargin()
            )
        }
    }


    fun excluirCurso(codigoCurso: Int) {
        //Primeiro "if" verifica se existe o código na lista
        if (cursos.map { it.codigo }.contains(codigoCurso)) {
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    println("Curso removido: ${i.codigo} - ${i.nome}")
                    cursos.remove(i)
                }
            }
        } else {
            println("Erro: Código digitado ($codigoCurso) não foi encontrado na lista de cursos")
        }
    }


    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        if (professores.map { it.codigo }.contains(codigoProfessor)) {
            for (i in professores) {
                if (i.codigo == codigoProfessor) {
                    println(
                        """——————————————————————————————————————————————
                           |Erro: Já existe um Professor com este código!
                           |Tentativa de inclusão: $codigoProfessor-$nome $sobrenome
                           |Registro já existente: ${i.codigo}-${i.nome} ${i.sobrenome}
                           |——————————————————————————————————————————————""".trimMargin()
                    )
                }
            }
        } else {
            val professor = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
            professores.add(professor)
        }
    }


    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        if (professores.map { it.codigo }.contains(codigoProfessor)) {
            for (i in professores) {
                if (i.codigo == codigoProfessor) {
                    println(
                        """——————————————————————————————————————————————
                            |Erro: Já existe um Professor com este código!
                            |Tentativa de inclusão: $codigoProfessor-$nome $sobrenome
                            |Registro já existente: ${i.codigo}-${i.nome} ${i.sobrenome}
                            |——————————————————————————————————————————————""".trimMargin()
                    )
                }
            }
        } else {
            val professor = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
            professores.add(professor)
        }
    }


    fun excluirProfessor(codigoProfessor: Int) {
        if (professores.map { it.codigo }.contains(codigoProfessor)) {
            for (i in professores) {
                if (i.codigo == codigoProfessor) {
                    println(
                        """
                        Professor removido: ${i.codigo}-${i.nome} ${i.sobrenome} 
                    """.trimIndent()
                    )
                    professores.remove(i)
                }
            }
        } else {
            println("Erro: Código digitado ($codigoProfessor) não foi encontrado na lista de professores.")
        }
    }


    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        if (alunos.map { it.codigo }.contains(codigoAluno)) {
            for (i in alunos) {
                if (i.codigo == codigoAluno) {
                    println(
                        """——————————————————————————————————————————————
                           |Erro: Já existe um aluno com este código!
                           |Tentativa de inclusão: $codigoAluno-$nome $sobrenome
                           |Registro existente:    ${i.codigo}-${i.nome} ${i.sobrenome}
                           |——————————————————————————————————————————————""".trimMargin()
                    )
                }
            }
        } else {
            val aluno = Aluno(nome, sobrenome, codigoAluno)
            alunos.add(aluno)
            println("$codigoAluno-$nome $sobrenome registrado(a) com sucesso!")
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        //Primeiro if verifica se o código de aluno existe na lista.
        //Segundo if verifica se o código de curso existe na lista.
        if (alunos.map { it.codigo }.contains(codigoAluno) == false) {
            println("Erro: Código de aluno digitado ($codigoAluno) não foi encontrado")
        } else if (cursos.map { it.codigo }.contains(codigoCurso) == false) {
            println("Erro: Código de curso digitado ($codigoCurso) não foi encontrado")

            //Parte do código que procura o curso "i" e adiciona o aluno "j"
        } else {
            for (i in cursos) for (j in alunos) {
                if (i.codigo == codigoCurso &&
                    j.codigo == codigoAluno
                ) {
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
            println("Erro: Código de Professor Adjunto não foi encontrado")
        } else {
//Primeiro for verifica se 1o código é de prof titular, se for, armazena
//Segundo for verifica se 2o código é de prof adjunto, se for, armazena
            var titular: ProfessorTitular? = null
            for (j in professores) {
                if (j.codigo == codigoProfessorTitular && (j is ProfessorTitular == false)) {
                    println("Erro: $codigoProfessorTitular é um código de professor adjunto, e não titular")
                    return
                } else {
                    if (j is ProfessorTitular)
                        titular = j
                }
            }
            var adjunto: ProfessorAdjunto? = null
            for (k in professores) {
                if (k.codigo == codigoProfessorAdjunto && (k is ProfessorAdjunto == false)) {
                    println("Erro: $codigoProfessorAdjunto é um código de professor titular, e não adjunto")
                    return
                } else {
                    if (k is ProfessorAdjunto)
                        adjunto = k
                }
            }
//Parte do código que procura o curso "i" e associa os professores "j" e "k".
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    i.profTitular = titular
                    i.profAdjunto = adjunto
                    println(
                        """——————————————————————————————————————————————
                    |Alocação realizada com sucesso!
                    |Curso: ${i.codigo} - ${i.nome}
                    |Professor titular: ${i.profTitular?.codigo} - ${i.profTitular?.nome} ${i.profTitular?.sobrenome}
                    |Professor adjunto: ${i.profAdjunto?.codigo} - ${i.profAdjunto?.nome} ${i.profAdjunto?.sobrenome}
                    |——————————————————————————————————————————————""".trimMargin()
                    )
                }
            }
        }
    }
}