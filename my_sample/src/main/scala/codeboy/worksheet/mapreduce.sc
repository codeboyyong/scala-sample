//this is some thing I learned from http://daily-scala.blogspot.com/2009/08/implicit-methods.html
object scala_mapreduce {
  import scala.io.Source
  Source.fromFile("/Users/zhaoyong/linuxwords.txt").
    getLines().
    flatMap(_.split("\\W+")).
    toList.
    groupBy((word: String) => word).
    mapValues(_.length)
    .toList
    .sortBy(_._1)                                 //> res0: List[(String, Int)] = List((2,1), (3,1), (ANSI,1), (ARCO,1), (ARPA,1),
                                                  //|  (ASCII,1), (Aarhus,1), (Aaron,1), (Ababa,1), (Abba,1), (Abbott,1), (Abby,1)
                                                  //| , (Abe,1), (Abel,1), (Abelian,1), (Abelson,1), (Aberdeen,1), (Abernathy,1), 
                                                  //| (Abidjan,1), (Abigail,1), (Abilene,1), (Abner,1), (Abo,1), (Abos,1), (Abraha
                                                  //| m,1), (Abram,1), (Abrams,1), (Abramson,1), (Abu,1), (Abyssinia,1), (Abyssini
                                                  //| an,1), (Abyssinians,1), (Acadia,1), (Acapulco,1), (Accra,1), (Achaean,1), (A
                                                  //| chaeans,1), (Achilles,1), (Ackerman,1), (Ackley,1), (Acta,1), (Actaeon,1), (
                                                  //| Acton,1), (Acts,1), (Ada,1), (Adair,1), (Adam,1), (Adams,1), (Adamson,1), (A
                                                  //| ddis,1), (Addison,1), (Addressograph,1), (Adelaide,1), (Adele,1), (Adelia,1)
                                                  //| , (Aden,1), (Adirondack,1), (Adirondacks,1), (Adkins,1), (Adler,1), (Adleria
                                                  //| n,1), (Adolph,1), (Adolphus,1), (Adonis,1), (Adrian,1), (Adriatic,1), (Adrie
                                                  //| nne,1), (Aegean,1), (Aeneas,1), (Aeneid,1), (Aeolus,1), (Aerobacter,1), (Aes
                                                  //| chylus,1), (Aesop,1), (A
                                                  //| Output exceeds cutoff limit.

//char occurance

 val str = "abcdefg abcd ABC"                     //> str  : String = abcdefg abcd ABC
 val map= str.map(x=>(x.toLower,1))               //> map  : scala.collection.immutable.IndexedSeq[(Char, Int)] = Vector((a,1), (b
                                                  //| ,1), (c,1), (d,1), (e,1), (f,1), (g,1), ( ,1), (a,1), (b,1), (c,1), (d,1), (
                                                  //|  ,1), (a,1), (b,1), (c,1))
 val g=map.toList                                 //> g  : List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,1), (e,1), (f,1), (g,1
                                                  //| ), ( ,1), (a,1), (b,1), (c,1), (d,1), ( ,1), (a,1), (b,1), (c,1))
 val g2 = g.groupBy(x=>x._1.toLower)              //> g2  : scala.collection.immutable.Map[Char,List[(Char, Int)]] = Map(e -> List
                                                  //| ((e,1)), f -> List((f,1)), a -> List((a,1), (a,1), (a,1)),   -> List(( ,1), 
                                                  //| ( ,1)), b -> List((b,1), (b,1), (b,1)), g -> List((g,1)), c -> List((c,1), (
                                                  //| c,1), (c,1)), d -> List((d,1), (d,1)))
val sortedResult0  =g2.mapValues(_.length).toList.sortBy(_._1)
                                                  //> sortedResult0  : List[(Char, Int)] = List(( ,2), (a,3), (b,3), (c,3), (d,2),
                                                  //|  (e,1), (f,1), (g,1))
 //char occurance 2
 val list= str.toList                             //> list  : List[Char] = List(a, b, c, d, e, f, g,  , a, b, c, d,  , A, B, C)
 val groupBy = list.groupBy(x=>x.toLower)         //> groupBy  : scala.collection.immutable.Map[Char,List[Char]] = Map(e -> List(e
                                                  //| ), f -> List(f), a -> List(a, a, A),   -> List( ,  ), b -> List(b, b, B), g 
                                                  //| -> List(g), c -> List(c, c, C), d -> List(d, d))
 val mapValues = groupBy.mapValues(_.length)      //> mapValues  : scala.collection.immutable.Map[Char,Int] = Map(e -> 1, f -> 1, 
                                                  //| a -> 3,   -> 2, b -> 3, g -> 1, c -> 3, d -> 2)
 val resultList = mapValues.toList                //> resultList  : List[(Char, Int)] = List((e,1), (f,1), (a,3), ( ,2), (b,3), (g
                                                  //| ,1), (c,3), (d,2))
 val sortedResult =  resultList.sortBy(_._1)      //> sortedResult  : List[(Char, Int)] = List(( ,2), (a,3), (b,3), (c,3), (d,2), 
                                                  //| (e,1), (f,1), (g,1))
 //.toList.groupBy((a,count)=>(a,count+)) ..flatMap()
 //..flatMap.toList.groupBy(x=>x)
 
 
 
//one line of char count map reduce sample

"abcdefg abcd ABC".map(x=>(x.toLower,1)).toList.groupBy(x=>x._1.toLower).mapValues(_.length).toList.sortBy(_._1)
                                                  //> res1: List[(Char, Int)] = List(( ,2), (a,3), (b,3), (c,3), (d,2), (e,1), (f
                                                  //| ,1), (g,1))
  
  
  "a".getClass                                    //> res2: Class[?0] = class java.lang.String
 // val a = String.class.getClass
  
}