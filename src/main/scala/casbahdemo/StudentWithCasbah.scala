package casbahdemo
import com.mongodb.casbah.Imports._
object StudentWithCasbah extends App {

  StudentScoreCard.saveStudentScore()
  StudentScoreCard.findAllStudentScore
  StudentScoreCard.findStudentByName("Rohan Singh")
  StudentScoreCard.updateStudentScore("Rohan Singh", 90.20, "exam")
  StudentScoreCard.deleteStudnetScore("Ram Singh")
}