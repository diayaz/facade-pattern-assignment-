package subsystem;

public class DvdPlayer {
    private String currentMovie;

    public void on() {
        System.out.println("DVD Player: on");
    }

    public void play(String movie) {
        currentMovie = movie;
        System.out.println("DVD Player: playing \"" + movie + "\"");
    }

    public void stop() {
        if (currentMovie != null) {
            System.out.println("DVD Player: stopped \"" + currentMovie + "\"");
        }
    }

    public void eject() {
        currentMovie = null;
        System.out.println("DVD Player: disc ejected");
    }

    public void off() {
        System.out.println("DVD Player: off");
    }
}
