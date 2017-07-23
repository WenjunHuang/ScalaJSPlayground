package example

import counter.store.{CounterStore, CounterStoreActions}
import counter.view.ControlPanel
import org.scalajs.dom._

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

import todos.todolist.AddTodoAction

@JSExportTopLevel("Hello")
object Hello extends JSApp {

  override def main(): Unit = {
//    CounterStore.DispatchToken = AppDispatcher.register(CounterStoreActions.counterActions)
//    SummaryStore.DispatchToken = AppDispatcher.register(SummaryStoreActions.sumaryActions)

    val component = ControlPanel.component
    component().renderIntoDOM(document.getElementById("app"))
  }
}

