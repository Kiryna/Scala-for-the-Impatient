package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 11 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define an unapplySeq operation for the RichFile class that extracts all path segments.
  * For example, for the file /home/cay/readme.txt, you should produce a sequence of three segments:
  * home, cay, and readme.txt.
  */
object Exercise10 extends App {
  println("Chapter 11 Exercise 10")

  val RichFileSeq(root, path, file) = "/home/cay/readme.txt"

  println(root)
  println(path)
  println(file)

  object RichFileSeq {
    def unapplySeq(fullPath: String) = {

      if (fullPath.length == 0) None
      else if (fullPath.charAt(0) == '/') Some(fullPath.substring(1).split("/"))
      else Some(fullPath.split("/"))
    }
  }

}
