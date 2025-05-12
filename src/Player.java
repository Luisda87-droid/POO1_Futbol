import java.time.LocalDate;

public class Player {

    private String name;
    private int dorsal;
    private String team;
    private String position;
    private double weight;
    private double height;
    private LocalDate birthday;
    private String nationality;
    private boolean isActive;

    public Player(String name, int dorsal, String teamName, String position,
                  double weight, double height, LocalDate birthday, String nationality, boolean isActive) {

        this.name = name;
        this.dorsal = dorsal;
        this.team = teamName;
        this.position = position;
        this.weight = weight;
        this.height = height;
        this.birthday = birthday;
        this.nationality = nationality;
        this.isActive = isActive;
    }

    public Player(String name, int dorsal) {
        this.name = name;
        this.dorsal = dorsal;
    }

    public String getName() {
        return name;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isActive() {
        return isActive;
    }

    public String toString() {
        return "Jugador [ Nombre: " + name +
                ", Dorsal: " + dorsal +
                ", Equipo: " + (team != null ? team : "N/A") +
                ", Posición: " + (position != null ? position : "N/A") +
                String.format(", Peso: %.2f kg", weight) +
                String.format(", Altura: %.2f m", height) +
                ", Nacimiento: " + (birthday != null ? birthday : "N/A") +
                ", Nacionalidad: " + (nationality != null ? nationality : "N/A") +
                ", Activo: " + isActive +
                " ]";
    }
}