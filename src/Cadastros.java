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
}
