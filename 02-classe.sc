class Montant(valeur: Double)

val a = new Montant(15d)
//a.valeur ne compile pas

class Montant(valeur: Double){

override def toString = valeur.toString

}

val a = new Montant(15)
//affiche la valeur de 15 dans le toString
//valeur est accessible partout dans la classe
//mais pas à l'extérieur



class Montant(val valeur: Double){
override def toString = valeur.toString
}

val a = new Montant(15)
a.valeur
//valeur possède un getter mais pas de setter
//a.valeur = 10 ne compile pas



class Montant(var valeur: Double){
override def toString = valeur.toString
}

val a = new Montant(10)
a.valeur
a.valeur = 15
a.valeur
//valeur possède maintenant un setter


