package com.ianders.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //Para apontar pro nosso Spring que essa aqui é uma tabela do banco de dados
@Table(name = "usuario") //Para por o nome da tabela (sempre colocar)

public class Usuario implements UserDetails { //implements UserDetails paraImplementar essa classe do Spring Security
    //para validar esse usuário como um usuario de acesso de login e senha

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Isso aqui vai gerar pra nós automaticamente os IDs
    private Long id;

    @Column(name = "nome", length = 100) //Identifica qual o nome da nossa coluna, entre outras informações
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "senha")
    private String senha;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
