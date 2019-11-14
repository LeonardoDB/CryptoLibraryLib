package br.univali.portugol.plugin.exemplo.biblioteca;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import javax.swing.JOptionPane;

@PropriedadesBiblioteca(tipo = TipoBiblioteca.COMPARTILHADA)
@DocumentacaoBiblioteca(
        descricao = "Esta biblioteca é um exemplo de como criar funções de biblioteca",
        versao = "0.01"
)
public final class Exemplo extends Biblioteca {

    @DocumentacaoFuncao(
            descricao = "Função de exemplo da biblioteca de exemplo sem parâmetros, mas com retorno",
            retorno = "Uma cadeia que mostra a função funcionando",
            autores
            = {
                @Autor(nome = "Seu nome de Autor", email = "seu_email@edu.univali.br")
            }
    )
    public void funcao_de_exemplo_1() throws ErroExecucaoBiblioteca, InterruptedException {
        int tam = 2;
        
        Crypto obj[] = new Crypto[tam];

        // CREATE
        for (int i = 0; i < tam; i++) {
            obj[i] = new Crypto("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
        }
        
        // WRITE
        for (int i = 0; i < tam; i++) {
            System.out.println(obj[i].id);
        }
    }

    @DocumentacaoFuncao(
            descricao = "Função de exemplo da biblioteca de exemplo com parâmetros, porém sem retorno",
            parametros
            = {
                @DocumentacaoParametro(nome = "frase", descricao = "Uma frase para apresentar na tela")
            },
            autores
            = {
                @Autor(nome = "Seu nome de Autor", email = "seu_email@edu.univali.br")
            }
    )

    public void mostra_frase(String frase) throws ErroExecucaoBiblioteca, InterruptedException {
        JOptionPane.showConfirmDialog(null, frase);
    }

    // 
}
