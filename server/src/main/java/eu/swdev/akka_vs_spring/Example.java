package eu.swdev.akka_vs_spring;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.*;

@RestController
@EnableAutoConfiguration
public class Example {

    private static final ScheduledExecutorService es = Executors.newScheduledThreadPool(10);

//    @RequestMapping("/")
//    DeferredResult<String> home() {
//        DeferredResult<String> res = new DeferredResult<>();
//        es.schedule(() -> res.setResult("Spring"), 2000, TimeUnit.MILLISECONDS);
//        return res;
//    }

    @RequestMapping("/")
    String home() {
        return "Spring";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}