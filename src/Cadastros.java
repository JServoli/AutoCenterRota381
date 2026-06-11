import java.util.Scanner;

public class Cadastros {
    public static int cadastrarMecanico(
        Scanner leitor,
        Mecanico[] mecanicos,
        int totalMecanicos
    ) {
        if (totalMecanicos >= mecanicos.length) {
            System.out.println("\nNao ha mais espaco para cadastrar mecanicos.");
            return totalMecanicos;
        }

        System.out.println("\n--- CADASTRO DE MECANICO ---");
        int codigo = Leitura.lerInteiro(leitor, "Codigo: ");

        if (codigo <= 0) {
            System.out.println("O codigo deve ser maior que zero.");
            return totalMecanicos;
        }

        if (buscarMecanicoPorCodigo(mecanicos, totalMecanicos, codigo) != -1) {
            System.out.println("Ja existe um mecanico com esse codigo.");
            return totalMecanicos;
        }

        Mecanico novoMecanico = new Mecanico();
        novoMecanico.codigo = codigo;
        novoMecanico.nome = Leitura.lerTexto(leitor, "Nome: ");
        novoMecanico.especialidade = Leitura.lerTexto(
            leitor,
            "Especialidade: "
        );

        mecanicos[totalMecanicos] = novoMecanico;
        System.out.println("Mecanico cadastrado com sucesso.");
        return totalMecanicos + 1;
    }

    public static int cadastrarVeiculo(
        Scanner leitor,
        Veiculo[] veiculos,
        int totalVeiculos
    ) {
        if (totalVeiculos >= veiculos.length) {
            System.out.println("\nNao ha mais espaco para cadastrar veiculos.");
            return totalVeiculos;
        }

        System.out.println("\n--- CADASTRO DE VEICULO ---");
        String placa = Leitura.lerTexto(leitor, "Placa: ");

        if (buscarVeiculoPorPlaca(veiculos, totalVeiculos, placa) != -1) {
            System.out.println("Ja existe um veiculo com essa placa.");
            return totalVeiculos;
        }

        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.placa = placa;
        novoVeiculo.nomeDono = Leitura.lerTexto(leitor, "Nome do dono: ");
        novoVeiculo.modelo = Leitura.lerTexto(leitor, "Modelo: ");

        veiculos[totalVeiculos] = novoVeiculo;
        System.out.println("Veiculo cadastrado com sucesso.");
        return totalVeiculos + 1;
    }

    public static int cadastrarPeca(
        Scanner leitor,
        Peca[] pecas,
        int totalPecas
    ) {
        if (totalPecas >= pecas.length) {
            System.out.println("\nNao ha mais espaco para cadastrar pecas.");
            return totalPecas;
        }

        System.out.println("\n--- CADASTRO DE PECA ---");
        int codigo = Leitura.lerInteiro(leitor, "Codigo: ");

        if (codigo <= 0) {
            System.out.println("O codigo deve ser maior que zero.");
            return totalPecas;
        }

        if (buscarPecaPorCodigo(pecas, totalPecas, codigo) != -1) {
            System.out.println("Ja existe uma peca com esse codigo.");
            return totalPecas;
        }

        String descricao = Leitura.lerTexto(leitor, "Descricao: ");
        int quantidade = Leitura.lerInteiro(
            leitor,
            "Quantidade em estoque: "
        );

        if (quantidade < 0) {
            System.out.println("A quantidade nao pode ser negativa.");
            return totalPecas;
        }

        double preco = Leitura.lerDouble(leitor, "Preco unitario: R$ ");

        if (preco < 0) {
            System.out.println("O preco nao pode ser negativo.");
            return totalPecas;
        }

        Peca novaPeca = new Peca();
        novaPeca.codigo = codigo;
        novaPeca.descricao = descricao;
        novaPeca.quantidadeEstoque = quantidade;
        novaPeca.precoUnitario = preco;

        pecas[totalPecas] = novaPeca;
        System.out.println("Peca cadastrada com sucesso.");
        return totalPecas + 1;
    }

    public static int buscarMecanicoPorCodigo(
        Mecanico[] mecanicos,
        int totalMecanicos,
        int codigo
    ) {
        for (int i = 0; i < totalMecanicos; i++) {
            if (mecanicos[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    public static int buscarVeiculoPorPlaca(
        Veiculo[] veiculos,
        int totalVeiculos,
        String placa
    ) {
        for (int i = 0; i < totalVeiculos; i++) {
            if (veiculos[i].placa.equalsIgnoreCase(placa)) {
                return i;
            }
        }

        return -1;
    }

    public static int buscarPecaPorCodigo(
        Peca[] pecas,
        int totalPecas,
        int codigo
    ) {
        for (int i = 0; i < totalPecas; i++) {
            if (pecas[i].codigo == codigo) {
                return i;
            }
        }

        return -1;
    }

    public static void listarMecanicos(
        Mecanico[] mecanicos,
        int totalMecanicos
    ) {
        System.out.println("\n--- MECANICOS CADASTRADOS ---");

        if (totalMecanicos == 0) {
            System.out.println("Nenhum mecanico cadastrado.");
            return;
        }

        for (int i = 0; i < totalMecanicos; i++) {
            System.out.println(
                "Codigo: " + mecanicos[i].codigo
                + " | Nome: " + mecanicos[i].nome
                + " | Especialidade: " + mecanicos[i].especialidade
            );
        }
    }

    public static void listarVeiculos(
        Veiculo[] veiculos,
        int totalVeiculos
    ) {
        System.out.println("\n--- VEICULOS CADASTRADOS ---");

        if (totalVeiculos == 0) {
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }

        for (int i = 0; i < totalVeiculos; i++) {
            System.out.println(
                "Placa: " + veiculos[i].placa
                + " | Dono: " + veiculos[i].nomeDono
                + " | Modelo: " + veiculos[i].modelo
            );
        }
    }

    public static void listarPecas(Peca[] pecas, int totalPecas) {
        System.out.println("\n--- PECAS CADASTRADAS ---");

        if (totalPecas == 0) {
            System.out.println("Nenhuma peca cadastrada.");
            return;
        }

        for (int i = 0; i < totalPecas; i++) {
            System.out.printf(
                "Codigo: %d | Descricao: %s | Quantidade: %d | Preco: R$ %.2f%n",
                pecas[i].codigo,
                pecas[i].descricao,
                pecas[i].quantidadeEstoque,
                pecas[i].precoUnitario
            );
        }
    }

    public static int abrirOrdemServico(
        Scanner leitor,
        OrdemServico[] ordensServico,
        int totalOrdensServico,
        Mecanico[] mecanicos,
        int totalMecanicos,
        Veiculo[] veiculos,
        int totalVeiculos,
        Peca[] pecas,
        int totalPecas
    ) {
        if (totalOrdensServico >= ordensServico.length) {
            System.out.println("\nNao ha mais espaco para ordens de servico.");
            return totalOrdensServico;
        }

        System.out.println("\n--- ABERTURA DE ORDEM DE SERVICO ---");
        int numero = Leitura.lerInteiro(leitor, "Numero da OS: ");

        if (numero <= 0) {
            System.out.println("O numero da OS deve ser maior que zero.");
            return totalOrdensServico;
        }

        if (buscarOrdemPorNumero(
            ordensServico,
            totalOrdensServico,
            numero
        ) != -1) {
            System.out.println("Ja existe uma ordem de servico com esse numero.");
            return totalOrdensServico;
        }

        String placa = Leitura.lerTexto(leitor, "Placa do veiculo: ");
        int posicaoVeiculo = buscarVeiculoPorPlaca(
            veiculos,
            totalVeiculos,
            placa
        );

        if (posicaoVeiculo == -1) {
            System.out.println(
                "Veiculo nao cadastrado. A ordem de servico foi bloqueada."
            );
            return totalOrdensServico;
        }

        int codigoMecanico = Leitura.lerInteiro(
            leitor,
            "Codigo do mecanico: "
        );
        int posicaoMecanico = buscarMecanicoPorCodigo(
            mecanicos,
            totalMecanicos,
            codigoMecanico
        );

        if (posicaoMecanico == -1) {
            System.out.println(
                "Mecanico nao cadastrado. A ordem de servico foi bloqueada."
            );
            return totalOrdensServico;
        }

        int codigoPeca = Leitura.lerInteiro(leitor, "Codigo da peca: ");
        int posicaoPeca = buscarPecaPorCodigo(
            pecas,
            totalPecas,
            codigoPeca
        );

        if (posicaoPeca == -1) {
            System.out.println(
                "Peca nao cadastrada. A ordem de servico foi bloqueada."
            );
            return totalOrdensServico;
        }

        int quantidadePeca = Leitura.lerInteiro(
            leitor,
            "Quantidade da peca: "
        );

        if (quantidadePeca <= 0) {
            System.out.println(
                "A quantidade deve ser maior que zero. A OS foi bloqueada."
            );
            return totalOrdensServico;
        }

        if (quantidadePeca > pecas[posicaoPeca].quantidadeEstoque) {
            System.out.println("Estoque insuficiente. A OS foi bloqueada.");
            System.out.println(
                "Quantidade disponivel: "
                + pecas[posicaoPeca].quantidadeEstoque
            );
            return totalOrdensServico;
        }

        double valorMaoDeObra = Leitura.lerDouble(
            leitor,
            "Valor da mao de obra: R$ "
        );

        if (valorMaoDeObra < 0) {
            System.out.println(
                "O valor da mao de obra nao pode ser negativo. A OS foi bloqueada."
            );
            return totalOrdensServico;
        }

        OrdemServico novaOrdem = new OrdemServico();
        novaOrdem.numero = numero;
        novaOrdem.placaVeiculo = veiculos[posicaoVeiculo].placa;
        novaOrdem.codigoMecanico = mecanicos[posicaoMecanico].codigo;
        novaOrdem.codigoPeca = pecas[posicaoPeca].codigo;
        novaOrdem.quantidadePeca = quantidadePeca;
        novaOrdem.valorMaoDeObra = valorMaoDeObra;

        ordensServico[totalOrdensServico] = novaOrdem;
        pecas[posicaoPeca].quantidadeEstoque =
            pecas[posicaoPeca].quantidadeEstoque - quantidadePeca;

        System.out.println("Ordem de servico aberta com sucesso.");
        System.out.println(
            "Estoque restante da peca: "
            + pecas[posicaoPeca].quantidadeEstoque
        );
        return totalOrdensServico + 1;
    }

    public static int buscarOrdemPorNumero(
        OrdemServico[] ordensServico,
        int totalOrdensServico,
        int numero
    ) {
        for (int i = 0; i < totalOrdensServico; i++) {
            if (ordensServico[i].numero == numero) {
                return i;
            }
        }

        return -1;
    }

    public static void listarOrdensServico(
        OrdemServico[] ordensServico,
        int totalOrdensServico,
        Mecanico[] mecanicos,
        int totalMecanicos,
        Veiculo[] veiculos,
        int totalVeiculos,
        Peca[] pecas,
        int totalPecas
    ) {
        System.out.println("\n--- ORDENS DE SERVICO ---");

        if (totalOrdensServico == 0) {
            System.out.println("Nenhuma ordem de servico cadastrada.");
            return;
        }

        for (int i = 0; i < totalOrdensServico; i++) {
            int posicaoMecanico = buscarMecanicoPorCodigo(
                mecanicos,
                totalMecanicos,
                ordensServico[i].codigoMecanico
            );
            int posicaoVeiculo = buscarVeiculoPorPlaca(
                veiculos,
                totalVeiculos,
                ordensServico[i].placaVeiculo
            );
            int posicaoPeca = buscarPecaPorCodigo(
                pecas,
                totalPecas,
                ordensServico[i].codigoPeca
            );

            System.out.println("\nOS numero: " + ordensServico[i].numero);
            System.out.println(
                "Veiculo: " + veiculos[posicaoVeiculo].placa
                + " - " + veiculos[posicaoVeiculo].modelo
            );
            System.out.println(
                "Mecanico: " + mecanicos[posicaoMecanico].nome
                + " - " + mecanicos[posicaoMecanico].especialidade
            );
            System.out.println(
                "Peca: " + pecas[posicaoPeca].descricao
                + " | Quantidade usada: " + ordensServico[i].quantidadePeca
            );
            System.out.printf(
                "Mao de obra: R$ %.2f%n",
                ordensServico[i].valorMaoDeObra
            );
        }
    }
}
