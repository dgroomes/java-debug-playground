package dgroomes;

import org.slf4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class App {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);

    public static final int DEFAULT_ITERATIONS = 100;
    public static final int SLEEP_MILLIS = 100;
    public static final Random rand = new Random(0);

    /**
     * A blocking method that might simulate how a blocking I/O call would behave. It's slow!
     */
    public void blockingMethod() throws InterruptedException {
        Thread.sleep(SLEEP_MILLIS);
    }

    /**
     * A method that might simulate how a computational method might behave. It might execute, well, fast!
     */
    public void fastComputeMethod() {
        var sum = rand.nextInt() + rand.nextInt();
        log.trace("Computed a sum: {}", sum);
    }

    public static void main(String[] args) throws InterruptedException {
        var start = Instant.now();
        int iterations;
        if (args.length > 0) {
            var arg = args[0];
            log.debug("Detected argument for 'iterations': {}", arg);
            iterations = Integer.parseInt(arg);
        } else {
            iterations = DEFAULT_ITERATIONS;
        }
        var app = new App();
        log.debug("Executing {} iterations. Calls to blockingMethod sleep for {} milliseconds", iterations, SLEEP_MILLIS);
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < iterations; j++) {
                app.fastComputeMethod();
            }
            app.blockingMethod();
        }
        var end = Instant.now();
        var duration = Duration.between(start, end);
        log.info("Done! Executed in {}", duration);
    }
}
