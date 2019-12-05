package com.blbz.mediator;

public interface Mediator {
 void notify(Collegue sender, String msg);
 void register(Collegue collegue);
}
