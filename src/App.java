import java.util.Scanner;

public class App {
    public static final int LIMITE_MECANICOS = 50;
    public static final int LIMITE_VEICULOS = 100;
    public static final int LIMITE_PECAS = 100;
    public static final int LIMITE_ORDENS_SERVICO = 200;

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Mecanico[] mecanicos = new Mecanico[LIMITE_MECANICOS];
        Veiculo[] veiculos = new Veiculo[LIMITE_VEICULOS];
        Peca[] pecas = new Peca[LIMITE_PECAS];
        OrdemServico[] ordensServico = new OrdemServico[LIMITE_ORDENS_SERVICO];

        int totalMecanicos = Cadastros.carregarMecanicos(mecanicos);
        int totalVeiculos = Cadastros.carregarVeiculos(veiculos);
        int totalPecas = Cadastros.carregarPecas(pecas);
        int totalOrdensServico = Cadastros.carregarOrdensServico(ordensServico);
        int opcaoPrincipal;

        System.out.println("Dados carregados dos arquivos CSV.");

        do {
            exibirMenuPrincipal();
            opcaoPrincipal = Leitura.lerInteiro(leitor, "Escolha uma opcao: ");

            if (opcaoPrincipal == 1) {
                totalMecanicos = executarMenuMecanicos(
                    leitor,
                    mecanicos,
                    totalMecanicos
                );
            } else if (opcaoPrincipal == 2) {
                totalVeiculos = executarMenuVeiculos(
                    leitor,
                    veiculos,
                    totalVeiculos
                );
            } else if (opcaoPrincipal == 3) {
                totalPecas = executarMenuPecas(
                    leitor,
                    pecas,
                    totalPecas
                );
            } else if (opcaoPrincipal == 4) {
                totalOrdensServico = executarMenuOrdensServico(
                    leitor,
                    ordensServico,
                    totalOrdensServico,
                    mecanicos,
                    totalMecanicos,
                    veiculos,
                    totalVeiculos,
                    pecas,
                    totalPecas
                );
            } else if (opcaoPrincipal == 5) {
                executarMenuRelatorios(
                    leitor,
                    mecanicos,
                    totalMecanicos,
                    veiculos,
                    totalVeiculos,
                    pecas,
                    totalPecas,
                    ordensServico,
                    totalOrdensServico
                );
            } else if (opcaoPrincipal != 0) {
                System.out.println("Opcao invalida.");
            }
        } while (opcaoPrincipal != 0);

        Cadastros.salvarMecanicos(mecanicos, totalMecanicos);
        Cadastros.salvarVeiculos(veiculos, totalVeiculos);
        Cadastros.salvarPecas(pecas, totalPecas);
        Cadastros.salvarOrdensServico(ordensServico, totalOrdensServico);

        leitor.close();
        System.out.println("\nDados salvos nos arquivos CSV.");
        System.out.println("\nSistema encerrado.");
    }

    public static void exibirMenuPrincipal() {
        System.out.println("\n====================================");
        System.out.println("      AUTO CENTER ROTA 381");
        System.out.println("====================================");
        System.out.println("1 - Mecanicos");
        System.out.println("2 - Clientes e veiculos");
        System.out.println("3 - Estoque de pecas");
        System.out.println("4 - Ordens de servico");
        System.out.println("5 - Relatorios");
        System.out.println("0 - Sair");
        System.out.println("====================================");
    }

    public static int executarMenuMecanicos(
        Scanner leitor,
        Mecanico[] mecanicos,
        int totalMecanicos
    ) {
        int opcao;

        do {
            System.out.println("\n--- MENU DE MECANICOS ---");
            System.out.println("1 - Cadastrar mecanico");
            System.out.println("2 - Listar mecanicos");
            System.out.println("0 - Voltar");
            opcao = Leitura.lerInteiro(leitor, "Escolha uma opcao: ");

            if (opcao == 1) {
                totalMecanicos = Cadastros.cadastrarMecanico(
                    leitor,
                    mecanicos,
                    totalMecanicos
                );
            } else if (opcao == 2) {
                Cadastros.listarMecanicos(mecanicos, totalMecanicos);
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        return totalMecanicos;
    }

    public static int executarMenuVeiculos(
        Scanner leitor,
        Veiculo[] veiculos,
        int totalVeiculos
    ) {
        int opcao;

        do {
            System.out.println("\n--- MENU DE CLIENTES E VEICULOS ---");
            System.out.println("1 - Cadastrar veiculo");
            System.out.println("2 - Listar veiculos");
            System.out.println("0 - Voltar");
            opcao = Leitura.lerInteiro(leitor, "Escolha uma opcao: ");

            if (opcao == 1) {
                totalVeiculos = Cadastros.cadastrarVeiculo(
                    leitor,
                    veiculos,
                    totalVeiculos
                );
            } else if (opcao == 2) {
                Cadastros.listarVeiculos(veiculos, totalVeiculos);
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        return totalVeiculos;
    }

    public static int executarMenuPecas(
        Scanner leitor,
        Peca[] pecas,
        int totalPecas
    ) {
        int opcao;

        do {
            System.out.println("\n--- MENU DE ESTOQUE ---");
            System.out.println("1 - Cadastrar peca");
            System.out.println("2 - Listar pecas");
            System.out.println("0 - Voltar");
            opcao = Leitura.lerInteiro(leitor, "Escolha uma opcao: ");

            if (opcao == 1) {
                totalPecas = Cadastros.cadastrarPeca(
                    leitor,
                    pecas,
                    totalPecas
                );
            } else if (opcao == 2) {
                Cadastros.listarPecas(pecas, totalPecas);
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        return totalPecas;
    }

    public static int executarMenuOrdensServico(
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
        int opcao;

        do {
            System.out.println("\n--- MENU DE ORDENS DE SERVICO ---");
            System.out.println("1 - Abrir ordem de servico");
            System.out.println("2 - Listar ordens de servico");
            System.out.println("0 - Voltar");
            opcao = Leitura.lerInteiro(leitor, "Escolha uma opcao: ");

            if (opcao == 1) {
                totalOrdensServico = Cadastros.abrirOrdemServico(
                    leitor,
                    ordensServico,
                    totalOrdensServico,
                    mecanicos,
                    totalMecanicos,
                    veiculos,
                    totalVeiculos,
                    pecas,
                    totalPecas
                );
            } else if (opcao == 2) {
                Cadastros.listarOrdensServico(
                    ordensServico,
                    totalOrdensServico,
                    mecanicos,
                    totalMecanicos,
                    veiculos,
                    totalVeiculos,
                    pecas,
                    totalPecas
                );
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        return totalOrdensServico;
    }

    public static void executarMenuRelatorios(
        Scanner leitor,
        Mecanico[] mecanicos,
        int totalMecanicos,
        Veiculo[] veiculos,
        int totalVeiculos,
        Peca[] pecas,
        int totalPecas,
        OrdemServico[] ordensServico,
        int totalOrdensServico
    ) {
        int opcao;

        do {
            System.out.println("\n--- MENU DE RELATORIOS ---");
            System.out.println("1 - Comissao da equipe");
            System.out.println("2 - Inventario critico");
            System.out.println("3 - Faturamento de pecas");
            System.out.println("4 - Diferencial: historico por placa");
            System.out.println("0 - Voltar");
            opcao = Leitura.lerInteiro(leitor, "Escolha uma opcao: ");

            if (opcao == 1) {
                Cadastros.relatorioComissaoEquipe(
                    mecanicos,
                    totalMecanicos,
                    ordensServico,
                    totalOrdensServico
                );
            } else if (opcao == 2) {
                Cadastros.relatorioInventarioCritico(pecas, totalPecas);
            } else if (opcao == 3) {
                Cadastros.relatorioFaturamentoPecas(
                    pecas,
                    totalPecas,
                    ordensServico,
                    totalOrdensServico
                );
            } else if (opcao == 4) {
                Cadastros.relatorioHistoricoPorPlaca(
                    leitor,
                    veiculos,
                    totalVeiculos,
                    pecas,
                    totalPecas,
                    ordensServico,
                    totalOrdensServico
                );
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }
}
