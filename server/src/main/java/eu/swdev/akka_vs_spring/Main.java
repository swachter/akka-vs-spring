package eu.swdev.akka_vs_spring;

import akka.actor.ActorSystem;
import org.springframework.boot.SpringApplication;

/**
 *
 */
public class Main {

  public static void main(String[] args) {

    SpringApplication.run(Example.class, args);

    ActorSystem actorSystem = ActorSystem.create("inst-backend");
    httpReceiver.HttpReceiver.bind("localhost", 9090, actorSystem);

  }

}
