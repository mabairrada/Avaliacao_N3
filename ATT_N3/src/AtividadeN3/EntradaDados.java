package AtividadeN3;

import javax.swing.JOptionPane;

public class EntradaDados {
    public static int obterValorPesquisa() {
        String input = JOptionPane.showInputDialog("Digite um valor para pesquisar:");
        return Integer.parseInt(input);
    }
}

