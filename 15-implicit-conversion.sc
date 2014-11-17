import java.util.Currency

sealed trait Montant{

  def +(autre: Montant): Montant

}

case object NaN extends Montant{

  def +(autre: Montant) = NaN

}

case object Zero extends Montant{
  def +(autre: Montant) = autre
}

case class Valide(valeur: Double, devise: Currency) extends Montant{

  def +(autre: Montant) = autre match{
    case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur = valeur + autreValeur)
    case Zero => this
    case _ => NaN
  }
}

object Montant{

  def apply(valeur:Double, devise: Currency):Montant = Valide(valeur,devise)

  def zero: Montant = Zero
  def nan: Montant = NaN
}

//val a = Montant(10,"EUR")
//ne compile pas

def convertToCurrency(devise:String): Currency = Currency.getInstance(devise)

val b  = Montant(10,convertToCurrency("EUR"))
//compile

object Implicits{

	implicit def stringToCurrency(devise:String): Currency = Currency.getInstance(devise)
}

import Implicits.stringToCurrency
val c = Montant(10,"EUR")
//compile :-)
