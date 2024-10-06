
## Jline Scala tests

This repo was just setup for testing [JLine](https://github.com/jline/jline3)

```
├── jline-io-app       Scala IOApp 
└── jline-scala-cli    Scala-cli tests
```

Works:
```bash
cd jline-scala-cli
scala-cli IOTerminalCLI.sc
```

Basically same thing, but does not work:
```bash
cd jline-io-app
sbt clean compile run 
```

Note had to add in `build.sbt` to make it work
Compile / run / fork := false,