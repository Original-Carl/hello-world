# Design Pattern Demo

A runnable reference for all 23 Gang of Four design patterns, built with **Java 21** and **Spring Shell**.

## Prerequisites

- Java 21+
- Maven 3.9+

## Build

```bash
mvn package -DskipTests
```

## Run

**One-shot (non-interactive):**
```bash
./demo.sh factory
./demo.sh observer
./demo.sh command
```

**Interactive REPL** (explore all patterns in one session):
```bash
./demo.sh
shell> help          # list all 23 commands
shell> factory
shell> builder
shell> singleton
shell> exit
```

## Test

```bash
mvn test
```

## Patterns

### Creational
| Command | Pattern | Status |
|---|---|---|
| `factory` | Factory Method | ✅ full demo |
| `builder` | Builder | ✅ full demo |
| `singleton` | Singleton | ✅ full demo |
| `abstract-factory` | Abstract Factory | ✅ full demo |
| `prototype` | Prototype | ✅ full demo |

### Structural
| Command | Pattern | Status |
|---|---|---|
| `adapter` | Adapter | ✅ full demo |
| `decorator` | Decorator | ✅ full demo |
| `facade` | Facade | ✅ full demo |
| `bridge` | Bridge | stub |
| `composite` | Composite | stub |
| `flyweight` | Flyweight | stub |
| `proxy` | Proxy | stub |

### Behavioral
| Command | Pattern | Status |
|---|---|---|
| `observer` | Observer | ✅ full demo |
| `strategy` | Strategy | ✅ full demo |
| `command` | Command | ✅ full demo |
| `chain` | Chain of Responsibility | stub |
| `iterator` | Iterator | ✅ full demo |
| `mediator` | Mediator | stub |
| `memento` | Memento | ✅ full demo |
| `state` | State | stub |
| `template` | Template Method | stub |
| `visitor` | Visitor | stub |
| `interpreter` | Interpreter | stub |

Stubs print the pattern's intent and a worked example scenario. See [CONTRIBUTING.md](CONTRIBUTING.md) to promote one to a full demo.

## Structure

Each pattern lives in its own package under `src/main/java/com/example/demo/{family}/{pattern}/`.

A machine-readable command reference is at [`specs/commands.yaml`](specs/commands.yaml).
