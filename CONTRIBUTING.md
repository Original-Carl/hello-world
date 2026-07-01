# Contributing

## Prerequisites

- Java 21+
- Maven 3.9+

## Build & run locally

```bash
mvn package -DskipTests
./demo.sh factory          # one-shot
./demo.sh                  # interactive REPL
```

## Run tests

```bash
mvn test
```

## How to promote a stub to a full demo

1. Add implementation classes to the pattern's package:
   ```
   src/main/java/com/example/demo/{family}/{pattern}/
   ```
2. Update the `*Command.java` in that package to instantiate your classes and print observable output (no `[stub — full demo coming]` line).
3. Add a test class under `src/test/java/com/example/demo/{family}/{pattern}/` — at minimum one test that runs the command and asserts on output.
4. Update the status table in `README.md` and `specs/commands.yaml` for that command (`stub` → `full_demo`).

### Package conventions

Each pattern follows this layout:

```
{pattern}/
  {Pattern}Command.java      # @ShellComponent entry point
  {SupportingClass}.java     # implementation classes
```

The `*Command.java` class has one `@ShellMethod` method that runs the demo top-to-bottom and prints all output to stdout.

## Branching

- Create a feature branch from `main`: `git checkout -b feature/your-thing`
- Open a PR targeting `main`
- At least one review required before merge

## PR checklist

- [ ] `mvn test` passes locally
- [ ] README status table updated if a pattern changed status
- [ ] `specs/commands.yaml` updated to match
- [ ] Example output included in the PR body
