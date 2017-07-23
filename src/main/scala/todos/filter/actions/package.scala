package todos.filter

import base.Action

package object actions {

  val SetFilter = 'SetFilter

  case class SetFilterAction(filter:String) extends Action {
    override val actionType: Symbol = SetFilter
  }
}
