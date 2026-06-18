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
- Importacao explicita apenas de `Scanner`, `File`, `FileWriter` e
  `PrintWriter` nos encontros concluidos.

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
|-- mecanicos.csv
|-- veiculos.csv
|-- pecas.csv
|-- ordens_servico.csv
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

- [x] Cadastrar uma ordem de servico em vetor fixo.
- [x] Impedir numeros de OS repetidos.
- [x] Buscar a placa no vetor de veiculos.
- [x] Buscar o mecanico pelo codigo.
- [x] Buscar a peca pelo codigo.
- [x] Validar a quantidade solicitada.
- [x] Bloquear a OS quando o estoque for insuficiente.
- [x] Descontar a quantidade usada somente depois de todas as validacoes.
- [x] Listar as ordens de servico abertas.

#### Regras validadas

- Uma placa nao cadastrada bloqueia a abertura da OS.
- Um mecanico nao cadastrado bloqueia a abertura da OS.
- Uma peca nao cadastrada bloqueia a abertura da OS.
- Quantidade zero, negativa ou maior que o estoque bloqueia a abertura.
- Mao de obra negativa bloqueia a abertura.
- Uma OS bloqueada nao altera o estoque.
- Uma OS aceita e armazenada no vetor desconta a peca imediatamente.

### Encontro 3 - Persistencia

- [x] Salvar mecanicos em `mecanicos.csv`.
- [x] Salvar veiculos em `veiculos.csv`.
- [x] Salvar pecas em `pecas.csv`.
- [x] Salvar ordens de servico em `ordens_servico.csv`.
- [x] Carregar todos os vetores ao iniciar o sistema.
- [x] Salvar todos os vetores ao encerrar o sistema.
- [x] Salvar imediatamente apos cada cadastro e apos cada OS aberta.
- [x] Confirmar que os dados sobrevivem ao encerramento.

### Encontro 4 - Relatorios e diferencial

- [x] Relatorio de mao de obra por mecanico.
- [x] Relatorio de pecas com estoque zerado.
- [x] Relatorio de faturamento de pecas.
- [x] Funcionalidade extra: historico de ordens por placa.

#### Relatorios disponiveis

- Comissao da equipe: soma a mao de obra gerada por cada mecanico.
- Inventario critico: mostra apenas as pecas com quantidade zero.
- Faturamento de pecas: soma quantidade usada na OS multiplicada pelo preco
  unitario gravado na propria OS.
- Historico por placa: diferencial que mostra as OS de um veiculo e o total
  gasto por ele.

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
git add .
git commit -m "Implementa persistencia e relatorios finais"
git push
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

### Encontro 2

**1. Quais ferramentas, metodos ou bibliotecas proibidas a IA tentou incluir?**

Nenhuma. A implementacao foi mantida em vetores fixos, lacos tradicionais,
metodos `public static` e busca sequencial com `for`. Nao foram usados
`ArrayList`, `List`, banco de dados, streams ou recursos de orientacao a
objetos avancada.

**2. Qual prompt foi usado para manter o padrao estruturado?**

Foi solicitado que a abertura da OS utilizasse somente os assuntos presentes
nos PDFs da disciplina: vetor nativo de tamanho fixo, classes de dados apenas
com atributos publicos, funcoes estaticas, `Scanner`, condicionais e lacos. O
prompt tambem exigiu a busca manual da placa, do mecanico e da peca dentro dos
vetores, sem colecoes dinamicas ou banco de dados.

**3. Qual regra de negocio precisou ser revisada ou debugada manualmente?**

A regra mais delicada foi o desconto da peca no estoque. Durante a revisao
manual, o grupo garantiu que a subtracao acontecesse somente depois de validar
todos os dados da OS, inclusive o valor da mao de obra. Foram executados testes
com placa, mecanico e peca inexistentes, estoque insuficiente e mao de obra
negativa. Em todos esses casos, a OS foi bloqueada e o estoque permaneceu
inalterado.

### Encontro 3

**1. Quais ferramentas, metodos ou bibliotecas proibidas a IA tentou incluir?**

Nenhuma. A persistencia foi feita com arquivos de texto CSV, usando `File`,
`FileWriter`, `PrintWriter`, `Scanner`, `split(";")`, vetores fixos e lacos
tradicionais.

**2. Qual prompt foi usado para manter o padrao estruturado?**

Foi solicitado que o sistema salvasse e carregasse todos os vetores em arquivos
CSV, sem banco de dados, sem `ArrayList`, sem serializacao automatica e sem
frameworks. Tambem foi pedido que os arquivos fossem lidos para a memoria no
inicio do programa e gravados novamente ao encerrar.

**3. Qual regra de negocio precisou ser revisada ou debugada manualmente?**

Foi revisado o carregamento das ordens de servico para que cada OS mantenha o
preco unitario da peca no momento do lancamento. Assim, o relatorio de
faturamento continua correto mesmo depois que o sistema fecha e abre de novo.
Depois dos testes em laboratorio, o grupo tambem ajustou o salvamento para
acontecer imediatamente apos cada cadastro e apos cada OS aberta, evitando perda
de dados quando o programa e interrompido pelo botao de parar do VS Code.

### Encontro 4

**1. Quais ferramentas, metodos ou bibliotecas proibidas a IA tentou incluir?**

Nenhuma. Os relatorios foram implementados com varreduras sequenciais nos
vetores, comparacoes com `if` e acumuladores numericos.

**2. Qual prompt foi usado para manter o padrao estruturado?**

Foi solicitado que os relatorios fossem feitos apenas com os dados ja carregados
em memoria, usando vetores fixos e lacos `for`, sem consultas SQL, colecoes
dinamicas ou bibliotecas externas.

**3. Qual regra de negocio precisou ser revisada ou debugada manualmente?**

A regra principal foi o faturamento de pecas. O grupo verificou que o calculo
usa `quantidadePeca * precoUnitarioPeca` em cada OS. Tambem foi testado o
inventario critico com peca zerada e o historico por placa como funcionalidade
diferencial.
