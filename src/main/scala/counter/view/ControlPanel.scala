package counter.view

import counter.store.SummaryStore
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, ScalaComponent}

/**
  * Created by rick on 2017/6/26.
  */
object ControlPanel {

  case class State(var sum: Int = 0)

  val component = ScalaComponent.builder[Unit]("No args")
    .initialState(new State(SummaryStore.getSummary()))
    .render_S(state =>
      <.div(
        Counter.component(new Counter.Props("First")),
        Counter.component(new Counter.Props("Second")),
        Counter.component(new Counter.Props("Third")),
        <.hr(),
        <.div(
          s"Total Count: ", state.sum
        )
      )
    )
    .componentDidMount { mount =>
      Callback {
        val modCb = mount.modState({ state =>
          state.copy(sum = SummaryStore.getSummary())
        })
        SummaryStore.addChangeListener { () =>
          modCb.runNow()
        }
      }
    }
    .build
}
