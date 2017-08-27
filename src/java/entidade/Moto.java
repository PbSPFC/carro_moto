package entidade;

public class Moto {
    
    public Moto(){}

    public Moto(String nome, String marca, Integer ano, Integer potencia) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
    }

    public Moto(Integer id, String nome, String marca, Integer ano, Integer potencia) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
    }

    
    
    private Integer id;
    private String nome;
    private String marca;
    private Integer ano;
    private Integer potencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }
    
    
    
}
