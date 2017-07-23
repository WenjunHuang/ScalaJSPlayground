import base.Action
import todos.store.TodoItem
import todos.todolist.actions
import todos.todolist.actions.{AddTodoAction, RemoveTodoAction, ToggleTodoAction}

/**
  * Created by rick on 2017/7/20.
  */
package object todolist {
  val AddTodo = actions.AddTodo
  val ToggleTodo = actions.ToggleTodo
  val RemoveTodo = actions.RemoveTodo

  def reducer(state: Seq[TodoItem], action: Action): Seq[TodoItem] = action match {
    case a: AddTodoAction =>
      state :+ TodoItem(actions.nextTodoId, a.text, a.isCompleted)
    case a: ToggleTodoAction =>
      state.map { item =>
        if (item.id == a.id)
          item.copy(isCompleted = !item.isCompleted)
        else
          item
      }
    case a: RemoveTodoAction =>
      state.filterNot { item => item.id == a.id }
    case _ =>
      state
  }
}
