package counter.store

import simpleflux.{Action, AppDispatcher}

/**
  * Created by rick on 2017/6/27.
  */
object SummaryStoreActions {
  def sumaryActions(action:Action): Unit = action match {
    case _:DecrementAction|_:IncrementAction =>
      AppDispatcher.waitFor(CounterStore.DispatchToken)
      SummaryStore.summaryChanged()
  }


}
