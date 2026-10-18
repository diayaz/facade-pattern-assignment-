package client;

import facade.HomeTheaterFacade;

/** Client: works only with the facade, never with subsystem classes. */
public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie("Interstellar");
        homeTheater.endMovie();
    }
}
