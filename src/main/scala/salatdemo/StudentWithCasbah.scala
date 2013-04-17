package salatdemo

import setup.MongoSetUp
import com.mongodb.casbah.Imports._
import com.novus.salat.global._
import com.novus.salat.annotations._
import java.util.Date
import com.novus.salat.dao.SalatDAO

/**
 *
 * Address class represent Student address details
 *
 * @param
 * street : String
 * zip : Int
 * city : String
 * state : String
 */
case class Address(
  street: String,
  zip: Int,
  city: String,
  state: String)

/**
 * Scores class represent Student Score Card having Exam type and Score
 * @param
 * examtype : String
 * score : Double
 */
case class Scores(

  examtype: String,
  score: Double)

/**
 * Student class represent whole information of Student having address and scores
 */
case class Student(
  @Key("_id") studentID: ObjectId,
  name: String,
  dob: Date,
  address: Address,
  scores: Seq[Scores])

object StudentDAO extends SalatDAO[Student, ObjectId](collection = MongoSetUp.getCollection) {

  /**
   * Save Student Record with address and score
   * @param
   * student : Student
   */
  def saveStudentRecord(student: Student) = {

    val id = insert(student)
    println("Student Record is saved with folling Id: " + id.get)
  }
  
  
  /**
   * Find Student by zip code and Student name
   * @param
   * name : String
   * zip : Int
   * 
   */
  
  def  findStudentByZipCode(name : String, zip : Int) = {
    
    val findList = find(MongoDBObject("name"->name, "address.zip"->zip ))
    findList
    
  }

}

object StudentWithSalat extends App {
  val address = Address("10/90 Patel Nagar", 203030, "Delhi", "Delhi")
  val scores = Seq(Scores("exam", 89.30), Scores("homework", 67.78))
  val student = Student(new ObjectId, "Mohan Gokhale", new Date, address, scores)
  StudentDAO.saveStudentRecord(student)
  val searchedStudents = StudentDAO.findStudentByZipCode("Mohan Gokhale", 203030)
  for(searchedStudent <- searchedStudents){
    val address = searchedStudent.address
    println("Student Name: " + searchedStudent.name)
    println("Student DOB: " + searchedStudent.dob)
    println("Adress street: " + address.street)
    println("Adress zip code: " + address.zip)
    println("Adress state: " + address.state)
    println("\n\n")
    
    
  
    
  }
  

  

}