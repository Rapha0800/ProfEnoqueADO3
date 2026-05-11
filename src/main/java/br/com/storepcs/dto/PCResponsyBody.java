package br.com.storepcs.dto;

import java.util.List;

public class PCResponsyBody {

    private List<PCDTO> PCS;

    public PCResponsyBody(List<PCDTO> allpcs){
        this.PCS = allpcs;
    }

    public List<PCDTO> getPCS() {
        return PCS;
    }

    public void setPCS(List<PCDTO> PCS) {
        this.PCS = PCS;
    }
}
