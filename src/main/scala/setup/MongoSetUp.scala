package setup
import com.mongodb.casbah.Imports._
import com.novus.salat.global._
import com.novus.salat.annotations._

object MongoSetUp {

  val SERVER = "localhost"
  val PORT = 27017
  val DBNAME = "test"
  val COLLECTION = "studentdemo"
    
    /**
     * Established connection to Mongo Server
     */

  def getConnection: MongoConnection = return MongoConnection(SERVER,PORT)
  
  /**
   * setup connection with collection along with database
   */
  def getCollection(): MongoCollection = return getConnection(DBNAME)(COLLECTION)
  
  
  /**
   * close connection
   */
  def closeConnection(conn: MongoConnection) { conn.close }

}