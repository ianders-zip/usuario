package com.ianders.usuario.infrastructure.repository;

import com.ianders.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email); //Isso é um SCRIPT de banco de dados (passei como parÂmetro o email)

    Optional<Usuario> findByEmail(String email);
    //O Optional serve para que o retorno não seja nulo caso não encontre algo,
    //ou seja, para não dar um erro e quebrar o código. Daí nesse caso, to evitando que
    //caso a nossa aplicação busque o email e não encontre, ela quebre

    //anotação obrigatoria pro delete para que não dê erro
    @Transactional
    void deleteByEmail (String email);
    //Agora precisamos chamar esse metodo na Service
}

