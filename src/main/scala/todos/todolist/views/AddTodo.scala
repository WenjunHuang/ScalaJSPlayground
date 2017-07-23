package todos.todolist.views

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{BackendScope, Callback, ScalaComponent}
import org.scalajs.dom.html

object AddTodo {
  var inputElement:html.Input = _
  val component = ScalaComponent.builder[Unit]("No Args")
      .render_P { props =>
      <.div(
        ^.className := "add-todo",
        <.form(
          ^.onSubmit ==> { event =>
            Callback {
              event.preventDefault()
              val input = AddTodo.inputElement
              if (!input.value.trim().isEmpty) {
                props.onAdd(input.value)
                input.value = ""
              }
            }
          },
          <.input(
            ^.className := "new-todo",
          ).ref { input =>
            AddTodo.inputElement = input
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
