package forimpatient.chapter09

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Expand the example with the serializable Person class that stores a collection of friends.
  * Construct a few Person objects, make some of them friends of another, and then save an Array[Person] to a file.
  * Read the array back in and verify that the friend relations are intact.
  */
object Exercise10 extends App {
  println("Chapter 09 Exercise 10")

  val fred = new Person("Fred", 42)
  val helga = new Person("Helga", 29)
  val tanya = new Person("Tanya", 24)
  val john = new Person("John", 35)

  fred.addFriend(helga)
  fred.addFriend(john)
  fred.addFriend(tanya)
  tanya.addFriend(helga)

  val fredFriendsFile = "src/forimpatient/chapter09/fredfrends.obj"
  val tanyaFriendsFile = "src/forimpatient/chapter09/tanyafrends.obj"

  val out = new ObjectOutputStream(new FileOutputStream(fredFriendsFile))
  out.writeObject(fred.friends)
  out.close()

  val in = new ObjectInputStream(new FileInputStream(fredFriendsFile))
  val fredFriends = in.readObject().asInstanceOf[ArrayBuffer[Person]]
  in.close()

  println(fredFriends.map(_.name).mkString("Fred's friends are: ", " and ", "."))

  val outTanya = new ObjectOutputStream(new FileOutputStream(tanyaFriendsFile))
  outTanya.writeObject(tanya.friends)
  outTanya.close()

  val inTanya = new ObjectInputStream(new FileInputStream(tanyaFriendsFile))
  val tanyaFriend = inTanya.readObject().asInstanceOf[ArrayBuffer[Person]]
  inTanya.close()

  println(tanyaFriend.map(_.name).mkString("Tanya's friends are: ", " and ", "."))


  class Person(val name: String, var age: Int) extends Serializable {
    val friends = new ArrayBuffer[Person]

    def addFriend(friend: Person): Unit = {
      friends += friend
      friend.friends += this
    }
  }

}
