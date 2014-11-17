//Une lambda est une fonction typée en entrée et sortie
//(Int => Int)
List(1,2,3).map((x:Int) => x + 1)


//Dans la plupart des cas, le typage explicite n'est pas obligatoire
List(1,2,3).map(x => x + 1)


//Une lambda peut prendre plusieurs paramètres, sous forme d'un tuple
//(Int,Int) => Int
List(1,2,3).foldLeft(0)((a,b) => a + b)


//Il n'y a pas de Predicate, il s'agit d'une fonction qui retourne un Booléen
//Int => Bool
List(1,2,3).filter(x => x % 2 == 0)


//Une fonction peut ne pas prendre de paramètre
//Getter
//() => Int
val f = {() => 2}
f()

//Une fonction peut ne pas avoir de retour, Unit est l'équivalent de Void de Java en Scala
//Int => Unit
val g = {(i:Int) => println(i)}
g(1)
