# Exercício de Fixação — Buscar Contato por Nome

## Contexto

Já temos o CRUD completo da Agenda: listar, criar, editar e excluir contatos, com os dados persistidos de verdade no PostgreSQL via JDBC. Este exercício pede que vocês apliquem, sozinhos, o mesmo padrão que já usamos em aula (View → Controller → DAO → Banco → Controller → View) para construir uma funcionalidade nova: **buscar contatos por nome**.

## Objetivo

Ao final deste exercício, vocês devem ter uma nova tela na Agenda Telefônica que permite encontrar contatos digitando apenas parte do nome — reforçando na prática o fluxo completo entre View, Controller e DAO, e introduzindo uma nova cláusula SQL.

\---

## Requisitos

1. **Uma nova tela**, `buscar-contato.jsp`, acessível por um link ou botão a partir da tela de Agenda (ex.: um botão "🔍 Buscar" ao lado do "+ Novo Contato").
2. Um **campo de texto** com botão "Buscar". O usuário digita parte de um nome (ex.: `"ana"`) e o sistema retorna todos os contatos cujo nome **contenha** esse trecho — em qualquer posição da palavra (ex.: buscar `"ana"` deve encontrar tanto "**Ana** Beatriz" quanto "Mari**ana**").
3. A busca deve ser **case-insensitive** — buscar `"ana"` deve encontrar "Ana Beatriz" independente de maiúsculas/minúsculas.
4. O resultado aparece **na mesma página**, em uma tabela seguindo o mesmo padrão visual já usado na Agenda (Bootstrap, colunas ID / Nome / Fone / E-mail).
5. Se nenhum contato for encontrado, exibir uma **mensagem amigável** — não uma tabela vazia sem explicação.
6. Ao exibir o resultado, **o termo buscado deve continuar preenchido** no campo de texto (não pode voltar em branco após a busca).
7. Um link ou botão para **voltar para a Agenda**.

## 

## O que entregar

* `ContatoDAO.java` com o novo método de busca.
* O novo Servlet (Controller) criado para essa funcionalidade.
* `buscar-contato.jsp`.
* O link de acesso adicionado em `agenda.jsp`.
* Projeto funcionando localmente.

## Como será avaliado

|Critério|Peso|
|-|-|
|Busca funciona corretamente e é case-insensitive|Alto|
|Uso de `PreparedStatement` com parâmetro (sem concatenar texto direto na query SQL)|Alto|
|Uso do verbo HTTP adequado para a busca|Médio|
|Tratamento do caso "nenhum resultado encontrado"|Médio|
|Reaproveitamento do padrão visual (Bootstrap) já usado na Agenda|Baixo|
|Termo buscado permanece preenchido no campo após a busca|Baixo|



