//> using scala 3.4.0
////> using lib org.jline:jline:3.25.0
////> using lib org.jline:jline-terminal:3.25.0
////> using lib org.jline:jline-terminal-jansi:3.25.0
////> using lib org.jline:jansi-core:3.25.0
////> using lib org.jline:jansi:3.25.0
//> using lib org.jline:jline:3.27.0
//> using lib org.jline:jline-terminal:3.27.0
//> using lib org.jline:jline-terminal-jansi:3.27.0
//> using lib org.jline:jansi-core:3.27.0
//> using lib org.jline:jansi:3.27.0

import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder
import org.jline.jansi.AnsiConsole

// Set up the ANSI console
AnsiConsole.systemInstall()

// Create the terminal
val terminal: Terminal = TerminalBuilder
  .builder()
  .dumb(false) // Avoid dumb terminal mode
  .system(true)
  .jansi(true) // Enable Jansi for colored output
  .jni(false)
  .ffm(false)
  .build()
assert(terminal != null, "Terminal term should not be null")
assert(terminal.getWidth > 0, "Terminal width should be greater than 0")
assert(terminal.getHeight > 0, "Terminal height should be greater than 0")

println("Terminal created")
terminal.close()
AnsiConsole.systemUninstall()
