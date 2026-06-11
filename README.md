# Auto Center Rota 381

Trabalho pratico da disciplina Desenvolvimento de Programas Estruturados e
Modularizacao.

## Regras tecnicas adotadas

- Logica estruturada.
- Vetores nativos de tamanho fixo.
- Lacos tradicionais (`for`, `while` e `do-while`).
- Metodos estaticos organizados em modulos.
- Classes de dados somente com atributos publicos.
- Sem `ArrayList`, `List`, banco de dados, heranca ou frameworks.
- Importacao explicita apenas do `Scanner` nesta primeira etapa.

## Estrutura do projeto

```text
AutoCenterRota381/
|-- src/
|   |-- App.java
|   |-- Cadastros.java
|   |-- Leitura.java
|   |-- Mecanico.java
|   |-- Veiculo.java
|   |-- Peca.java
|   `-- OrdemServico.java
|-- bin/
|-- .gitignore
`-- README.md
```

## Planejamento por encontros

### Encontro 1 - Cadastros base

- [x] Criar as estruturas de Mecanico, Veiculo, Peca e OrdemServico.
- [x] Criar o menu principal.
- [x] Cadastrar mecanicos em vetor fixo.
- [x] Cadastrar clientes e veiculos em vetor fixo.
- [x] Cadastrar pecas em vetor fixo.
- [x] Listar os registros que estao na memoria RAM.
- [x] Impedir codigos e placas repetidos.

### Encontro 2 - Ordem de servico

- [ ] Cadastrar uma ordem de servico.
- [ ] Buscar a placa no vetor de veiculos.
- [ ] Buscar o mecanico pelo codigo.
- [ ] Buscar a peca pelo codigo.
- [ ] Validar a quantidade disponivel.
- [ ] Descontar a quantidade usada do estoque.

### Encontro 3 - Persistencia

- [ ] Salvar os vetores em arquivos CSV.
- [ ] Carregar os vetores ao iniciar o sistema.
- [ ] Confirmar que os dados sobrevivem ao encerramento.

### Encontro 4 - Relatorios e diferencial

- [ ] Relatorio de mao de obra por mecanico.
- [ ] Relatorio de pecas com estoque zerado.
- [ ] Relatorio de faturamento de pecas.
- [ ] Funcionalidade extra.

## Como compilar e executar

Dentro da pasta do projeto:

```powershell
javac -d bin src\*.java
java -cp bin App
```

## Versionamento

O planejamento esta documentado neste README, o arquivo `.gitignore` esta
configurado e o projeto esta publicado no GitHub. O fluxo utilizado segue os
comandos ensinados em aula:

```powershell
git init
git add .
git commit -m "Conclui os cadastros base do Encontro 1"
```

## Diario da IA

### Encontro 1

**1. Quais ferramentas, metodos ou bibliotecas proibidas a IA tentou incluir?**

Nenhuma. Desde o primeiro pedido, a IA recebeu os materiais das aulas e foi
instruida a utilizar somente logica estruturada, vetores fixos e os recursos
ensinados pelo professor. O codigo foi conferido para garantir que nao ha
colecoes dinamicas, banco de dados ou orientacao a objetos avancada.

**2. Qual prompt foi usado para manter o padrao estruturado?**

O grupo informou que todo o codigo deveria seguir exclusivamente o conteudo
dos PDFs da disciplina. Tambem determinou que fossem usados vetores nativos de
tamanho fixo, classes simples apenas com atributos publicos, metodos
`public static`, lacos tradicionais e `Scanner`, sem `ArrayList`, `List`, SQL,
frameworks, encapsulamento ou metodos dentro das estruturas de dados.

**3. Qual regra de negocio precisou ser corrigida manualmente?**

No Encontro 1, a regra cruzada da ordem de servico ainda nao foi implementada.
Foram revisadas as validacoes dos cadastros para impedir codigo repetido de
mecanico, placa repetida de veiculo e codigo repetido de peca. Esta resposta
sera complementada nos proximos encontros, principalmente durante a validacao
e o desconto de estoque.
