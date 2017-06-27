package example

import counter.store.{CounterStore, CounterStoreActions, SummaryStore, SummaryStoreActions}
import counter.view.ControlPanel
import org.scalajs.dom._
import simpleflux.AppDispatcher

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Hello")
object Hello extends JSApp with Greeting {

  override def main(): Unit = {
    CounterStore.DispatchToken = AppDispatcher.register(CounterStoreActions.counterActions)
    SummaryStore.DispatchToken = AppDispatcher.register(SummaryStoreActions.sumaryActions)

    val component = ControlPanel.component
    component().renderIntoDOM(document.getElementById("app"))
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
