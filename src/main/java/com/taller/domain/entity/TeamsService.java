package com.taller.domain.entity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TeamsService {
    private static final String FILE_PATH = "uefa.json";
    private Map<Integer, Team> teams;
    private ObjectMapper objectMapper;

    public TeamsService() {
        objectMapper = new ObjectMapper();
        teams = cargarTeams();
    }

    private Map<Integer, Team> cargarTeams() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("⚠️ El archivo 'uefa.json' no existe. Se creará una lista vacía.");
                return new HashMap<>();
            }

            TeamsContainer container = objectMapper.readValue(file, TeamsContainer.class);

            Map<Integer, Team> teamsMap = new HashMap<>();
            for (Team team : container.getTeams()) {
                teamsMap.put(team.getId(), team);
            }

            return teamsMap;
        } catch (IOException e) {
            System.out.println("❌ Error al cargar el archivo 'uefa.json'. Se creará una lista vacía.");
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public List<Team> obtenerTodosLosEquipos() {
        return new ArrayList<>(teams.values());
    }

    public void listarTeams() {
        if (teams.isEmpty()) {
            System.out.println("📂 No hay equipos disponibles.");
            return;
        }

        teams.forEach((id, team) -> {
            String lista = String.format(
                    "| ID: %s - Nombre: %s - Fecha de fundación: %s - Estadísticas: %s - Jugadores: %s - Coach: %s |",
                    id, team.getName(), team.getYearfoundation(), team.getStatistics(), team.getPlayers(),
                    team.getCoach());
            System.out.println("------------------------------------------------------");
            System.out.println(lista);
            System.out.println("------------------------------------------------------");
        });
    }
}