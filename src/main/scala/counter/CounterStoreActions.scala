package counter

import simpleflux.{Action, AppDispatcher}

/**
  * Created by rick on 2017/6/26.
  */
case class IncrementAction(val counterCaption: String, val actionType: String = "Increment") extends Action

case class DecrementAction(val counterCaption: String, val actionType: String = "Decrement") extends Action

object CounterStoreActions {
    def increment(counterCaption: String): Unit = {
        AppDispatcher.dispatch(IncrementAction(counterCaption))
    }

    def decrement(counterCaption:String): Unit = {
        AppDispatcher.dispatch(DecrementAction(counterCaption))
    }

    def counterActions(action:Action): Unit = {
        action match {
            case _:IncrementAction => increment(action.actionType)
            case _:DecrementAction => decrement(action.actionType)
        }
    }

}
