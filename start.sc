import scala.io.Source

def maPrez = Source.fromFile("prez.txt").getLines()

maPrez.foreach{l => println(s"\n\n\n\n$l");Thread.sleep(5000);}

