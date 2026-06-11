import java.util.Scanner;

public class OrdensServico {
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
        int posicaoVeiculo = Cadastros.buscarVeiculoPorPlaca(
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
        int posicaoMecanico = Cadastros.buscarMecanicoPorCodigo(
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
        int posicaoPeca = Cadastros.buscarPecaPorCodigo(
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
            int posicaoMecanico = Cadastros.buscarMecanicoPorCodigo(
                mecanicos,
                totalMecanicos,
                ordensServico[i].codigoMecanico
            );
            int posicaoVeiculo = Cadastros.buscarVeiculoPorPlaca(
                veiculos,
                totalVeiculos,
                ordensServico[i].placaVeiculo
            );
            int posicaoPeca = Cadastros.buscarPecaPorCodigo(
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
