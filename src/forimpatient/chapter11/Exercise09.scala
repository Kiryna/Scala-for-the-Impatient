package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 11 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define an unapply operation for the RichFile class that extracts the file path, name, and extension.
  * For example, the file /home/cay/readme.txt has path /home/cay, name readme, and extension txt.
  */
object Exercise09 extends App {
  println("Chapter 11 Exercise 09")

  val RichFile(path, name, extention) = "/home/cay/readme.txt"

  println(path)
  println(name)
  println(extention)

  object RichFile {
    def unapply(fullPath: String) = {
      val nameIndex = fullPath.lastIndexOf("/")
      val extIndex = fullPath.lastIndexOf(".")

      if (nameIndex == -1 && extIndex == -1) Some("", fullPath, "")
      else if (nameIndex == -1) Some("", fullPath.substring(0, extIndex), fullPath.substring(extIndex + 1))
      else if (extIndex == -1) Some(fullPath.substring(0, nameIndex), fullPath.substring(nameIndex + 1), "")
      else Some(fullPath.substring(0, nameIndex), fullPath.substring(nameIndex + 1, extIndex),
        fullPath.substring(extIndex + 1))
    }
  }
}
