package com.taller.application.usecase.player;

import java.util.List;

import com.taller.domain.entity.Players;
import com.taller.domain.repository.PlayerRespository;

public class PlayerUseCase {
    private final PlayerRespository repository;

    public PlayerUseCase(PlayerRespository repository) {
        this.repository = repository;
    }

    // public void registrarPlayere(int dorsal,String name,String nationality,int age,int height,String position) {
    //     Players Player = new Players(dorsal,name,nationality,age,height,position);
    //     repository.guardar(Player);
    // }

    public Players obtenerPlayer(int id) {
        return repository.buscarPorId(id);
    }

    public List<Players> listarPlayers() {
        return repository.listarTodos();
    }

    // public void actualizarPlayere(int dorsal,String name,String nationality,int age,int height,String position) {
    //     Players Playere = new Players(dorsal,name,nationality,age,height,position);
    //     repository.actualizar(Playere);
    // }

    // public void eliminarPlayere(int id) {
    //     repository.eliminar(id);
    // }
}
