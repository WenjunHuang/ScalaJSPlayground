package counter.view

import counter.store.{CounterStore, CounterStoreActions}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

/**
  * Created by rick on 2017/6/26.
  */
object Counter {

  case class Props(val caption: String)

  case class State(val caption: String, val counter: Int = 0)

  val component = ScalaComponent.builder[Props]("Counter")
    .initialStateFromProps { props =>
      new State(props.caption, CounterStore.counterValues.getOrElse(props.caption, 0))
    }
    .render_S { state =>
      <.div(
        ^.`class` := "chap02-btn",
        <.button(
          ^.onClick --> Callback {
            println("in callback")
            CounterStoreActions.increment(state.caption)
          },
          "+"
        ),
        <.button(
          ^.`class` := "chap02-btn",
          ^.onClick --> Callback {
            CounterStoreActions.decrement(state.caption)
          },
          "-"
        ),
        <.span(
          s"${state.caption} count: ${state.counter}"
        )
      )
    }
    .componentDidMount { mount =>
      Callback {
        val modCb = mount.modState({ state =>
          state.copy(counter = CounterStore.counterValues(state.caption))
        })
        CounterStore.addChangeListener { () =>
          modCb.runNow()
        }
      }
    }
    .build

  def onButtonClicked: Callback = Callback.alert("The button was pressed!")

}
