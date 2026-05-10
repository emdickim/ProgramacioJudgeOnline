package a23_02_playerManager;

import java.util.HashSet;
import java.util.Set;

public class PlayerManager {

    private Set<Player> players;

    public PlayerManager() {
        this.players = new HashSet<>();
    }
    //Mostra la llista de jugadors per consola.
    //Repte: pots utilitzar Streams en comptes d'iterar els jugadors.
    public void listPlayers() {
        players.forEach(System.out::println);
    }



    //Retorna el client que contingui el nom, cognom i edat especificats (sense considerar majúscules o minúscules).
    //Repte: aquí també pots utilizar Streams i, per tant, no cal iterar els jugadors.
    public Player getPlayerByNameSurnameAndAge(String name, String surname, byte age) {
        return players.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name) && p.getSurname().equalsIgnoreCase(surname) && p.getAge() == age)
                .findFirst()
                .orElse(null);
    }



    //Afegeix un jugador a la llista. Retorna true si l'element és afegit a la llista.
    public boolean addPlayer(Player player) {
        return players.add(player);
    }



    //Actualitza el jugador de la llista que tingui el nom, cognom i edat especificats amb les noves dades de updatedPlayer.
    // El nom, cognom i l'edat no es poden modificar. Retorna true si l'element és actualitzat satisfactòriament.
    //Repte: aquest mètode es pot realitzar sense iterar el conjunt de jugadors.
    public boolean updatePlayer(String name, String surname, byte age, Player updatedPlayer) {
        if (players.remove(updatedPlayer)) {
            players.add(updatedPlayer);
            return true;
        }

        return false;
    }



    //Esborra el jugador de la llista que conté el nom, cognom i l'edat especificats
    // (sense considerar majúscules o minúscules).
    // Retorna true si l'element és esborrat de la llista, false en cas contrari.
     //Repte: aquest mètode es pot realitzar sense iterar el conjunt de jugadors.
    public boolean removePlayer(String name, String surname, byte age) {
        return players.removeIf(p -> p.getAge() == age && p.getSurname().equalsIgnoreCase(surname) && p.getName().equalsIgnoreCase(name));
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "PlayerManager{" +
                "players=" + players +
                '}';
    }
}
