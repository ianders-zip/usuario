package com.ianders.usuario.business;

import com.ianders.usuario.business.converter.UsuarioConverter;
import com.ianders.usuario.business.dto.UsuarioDTO;
import com.ianders.usuario.infrastructure.entity.Usuario;
import com.ianders.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(UsuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
}
