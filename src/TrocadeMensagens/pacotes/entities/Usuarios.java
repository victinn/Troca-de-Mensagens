package TrocadeMensagens.pacotes.entities;

public class Usuarios {
    private int id;
    private String username, senha, nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuarios(int id, String username, String senha, String nome) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.nome = nome;
    }

    public Usuarios(String username, String senha, String nome) {
        this.username = username;
        this.senha = senha;
        this.nome = nome;
    }

    public Usuarios() {
    }
    
    
}
