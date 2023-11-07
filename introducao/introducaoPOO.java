package introducao;

import java.util.Scanner;
//Importando classe JOptionPane para usarmos os paineis de diálogo
import javax.swing.JOptionPane;

public class introducaoPOO {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] valores = new int[10];

        for(int i=0; i<10; i++)
        {
            valores[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (i+1) + "º valor: "));
        }
        String repetir;

        do
        {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja ver?:"
                    + "\n1 - Todos os valores"
                    + "\n2 - Somente o primeiro valor"
                    + "\n3 - Somente o último valor"
                    + "\n4 - Ver os valores pares"));

            switch (opcao)
            {
                case 1:
                    for(int i=0; i<10; i++)
                    {
                        JOptionPane.showMessageDialog(null, valores[i], "Valor " + (i+1), JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, valores[0], "Primeiro valor ", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, valores[9], "Último valor ", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4:
                    String valoresPares = "";
                    for(int i=0; i<10; i++)
                    {
                        if(valores[i] % 2 == 0)
                        {
                            if(valoresPares != "")
                            {
                                valoresPares += ", ";
                            }
                            valoresPares += valores[i];
                        }
                    }
                    JOptionPane.showInputDialog(null, valoresPares, "Valores pares ", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida ", "Erro ", JOptionPane.INFORMATION_MESSAGE);
            }

            repetir = JOptionPane.showInputDialog("Deseja voltar ao menu?"
                    + "\nDigite S para sim ou outro caractere para encerrar:");
        }while(repetir.equals("S"));


    }
}
