package forimpatient.chapter18

/**
  * Created by Iryna Kharaborkina on 8/27/16. 
  *
  * Solution to the Chapter 18 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Complete the fluent interface in Section 18.1, “Singleton Types,” on page 246 so that one can call
  *       book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
  */
object Exercise03 extends App {
  println("Chapter 18 Exercise 03")

  val book = new Document
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"

  println(book)

  class Document {
    var title = ""
    var author = ""

    private var useNextArgsAs: Any = null
    def set(obj: Title.type): this.type  = {useNextArgsAs = obj; this}
    def set(obj: Author.type): this.type  = {useNextArgsAs = obj; this}
    def to(arg: String): this.type =
      {if (useNextArgsAs == Title) title = arg else if (useNextArgsAs == Author) author = arg; this}
    override def toString: String = "\"" + title + "\" by " + author
  }

  object Title
  object Author


}
