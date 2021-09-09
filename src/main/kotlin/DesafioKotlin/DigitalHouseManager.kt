package DesafioKotlin

class DigitalHouseManager(
    var alunos: MutableList<Aluno> = mutableListOf(),
    var professores: MutableList<Professor> = mutableListOf(),
    var cursos: MutableList<Curso> = mutableListOf(),
    var matriculas: MutableList<Matricula> = mutableListOf(),
) {

    //Adiciona um curso na lista "cursos".
    fun registrarCurso(nome: String, codigo: Int, maxAlunos: Int) {
        //Instancia um curso com os parâmetros informados
        val curso = Curso(nome, codigo, maxAlunos)
        //Verifica se já existe esse curso na lista
        if (cursos.contains(curso)) {
            for (i in cursos) {
                if (i == curso) {
                    println(
                        """▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
                           |-Erro: Já existe um Curso com este código!-
                           |Tentativa de inclusão: $codigo-$nome
                           |Registro já existente: ${i.codigo}-${i.nome}
                           |▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔""".trimMargin()
                    )
                }
            }
        } else {
            //Inclui o curso criado na lista
            cursos.add(curso)
            println(
                """▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
                   |Curso registrado com sucesso!
                   |Identificação: $codigo-$nome
                   |Limite de Alunos: $maxAlunos
                   |▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔""".trimMargin()
            )
        }
    }

    //Exclui um curso da lista "cursos" usando o codigo.
    fun excluirCurso(codigoCurso: Int) {
        //Primeiro "if" verifica se existe o código na lista
        if (cursos.map { it.codigo }.contains(codigoCurso)) {
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    println("Curso removido: ${i.codigo} - ${i.nome}")
                    cursos.remove(i)
                    return
                }
            }
        } else {
            println("Erro: Código digitado ($codigoCurso) não foi encontrado na lista de cursos")
        }
    }

    //Inclui um professor adjunto na lista "professores"
    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professor = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        if (professores.contains(professor)) {
            for (i in professores) {
                if (i == professor) {
                    println(
                        """▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
                           |-Erro: Já existe um Professor com este código!-
                           |Tentativa de inclusão: $codigoProfessor-$nome $sobrenome
                           |Registro já existente: ${i.codigo}-${i.nome} ${i.sobrenome}
                           |▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔""".trimMargin()
                    )
                }
            }
        } else {
            professores.add(professor)
            println("Prof Adjunto $codigoProfessor-$nome $sobrenome registrado(a) com sucesso!")
        }
    }

    //Inclui um professor titular na lista "professores"
    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professor = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        if (professores.contains(professor)) {
            for (i in professores) {
                if (i == professor) {
                    println(
                        """▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
                            |Erro: Já existe um Professor com este código!
                            |Tentativa de inclusão: $codigoProfessor-$nome $sobrenome
                            |Registro já existente: ${i.codigo}-${i.nome} ${i.sobrenome}
                            |▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔""".trimMargin()
                    )
                }
            }
        } else {
            professores.add(professor)
            println("Prof Titular $codigoProfessor-$nome $sobrenome registrado(a) com sucesso!")
        }
    }

    //Remove um professor da lista "professores"
    fun excluirProfessor(codigoProfessor: Int) {
        //if verifica se existe o código na lista
        //for procura o prof correspondente e remove
        if (professores.map { it.codigo }.contains(codigoProfessor)) {
            for (i in professores) {
                if (i.codigo == codigoProfessor) {
                    println(
                        """
                        Professor removido: ${i.codigo}-${i.nome} ${i.sobrenome} 
                    """.trimIndent()
                    )
                    professores.remove(i)
                    return
                }
            }
        } else {
            println("Erro: Código digitado ($codigoProfessor) não foi encontrado na lista de professores.")
        }
    }

    //Adiciona um aluno à lista "alunos".
    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome, sobrenome, codigoAluno)
        if (alunos.contains(aluno)) {
            for (i in alunos) {
                if (i == aluno) {
                    println(
                        """▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
                           |Erro: Já existe um aluno com este código!
                           |Tentativa de inclusão: $codigoAluno-$nome $sobrenome
                           |Registro existente:    ${i.codigo}-${i.nome} ${i.sobrenome}
                           |▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔""".trimMargin()
                    )
                }
            }
        } else {
            alunos.add(aluno)
            println("$codigoAluno-$nome $sobrenome registrado(a) com sucesso!")
        }
    }

    //Inclui um aluno da lista "alunos" em um curso da lista "cursos".
    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        //Primeiro if verifica se o código de aluno existe na lista.
        //Segundo if verifica se o código de curso existe na lista.
        if (alunos.map { it.codigo }.contains(codigoAluno) == false) {
            println("Erro: Código de aluno digitado ($codigoAluno) não foi encontrado")
        } else if (cursos.map { it.codigo }.contains(codigoCurso) == false) {
            println("Erro: Código de curso digitado ($codigoCurso) não foi encontrado")

        } else {
            //Cria variáveis vazias "curso" e "aluno".
            var curso: Curso? = null
            var aluno: Aluno? = null
            //Procura pelo curso com o código digitado e armazena na variável "curso
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    curso = i
                }
            }
            //Procura pelo aluno com o código digitado e armazena na variável "aluno"
            for (j in alunos) {
                if (j.codigo == codigoAluno) {
                    aluno = j
                }
            }
            /*Este if foi adicionado porque, para serem declaradas sem valor, as variáveis "curso" e "aluno"
            são do tipo Curso? e Aluno?, que não são aceitas na função adicionarUmAluno. Tentei criar as variáveis
            dentro dos for, mas a função adicionarUmAluno não conseguia acessá-las*/
            if (curso is Curso && aluno is Aluno) {

                //Adiciona matrícula na lista se a função for true.
                //*Função está dentro do "if" apenas para verificar se é true ou false, mas por algum motivo está rodando
                if (curso.adicionarUmAluno(aluno) == true) {
                    val matricula = Matricula(aluno, curso)
                    matriculas.add(matricula)
                }
            }
        }
    }

    //Usa a função excluirAlunos da classe curso para excluir um aluno da lista "listaAlunos" do curso.
    //Depois remove a matrícula da lista.
    fun excluirAluno(codigoAluno: Int, codigoCurso: Int) {
        if (cursos.map { it.codigo }.contains(codigoCurso) == false) {
            println("Erro: Código de curso ($codigoCurso) não foi encontrado")
        } else {
            val aluno = Aluno("", "", codigoAluno)
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    if (i.listaAlunos.contains(aluno)) {
                        for (j in i.listaAlunos) {
                            if (j.codigo == codigoAluno) {
                                i.excluirAluno(j)
                            }
                        }
                    } else {
                        println("Código de aluno não foi encontrado neste curso.")
                    }
                }
            }
            for (i in matriculas) {
                if (i.aluno.codigo == codigoAluno && i.curso.codigo == codigoCurso) {
                    matriculas.remove(i)
                }
            }
        }

    }


    // Busca um professor adjunto e um titular na lista "professores" e associa às variáveis profTitular e
    // profAdjunto de um curso da lista "cursos".
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
            //Cria variáveis vazias para futuramente armazenar os objetos do tipo Professor.
            //Primeiro for verifica se 1o código é de prof titular, se for, armazena; se não for, printa erro e encerra.
            //Segundo for verifica se 2o código é de prof adjunto, se for, armazena; se não for, printa erro e encerra.
            var titular: ProfessorTitular? = null
            var adjunto: ProfessorAdjunto? = null
            for (j in professores) {
                if (j.codigo == codigoProfessorTitular && (j is ProfessorTitular == false)) {
                    println("Erro: $codigoProfessorTitular é um código de professor adjunto, e não titular")
                    return
                } else {
                    if (j is ProfessorTitular)
                        titular = j
                }
            }
            for (k in professores) {
                if (k.codigo == codigoProfessorAdjunto && (k is ProfessorAdjunto == false)) {
                    println("Erro: $codigoProfessorAdjunto é um código de professor titular, e não adjunto")
                    return
                } else {
                    if (k is ProfessorAdjunto)
                        adjunto = k
                }
            }
            //for procura o curso e associa os professores que estavam armazenados nas variaveis criadas.
            for (i in cursos) {
                if (i.codigo == codigoCurso) {
                    i.profTitular = titular
                    i.profAdjunto = adjunto
                    println(
                        """▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁
                    |Alocação realizada com sucesso!
                    |Curso: ${i.codigo} - ${i.nome}
                    |Professor titular: ${i.profTitular?.codigo} - ${i.profTitular?.nome} ${i.profTitular?.sobrenome}
                    |Professor adjunto: ${i.profAdjunto?.codigo} - ${i.profAdjunto?.nome} ${i.profAdjunto?.sobrenome}
                    |▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔""".trimMargin()
                    )
                }
            }
        }
    }

    //Verifica em que curso o aluno está matriculado.
    fun verificarCurso(codigoAluno: Int) {
        //Primeiro if verifica se o aluno está em alguma matrícula da lista "matriculas". Se sim, printa os dados dela.
        //Segundo if verifica se o aluno pelo menos está na lista "alunos".
        if (matriculas.map { it.aluno.codigo }.contains(codigoAluno)) {
            for (i in matriculas) {
                if (i.aluno.codigo == codigoAluno) {
                    println("Aluno(a) ${i.aluno.codigo}-${i.aluno.nome} ${i.aluno.sobrenome} está matriculado no curso ${i.curso.codigo}-${i.curso.nome}")
                }
            }
        } else if (alunos.map { it.codigo }.contains(codigoAluno)) {
            for (i in alunos) {
                if (i.codigo == codigoAluno) {
                    println("Aluno(a) ${i.codigo}-${i.nome} ${i.sobrenome} ainda não está matriculado(a) em nenhum curso.")
                }
            }
        } else {
            println("Erro: Código de aluno não foi localizado.")
        }
    }

}