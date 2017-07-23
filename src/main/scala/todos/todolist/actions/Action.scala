package todos.todolist.actions

import base.Action


case class AddTodoAction(isCompleted:Boolean, id:Int, text:String) extends Action {
  override val actionType: Symbol = AddTodo
}
case class ToggleTodoAction(id:Int) extends Action {
  override val actionType: Symbol = ToggleTodo
}

case class RemoveTodoAction(id:Int) extends Action {
  override val actionType: Symbol = RemoveTodo
}
