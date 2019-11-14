/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.plugin.exemplo.biblioteca;

/**
 *
 * @author leoda
 */
public class Crypto {

    String id = "";
    String rank = "";
    String symbol = "";
    String name = "";
    String supply = "";
    String maxSupply = "";
    String marketCapUsd = "";
    String volumeUsd24Hr = "";
    String priceUsd = "";
    String changePercent24Hr = "";
    String vwap24Hr = "";

    public Crypto(String id, String rank, String symbol, String name, String supply, String maxSupply, String marketCapUsd, String volumeUsd24Hr, String priceUsd, String changePercent24Hr, String vwap24Hr) {
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
        this.name = name;
        this.supply = supply;
        this.maxSupply = maxSupply;
        this.marketCapUsd = marketCapUsd;
        this.volumeUsd24Hr = volumeUsd24Hr;
        this.priceUsd = priceUsd;
        this.changePercent24Hr = changePercent24Hr;
        this.vwap24Hr = vwap24Hr;
    }
}
