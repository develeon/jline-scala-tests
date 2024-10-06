//> using scala 3.4.0
//> using lib org.jline:jline:3.25.0
//> using lib org.fusesource.jansi:jansi:2.4.1

import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder
import org.fusesource.jansi.AnsiConsole

// Set up the ANSI console
AnsiConsole.systemInstall()

// Create the terminal
val terminal: Terminal = TerminalBuilder
  .builder()
  .dumb(false) // Avoid dumb terminal mode
  .jansi(true) // Enable Jansi for colored output
  .build()
if terminal == null then {
  println("Terminal is null")
}
println("Terminal created")
terminal.close()
AnsiConsole.systemUninstall()
