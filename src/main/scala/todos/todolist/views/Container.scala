package todos.todolist.views

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

/**
  * Created by rick on 2017/7/20.
  */
object Todos {
  val component = ScalaComponent.builder[Unit]("No Args")
    .render { _ =>
      <.div(
        ^.className := "todos",
        AddTodo.component()
      )
    }.build

}
