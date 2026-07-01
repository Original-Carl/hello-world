# CLAUDE.md

## Project

GoF design pattern demos — Java 21, Spring Boot 3.3.5, Spring Shell 3.3.3. Each of the 23 patterns is a Spring Shell command with its own package. See `machine-readable-context.md` for a full agent-oriented summary.

## Package layout

```
src/main/java/com/example/demo/
  DemoApplication.java
  behavioral/   # 11 patterns
  creational/   # 5 patterns
  structural/   # 7 patterns

src/test/java/com/example/demo/
  behavioral/
  creational/
  structural/
```

Each pattern package contains:
- `{Pattern}Command.java` — `@ShellComponent` with one `@ShellMethod run()` that drives the demo
- Supporting implementation classes (for full demos)

## Adding or promoting a pattern

1. Add implementation classes to the pattern package
2. Update `{Pattern}Command.java` — remove the `[stub]` text, add real demo logic
3. Add a test class exercising the demo
4. Update `README.md` status table and `specs/commands.yaml`

## Build and test

```bash
mvn package -DskipTests   # build
./demo.sh <command>        # run one pattern
mvn test                   # run all tests
```

## Never-do

- No external runtime dependencies (no database, no network calls in demo code)
- No PII in demos or tests
- No global/shared mutable state between pattern packages
