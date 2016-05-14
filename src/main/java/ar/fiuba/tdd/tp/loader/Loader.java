package ar.fiuba.tdd.tp.loader;


import ar.fiuba.tdd.tp.model.Game;

/**
 * Created by leandro on 22/04/16.
 */
public interface Loader {
    Game get(String name);
}
