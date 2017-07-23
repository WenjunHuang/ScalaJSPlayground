package todos.todolist.views

import counter.store.CounterStoreActions
import japgolly.scalajs.react.{Callback, ScalaComponent}
import japgolly.scalajs.react.vdom.html_<^._

object AddTodo {
  val component = ScalaComponent.builder[Unit]("No Args")
    .render { _ =>
      <.div(
        ^.className := "add-todo",
        <.form(
          ^.onSubmit --> Callback {
          },
          <.input(
            ^.className := "new-todo",
          ).ref {input =>

          },
          <.button(
            ^.className := "add-btn",
            ^.`type` := "submit",
            "添加"
          )
        )
      )
    }
    .build

}
