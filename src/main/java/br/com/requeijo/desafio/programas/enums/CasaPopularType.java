package br.com.requeijo.desafio.programas.enums;

import br.com.requeijo.desafio.programas.casapopular.CasaPopular;
import br.com.requeijo.desafio.programas.casapopular.FamiliaMG;
import br.com.requeijo.desafio.programas.casapopular.FamiliaRJ;
import br.com.requeijo.desafio.programas.casapopular.FamiliaSP;

import java.util.Arrays;

public enum CasaPopularType {
	
	CASAPOPULAR_RJ("Casa RJ", FamiliaRJ.class),
	CASAPOPULAR_SP("Casa SP", FamiliaSP.class),
	CASAPOPULAR_MG("Casa MG", FamiliaMG.class);
	
	private String name;
	private Class<? extends CasaPopular> type;
	
	CasaPopularType(String name, Class<? extends CasaPopular> type){
		this.name = name;
		this.type = type;
	}
	
    public static CasaPopularType of(String value) {
		
        return Arrays.stream(values()).filter(type -> type.name.equalsIgnoreCase(value)).findFirst().get();
    }

	public static CasaPopularType of(CasaPopularType value) {
		
		return Arrays.stream(values()).filter(type -> type.equals(value)).findFirst().get();
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends CasaPopular> getType(){
		return type;
	}

}
