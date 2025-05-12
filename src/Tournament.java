import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tournament {

    private String name;
    private Team[] teams;
    private Random random;

    private static final int NUMBER_OF_TEAMS = 6;
    private static final int PLAYERS_PER_TEAM = 5;

    private String[] teamNames = {"Dragones FC", "Águilas Rojas", "Tigres Azules", "Leones Negros", "Halcones Dorados", "Serpientes Verdes", "Lobos Grises", "Coyotes Rojos"};
    private String[] teamCities = {"Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena", "Santa Marta", "Manizales", "Pereira"};
    private String[] teamStadiums = {"Estadio A", "Estadio B", "Estadio C", "Estadio D", "Estadio E", "Estadio F", "Estadio G", "Estadio H"};
    private String[] playerPositions = {"Portero", "Defensa", "Centrocampista", "Delantero"};
    private String[] playerNationalities = {"Colombiana", "Argentina", "Brasilera", "Mexicana", "Española", "Francesa", "Alemana", "Uruguaya", "Chilena", "Peruana"};

    private int minDorsal = 1;
    private int maxDorsal = 99;
    private double minWeight = 60.0;
    private double maxWeight = 100.0;
    private double minHeight = 1.60;
    private double maxHeight = 2.00;
    private LocalDate minBirthDate;
    private LocalDate maxBirthDate;

    public Tournament(String name) {
        this.name = name;
        this.teams = new Team[NUMBER_OF_TEAMS];
        this.random = new Random();

        LocalDate today = LocalDate.now();
        this.minBirthDate = today.minusYears(35);
        this.maxBirthDate = today.minusYears(18);

        System.out.println("--- Creando Torneo: " + this.name + " ---");
        createTeams();
        System.out.println("--- Torneo " + this.name + " creado con " + NUMBER_OF_TEAMS + " equipos ---");
    }

    private void createTeams() {
        for (int i = 0; i < NUMBER_OF_TEAMS; i++) {

            String teamName = teamNames[random.nextInt(teamNames.length)];
            String teamCity = teamCities[random.nextInt(teamCities.length)];
            String teamStadium = teamStadiums[random.nextInt(teamStadiums.length)];

            Player dt = createRandomPlayer("DT " + teamName + " - " + (i + 1));

            teams[i] = new Team(i + 1, teamName, teamCity, teamStadium, dt);

            System.out.println("  Poblando equipo: " + teamName);
            for (int j = 0; j < PLAYERS_PER_TEAM; j++) {
                Player player = createRandomPlayer("Jugador " + (j + 1) + " de " + teamName);
                teams[i].addPlayer(player);
            }
            System.out.println("  Equipo " + teamName + " poblado.");
        }
    }

    private Player createRandomPlayer(String name) {
        int dorsal = random.nextInt(maxDorsal - minDorsal + 1) + minDorsal;
        String teamNameForPlayer = "Equipo " + (random.nextInt(teamNames.length) + 1);
        String position = playerPositions[random.nextInt(playerPositions.length)];
        double weight = minWeight + (maxWeight - minWeight) * random.nextDouble();
        double height = minHeight + (maxHeight - minHeight) * random.nextDouble();

        long daysBetween = ChronoUnit.DAYS.between(minBirthDate, maxBirthDate);
        LocalDate birthDate = minBirthDate.plusDays(random.nextInt((int) daysBetween + 1));

        String nationality = playerNationalities[random.nextInt(playerNationalities.length)];
        boolean isActive = random.nextBoolean();

        return new Player(name, dorsal, teamNameForPlayer, position, weight, height, birthDate, nationality, isActive);
    }


    public void displayTeams() {
        System.out.println("\n--- Equipos Participantes en el Torneo '" + this.name + "' ---");
        for (Team team : teams) {
            System.out.println(team.toString());
        }
        System.out.println("-------------------------------------------------------");
    }

    // Método para simular el torneo y obtener el ganador aleatorio
    public Team simulateTournament() {
        System.out.println("\n--- Simulando el Torneo '" + this.name + "' ---");
        int winnerIndex = random.nextInt(NUMBER_OF_TEAMS);
        Team winner = teams[winnerIndex];
        System.out.println("--- Simulación completa ---");
        return winner;
    }

    // Método para mostrar el ganador
    public void displayWinner(Team winner) {
        System.out.println("\n***************************************");
        System.out.println("¡El ganador del Torneo '" + this.name + "' es:");
        System.out.println(winner.getName() + "!");
        System.out.println("***************************************");
    }

    public Team[] getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }
}