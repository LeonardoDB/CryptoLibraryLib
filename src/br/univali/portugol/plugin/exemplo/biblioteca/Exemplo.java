package br.univali.portugol.plugin.exemplo.biblioteca;

import br.univali.portugol.nucleo.bibliotecas.base.Biblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.TipoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.Autor;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoBiblioteca;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoFuncao;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.DocumentacaoParametro;
import br.univali.portugol.nucleo.bibliotecas.base.anotacoes.PropriedadesBiblioteca;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@PropriedadesBiblioteca(tipo = TipoBiblioteca.COMPARTILHADA)
@DocumentacaoBiblioteca(
        descricao = "Esta biblioteca é um exemplo de como criar funções de biblioteca",
        versao = "0.01"
)
public final class Exemplo extends Biblioteca {

    TesteTrabalho myTypes;
    Crypto obj[];
    int tam;
    boolean failsafe = false;

    @DocumentacaoFuncao(
            descricao = "Faz a requisição inicial para a API contendo os dados sobre as criptomoedas (IMPORTANTE: UTILIZAR ESSA FUNÇÃO ANTES DE QUALQUER OUTRA)",
            retorno = "SEM RETORNO",
            autores = {
                @Autor(nome = "Daniel A. Battisti, Leonardo Dalbosco, Victor H. F. Wachsmann", email = "daniel.ab@edu.univali.br; leodalbosco@hotmail.com")
            }
    )
    public void inicializa() throws ErroExecucaoBiblioteca, InterruptedException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.coincap.io/v2/assets").build();

        //   JOptionPane.showConfirmDialog(null, "request built");
        try (okhttp3.Response response = client.newCall(request).execute()) {

            //  JOptionPane.showConfirmDialog(null, "request successful");
            String str = response.body().string();
            System.out.println(str);
            //   JOptionPane.showConfirmDialog(null, str);

            //      JOptionPane.showConfirmDialog(null, "just before gson shit");
            Gson gsone = new Gson();

            //  JOptionPane.showConfirmDialog(null, "gson instantiated");
            myTypes = gsone.fromJson(str, TesteTrabalho.class);

            // JOptionPane.showConfirmDialog(null, "json data transfered to java object");
            tam = myTypes.data.size();

            obj = new Crypto[tam];

            for (int i = 0; i < tam; i++) {
                obj[i] = myTypes.data.get(i);
            }
//            JOptionPane.showConfirmDialog(null, "tamanho do obj" + obj.length);
        } catch (Exception ex) {
//            JOptionPane.showConfirmDialog(null, "gerou exceção");;
        }
    }

    @DocumentacaoFuncao(
            descricao = "Retorna a quantidade de criptomoedas",
            retorno = "Inteiro",
            autores = {
                @Autor(nome = "Daniel A. Battisti, Leonardo Dalbosco, Victor H. F. Wachsmann", email = "daniel.ab@edu.univali.br; leodalbosco@hotmail.com")
            }
    )
    public int pegaTamanho() throws ErroExecucaoBiblioteca, InterruptedException {
        return obj.length;
    }

    @DocumentacaoFuncao(
            descricao = "Retorna uma string com o nome da criptomoeda",
            parametros = {
                @DocumentacaoParametro(nome = "posicao", descricao = "Id")
            },
            retorno = "Cadeia",
            autores = {
                @Autor(nome = "Daniel A. Battisti, Leonardo Dalbosco, Victor H. F. Wachsmann", email = "daniel.ab@edu.univali.br; leodalbosco@hotmail.com")
            }
    )
    public String pegaNomeMoeda(int posicao) throws ErroExecucaoBiblioteca, InterruptedException {
        return obj[posicao].name;
    }

    @DocumentacaoFuncao(
            descricao = "Retorna uma string com o valor da criptomoeda",
            parametros = {
                @DocumentacaoParametro(nome = "posicao", descricao = "Id")
            },
            retorno = "Cadeia",
            autores = {
                @Autor(nome = "Daniel A. Battisti, Leonardo Dalbosco, Victor H. F. Wachsmann", email = "daniel.ab@edu.univali.br; leodalbosco@hotmail.com")
            }
    )
    public String pegaValorMoeda(int posicao) throws ErroExecucaoBiblioteca, InterruptedException {
        return obj[posicao].priceUsd;
    }

    @DocumentacaoFuncao(
            descricao = "Retorna uma string com simbolo da moeda",
            parametros = {
                @DocumentacaoParametro(nome = "posicao", descricao = "Id")
            },
            retorno = "Cadeia",
            autores
            = {
                @Autor(nome = "Daniel A. Battisti, Leonardo Dalbosco, Victor H. F. Wachsmann", email = "daniel.ab@edu.univali.br; leodalbosco@hotmail.com")
            }
    )
    public String pegaSimboloMoeda(int posicao) throws ErroExecucaoBiblioteca, InterruptedException {
        return obj[posicao].symbol;
    }

    @DocumentacaoFuncao(
            descricao = "Retorna uma string com o volume de transações das ultimas 24 horas",
            parametros = {
                @DocumentacaoParametro(nome = "posicao", descricao = "Id")
            },
            retorno = "Cadeia",
            autores = {
                @Autor(nome = "Daniel A. Battisti, Leonardo Dalbosco, Victor H. F. Wachsmann", email = "daniel.ab@edu.univali.br; leodalbosco@hotmail.com")
            }
    )
    public String pegaVolumeUltimas24hMoeda(int posicao) throws ErroExecucaoBiblioteca, InterruptedException {
        return obj[posicao].volumeUsd24Hr;
    }
}
