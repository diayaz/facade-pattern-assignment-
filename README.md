# Assignment 4 — Facade Pattern (Home Theater)

`HomeTheaterFacade` hides 6 subsystem classes (Amplifier, DvdPlayer, Projector, Screen, Lights, PopcornPopper)
behind two simple methods: `watchMovie(movie)` and `endMovie()`.

## Structure
```
src/
  subsystem/   Amplifier, DvdPlayer, Projector, Screen, Lights, PopcornPopper
  facade/      HomeTheaterFacade
  client/      Main  (uses only the facade)
docs/          UML diagram
```

## Run (JDK 17)
```
javac -d out $(find src -name "*.java")
java -cp out client.Main
```
In IntelliJ: mark `src` as Sources Root and run `client.Main`.
