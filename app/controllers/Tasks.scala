package controllers

import play.api.data.Forms._
import play.api.data._
import play.api.mvc._

/**
  * Created by mactur on 01/03/16.
  */
class Tasks extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def listTasks = TODO

  def createTask = TODO

  def deleteTask(id: Long) = TODO

}
