//_ peut être utilisé pour masquer le nom d'une variable qui n'aide pas à la compréhension du problème.
List(1,2,3).map(x => x + 1)
List(1,2,3).map(_ + 1)

//_ peut aussi être utilisé dans le patter matching pour supprimer des variables qui ne sont pas utiles
def affiche(montant: Montant) = montant match{
    case Valide(v,_) => println(s"$v")
    case Zero => println("Ø")
    case NaN => println("cheese")
}

//En Scala, le typage des génériques est obligatoire. List n'est pas un type. Mais List[_] oui, si le type n'a pas d'intérêt
def affiche(x: List[_]) = x.foreach(println)

//Utilisé aussi comme import
import concurrent.duration._
