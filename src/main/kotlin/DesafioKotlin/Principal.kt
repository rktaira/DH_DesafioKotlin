package DesafioKotlin

fun main() {
    val dh = DigitalHouseManager()

//2. Registrar dois professores titulares e dois professores adjuntos. (Inventar
//todos os seus valores)
    println("2: Registrar dois professores titulares e dois adjuntos")

    dh.registrarProfessorTitular("João", "Silva", 110, "Full Stack")
    dh.registrarProfessorTitular("Maria", "Joana", 111, "Android")
    dh.registrarProfessorAdjunto("José", "Marques", 210, 8)
    dh.registrarProfessorAdjunto("Clara", "Lima", 211, 10)

    println("====================================================================")

//3. Registrar dois cursos
    println("3: Registrar dois cursos")

    dh.registrarCurso("Full Stack", 20001, 3)
    dh.registrarCurso("Android", 20002, 2)

    println("====================================================================")

//4. Alocar um professor titular e um adjunto para cada curso.
    println("4: Alocar professores nos cursos")

    dh.alocarProfessor(20001, 111, 210)
    dh.alocarProfessor(20002, 110, 211)

    println("====================================================================")

//5. Matricular dois alunos no curso de Full Stack
    println("5: Matricular dois alunos no curso de Full Stack")

    dh.registrarAluno("Leonardo", "Souza", 50)
    dh.registrarAluno("Carolina", "Pontes", 51)

    dh.matricularAluno(50, 20001)
    dh.matricularAluno(51, 20001)

    println("====================================================================")

//6. Matricular três alunos no curso de Android
    println("6. Matricular três alunos no curso de Android")

    dh.registrarAluno("Gabriel", "Pires", 52)
    dh.registrarAluno("Luan", "Fernandes", 53)
    dh.registrarAluno("Luana", "Morais", 54)

    dh.matricularAluno(52, 20002)
    dh.matricularAluno(53, 20002)
    dh.matricularAluno(54, 20002)
}