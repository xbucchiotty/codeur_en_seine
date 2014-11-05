#Scala, pourquoi et pourquoi pas

##Langage objet

###Déclaration
* new class
* type annotation
* def , var, val, lazy val
* AnyVal, AnyRef

###Classe
* classe avec paramètre
* pas de getter,setter pour l'instant
* mais on peut l'utiliser en interne, ex avec toString
* val, var pour des fields

###case class
* case class
* toString, hashcode, copy
* Serializable

Montant et méthode + => coincé par devise

###trait
trait + object Vide + Pattern matching

	trait Montant{
		def plus (autre: Montant): Montant
	}

	case object Vide extends Montant{
		def plus (autre: Montant) = this
	}

	case class Valide(valeur: Double, devise: String) extends Montant{
		def plus (autre: Montant): Montant = autre match{
			case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur= valeur + autreValeur)
			case _ => Vide
		}
	}

###object companion

	object Montant{
		def apply(valeur: Double, devise: String): Montant = Valide(valeur,devise)
	}

##λ
###Algebric data type
Montant Zero

	case object Zero extends Montant{
		def plus(autre: Montant) = autre
	}

total

	trait Montant{
    	def plus(autre: Montant): Montant
	}

	case object Vide extends Montant{
    	def plus(autre: Montant) = this
	}

	case class Valide(valeur: Double, devise: String) extends Montant{
    	def plus (autre: Montant): Montant = autre match{
        	case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur= valeur + autreValeur)
			case Zero => this
	        case _ => Vide
    	}
	}
	
	case object Zero extends Montant{
		def plus (autre: Montant) = autre
	}
	
	object Montant{
		def apply(valeur: Double, devise: String): Montant = Valide(valeur,devise)
		def zero: Montant = Zero
	    def vide: Montant = Vide
	}

###sealed trait + pattern matching
	
	def affiche(montant: Montant) = montant match{
    	case Valide(v,d) => println(s"$v $d")
     	case Zero => println("Ø")
    }
    

###for comprehension

	def source_1() = List(1,2,3)
	def source_2() = List(4,5,6)
	
	def somme() = 
		for { i <- source_1()
			j <- source_2()
       } yield i + j

try

	import scala.util.Try
	import scala.util.Success
	import scala.util.Failure
	
	def source_1():Try[Int] = Success(1)
	def source_2():Try[Int] = Failure(new NullPointerException)
	def source_3():Try[Int] = Success(3)

	def somme() = 
		for { i <- source_1()
			j <- source_2()
			k <- source_3()
       } yield i + j + k

future
   
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
	
	def somme() = 
		for { i <- source_1()
			j <- source_2()
       } yield i + j
	
	

##Sugar, sugar, sugar
###PRODUCTION: _
Lambas

	List(1,2,3).map((x:Int) => x + 1)
	List(1,2,3).map(x => x + 1)
	List(1,2,3).map(_ + 1)
	List(1,2,3).map(1 + _)	
	List(1,2,3).map(1 + )	

Pattern matching

	def afficheValeur(montant: Montant) = montant match{
    	case Valide(v,_) => println(s"$v")
     	case Zero => println("Ø")
    }

higher kinded type

	type Truc = List[Int]
	type Machin = Option[String]
	
	//Liste et Option acceptent "map"
	
	List[A] -> (A=>B) -> List[B]
	
	trait Mappable[F[_]] {
	
		def map[A,B](a: F[A],f: (A=>B) ):F[B]
	}
	
	type Functor[_] = Mappable[_]
	

###PRODUCTION: Infix
	List(1,2,3) map  (1 +) map (3 -)
	
	
###PRODUCTION: Methods with symbols
	trait Montant{
    	def +(autre: Montant): Montant
	}

	case object Vide extends Montant{
    	def +(autre: Montant) = this
	}

	case class Valide(valeur: Double, devise: String) extends Montant{
    	def + (autre: Montant): Montant = autre match{
        	case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur= valeur + autreValeur)
			case Zero => this
	        case _ => Vide
    	}
	}
	
	case object Zero extends Montant{
		def + (autre: Montant) = autre
	}
	
	object Montant{
		def apply(valeur: Double, devise: String): Montant = Valide(valeur,devise)
		def zero: Montant = Zero
	    def vide: Montant = Vide
	}
	


###TEST: Default parameter value
	
	def unMontant(valeur:Double=0d, devise:String="EUR") = 
		Montant(valeur,devise)
		
###TEST: Implicit conversion
	import java.util.Currency
				
	trait Montant{
	    def +(autre: Montant): Montant
	}

	case object Vide extends Montant{
	    def +(autre: Montant) = this
	}

	case class Valide(valeur: Double, devise: Currency) extends Montant{
    	def + (autre: Montant): Montant = autre match{
	        case Valide(autreValeur,autreDevise) if autreDevise == devise => copy(valeur= valeur + autreValeur)
    	    case Zero => this
        	case _ => Vide
	    }
	}

	case object Zero extends Montant{
	    def +(autre: Montant) = autre
	}

	object Montant{
	    def apply(valeur: Double, devise: Currency): Montant = Valide(valeur,devise)
    	def zero: Montant = Zero
	    def vide: Montant = Vide
	}				
	
//conversion

	implicit def toCurrency(devise:String)=
		Currency.getInstance(devise)
		
###TEST: Implicit classes

	class SuperDouble(val valeur:Double) extends AnyVal {

		def EUR=Montant(valeur,"EUR")

		def USD=Montant(valeur,"USD")

	}			
