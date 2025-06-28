package ifsc.jvgc.view;

import ifsc.jvgc.controller.MenuController;
import ifsc.jvgc.model.entities.Aluno;
import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.Curso;
import ifsc.jvgc.model.entities.Matricula;
import ifsc.jvgc.model.entities.modalidades.Modalidade;

import java.util.Map;
import java.util.Scanner;

public class MenuInterativo {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Matricula matricula = new Matricula(
            146846,
            new Curso("Analise e desenvolvimento de sistemas", 100),
            new Aluno("Ana")
    );
    private static final MenuController controller = new MenuController(matricula);

    public static void exibirMenu() {
        while (true) {
            System.out.println("\n--- MENU DE MODALIDADES ---");
            controller.getModalidades().forEach((k, v) -> System.out.printf("%d - %s\n", k, v.nome()));
            System.out.println("0 - Finalizar e gerar parecer");

            int escolha = lerOpcao();
            if (escolha == 0) break;

            Modalidade modalidade = controller.getModalidade(escolha);
            if (modalidade == null) {
                System.out.println("Modalidade inválida.");
                continue;
            }

            exibirSubmenuAtividades(modalidade);
        }

        emitirRelatorioParecer();
    }

    private static void exibirSubmenuAtividades(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> atividades = controller.getAtividades(modalidade);

        while (true) {
            System.out.printf("\n--- ATIVIDADES DA MODALIDADE: %s ---\n", modalidade.nome());
            atividades.forEach((k, v) -> System.out.printf("%d - %s\n", k, v.descricao()));
            System.out.println("0 - Voltar");

            int escolha = lerOpcao();
            if (escolha == 0) break;

            System.out.print("Digite as horas declaradas: ");
            int horas = lerOpcao();

            String resultado = controller.validarAtividade(modalidade, escolha, horas);
            System.out.println(resultado);
        }
    }

    public static void emitirRelatorioParecer(){
        if (!controller.temValidacoes()) {
            System.out.println("Nenhuma atividade validada.");
            return;
        }

        String textoParecer;
        while (true) {
            System.out.print("Digite o texto do parecer final: ");
            textoParecer = scanner.nextLine().trim();

            if (!textoParecer.isEmpty()) break;
            System.out.println("O texto do parecer não pode estar vazio. Tente novamente.");
        }

        String relatorioParecer = controller.gerarParecer(textoParecer);
        System.out.println(relatorioParecer);
    }

    private static int lerOpcao() {
        System.out.print("Escolha: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
