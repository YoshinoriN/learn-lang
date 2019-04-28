#use "../utils/studentType.ml";;

let s1 = { name = "Hoge"; score = 90; rank = "A"; }
let s2 = { name = "Foo"; score = 77; rank = "B"; }
let s3 = { name = "Bar"; score = 98; rank = "A"; }
let s4 = { name = "Poyo"; score = 56; rank = "C"; }
let s5 = { name = "Piyo"; score = 62; rank = "C"; }
let s6 = { name = "Poo"; score = 51; rank = "C"; }


(*
  Aggregate sstudent by rank
  aggregateByRank : studentType -> int * int * int
*)
let rec aggregateByRank list = match list with
  [] -> (0, 0, 0)
  | studentType :: rest ->
    let aggregateRest = aggregateByRank rest in match aggregateRest with
      (a, b, c) ->
        if studentType.rank = "A" then
          (a + 1, b, c)
        else if studentType.rank = "B" then
          (a, b + 1, c)
        else
          (a, b, c + 1)

(* Unit test *)
let students1 = []
let students2 = [s1]
let students3 = [s1; s2]
let students4 = [s1; s2; s3]
let students5 = [s1; s2; s3; s4]
let students6 = [s1; s2; s3; s4; s5]
let students7 = [s1; s2; s3; s4; s5; s6]

let test1 = aggregateByRank students1 = (0, 0, 0)
let test2 = aggregateByRank students2 = (1, 0, 0)
let test3 = aggregateByRank students3 = (1, 1, 0)
let test4 = aggregateByRank students4 = (2, 1, 0)
let test5 = aggregateByRank students5 = (2, 1, 1)
let test6 = aggregateByRank students6 = (2, 1, 2)
let test7 = aggregateByRank students7 = (2, 1, 3)

(*
  #use "4_local-argument_with_pattern-match.ml";;

  Result
  ----------------------------------------------
  type studentType = { name : string; score : int; rank : string; }
  val s1 : studentType = {name = "Hoge"; score = 90; rank = "A"}
  val s2 : studentType = {name = "Foo"; score = 77; rank = "B"}
  val s3 : studentType = {name = "Bar"; score = 98; rank = "A"}
  val s4 : studentType = {name = "Poyo"; score = 56; rank = "C"}
  val s5 : studentType = {name = "Piyo"; score = 62; rank = "C"}
  val s6 : studentType = {name = "Poo"; score = 51; rank = "C"}
  val aggregateByRank : studentType list -> int * int * int = <fun>
  val students1 : 'a list = []
  val students2 : studentType list = [{name = "Hoge"; score = 90; rank = "A"}]
  val students3 : studentType list =
    [{name = "Hoge"; score = 90; rank = "A"};
    {name = "Foo"; score = 77; rank = "B"}]
  val students4 : studentType list =
    [{name = "Hoge"; score = 90; rank = "A"};
    {name = "Foo"; score = 77; rank = "B"};
    {name = "Bar"; score = 98; rank = "A"}]
  val students5 : studentType list =
    [{name = "Hoge"; score = 90; rank = "A"};
    {name = "Foo"; score = 77; rank = "B"};
    {name = "Bar"; score = 98; rank = "A"};
    {name = "Poyo"; score = 56; rank = "C"}]
  val students6 : studentType list =
    [{name = "Hoge"; score = 90; rank = "A"};
    {name = "Foo"; score = 77; rank = "B"};
    {name = "Bar"; score = 98; rank = "A"};
    {name = "Poyo"; score = 56; rank = "C"};
    {name = "Piyo"; score = 62; rank = "C"}]
  val students7 : studentType list =
    [{name = "Hoge"; score = 90; rank = "A"};
    {name = "Foo"; score = 77; rank = "B"};
    {name = "Bar"; score = 98; rank = "A"};
    {name = "Poyo"; score = 56; rank = "C"};
    {name = "Piyo"; score = 62; rank = "C"};
    {name = "Poo"; score = 51; rank = "C"}]
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test4 : bool = true
  val test5 : bool = true
  val test6 : bool = true
  val test7 : bool = true
*)
