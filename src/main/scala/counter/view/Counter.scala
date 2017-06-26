package counter.view

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

/**
  * Created by rick on 2017/6/26.
  */
object Counter {

  case class Props(val caption: String)

  case class State(val counter: Int = 0)

  val component = ScalaComponent.builder[Props]("Counter")
    .initialState(new State(0))
    .render_PS { (prop, state) =>
      <.div(
        ^.`class` := "chap02-btn",
        <.button(
          ^.onClick --> onButtonClicked ,
          "+"
        ),
        <.button(
          ^.`class` := "chap02-btn",
          ^.onClick --> onButtonClicked,
          "-"
        ),
        <.span(
          s"${prop.caption} count: ${state.counter}"
        )
      )
    }
    .build

  def onButtonClicked: Callback = Callback.alert("The button was pressed!")

}
