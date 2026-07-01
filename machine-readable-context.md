# Machine-Readable Agent Context

## Intent

A runnable reference implementation of all 23 Gang of Four design patterns as a Java 21 + Spring Shell CLI. Each pattern is its own command — either a full interactive demo with working classes or a stub that explains the pattern's intent and a worked example scenario.

## Entry Points

- `src/main/java/com/example/demo/DemoApplication.java` — Spring Boot entry point
- `src/main/java/com/example/demo/{family}/{pattern}/{Pattern}Command.java` — one `@ShellComponent` per pattern (23 total); the `run()` method is the demo
- `demo.sh` — launcher: `exec java ... -jar target/demo-0.0.1-SNAPSHOT.jar "$@"`
- `specs/commands.yaml` — machine-readable listing of all 23 commands with status and descriptions

## Common Tasks

**Run a single pattern:**
```bash
mvn package -DskipTests   # build once
./demo.sh factory          # run any command by name
```

**Run all tests:**
```bash
mvn test
```

**Add a new pattern implementation (promote a stub):**
1. Add implementation classes to `src/main/java/com/example/demo/{family}/{pattern}/`
2. Replace stub body in `{Pattern}Command.java` with real demo code; remove the `[stub]` line
3. Add test class to `src/test/java/com/example/demo/{family}/{pattern}/`
4. Update `README.md` status table and `specs/commands.yaml` (`stub` → `full_demo`)

**Find all stubs:**
```bash
grep -r "\[stub" src/main/java/
```

## Constraints

- Java 21 required (uses records, text blocks, pattern matching)
- Spring Boot 3.3.5 / Spring Shell 3.3.3
- License: GPLv3
- No external service dependencies — all demos run offline
- Each demo must produce deterministic stdout output (no random seeds unless fixed)

## Repro Steps

```bash
# Clone and build
git clone <repo>
cd hello-world
mvn package -DskipTests

# Run any pattern
./demo.sh <command-name>

# Run tests
mvn test
```

No environment variables required. No database or network access.

## Expected Outputs

**Full demo** — produces structured stdout showing the pattern in action with concrete objects, state changes, or comparisons. Example (`prototype`):
```
=== Prototype Pattern ===
...
goblin   clone-A health=5  clone-B health=10 (after doubling)  same ref=false
dragon   clone-A health=50  clone-B health=100 (after doubling)  same ref=false
```

**Stub** — prints the pattern's GoF definition, a worked example scenario, and ends with `[stub — full demo coming]`. No interactive behavior beyond reading the text.
