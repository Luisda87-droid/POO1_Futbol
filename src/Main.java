import java.util.Scanner;


public class Main {
 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  System.out.println("--- Inicio del Torneo ---");

  String tournamentName = "LIga Betplay";

  Tournament myTournament = new Tournament(tournamentName);

  myTournament.displayTeams();

  Team tournamentWinner = myTournament.simulateTournament();

  myTournament.displayWinner(tournamentWinner);

  System.out.println("\n--- Jugadores del Equipo Ganador (" + tournamentWinner.getName() + ") ---");
  tournamentWinner.showTeam(); // Usamos el método showTeam de la clase Team


  scanner.close();
  System.out.println("\n--- Fin del Programa ---");
 }
}