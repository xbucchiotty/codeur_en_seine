trait Montant{

  def plus(autre: Montant): Montant

}

case object NaN extends Montant{

  def plus(autre: Montant) = NaN

}

case class Valide(valeur: Double, devise: String) extends Montant{

  def plus(autre: Montant) = autre match{
    case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur = valeur + autreValeur)
    case _ => NaN
  }
}

object Montant{

  def apply(valeur:Double, devise: String):Montant = Valide(valeur,devise)

}

Montant(15,"EUR").plus(Montant(10,"EUR"))
//> Valide(25,"EUR")

Montant(15,"EUR").plus(NaN)
//> NaN 
