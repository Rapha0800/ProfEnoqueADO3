package br.com.storepcs.dto;


public class PCDTO {

    private String id;
    private String Processador;
    private String PlacaDeVideo;
    private String Ram;

    public PCDTO() {

    }

    public PCDTO(String Proc, String PV, String Ram) {

        this.Processador = Proc;
        this.PlacaDeVideo = PV;
        this.Ram = Ram;
    }

    public String getId() {
        return id;
    }

    public String getProcessador() {
        return Processador;
    }

    public String getPlacaDeVideo() {
        return PlacaDeVideo;
    }

    public String getRam() {
        return Ram;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProcessador(String processador) {
        Processador = processador;
    }

    public void setPlacaDeVideo(String placaDeVideo) {
        PlacaDeVideo = placaDeVideo;
    }

    public void setRam(String ram) {
        Ram = ram;
    }
}
