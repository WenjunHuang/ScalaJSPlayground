package todos.todolist.views

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object TodoList {
  val component = ScalaComponent.builder[Unit]("No Args")
    .render { _ =>
      <.div("todo list")
    }.build

}
