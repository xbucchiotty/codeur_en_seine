def affiche(montant: Montant)= montant match{
	case Valide(v,d) => println(s"$v $d")
	case Zero => println("Ø")
}
 
affiche(Montant(15,"EUR"))
//> 15.0 EUR

affiche(Montant.zero)
//>Ø

affiche(Montant.nan)
//> BOOM



sealed trait Montant{

  def plus(autre: Montant): Montant

}

case object NaN extends Montant{

  def plus(autre: Montant) = NaN

}

case object Zero extends Montant{
  def plus(autre: Montant) = autre
}

case class Valide(valeur: Double, devise: String) extends Montant{

  def plus(autre: Montant) = autre match{
    case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur = valeur + autreValeur)
    case Zero => this
    case _ => NaN
  }
}

object Montant{

  def apply(valeur:Double, devise: String):Montant = Valide(valeur,devise)

  def zero: Montant = Zero
  def nan: Montant = NaN
}


def affiche(montant: Montant)= montant match{
 case Valide(v,d) => println(s"$v $d")
 case Zero => println("Ø")
 case NaN => println("cheese")
}

affiche(Montant(15,"EUR"))
//> 15.0 EUR
 
affiche(Montant.zero)
//>Ø
 
affiche(Montant.nan)
//> cheese
