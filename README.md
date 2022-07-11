Esta API Gerencia Turma e Aluno.
API - gerenciar-turma-aluno-backend com as seguintes funcoes:
POST: http://localhost:8080/api/inserir-aluno
{
    "nome":"Aluno Teste"
}
POST: http://localhost:8080/api/inserir-turma
{
    "nome":"Turma 1"
}
POST: http://localhost:8080/api/inserir-aluno-turma
{
    "idTurma":"2",
    "idAluno":"1"
}
POST: http://localhost:8080/api/excluir-aluno-turma
{
    "idTurma":"1",
    "idAluno":"1"
}
DELETE: http://localhost:8080/api/excluir-aluno/1
DELETE: http://localhost:8080/api/excluir-turma/1
GET: http://localhost:8080/api/listar-aluno-turma/1
GET: http://localhost:8080/api/listar-aluno
GET: http://localhost:8080/api/listar-turma
PUT: http://localhost:8080/api/atualizar-aluno
{
    "id": 1,
    "nome": "Teste Nome 2"
}
PUT: http://localhost:8080/api/atualizar-turma
{
    "id": 1,
    "nome": "Turma 1 atualizar"
}
GET: http://localhost:8080/api/listar-aluno-paginacao/0/1/id