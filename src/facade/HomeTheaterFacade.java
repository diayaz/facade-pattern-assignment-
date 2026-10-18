package facade;

import subsystem.*;

/**
 * Facade: gives the client two simple methods (watchMovie / endMovie)
 * and hides the correct order of calls to six subsystem classes.
 */
public class HomeTheaterFacade {
    private static final int MOVIE_LIGHT_LEVEL = 10;
    private static final int DEFAULT_VOLUME = 5;

    private final Amplifier amp;
    private final DvdPlayer dvd;
    private final Projector projector;
    private final Screen screen;
    private final Lights lights;
    private final PopcornPopper popper;

    /** Ready-to-use facade: the client does not need to build the subsystem. */
    public HomeTheaterFacade() {
        this(new Amplifier(), new DvdPlayer(), new Projector(),
             new Screen(), new Lights(), new PopcornPopper());
    }

    /** Lets advanced code pass its own (already configured) components. */
    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector,
                             Screen screen, Lights lights, PopcornPopper popper) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        if (movie == null || movie.isBlank()) {
            throw new IllegalArgumentException("Movie title must not be empty");
        }
        System.out.println("\n=== Get ready to watch a movie... ===");
        try {
            preparePopcorn();
            prepareRoom();
            prepareSound();
            dvd.on();
            dvd.play(movie);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage() + " -> shutting down");
            endMovie();
        }
    }

    public void endMovie() {
        System.out.println("\n=== Shutting movie theater down... ===");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }

    private void preparePopcorn() {
        popper.on();
        popper.pop();
    }

    private void prepareRoom() {
        lights.dim(MOVIE_LIGHT_LEVEL);
        screen.down();
        projector.on();
        projector.wideScreenMode();
    }

    private void prepareSound() {
        amp.on();
        amp.setSource(dvd);
        amp.setSurroundSound();
        amp.setVolume(DEFAULT_VOLUME);
    }
}
