package ifsc.jvgc.view;

import ifsc.jvgc.model.*;
import ifsc.jvgc.strategy.*;
import ifsc.jvgc.template.*;

import java.time.LocalDate;
import java.util.*;

public class MenuInterativo {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<AtividadeRealizada> atividadesRealizadas = new ArrayList<>();
    private static final Aluno aluno = new Aluno(1, "Ana");
    private static final Requerimento requerimento = new Requerimento(1, aluno, LocalDate.now(), null);

    public static void exibirMenu() {
        Map<Integer, Modalidade> modalidades = carregarModalidades();

        while (true) {
            System.out.println("\n--- MENU DE MODALIDADES ---");
            for (Map.Entry<Integer, Modalidade> entry : modalidades.entrySet()) {
                System.out.printf("%d - %s\n", entry.getKey(), entry.getValue().getNome());
            }
            System.out.println("0 - Finalizar e gerar parecer");

            int escolhaModalidade = lerOpcao();
            if (escolhaModalidade == 0) break;

            Modalidade modalidadeSelecionada = modalidades.get(escolhaModalidade);
            if (modalidadeSelecionada == null) {
                System.out.println("Modalidade inválida.");
                continue;
            }

            exibirSubmenuAtividades(modalidadeSelecionada);
        }

        if (atividadesRealizadas.isEmpty()) {
            System.out.println("Nenhuma atividade informada. Finalizando...\n");
            return;
        }
        gerarParecer();
    }

    private static void exibirSubmenuAtividades(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> atividades = carregarAtividadesPorModalidade(modalidade);

        while (true) {
            System.out.printf("\n--- ATIVIDADES DA MODALIDADE: %s ---\n", modalidade.getNome());
            for (Map.Entry<Integer, AtividadeComplementar> entry : atividades.entrySet()) {
                System.out.printf("%d - %s\n", entry.getKey(), entry.getValue().descricao());
            }
            System.out.println("0 - Voltar ao menu anterior");

            int escolhaAtividade = lerOpcao();
            if (escolhaAtividade == 0) break;

            AtividadeComplementar atividade = atividades.get(escolhaAtividade);
            if (atividade == null) {
                System.out.println("Atividade inválida.");
                continue;
            }

            System.out.print("Digite as horas declaradas: ");
            int horasDeclaradas = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            AtividadeRealizada realizada = new AtividadeRealizada(
                    atividadesRealizadas.size() + 1,
                    requerimento,
                    atividade,
                    horasDeclaradas,
                    "certificado.pdf"
            );

            ProcessoValidacaoAtividade processo = new ProcessoValidacaoPadrao();
            processo.validar(realizada, new ValidacaoComLimiteMaximo());

            atividadesRealizadas.add(realizada);
            System.out.println("Atividade registrada com sucesso.");
        }
    }

    private static void gerarParecer() {
        System.out.println("\n=== PARECER DE VALIDAÇÃO ===");
        System.out.println("Matrícula: " + aluno.matricula());
        System.out.println("Data emissão: " + LocalDate.now());

        int totalDeclaradas = 0;
        int totalValidadas = 0;

        int count = 1;
        for (AtividadeRealizada ar : atividadesRealizadas) {
            int declaradas = ar.horasApresentadas();
            int validadas = ar.horasValidadas();
            String desc = ar.atividade().descricao();
            int limite = ar.atividade().limiteMaximo();

            System.out.println("\nAtividade " + count++ + ":");
            System.out.println("  Descrição:       " + desc);
            System.out.println("  Horas declaradas: " + declaradas + "h");
            System.out.println("  Limite Máximo:    " + limite + "h");
            System.out.println("  Horas validadas:  " + validadas + "h");
            System.out.println("  Observação:      " + ar.observacao());

            totalDeclaradas += declaradas;
            totalValidadas += validadas;
        }

        System.out.println("\nResumo geral:");
        System.out.println("  Total de horas declaradas: " + totalDeclaradas + "h");
        System.out.println("  Total de horas validadas:  " + totalValidadas + "h");
    }

    private static int lerOpcao() {
        System.out.print("Escolha: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static Map<Integer, Modalidade> carregarModalidades() {
        Map<Integer, Modalidade> map = new LinkedHashMap<>();
        map.put(1, new Modalidade(1, "Ensino"));
        map.put(2, new Modalidade(2, "Pesquisa"));
        map.put(3, new Modalidade(3, "Extensão"));
        map.put(4, new Modalidade(4, "Representação Discente"));
        return map;
    }

    private static Map<Integer, AtividadeComplementar> carregarAtividadesPorModalidade(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();

        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria(1, "Certificado");
        HorasPorAtividade horas = new HorasPorAtividade(1, "Conforme documento");

        // Exemplo de atividades genéricas por modalidade
        if (modalidade.getNome().equals("Ensino")) {
            map.put(1, new AtividadeComplementar(1, "Monitoria", doc, horas, 60, modalidade));
            map.put(2, new AtividadeComplementar(2, "Curso de Línguas", doc, horas, 40, modalidade));
        } else if (modalidade.getNome().equals("Pesquisa")) {
            map.put(1, new AtividadeComplementar(3, "Iniciação Científica", doc, horas, 100, modalidade));
            map.put(2, new AtividadeComplementar(4, "Publicação de Artigo", doc, horas, 80, modalidade));
        } else if (modalidade.getNome().equals("Extensão")) {
            map.put(1, new AtividadeComplementar(5, "Curso de Extensão", doc, horas, 40, modalidade));
        } else if (modalidade.getNome().equals("Representação Discente")) {
            map.put(1, new AtividadeComplementar(6, "Representante de Turma", doc, horas, 30, modalidade));
        }

        return map;
    }
}
