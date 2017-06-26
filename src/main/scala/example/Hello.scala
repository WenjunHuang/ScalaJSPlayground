package example

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom._

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Hello")
object Hello extends JSApp with Greeting {
    override def main(): Unit = {
        val HelloMessage = ScalaComponent.builder[String]("HelloMessage")
            .render($ => <.div("Hello ", $.props))
            .build

        HelloMessage("John").renderIntoDOM(document.getElementById("app"))
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
