//List, append only
//idéel pour récursion
List(1,2,3)

def affiche(l: List[_]):Unit = l match{
case head::tail => print(head); affiche(tail);
case Nil => println("")
}

affiche(List(1,2,3))

//Création à la volée de Range
val aRange = 1 to 25

//Création de structure lazy
val aStream = Stream.iterate(0){i => 
    print(s"calcul-")
    i+2
}
aStream.take(5).foreach(println)

//ATTENTION À la mémoisation de Stream
aStream.take(5).foreach(println)


List(1,2,3).map(i => i + 1 )
List(1,2,3).flatMap(i => 1 to i)
List(1,2,3).foreach(i => println(i))
List(1,2,3).drop(1)
List(1,2,3).drop(10)
List(1,2,3).take(2)
List(1,2,3).take(10)
List(1,2,3).dropRight(1)
List(1,2,3).toStream.map{i => println("calcul"); i +10}.take(2).toList
List(1,2,3,4).sliding(2).toList
List(1,2,3,4,5).grouped(2).toList
Iterator(1,2,3).flatMap(i => 0 to i).toList

import concurrent.ExecutionContext.Implicits.global

Stream.iterate(0)(i => i + 2).take(100).par.map{i => Thread.currentThread.getName}.foreach(println)

