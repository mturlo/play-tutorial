package controllers

import javax.inject.{Inject, Singleton}

import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import service.TaskService

/**
  * Created by mactur on 01/03/16.
  */
@Singleton
class Tasks @Inject() (taskService: TaskService) extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def listTasks = Action {
    Ok(views.html.tasks(taskService.getAll, taskForm))
  }

  def createTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks(taskService.getAll, errors)),
      label => {
        taskService.create(label)
        Redirect(routes.Tasks.listTasks)
      }
    )
  }

  def deleteTask(id: Long) = TODO

}
