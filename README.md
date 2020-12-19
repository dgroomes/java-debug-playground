# java-debug-playground

NOT YET IMPLEMENTED

📚 Learning and exploring debugging and profiling tools in Java, the Java toolchain and the Java ecosystem.

### Instructions

* Use Java 15
* Run with `./gradlew run` 

### Wish List

Things I wish for!

* Implement some examples using Java Flight Recording
  * As a reference, use <https://github.com/dgroomes/wiremock-playground/blob/ecf7f4b7490a28f2df6ce01489d52e881d30cd76/docs/CONTRIBUTING.md>
  
### Notes

Build a distribution: `./gradlew installDist`

Run with args: `JAVA_OPTS="-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints" ./build/install/java-debug-playground/bin/java-debug-playground 30`

List Java processes (that can be recorded using JFR?): `jcmd`

Start a JFR for some running Java process `jcmd 3891 JFR.start`

Dump the the JFR recording to file (the Java process must still be running! If it's terminated, you're too late!) `jcmd 3891 JFR.dump name=1 filename=1.jfr` 

To get a flight recording from the start of the program's execution through the finish, add the options `-XX:StartFlightRecording,dumponexit=true`
  * So, in full: `JAVA_OPTS="-XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:StartFlightRecording,dumponexit=true" ./build/install/java-debug-playground/bin/java-debug-playground 30`
