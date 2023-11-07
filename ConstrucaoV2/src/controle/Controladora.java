package controle;

import modelo.Aberturas;
import modelo.Casa;
import modelo.Janela;
import modelo.Porta;
import visualizacao.EntradaSaida;

import javax.swing.*;
import java.util.ArrayList;

public class Controladora {

    private Casa casa = null;

    public void exibeMenu()
    {
        int opcao;
        do {
            opcao = EntradaSaida.solicitaOpcao();

            switch (opcao)
            {
                case 0:
                    JOptionPane.showMessageDialog(null, "Construir casa");

                    this.casa = new Casa();

                    String descricao = EntradaSaida.solicitaDescricao("casa", 0);
                    String cor = EntradaSaida.solicitaCor();
                    int qtdDePortas = EntradaSaida.solicitaQtdDeAberturas("portas");
                    int qtdDeJanelas = EntradaSaida.solicitaQtdDeAberturas("janelas");

                    ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();

                    for(int i=0; i<qtdDePortas; i++){
                        Porta porta = new Porta();
                        porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i+1)));
                        porta.setEstado(EntradaSaida.solicitaEstado("porta"));
                        listaDePortas.add(porta);
                    }

                    ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

                    for (int i=0; i<qtdDeJanelas; i++){
                        Janela janela = new Janela();
                        janela.setDescricao(EntradaSaida.solicitaDescricao("janela", (i+1)));
                        janela.setEstado(EntradaSaida.solicitaEstado("janela"));
                        listaDeJanelas.add(janela);
                    }

                    this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);

                    System.out.println("Descrição da casa: " + casa.getDescricao() + "\n");
                    System.out.println("Cor da casa: " + casa.getCor() + "\n");

                    for(Aberturas porta : casa.getListaDePortas()){
                        System.out.println("Descrição da janela: " + porta.getDescricao() + "\n");
                        System.out.println("Estado da porta: " + porta.getEstado() + "\n");
                    }

                    for(Aberturas janela : casa.getListaDeJanelas()){
                        System.out.println("Descrição da janela: " + janela.getDescricao() + "\n");
                        System.out.println("Estado da janela: " + janela.getEstado() + "\n");
                    }

                break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Movimentar portas ou janelas");
                break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Ver informações da casa");
                break;
            }
        }while(opcao != 3);

        EntradaSaida.exibeMsgEncerrarPrograma();
        System.exit(0);
    }
}
