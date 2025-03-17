package com.taller.domain.repository;

import java.util.List;

import com.taller.domain.entity.Players;

public interface PlayerRespository {
    void guardar(Players Player);
    Players buscarPorId(int id);
    List<Players> listarTodos();
    void actualizar(Players Playere);
    void eliminar(int id);
}
