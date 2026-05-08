package a23_01_clientManager;

import java.util.HashSet;
import java.util.Set;

public class ClientManager {

    private Set<Client> clients;

    public ClientManager() {
        clients = new HashSet<>();
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "ClientManager{" +
                "clients=" + clients +
                '}';
    }

    //Mostra la llista de clients per consola.
    public void listClients() {
        clients.forEach(System.out::println);
    }


    //Retorna el client que contingui el compte i dni especificats
    // (en majúscules o minúscules).
    // Si no hi ha cap client amb aquestes dades, el mètode retorna null.
    public Client getClientByAccountAndDni(String account, String dni) {
        for (Client c : clients) {
            if (c.getAccount().equalsIgnoreCase(account) && c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        //return null;
        return clients.stream().filter(c -> c.getAccount().equalsIgnoreCase(account) && c.getDni().equalsIgnoreCase(dni)).findFirst().orElse(null);
    }



    //Afegeix un client a la llista. Retorna true si l'element és afegit a la llista.
    public boolean addClient(Client client) {
        return clients.add(client);
    }



    //Actualitza el client de la llista que tingui el compte i el DNI especificats amb les noves dades de updatedClient.
    // El compte i el DNI no es poden modificar. Retorna true si l'element és actualitzat satisfactòriament.
    public boolean updateClient(String account, String dni, Client updatedClient) {

        Client c = clients.stream().filter(e -> e.getDni() == dni && e.getAccount() == account).findFirst().orElse(null);

        if (c == null) return false;

        clients.remove(c);
        clients.add(updatedClient);
        return true;
    }



    //Esborra el client de la llista que conté el compte i el dni especificats. Retorna true si l'element és esborrat de la llista, false en cas contrari.
    public boolean removeClient(String account, String dni) {
        return clients.removeIf(e -> e.getDni() == dni && e.getAccount() == account);
    }

}
