class ClassA(val name: String) extends TraitA

/*


scala> val a = new ClassA("d")
a: ClassA = ClassA@3fd4339c

scala> val a2 = new TraitA { val name = "k" }
a2: TraitA = $anon$1@3d578a9a
 */