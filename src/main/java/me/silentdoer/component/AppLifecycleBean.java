package me.silentdoer.component;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class AppLifecycleBean {


    void onStart(@Observes StartupEvent ev) {
        System.out.println("The application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {
        System.out.println("The application is stopping...");
        //Quarkus.waitForExit();
        // 居然不会退出应用
        //System.exit(0);
    }

}