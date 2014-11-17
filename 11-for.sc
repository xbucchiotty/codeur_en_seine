def source_1() = List(1,2,3)
def source_2() = List(4,5,6)

def sommeList() = 
    for { i <- source_1()
          j <- source_2()
   } yield i + j



import scala.util.Try
import scala.util.Success
import scala.util.Failure

def source_1():Try[Int] = Success(1)
def source_2():Try[Int] = Failure(new NullPointerException)
def source_3():Try[Int] = Success(3)

def sommeTry() = 
    for { i <- source_1()
          j <- source_2()
          k <- source_3()
   } yield i + j + k



import concurrent.ExecutionContext.Implicits.global
import concurrent.Future
import concurrent.Await
import concurrent.duration._

def source_1() = Future{
    Thread.sleep(1000)
    println("1 terminated")
    1
}

def source_2() = Future{
    Thread.sleep(2000)
    println("2 terminated")
    2
}

def sommeFuture() = 
    for { i <- source_1()
          j <- source_2()
   } yield i + j
