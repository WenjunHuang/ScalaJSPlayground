package counter.store

import simpleflux.Action

/**
  * Created by rick on 2017/6/26.
  */
case class IncrementAction(val counterCaption: String) extends Action {
  override val actionType: String = CounterStoreActions.Increment
}

case class DecrementAction(val counterCaption: String) extends Action {
  override val actionType: String = CounterStoreActions.Decrement
}

object CounterStoreActions {
  val Increment = "Increment"
  val Decrement = "Decrement"

  def increment(counterCaption: String): Unit = {
    CounterStore.dispatch(IncrementAction(counterCaption))
  }

  def decrement(counterCaption: String): Unit = {
    CounterStore.dispatch(DecrementAction(counterCaption))
  }

  //    def counterActions(action:Action): Unit = {
  //        println("called counterActions")
  //        action match {
  //            case inc:IncrementAction => CounterStore.incrementByOne(inc.counterCaption)
  //            case inc:DecrementAction => CounterStore.decrementByOne(inc.counterCaption)
  //        }
  //    }

}
