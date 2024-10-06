import cats.effect.{ExitCode, IO, IOApp}
import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder
import org.fusesource.jansi.AnsiConsole

import scala.concurrent.ExecutionContext

object Main extends IOApp {

  private val mainThread: ExecutionContext = ExecutionContext.global

  override def run(args: List[String]): IO[ExitCode] = {

    (for {
      _ <- IO(println("AnsiConsole.systemInstall()"))
      _ <- IO(AnsiConsole.systemInstall())
      _ <- IO(println("TerminalBuilder"))
      terminal <- IO {
        TerminalBuilder
          .builder()
          .dumb(false) // Avoid dumb terminal mode
          .system(true)
          .jansi(true) // Enable Jansi for colored output
          .jni(false)
          .ffm(false)
          .jna(false)
          .build()
      }.evalOn(mainThread)
      _ <- IO(println("Validate"))
      _ <- IO {
        assert(terminal != null, "Terminal term should not be null")
        assert(terminal.getWidth > 0, "Terminal width should be greater than 0")
        assert(terminal.getHeight > 0, "Terminal height should be greater than 0")
        terminal.close()
        AnsiConsole.systemUninstall() // Restore the original console
      }.evalOn(mainThread)
      _ <- IO(println("Cleaned up"))
    } yield ExitCode.Success).handleErrorWith { e =>
      println("Error:" + e.getMessage)
      e.printStackTrace()
      IO.raiseError(e)
    }
  }
}
