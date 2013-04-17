package casbahdemo
import setup.MongoSetUp
import com.mongodb.casbah.Imports._
object StudentScoreCard {

  /**
   * Manage Student details and Exam score
   * _id :ObjectID
   * name :String
   * scores:{score:Double,exam: String}
   */

  def saveStudentScore() = {
    val studentScore = MongoDBObject(
      "name" -> "Rohan Singh",
      "scores" -> List(MongoDBObject("type" -> "exam", "score" -> 69.09840625499065)))

    val studentCollection = MongoSetUp.getCollection()
    val isSaved = studentCollection.save(studentScore)
    println(isSaved.getN)

  }

  /**
   * Find All students Score
   */

  def findAllStudentScore() = {

    val collection = MongoSetUp.getCollection
    val studentList = collection.find.toList
    println(studentList)

  }

  /**
   *  Find student by name
   *  @param
   *  name :String
   */

  def findStudentByName(studentName: String) = {

    val collection = MongoSetUp.getCollection
    val studentScore = collection.find(
      MongoDBObject("name" -> studentName))
    studentScore.foreach(student => println(student))

  }

  /**
   * Update score of exam type by user name and exam type
   */

  def updateStudentScore(name: String, score: Double, examtype: String) = {

    
    val query = MongoDBObject(
      "name" -> name,
      "scores.type" -> examtype)
    val updateScore = MongoDBObject(
      "$set" -> MongoDBObject("scores.$.score" -> score))

    val collection = MongoSetUp.getCollection

    val numberOfRecordUpdated = collection.update(query, updateScore)
    println(numberOfRecordUpdated.getN + " Records Updated")
  }

  /**
   * Delete Student Record 
   * 
   */
  
  def deleteStudnetScore(name : String) = {
    
    val query = MongoDBObject(
    "name"->name    
    )
    
    val  coll = MongoSetUp.getCollection
    
    val deletedRecords = coll.remove(query)
    println(deletedRecords.getN + " Records Deleted")
    
    
    
    
  }
  
  
  
  
  
  
}