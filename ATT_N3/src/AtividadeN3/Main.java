package AtividadeN3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static NoArvore raiz = null;
    private static List<Integer> valoresEmOrdem = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Árvore Binária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new FlowLayout());

        JButton adicionarButton = new JButton("Adicionar Número");
        JButton listarButton = new JButton("Listar Números");

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Loop para inserir vários números
                while (true) {
                    String input = JOptionPane.showInputDialog("Digite um número (ou clique em Cancelar para encerrar):");
                    if (input == null) {
                        break; // O usuário clicou em Cancelar, sair do loop
                    }
                    try {
                        int valor = Integer.parseInt(input);
                        raiz = inserir(raiz, valor);
                        SaidaDados.exibirMensagem("Número adicionado com sucesso!");
                    } catch (NumberFormatException ex) {
                        SaidaDados.exibirMensagem("Por favor, insira um número válido.");
                    }
                }
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valoresEmOrdem.clear();
                listarEmOrdem(raiz);
                String mensagem = "Números em ordem: " + valoresEmOrdem.toString();
                SaidaDados.exibirMensagem(mensagem);
            }
        });

        panel.add(adicionarButton);
        panel.add(listarButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static NoArvore inserir(NoArvore raiz, int valor) {
        if (raiz == null) {
            return new NoArvore(valor);
        }
        if (valor < raiz.valor) {
            raiz.esquerda = inserir(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserir(raiz.direita, valor);
        }
        return raiz;
    }

    public static void listarEmOrdem(NoArvore raiz) {
        if (raiz != null) {
            listarEmOrdem(raiz.esquerda);
            valoresEmOrdem.add(raiz.valor);
            listarEmOrdem(raiz.direita);
        }
    }
}
