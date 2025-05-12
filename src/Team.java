public class Team {

    private int id;
    private String name;
    private Player dt;
    private Player[] players;
    private String city;
    private String stadium;
    private int playerCount = 0;

    public Team(int id, String name, String city, String stadium, Player dt) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stadium = stadium;
        this.dt = dt;
        this.players = new Player[5];
        this.playerCount = 0;
    }

    public Team(int id, String name, String city, String stadium) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stadium = stadium;
        this.dt = null;
        this.players = new Player[5];
        this.playerCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Player getDt() {
        return dt;
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getTeamSize() {
        return players.length;
    }

    public String getCity() {
        return city;
    }

    public String getStadium() {
        return stadium;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDt(Player dt) {
        this.dt = dt;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void addPlayer(Player player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
            System.out.println(player.getName() + " añadido al equipo " + this.name);
        } else {
            System.out.println("Error: el equipo " + this.name + " ya tiene el número máximo de jugadores (" + players.length + ").");
        }
    }

    public void showTeam() {
        System.out.println("\n--- Equipo: " + name + " (" + stadium + ") ---");
        if (dt != null) {
            System.out.println("Director Técnico: " + dt.getName());
        } else {
            System.out.println("Director Técnico: No asignado");
        }

        if (playerCount == 0) {
            System.out.println("El equipo no tiene jugadores registrados.");
        } else {
            System.out.println("Jugadores (" + playerCount + "/" + players.length + "):");
            for (int i = 0; i < playerCount; i++) {
                System.out.println((i + 1) + ". " + players[i].toString());
            }
        }
        System.out.println("----------------------");
    }

    public String toString() {
        return "Equipo [ ID: " + id +
                ", Nombre: " + name +
                ", Ciudad: " + city +
                ", Estadio: " + stadium +
                ", DT: " + (dt != null ? dt.getName() : "N/A") +
                ", Jugadores registrados: " + playerCount + "/" + players.length +
                " ]";
    }
}