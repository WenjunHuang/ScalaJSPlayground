import base.Action
import todos.filter.actions.SetFilterAction

/**
  * Created by rick on 2017/7/20.
  */
package object filter {
  def reducer(filter: String, action: Action): String = action match {
    case a: SetFilterAction =>
      a.filter
    case _ =>
      filter
  }
}
