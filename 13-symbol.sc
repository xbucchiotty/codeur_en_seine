sealed trait Montant{

  def +(autre: Montant): Montant

}

case object NaN extends Montant{

  def +(autre: Montant) = NaN

}

case object Zero extends Montant{
  def +(autre: Montant) = autre
}

case class Valide(valeur: Double, devise: String) extends Montant{

  def +(autre: Montant) = autre match{
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


List(Montant(15,"EUR"),Montant(10,"EUR")).foldLeft(Montant.zero)(_ + _)
