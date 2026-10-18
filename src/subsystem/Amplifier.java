package subsystem;

public class Amplifier {
    private int volume;

    public void on() {
        System.out.println("Amplifier: on");
    }

    public void setSource(DvdPlayer dvd) {
        System.out.println("Amplifier: source set to DVD player");
    }

    public void setSurroundSound() {
        System.out.println("Amplifier: surround sound on");
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 10) {
            throw new IllegalArgumentException("Volume must be between 0 and 10");
        }
        this.volume = volume;
        System.out.println("Amplifier: volume " + volume);
    }

    public void off() {
        System.out.println("Amplifier: off");
    }
}
