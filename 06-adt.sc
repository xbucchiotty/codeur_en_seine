trait Montant{

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

Montant(15,"EUR").plus(Montant(10,"EUR"))
//> Montant(25,"EUR")

Montant(15,"EUR").plus(Montant(10,"USD"))
//> Nan

Montant.nan.plus(Montant(10,"USD"))
//> Nan

Montant.zero.plus(Montant(10,"USD"))
//> Montant(10,"USD")
