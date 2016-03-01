package service

import javax.inject.Singleton

import anorm.SqlParser._
import anorm._
import model.Task
import play.api.Play.current
import play.api.db.DB

/**
  * Created by mactur on 01/03/16.
  */
@Singleton
class TaskService {

  val task: RowParser[Task] = {
    get[Long]("id") ~
      get[String]("label") map {
      case id ~ label => Task(id, label)
    }
  }

  def getAll: List[Task] = {
    DB.withConnection { implicit c =>
      SQL("select * from task").as(task *)
    }
  }

  def create(label: String): Unit = {
    DB.withConnection { implicit c =>
      SQL("insert into task (label) values ({label})").on(
        'label -> label
      ).executeUpdate()
    }
  }

  def delete(id: Long): Unit = {
    DB.withConnection { implicit c =>
      SQL("delete from task where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

}
