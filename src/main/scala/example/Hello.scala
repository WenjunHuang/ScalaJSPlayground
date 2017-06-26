package example

import counter.view.Counter
import org.scalajs.dom._

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Hello")
object Hello extends JSApp with Greeting {
  override def main(): Unit = {
    val component = Counter.component
    component(new Counter.Props("First")).renderIntoDOM(document.getElementById("app"))
  }

  @JSExport
  def main(canvas: html.Canvas): Unit = {
  }

  def foo(): Unit = {
    println("hello foo")
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
