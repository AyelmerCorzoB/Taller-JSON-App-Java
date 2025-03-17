package com.taller.domain.repository;

import java.util.List;

import com.taller.domain.entity.Team;


public interface EquipoRepository {
    void guardar(Team Teams);
    Team buscarPorId(int id);
    List<Team> listarTodos();
    void actualizar(Team Teams);
    void eliminar(int id);
}
